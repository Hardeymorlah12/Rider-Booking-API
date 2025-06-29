package com.tech1971.rider_booking_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


    @Getter
    @Entity
    public class Rider {
        @Setter
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Setter
        @NotBlank(message = "Name is required")
        private String name;

        public Long getId() {
            return id;
        }

        @Setter
        @Column(unique = true)
        @NotBlank(message = "Phone number is required")
        private String phoneNumber;

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

