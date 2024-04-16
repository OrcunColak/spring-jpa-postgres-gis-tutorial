INSERT INTO geofences (name, geometry_polygon, geometry_point)
VALUES
  ('Geofence 1', ST_GeomFromText('POLYGON((30 10, 40 40, 20 40, 10 20, 30 10))', 4326), ST_GeomFromText('POINT(35 20)', 4326)),
  ('Geofence 2', ST_GeomFromText('POLYGON((50 10, 60 20, 70 10, 50 10))', 4326), ST_GeomFromText('POINT(55 15)', 4326)),
  ('Geofence 3', ST_GeomFromText('POLYGON((10 50, 20 60, 30 50, 10 50))', 4326), ST_GeomFromText('POINT(15 55)', 4326));
