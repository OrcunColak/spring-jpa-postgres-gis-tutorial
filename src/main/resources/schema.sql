CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS postgis_topology;

DROP INDEX IF EXISTS geofences_geometry_polygon_idx;
DROP TABLE IF EXISTS geofences;

CREATE TABLE geofences
(
  id UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
  name TEXT NOT NULL,

  geometry_polygon GEOMETRY(POLYGON, 4326) NOT NULL,
  geometry_point GEOMETRY(POINT, 4326) NOT NULL
);

CREATE INDEX geofences_geometry_polygon_idx ON geofences USING gist(geometry_polygon);