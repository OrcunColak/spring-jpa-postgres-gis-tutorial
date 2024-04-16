package com.colak.springjpapostgresgistutorial.service;

import com.colak.springjpapostgresgistutorial.jpa.Geofence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeofenceServiceTest {

    @Autowired
    private GeofenceService geofenceService;

    @Test
    void findAllByLngLat() {
        List<Geofence> geofenceList = geofenceService.findAllByLngLat(32.8597, 39.9334);
        assertThat(geofenceList).hasSize(1);

        Geofence first = geofenceList.getFirst();
        assertThat(first.getName()).isEqualTo("Geofence 1");
    }
}