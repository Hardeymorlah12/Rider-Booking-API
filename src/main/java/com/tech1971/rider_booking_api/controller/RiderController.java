package com.tech1971.rider_booking_api.controller;

//@RestController
//@Tag(name = "Rider Controller", description = "Endpoints for managing riders")
//@RequestMapping("api/v1/riders")

import com.tech1971.rider_booking_api.entity.Rider;
import com.tech1971.rider_booking_api.models.GenericResponse;
import com.tech1971.rider_booking_api.service.RiderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @Tag(name = "Rider Controller", description = "Endpoints for managing riders")
    @RequestMapping("/api/v1/riders")
    public class RiderController {

        private final RiderService riderService;

        public RiderController(RiderService riderService) {
            this.riderService = riderService;
        }

        @Operation(
                summary = "Create a new rider",
                description = "Registers a new rider with name and phone number"
        )
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Rider created successfully"),
                @ApiResponse(responseCode = "400", description = "Invalid request body")
        })
        @PostMapping("/new_rider")
        public ResponseEntity<GenericResponse<Rider>> createRider(@Valid @RequestBody Rider rider) {
            return riderService.createRider(rider);
        }

        @Operation(
                summary = "Update an existing rider",
                description = "Updates the name or phone number of a specific rider"
        )
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Rider updated successfully"),
                @ApiResponse(responseCode = "404", description = "Rider not found")
        })
        @PutMapping("/update/{id}")
        public ResponseEntity<GenericResponse<Rider>> updateRider(@PathVariable Long id, @Valid @RequestBody Rider rider) {
            return riderService.updateRider(id, rider);
        }

        @Operation(
                summary = "Delete a rider by ID",
                description = "Deletes a rider from the system using their ID"
        )
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Rider deleted successfully"),
                @ApiResponse(responseCode = "404", description = "Rider not found")
        })
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<GenericResponse<Void>> deleteRider(@PathVariable Long id) {
            return riderService.deleteRider(id);
        }

        @Operation(
                summary = "Get a rider by ID",
                description = "Retrieves a single rider using their ID"
        )
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Rider retrieved successfully"),
                @ApiResponse(responseCode = "404", description = "Rider not found")
        })
        @GetMapping("/get/{id}")
        public ResponseEntity<GenericResponse<Rider>> getRiderById(@PathVariable Long id) {
            return riderService.getRider(id);
        }

        @Operation(
                summary = "Get all riders",
                description = "Retrieves a list of all registered riders"
        )
        @ApiResponse(responseCode = "200", description = "All riders retrieved successfully")
        @GetMapping("/getAll")
        public ResponseEntity<GenericResponse<List<Rider>>> getAllRiders() {
            return riderService.getAllRiders();
        }
    }











































//    private final RiderService riderService;
//
//    public RiderController(RiderService riderService) {
//        this.riderService = riderService;
//    }
//
//    @Operation(summary = "Create a new rider")
//    @PostMapping("/create")
//    public ResponseEntity<GenericResponse<Rider>> createRider(@Valid @RequestBody Rider rider) {
//        return riderService.createRider(rider);
//    }
//    @Operation(summary = "Update an existing rider")
//    @PutMapping("/update/{id}")
//    public ResponseEntity<GenericResponse<Rider>> updateRider(@PathVariable Long id, @Valid @RequestBody Rider rider) {
//        return riderService.updateRider(id, rider);
//    }
//    @Operation(summary = "Delete a rider by ID")
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<GenericResponse<Void>> deleteRider(@PathVariable Long id) {
//        return riderService.deleteRider(id);
//    }
//    @Operation(summary = "Get Rider by ID")
//    @GetMapping("/get/{id}")
//    public ResponseEntity<GenericResponse<Rider>> getRiderById(@PathVariable Long id) {
//        return riderService.getRider(id);
//    }
//    @Operation(summary = "Get all riders")
//    @GetMapping("/getAll")
//    public ResponseEntity<GenericResponse<List<Rider>>> getAllRiders() {
//        return riderService.getAllRiders();
//    }
//


