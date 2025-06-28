# Rider Booking API - Spring Boot

A RESTful API for managing Riders and Bookings using Spring Boot and Spring Data JPA.

---

## 🚀 Features

- Rider & Booking CRUD operations
- Field validation & global exception handling
- Swagger API documentation
- Follows RESTful principles and industry best practices

---

## 🧱 Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- Swagger / OpenAPI

---

## 📁 Project Structure (src/main/java)

```
com.tech1971.rider_booking_api
├── controller
├── dto
├── entity
├── exception
├── models
├── repository
├── service
└── config
```

---

## 🧑‍💻 API Endpoints

### Rider

- `POST /api/v1/riders/new_rider`
- `PUT /api/v1/riders/update/{id}`
- `DELETE /api/v1/riders/delete/{id}`
- `GET /api/v1/riders/get/{id}`
- `GET /api/v1/riders/getAll`

### Booking

- `POST /api/v1/bookings/create`
- `PUT /api/v1/bookings/update/{id}`
- `DELETE /api/v1/bookings/delete/{id}`
- `GET /api/v1/bookings/getAll`

---

## 🧪 Testing the API

### Option 1: Swagger UI

- Visit: `http://localhost:8089/tech1971/api/v1/riders/new_rider/swagger-ui.html`
- Test endpoints directly from the browser

### Option 2: Postman

- Import Postman Collection (provided in submission)

---

## 🛠 Setup Instructions

1. **Clone the repository:**

```
git clone <your-repo-url>
```

2. **Set environment variables or use IntelliJ Run Config:**

```
SPRING_DATASOURCE_USERNAME=your_mysql_user
SPRING_DATASOURCE_PASSWORD=your_mysql_pass
```

3. **Configure **`` (basic):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rider_db
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

4. **Run the app:**

```
mvn spring-boot:run
```

---

## 📦 Download and Submit

1. **Generate a ZIP:**

   - Go to your project root
   - Run:

   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   zip -r rider-booking-api.zip .
   ```

   OR

   - Upload to GitHub and download ZIP from repository

2. **Submit:**

   - Provide the `.zip` or GitHub repository link
   - Include this README in the project root

---

## 📚 Evaluation Criteria

- ✅ RESTful principles adherence
- ✅ API design consistency
- ✅ Error handling quality
- ✅ Documentation completeness
- ✅ Code organisation & clarity

---

## 🧠 Author

**Saheed Adewale**\
Built with ❤️ for 1791 Technologies

