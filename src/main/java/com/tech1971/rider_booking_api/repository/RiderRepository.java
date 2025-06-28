package com.tech1971.rider_booking_api.repository;

import com.tech1971.rider_booking_api.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}
