
package com.colak.springjpapostgresgistutorial.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

public record CreateGeofenceRequest(@JsonProperty("name") String name,
                                    @JsonProperty("geometry_polygon") Polygon geometryPolygon,
                                    @JsonProperty("geometry_point") Point geometryPoint) {
}
