# 💼 Volunteer Management System (VMS)

A web-based application for managing volunteers, built using **Spring Boot**, **Thymeleaf**, and **MySQL**.
Volunteer Management System (VMS) is a web-based application designed to help organizations efficiently manage their volunteers. The system allows users to add, update, search, and delete volunteer records, ensuring all data is validated and accurate. With a user-friendly interface and robust backend validation, VMS streamlines the process of organizing volunteer information for non-profits, event coordinators, and community groups.
---

## ✨ Features

- 📝 **Add Volunteers**: Register new volunteers with name, age, department, and location.
- ✅ **Validation**: Ensures all fields are valid (e.g., required fields, age between 18 and 100).
- 🔍 **Search & Filter**: Find volunteers by name, age, department, or location.
- ✏️ **Edit & Delete**: Update or remove volunteer records.
- ⚠️ **Exception Handling**: Friendly error pages for unexpected issues.
- 📱 **Responsive UI**: Modern interface using Bootstrap and Thymeleaf.

---

## 🛠️ Technologies Used

### 🔹 Backend
- Spring Boot
- Spring Data JPA
- Hibernate Validator

### 🔹 Frontend
- Thymeleaf
- Bootstrap 5

### 🔹 Database
- MySQL

## 🚀 Getting Started

### ✅ Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven
- MySQL

****Project Structure****
volunteer-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/example/vms/
│   │   │   ├── controller/        # Controllers
│   │   │   ├── model/             # Volunteer entity
│   │   │   ├── repository/        # Spring Data JPA repositories
│   │   │   ├── service/           # Business logic
│   │   │   └── VmsApplication.java
│   │   └── resources/
│   │       ├── templates/         # Thymeleaf templates
│   │       ├── static/            # CSS, JS, Bootstrap
│   │       └── application.properties
│   └── test/                      # Test classes
├── pom.xml
└── README.md

**🙌 Acknowledgements**
Spring Boot
Thymeleaf
Bootstrap 5
MySQL
Hibernate Validator

**👨‍💻 Author**
Developed with ❤️ by Anuragsinh Gohil
