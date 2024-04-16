package com.colak.springjpapostgresgistutorial.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.util.UUID;

// Every geometric shape has a spatial reference system associated with it, and each such reference system
// has a Spatial Reference System ID (SRID).
// The SRID is used to tell which spatial reference system will be used to interpret each spatial object.
//
// A common SRID in use is 4326, which represents spatial data using longitude and latitude coordinates on
// the Earth’s surface as defined in the WGS84 standard, which is also used for the Global Positioning System (GPS).
@Entity
@Table(name = "geofences")

@Getter
@Setter
public class Geofence {

    @Id
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "geometry_polygon", columnDefinition = "geometry(Polygon, 4326)", nullable = false)
    private Polygon geometryPolygon;

    @Column(name = "geometry_point", columnDefinition = "geometry(Point, 4326)", nullable = false)
    private Point geometryPoint;
}
