package com.colak.springjpapostgresgistutorial.service;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class GeofenceResponse {
    private final UUID id;
    private final String name;
    private final Polygon geometryPolygon;
    private final Point geometryPoint;
}

