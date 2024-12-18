package ru.appline.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.CompassModel;

import java.util.Map;

@RestController
@RequestMapping("/compass")
public class CompassController {

    private static final CompassModel compassModel=CompassModel.getInstance();

    @PostMapping("/setDegree")
    public void setDegree(@RequestBody Map<String, String> degreeRanges) {
        compassModel.updateDirections(degreeRanges);
    }

    @GetMapping("/getDegree")
    public ResponseEntity<String> getDegree(@RequestParam int degree) {
        String direction = compassModel.findDirection(degree);
        return ResponseEntity.ok(direction);
    }
}