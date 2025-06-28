package com.tech1971.rider_booking_api.repository;

import com.tech1971.rider_booking_api.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
