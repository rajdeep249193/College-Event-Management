package com.example.collegeevents.repository;

import com.example.collegeevents.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByOrderByEventDateAsc();
    List<Event> findByCategoryIgnoreCaseOrderByEventDateAsc(String category);
    long countByCategoryIsNotNull();
}
