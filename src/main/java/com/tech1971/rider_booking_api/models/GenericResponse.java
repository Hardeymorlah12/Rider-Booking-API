package com.tech1971.rider_booking_api.models;

    public class GenericResponse<T> {

            private boolean success;
            private String message;
            private T data;
            private int status;

            public GenericResponse() {}

            public GenericResponse(boolean success, String message, T data, int status) {
                this.success = success;
                this.message = message;
                this.data = data;
                this.status = status;
            }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isSuccess() {
                return success;
            }

            public void setSuccess(boolean success) {
                this.success = success;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public T getData() {
                return data;
            }

            public void setData(T data) {
                this.data = data;
            }
        }

