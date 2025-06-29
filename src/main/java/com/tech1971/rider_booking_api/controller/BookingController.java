package com.tech1971.rider_booking_api.controller;

import com.tech1971.rider_booking_api.entity.Booking;
import com.tech1971.rider_booking_api.models.GenericResponse;
import com.tech1971.rider_booking_api.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @Tag(name = "Booking Controller", description = "Endpoints for managing bookings")
    @RequestMapping("api/v1/bookings")
    public class BookingController {

        private final BookingService bookingService;

        public BookingController(BookingService bookingService) {
            this.bookingService = bookingService;
        }

        @Operation(summary = "Create a new booking")
        @PostMapping("/create")
        public ResponseEntity<GenericResponse<Booking>> createBooking(@Valid @RequestBody Booking booking) {
            return bookingService.createBooking(booking);
        }

        @Operation(summary = "Update an    existing booking")
        @PutMapping("/update/{id}")
        public ResponseEntity<GenericResponse<Booking>> updateBooking(@PathVariable Long id, @Valid @RequestBody Booking booking) {
            return bookingService.updateBooking(id, booking);
        }

        @Operation(summary = "Delete a booking by ID")
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<GenericResponse<Void>> deleteBooking(@PathVariable Long id) {
            return bookingService.deleteBooking(id);
        }

        @Operation(summary = "Get all bookings")
        @GetMapping("/getAll")
        public ResponseEntity<GenericResponse<List<Booking>>> getAllBookings() {
            return bookingService.getAllBookings();
        }
    }
























































