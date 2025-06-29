package com.tech1971.rider_booking_api.service;

import com.tech1971.rider_booking_api.entity.Booking;
import com.tech1971.rider_booking_api.entity.Rider;
import com.tech1971.rider_booking_api.exception.ResourceNotFoundException;
import com.tech1971.rider_booking_api.models.GenericResponse;
import com.tech1971.rider_booking_api.repository.BookingRepository;
import com.tech1971.rider_booking_api.repository.RiderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class BookingService {

        private final BookingRepository bookingRepository;
        private final RiderRepository riderRepository;

        public BookingService(BookingRepository bookingRepository, RiderRepository riderRepository) {
            this.bookingRepository = bookingRepository;
            this.riderRepository = riderRepository;
        }

        public ResponseEntity<GenericResponse<Booking>> createBooking(Booking booking) {
            // Ensure rider exists
            Rider rider = riderRepository.findById(booking.getRider().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Rider not found with ID: " + booking.getRider().getId()));
            booking.setRider(rider);
            Booking saved = bookingRepository.save(booking);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new GenericResponse<>(true, "Booking created", saved, HttpStatus.OK.value()));
        }

        public ResponseEntity<GenericResponse<Booking>> updateBooking(Long id, Booking updatedBooking) {
            Booking existing = bookingRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
            existing.setPickupLocation(updatedBooking.getPickupLocation());
            existing.setDropOffLocation(updatedBooking.getDropOffLocation());

            // Optionally update rider
            if (updatedBooking.getRider() != null) {
                Rider rider = riderRepository.findById(updatedBooking.getRider().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Rider not found with ID: " + updatedBooking.getRider().getId()));
                existing.setRider(rider);
            }

            Booking saved = bookingRepository.save(existing);
            return ResponseEntity.ok(new GenericResponse<>(true, "Booking updated", saved, HttpStatus.OK.value()));
        }

        public ResponseEntity<GenericResponse<Void>> deleteBooking(Long id) {
            Booking booking = bookingRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
            bookingRepository.delete(booking);
            return ResponseEntity.ok(new GenericResponse<>(true, "Booking deleted", null, HttpStatus.OK.value() ));
        }

        public ResponseEntity<GenericResponse<List<Booking>>> getAllBookings() {
            List<Booking> bookings = bookingRepository.findAll();
            return ResponseEntity.ok(new GenericResponse<>(true, "All bookings", bookings, HttpStatus.OK.value()));
        }
    }













































//    public BookingService(BookingRepository bookingRepository, RiderRepository riderRepository) {
//        this.bookingRepository = bookingRepository;
//        this.riderRepository = riderRepository;
//    }
//
//    private final BookingRepository bookingRepository;
//
//    private final RiderRepository riderRepository;
//
//    public ResponseEntity<GenericResponse<Booking>> createBooking(Booking booking) {
//        Long riderId = booking.getRider().getId();
//        Rider rider = riderRepository.findById(riderId).orElseThrow(() -> new EntityNotFoundException("Rider not found "));
//        booking.setRider(rider);
//        Booking saved = bookingRepository.save(booking);
//        return ResponseEntity.ok(new GenericResponse<>(true, "Booking created successfully", saved));
//
//    }
//    public ResponseEntity<GenericResponse<Booking>> updateBooking(Long id, Booking updatedBooking) {
//    Booking existing = bookingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Booking not found"));
//    Rider rider = riderRepository.findById(updatedBooking.getRider().getId()).orElseThrow(() -> new EntityNotFoundException("Rider not found"));
//    existing.setPickupLocation(updatedBooking.getPickupLocation());
//    existing.setDropOffLocation(updatedBooking.getDropOffLocation());
//    existing.setRider(rider);
//
//    Booking saved = bookingRepository.save(existing);
//    return ResponseEntity.ok(new GenericResponse<>(true, "Booking updated successfully", saved));
//
//    }
//    public ResponseEntity<GenericResponse<Void>> deleteBooking(Long id) {
//    if ((!bookingRepository.existsById(id))) {
//        throw new EntityNotFoundException("Booking not found");
//    }
//    bookingRepository.deleteById(id);
//    return ResponseEntity.ok(new GenericResponse<>(true, "Booking deleted successfully", null));
//
//    }
//    public ResponseEntity<GenericResponse<List<Booking>>> getAllBookings() {
//        List<Booking> bookings = bookingRepository.findAll();
//        return ResponseEntity.ok(new GenericResponse<>(true, "All bookings fetched successfully", bookings));
//    }

