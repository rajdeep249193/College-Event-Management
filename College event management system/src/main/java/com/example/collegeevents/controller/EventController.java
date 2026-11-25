package com.example.collegeevents.controller;

import com.example.collegeevents.model.Event;
import com.example.collegeevents.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class EventController {

    private static final List<String> CATEGORIES = List.of("Cultural", "Technical", "Management", "Sports");

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(required = false) String category,
            Model model,
            Authentication authentication
    ) {
        List<Event> events;
        if (category != null && !category.isBlank() && !category.equalsIgnoreCase("All")) {
            events = eventRepository.findByCategoryIgnoreCaseOrderByEventDateAsc(category.trim());
        } else {
            events = eventRepository.findAllByOrderByEventDateAsc();
        }

        model.addAttribute("events", events);
        model.addAttribute("allEvents", eventRepository.findAllByOrderByEventDateAsc());
        model.addAttribute("categories", CATEGORIES);
        model.addAttribute("selectedCategory", category != null ? category : "All");
        model.addAttribute("isAdmin", isAdmin(authentication));
        model.addAttribute("username", authentication != null ? authentication.getName() : "Guest");
        return "dashboard";
    }

    @GetMapping("/events/{id}")
    public String viewEventDetails(@PathVariable @NonNull Long id, Model model, Authentication authentication) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        model.addAttribute("event", event);
        model.addAttribute("isAdmin", isAdmin(authentication));
        model.addAttribute("username", authentication != null ? authentication.getName() : "Guest");
        return "event-detail";
    }

    @PostMapping("/events/{id}/rsvp")
    @ResponseBody
    public ResponseEntity<?> rsvpEventAjax(
            @PathVariable @NonNull Long id,
            @RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
            @RequestParam(required = false) String studentName
    ) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        if (event.isFull()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Sorry, this event is already fully booked!"
            ));
        }

        event.setRegisteredCount(event.getRegisteredCount() + 1);
        eventRepository.save(event);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "RSVP confirmed! Spot reserved for " + (studentName != null && !studentName.isBlank() ? studentName : "you") + ".",
                "registeredCount", event.getRegisteredCount(),
                "spotsRemaining", event.getSpotsRemaining(),
                "fillPercentage", event.getFillPercentage(),
                "isFull", event.isFull()
        ));
    }

    @PostMapping("/events/{id}/register")
    public String rsvpEventForm(
            @PathVariable @NonNull Long id,
            RedirectAttributes redirectAttributes
    ) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        if (event.isFull()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Sorry, '" + event.getTitle() + "' is completely full!");
        } else {
            event.setRegisteredCount(event.getRegisteredCount() + 1);
            eventRepository.save(event);
            redirectAttributes.addFlashAttribute("successMessage", "🎉 Successfully registered for " + event.getTitle() + "! See you at " + event.getLocation() + ".");
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/events/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("categories", CATEGORIES);
        model.addAttribute("isAdmin", true);
        model.addAttribute("pageTitle", "Create an event");
        return "event-form";
    }

    @GetMapping("/events/{id}/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String editEvent(@PathVariable @NonNull Long id, Model model) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        model.addAttribute("event", event);
        model.addAttribute("categories", CATEGORIES);
        model.addAttribute("isAdmin", true);
        model.addAttribute("pageTitle", "Edit event");
        return "event-form";
    }

    @PostMapping("/events/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveEvent(
            @Valid @ModelAttribute("event") @NonNull Event event,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", CATEGORIES);
            model.addAttribute("isAdmin", true);
            model.addAttribute("pageTitle", event.getId() == null ? "Create an event" : "Edit event");
            return "event-form";
        }

        boolean isNew = event.getId() == null;
        eventRepository.save(event);
        redirectAttributes.addFlashAttribute("successMessage",
                isNew ? "✨ Event created successfully!" : "✨ Event details updated successfully!");
        return "redirect:/dashboard";
    }

    @PostMapping("/events/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEvent(@PathVariable @NonNull Long id, RedirectAttributes redirectAttributes) {
        if (!eventRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

        eventRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "🗑 Event has been removed.");
        return "redirect:/dashboard";
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication != null && authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }
}
