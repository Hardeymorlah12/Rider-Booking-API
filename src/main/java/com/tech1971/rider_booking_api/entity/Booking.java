package com.tech1971.rider_booking_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Booking {
        @Id
        @Getter
        @Setter
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Getter
        @Setter
        @NotBlank(message = "Pickup location is required")
        private String pickupLocation;

        @Getter
        @Setter
        @NotBlank(message = "Drop-off location is required")
        private String dropOffLocation;

//        @Column(unique = true)
//        @JoinColumn(name = "rider_id", nullable = false)
//        private Rider rider;

        @ManyToOne(fetch = FetchType.LAZY) // or EAGER
        @JoinColumn(name = "rider_id", nullable = false)
        private Rider rider;

        public void setRider(Rider rider) {
                this.rider = rider;
        }

        public Rider getRider() {
                return rider;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getPickupLocation() {
                return pickupLocation;
        }

        public void setPickupLocation(String pickupLocation) {
                this.pickupLocation = pickupLocation;
        }

        public String getDropOffLocation() {
                return dropOffLocation;
        }

        public void setDropOffLocation(String dropOffLocation) {
                this.dropOffLocation = dropOffLocation;
        }
}