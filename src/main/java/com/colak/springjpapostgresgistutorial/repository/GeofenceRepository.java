package com.colak.springjpapostgresgistutorial.repository;

import com.colak.springjpapostgresgistutorial.jpa.Geofence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GeofenceRepository extends CrudRepository<Geofence, UUID> {

    @Query(
            value = """
                        SELECT g.*
                        FROM geofences g
                        WHERE ST_Intersects(g.geometry_polygon, ST_SetSRID(ST_MakePoint(:lng, :lat), 4326))
                    """,
            nativeQuery = true
    )
    List<Geofence> findAllByLngLat(Double lng, Double lat);
}
