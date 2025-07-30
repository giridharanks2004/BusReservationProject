# 🚌 Bus Reservation System (Java + JDBC + MySQL)

A simple Bus Reservation System built using **Java**, **JDBC**, and **MySQL** to demonstrate backend development concepts including database connectivity, CRUD operations, object-oriented design (OOP), and transaction management.

---

## 📌 Features

- View available buses with capacity
- Book a seat by entering user and bus details
- Check seat availability before booking
- Insert new passengers into the database
- Handle SQL exceptions and input validations
- Implements `DAO` structure for clean separation of logic

---

## 🛠 Tech Stack

- **Java 17**
- **MySQL 8.x**
- **JDBC**
- **Git** (for version control)

---

## 📂 Project Structure

```
/
├── Bus.java             # POJO for Bus details 
├── BusDAO.java          # DAO for bus-related DB logic
├── Booking.java         # Handles booking logic and transactions
├── BookingDAO           DAO for bus-related DB logic       
├── DBConnect.java       # Manages DB connection
└── App.java       # Main program (driver class)
```

---

## 👨‍💻 Author

**Giridharan Kandasamy**  
Backend Developer in progress | Java | SQL | JDBC | Spring Boot (coming soon)

---

## 🏁 Next Steps

- Convert this to a **Spring Boot REST API**
- Add **user login/authentication**
- Create a **frontend (HTML/CSS/JS or React)** for users to book tickets online
- Deploy using **Docker** or **Heroku**

---

## 📃 License

This project is open-source and available under the MIT License.
