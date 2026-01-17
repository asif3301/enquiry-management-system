# Enquiry Management System (EMS)

Enquiry Management System is a Java web application built using **Servlet, JSP, JDBC, and MySQL**.
It allows users/admin to manage enquiries with full **CRUD operations** (Create, Read, Update, Delete).

---

## 🚀 Features

✅ User Login / Logout  
✅ Add New Enquiry (Registration)  
✅ View All Enquiries (List)  
✅ Update Enquiry  
✅ Delete Enquiry  
✅ JSP-based UI (menu page + forms)  
✅ MySQL Database Integration using JDBC  

---

## 🛠 Tech Stack

- **Backend:** Java, Servlet
- **Frontend:** JSP, HTML, CSS
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Server:** Apache Tomcat
- **IDE:** Eclipse

---

## 📂 Project Structure

ems/
├── src/main/java/
│ └── com/ems/
│ ├── controller/
│ │ ├── LoginController.java
│ │ ├── LogoutController.java
│ │ ├── RegistrationController.java
│ │ ├── ReadRegistrationController.java
│ │ ├── UpdateRegistrationController.java
│ │ └── DeleteRegistrationController.java
│ └── model/
│ ├── DBService.java
│ └── DBServiceImpl.java
├── src/main/webapp/
│ ├── index.jsp
│ └── WEB-INF/
│ ├── lib/
│ │ └── mysql-connector-j-9.4.0.jar
│ └── views/
│ ├── menu.jsp
│ ├── Registration.jsp
│ ├── list_registration.jsp
│ └── update_registration.jsp
└── .gitignore
