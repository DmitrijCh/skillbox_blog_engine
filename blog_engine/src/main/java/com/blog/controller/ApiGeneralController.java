package com.blog.controller;

import com.blog.api.request.CalendarRequest;
import com.blog.api.request.TagRequest;
import com.blog.api.response.*;
import com.blog.service.CalendarService;
import com.blog.service.SettingsService;
import com.blog.service.StatisticService;
import com.blog.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiGeneralController {

    private final InitResponse initResponse;
    private final SettingsService settingsService;
    private final TagService tagService;
    private final CalendarService calendarService;
    private final StatisticService statisticService;

    @GetMapping("/init")
    private InitResponse init() {
        return initResponse;
    }

    @GetMapping("/settings")
    public SettingsResponse settings() {
        return settingsService.getGlobalSettings();
    }

    @GetMapping("/tag")
    public ResponseEntity<TagResponse> tag(TagRequest request) {
        return ResponseEntity.ok(tagService.response(request));
    }

    @GetMapping("/calendar")
    public ResponseEntity<CalendarResponse> calendar(CalendarRequest request) {
        return ResponseEntity.ok(calendarService.response(request));
    }

    @GetMapping("/statistics/my")
    public ResponseEntity<StatisticResponse> myStatistic() {
        return ResponseEntity.ok(statisticService.getMy());
    }

    @GetMapping("/statistics/all")
    public ResponseEntity<StatisticResponse> allStatistic() {
        return ResponseEntity.ok(statisticService.getAll());
    }
}
