# 🚑 **Patient Consultation Management System**

## 🌟 Overview
Welcome to the **Patient Consultation Management System**, a sleek and efficient Java-based application designed to handle the management of patient consultations. This app follows the **DAO (Data Access Object)** pattern for clean and scalable data management. With seamless MySQL integration, users can easily add, update, delete, and search for patients and consultations.

## 🏗️ **Project Structure**

```
ma.enset.management_of_patient_consultations
│
├── DAO
│   ├── DBConnection.java
│   ├── IGeneric_DAO.java
│   ├── IPatient_DAO.java
│   ├── Patient_DAO.java
│
├── entities
│   ├── Consultation.java
│   ├── Patient.java
│
├── service
│   ├── CabinetService.java
│   ├── ICabinetService.java
│
├── Main.java
```


## 🚀 **Key Features**

### **👩‍⚕️ Patient Management**
- **Add, Update, Delete Patients**: Full CRUD functionality.
- **Search**: Find patients by **First Name** or **Last Name**.
- **Retrieve Patient Details**: Access detailed information by **Patient ID**.
- **View All Patients**: Get a list of all registered patients.

### **📝 Consultation Management**
- **Add, Update, Delete Consultations**: Manage consultations effortlessly.
- **View Consultations by Patient**: Retrieve all consultations for a specific patient.

## 🛠️ **Installation & Setup**

1. **Clone the repository**:
   ```sh
   git clone <repository-url>
   ```
2. Open the project in your preferred Java IDE.
3. Ensure you have a MySQL database set up with the required tables:
   ```sql
   CREATE TABLE PATIENTS (
       PATIENT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
       First_Name VARCHAR(255),
       Last_Name VARCHAR(255),
       Tel VARCHAR(20),
       Address VARCHAR(255)
   );

   CREATE TABLE CONSULTATIONS (
       CONSULTATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
       CONSULTATION_DATE DATE,
       DESCRIPTION TEXT,
       PATIENT_ID BIGINT,
       FOREIGN KEY (PATIENT_ID) REFERENCES PATIENTS(PATIENT_ID)
   );
   ```
4. Configure your database connection in `DBConnection.java`.

## ⚡ How to Use

- Run `Main.java` to start the application.

## 💻Technologies Used

- Java - The backbone of the application.
- MySQL - Relational database for storing all patient and consultation data.
- JDBC - To interact with the MySQL database seamlessly.

## Contributors

- Ayoub Youhad

