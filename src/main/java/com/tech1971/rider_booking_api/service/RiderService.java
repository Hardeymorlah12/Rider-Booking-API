package com.tech1971.rider_booking_api.service;

import com.tech1971.rider_booking_api.entity.Rider;
import com.tech1971.rider_booking_api.exception.ResourceNotFoundException;
import com.tech1971.rider_booking_api.models.GenericResponse;
import com.tech1971.rider_booking_api.repository.RiderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class RiderService {

        private final RiderRepository riderRepository;

        public RiderService(RiderRepository riderRepository) {
            this.riderRepository = riderRepository;
        }

        public ResponseEntity<GenericResponse<Rider>> createRider(Rider rider) {
            Rider saved = riderRepository.save(rider);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new GenericResponse<>(true, "Rider created successfully", saved, HttpStatus.OK.value()));
        }

        public ResponseEntity<GenericResponse<Rider>> updateRider(Long id, Rider rider) {
            Rider existing = riderRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Rider not found with ID: " + id));
            existing.setName(rider.getName());
            existing.setPhoneNumber(rider.getPhoneNumber());
            Rider updated = riderRepository.save(existing);
            return ResponseEntity.ok(new GenericResponse<>(true, "Rider updated successfully", updated, HttpStatus.OK.value()));
        }

        public ResponseEntity<GenericResponse<Void>> deleteRider(Long id) {
            Rider rider = riderRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Rider not found with ID: " + id));
            riderRepository.delete(rider);
            return ResponseEntity.ok(new GenericResponse<>(true, "Rider deleted successfully", null, HttpStatus.OK.value()));
        }

        public ResponseEntity<GenericResponse<Rider>> getRider(Long id) {
            Rider rider = riderRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Rider not found with ID: " + id));
            return ResponseEntity.ok(new GenericResponse<>(true, "Rider retrieved", rider, HttpStatus.OK.value()));
        }

        public ResponseEntity<GenericResponse<List<Rider>>> getAllRiders() {
            List<Rider> riders = riderRepository.findAll();
            return ResponseEntity.ok(new GenericResponse<>(true, "All riders", riders, HttpStatus.OK.value()));
        }
    }












































///    public RiderService(RiderRepository riderRepository) {
//        this.riderRepository = riderRepository;
//    }
///
// /  private final RiderRepository riderRepository;
//
//    public ResponseEntity<GenericResponse<Rider>> createRider(Rider rider) {
//        Rider saved = riderRepository.save(rider);
//        return ResponseEntity.ok(new GenericResponse<>(true, "Rider created", saved));
//    }
//    public ResponseEntity<GenericResponse<Rider>> updateRider(Long id, Rider updated) {
//        Rider rider = riderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rider not found"));
//        rider.setName(updated.getName());
//        rider.setPhoneNumber(updated.getPhoneNumber());
//        Rider saved = riderRepository.save(rider);
//        return ResponseEntity.ok((new GenericResponse<>(true, "Rider updated", saved)));
//
//    }
//    public ResponseEntity<GenericResponse<Void>> deleteRider(Long id) {
//        riderRepository.deleteById(id);
//        return ResponseEntity.ok(new GenericResponse<>(true, "Rider deleted", null));
//
//    }
//    public ResponseEntity<GenericResponse<Rider>> getRider(Long id) {
//        Rider rider = riderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rider not found"));
//        return ResponseEntity.ok(new GenericResponse<>(true, "Rider retrieved", rider));
//
//    }
//public ResponseEntity<GenericResponse<List<Rider>>> getAllRiders() {
//        return ResponseEntity.ok(new GenericResponse<>(true, "Riders fetched", riderRepository.findAll() ));
//}
