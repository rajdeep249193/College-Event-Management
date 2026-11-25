package com.example.collegeevents.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter an event title.")
    @Size(max = 120, message = "Title must be 120 characters or fewer.")
    private String title;

    @NotBlank(message = "Please select a category.")
    @Column(nullable = true)
    private String category; // Cultural, Technical, Management, Sports

    @NotBlank(message = "Please enter an event description.")
    @Size(max = 1500, message = "Description must be 1500 characters or fewer.")
    @Column(length = 1500)
    private String description;

    @NotBlank(message = "Please enter a location.")
    private String location;

    @NotNull(message = "Please select a date and time.")
    private LocalDateTime eventDate;

    @NotNull(message = "Please specify the seating capacity.")
    @Min(value = 1, message = "Capacity must be at least 1 seat.")
    @Column(nullable = true)
    private Integer capacity = 100;

    @Column(nullable = true)
    private Integer registeredCount = 0;

    @Column(nullable = true)
    private String organizer;

    public Event() {
    }

    public Event(String title, String description, String location, LocalDateTime eventDate) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.category = "Cultural";
        this.capacity = 100;
        this.registeredCount = 0;
        this.organizer = "Campus Committee";
    }

    public Event(String title, String category, String description, String location,
                 LocalDateTime eventDate, Integer capacity, Integer registeredCount, String organizer) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.capacity = capacity != null ? capacity : 100;
        this.registeredCount = registeredCount != null ? registeredCount : 0;
        this.organizer = organizer != null ? organizer : "Campus Committee";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category != null && !category.isBlank() ? category : "Cultural";
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getCapacity() {
        return capacity != null ? capacity : 100;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getRegisteredCount() {
        return registeredCount != null ? registeredCount : 0;
    }

    public void setRegisteredCount(Integer registeredCount) {
        this.registeredCount = registeredCount;
    }

    public String getOrganizer() {
        return organizer != null && !organizer.isBlank() ? organizer : "Student Affairs & Event Council";
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    // Helper methods for presentation and logic
    public int getSpotsRemaining() {
        int cap = getCapacity();
        int reg = getRegisteredCount();
        return Math.max(0, cap - reg);
    }

    public boolean isFull() {
        return getSpotsRemaining() <= 0;
    }

    public int getFillPercentage() {
        if (getCapacity() <= 0) return 100;
        int pct = (int) Math.round(((double) getRegisteredCount() / getCapacity()) * 100);
        return Math.min(100, Math.max(0, pct));
    }

    public String getCategorySlug() {
        return getCategory().trim().toLowerCase();
    }

    public String getCategoryIcon() {
        String cat = getCategory().toLowerCase();
        if (cat.contains("cultur")) return "🎭";
        if (cat.contains("tech")) return "⚡";
        if (cat.contains("manag")) return "📈";
        if (cat.contains("sport")) return "🏆";
        return "✦";
    }
}
