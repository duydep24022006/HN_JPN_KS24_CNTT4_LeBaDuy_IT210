package com.example.ss2.controller.old_way;


import com.example.ss2.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    // dữ liệu giả lập
    private List<Event> allEvents = List.of(
            new Event(1, "Spring Framework", "2026-05-01", 500000, 20),
            new Event(2, "Java Conference", "2026-06-15", 0, 0),
            new Event(3, "Music Festival", "2026-07-10", 300000, 5),
            new Event(4, "Hackathon \"Code & Coffee\"", "2026-08-20", 100000, 50)
    );

    @GetMapping("/events/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Event> results;
        if (keyword == null || keyword.trim().isEmpty()) {
            results = allEvents;
        } else {
            String lower = keyword.toLowerCase();
            results = allEvents.stream()
                    .filter(e -> e.getName().toLowerCase().contains(lower))
                    .collect(Collectors.toList());
        }

        model.addAttribute("keyword", keyword == null ? "" : keyword);
        model.addAttribute("events", results);
        return "events/search"; // trỏ tới search.jsp
    }
}
