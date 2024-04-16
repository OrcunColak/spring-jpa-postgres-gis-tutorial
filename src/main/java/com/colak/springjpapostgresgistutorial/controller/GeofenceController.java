package com.colak.springjpapostgresgistutorial.controller;

import com.colak.springjpapostgresgistutorial.service.CreateGeofenceRequest;
import com.colak.springjpapostgresgistutorial.service.GeofenceResponse;
import com.colak.springjpapostgresgistutorial.service.GeofenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/geofences")

@RequiredArgsConstructor
public class GeofenceController {

    private final GeofenceService geofenceService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GeofenceResponse> create(@RequestBody @Valid CreateGeofenceRequest requestBody) {
        GeofenceResponse geofenceResponse = geofenceService.create(requestBody);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(URI.create("/geofences/" + geofenceResponse.getId()))
                .body(geofenceResponse);
    }
}

