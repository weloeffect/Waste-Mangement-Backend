# Garbage Collection System

This is a project structure for a Garbage Collection System built using Java and Spring Boot. The application is designed to manage garbage bins and drivers efficiently.

## Folder Structure

```plaintext
src/main/java/com/example/garbagecollection/
├── config/
│   └── DatabaseConfig.java        # Configuration for database connections
├── controller/
│   ├── BinController.java         # REST API for managing bins
│   └── DriverController.java      # REST API for managing drivers
├── dto/
│   ├── BinRequestDTO.java         # Data Transfer Object for bin requests
│   └── DriverRequestDTO.java      # Data Transfer Object for driver requests
├── entity/
│   ├── Bin.java                   # Entity class representing bins
│   └── Driver.java                # Entity class representing drivers
├── exception/
│   └── CustomExceptionHandler.java# Global exception handling
├── repository/
│   ├── BinRepository.java         # Repository for bin-related database operations
│   └── DriverRepository.java      # Repository for driver-related database operations
├── service/
│   ├── BinService.java            # Interface for bin services
│   ├── BinServiceImpl.java        # Implementation of bin services
│   ├── DriverService.java         # Interface for driver services
│   └── DriverServiceImpl.java     # Implementation of driver services
├── util/
│   └── GeoUtils.java              # Utility class for geospatial calculations
└── GarbageCollectionApplication.java # Main application entry point
```
