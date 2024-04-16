package com.colak.springjpapostgresgistutorial.service;

import com.colak.springjpapostgresgistutorial.jpa.Geofence;
import com.colak.springjpapostgresgistutorial.repository.GeofenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeofenceService {

    private final GeofenceRepository geofenceRepository;

    @Transactional
    public GeofenceResponse create(CreateGeofenceRequest requestBody) {
        Geofence newGeofence = new Geofence();
        newGeofence.setName(requestBody.name());
        newGeofence.setGeometryPolygon(requestBody.geometryPolygon());
        newGeofence.setGeometryPoint(requestBody.geometryPoint());

        Geofence geofence = geofenceRepository.save(newGeofence);

        return new GeofenceResponse(
                geofence.getId(),
                geofence.getName(),
                geofence.getGeometryPolygon(),
                geofence.getGeometryPoint()
        );
    }

    @Transactional(readOnly = true)
    public List<Geofence> findAllByLngLat(Double lng, Double lat) {
        return geofenceRepository.findAllByLngLat(lng, lat);
    }

}
