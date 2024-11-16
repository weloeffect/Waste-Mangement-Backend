package com.example.garbagecollection.util;

import com.example.garbagecollection.entity.Bin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GeoUtils {

    public static List<Bin> calculateShortestRoute(double driverLat, double driverLong, List<Bin> bins) {
        // A simple nearest neighbor heuristic for route optimization
        List<Bin> route = new ArrayList<>(bins);
        route.sort(Comparator.comparingDouble(bin -> calculateDistance(driverLat, driverLong, bin.getLatitude(), bin.getLongitude())));
        return route;
    }

    private static double calculateDistance(double lat1, double long1, double lat2, double long2) {
        // Haversine formula for distance calculation
        double earthRadius = 6371.0; // Radius of Earth in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLong = Math.toRadians(long2 - long1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLong / 2) * Math.sin(dLong / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
}
