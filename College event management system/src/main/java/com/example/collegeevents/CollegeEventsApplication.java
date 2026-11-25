package com.example.collegeevents;

import com.example.collegeevents.model.Event;
import com.example.collegeevents.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class CollegeEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeEventsApplication.class, args);
    }

   
    @Bean
    CommandLineRunner seedFestEvents(EventRepository repository) {
        return args -> {
            boolean hasRichEvents = repository.findAll().stream()
                    .anyMatch(e -> e.getCategory() != null && !e.getCategory().equalsIgnoreCase("General"));

         
            if (repository.count() < 4 || !hasRichEvents) {
                repository.deleteAll();

                LocalDateTime base = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);

                List.of(
                        
                        new Event(
                                "Battle of the Bands: Echoes of Rock",
                                "Cultural",
                                "Campus rock bands and acoustic ensembles face off on the amphitheater stage with live amps, original riffs, and thunderous crowd voting.",
                                "Open Air Amphitheater",
                                base.plusDays(3).withHour(18).withMinute(30),
                                350,
                                215,
                                "Music & Performing Arts Society"
                        ),
                        new Event(
                                "Classical & Folk Dance Night (Nrityakala)",
                                "Cultural",
                                "A celebration of Indian classical Kathak, Bharatanatyam, and regional folk traditions with vibrant choreography and live percussion.",
                                "Grand University Auditorium",
                                base.plusDays(6).withHour(17).withMinute(0),
                                500,
                                480,
                                "Cultural Heritage Club"
                        ),
                        new Event(
                                "Street Play Competition (Nukkad Natak)",
                                "Cultural",
                                "High-octane street plays tackling vital social issues through rhythmic beats, satirical monologues, and expressive synchronized ensembles.",
                                "Central Plaza Circle",
                                base.plusDays(9).withHour(15).withMinute(30),
                                200,
                                120,
                                "Dramatics Wing (Rangmanch)"
                        ),

                        
                        new Event(
                                "AI Code Sprint: LLM & Agentic Hackathon",
                                "Technical",
                                "24-hour sprint to build autonomous AI agents and innovative web apps using cutting-edge models. Cash pool of ₹50,000 for top prototypes.",
                                "Tech Hub - Innovation Lab 3",
                                base.plusDays(4).withHour(9).withMinute(0),
                                120,
                                110,
                                "ACM & Developer Student Clubs"
                        ),
                        new Event(
                                "RoboWars: Combat Robotics Arena",
                                "Technical",
                                "Custom-built 15kg and 30kg combat bots clash inside a reinforced steel battlecage for ultimate destructive supremacy.",
                                "Mechanical Quad Arena",
                                base.plusDays(7).withHour(14).withMinute(0),
                                250,
                                250,
                                "Robotics & Mechatronics Society"
                        ),
                        new Event(
                                "Hack-a-Web: 48h Full-Stack Challenge",
                                "Technical",
                                "Rapidly architect, develop, and deploy cloud-native web apps. Judges evaluate responsive design, accessibility, and clean architecture.",
                                "Computer Science Center - Lab 1",
                                base.plusDays(11).withHour(10).withMinute(0),
                                100,
                                45,
                                "Web & Open Source Guild"
                        ),

                        
                        new Event(
                                "Shark Tank Campus: Business Plan Pitch",
                                "Management",
                                "Student founders pitch disruptive business models and seed-stage ventures directly to angel investors and industry leaders.",
                                "Management Block - Boardroom A",
                                base.plusDays(5).withHour(11).withMinute(0),
                                80,
                                68,
                                "E-Cell & Entrepreneurship Guild"
                        ),
                        new Event(
                                "Corporate Mock Interview & HR Gauntlet",
                                "Management",
                                "Simulated corporate stress interviews, psychometric evaluations, and personal resume teardowns led by Senior HR executives.",
                                "Executive Seminar Hall",
                                base.plusDays(8).withHour(13).withMinute(30),
                                60,
                                52,
                                "Corporate Relations & Placement Cell"
                        ),
                        new Event(
                                "Treasure Hunt Strategy: Chanakya's Quest",
                                "Management",
                                "Test crisis management, logical cipher decryption, and resource allocation under intense time constraints across campus.",
                                "Central Library Lawns",
                                base.plusDays(12).withHour(16).withMinute(0),
                                150,
                                85,
                                "Operations & Leadership Forum"
                        ),

                        
                        new Event(
                                "Inter-College Cricket League (Floodlight Cup)",
                                "Sports",
                                "High-intensity 10-over floodlight cricket tournament pitting rival departments and colleges for the grand championship trophy.",
                                "Main University Sports Stadium",
                                base.plusDays(2).withHour(16).withMinute(30),
                                400,
                                380,
                                "University Sports Directorate"
                        ),
                        new Event(
                                "All-Star Badminton Championship",
                                "Sports",
                                "Fast-paced indoor knockout tournament for Men's and Women's singles and doubles under BWF international match rules.",
                                "Indoor Sports Complex - Courts 1-3",
                                base.plusDays(10).withHour(8).withMinute(30),
                                80,
                                72,
                                "Racquet Sports Club"
                        ),
                        new Event(
                                "Esports FIFA & Valorant LAN Tournament",
                                "Sports",
                                "Premier esports battle on ultra-high refresh tournament rigs with live stage shoutcasting, spectator projection, and medals.",
                                "Student Activity Center - Gaming Arena",
                                base.plusDays(13).withHour(15).withMinute(0),
                                160,
                                140,
                                "Campus Esports & Gaming Union"
                        )
                ).forEach(repository::save);
            }
        };
    }
}
