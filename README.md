<h1 align = "center">
    Online shopping System
</h1>

---

<img alt="PyPI - Java Version" src="https://img.shields.io/badge/python%20-green"> 

<p>
<img src = "OSS.PNG">
</p>

<h1>Table of Content</h1>

- [Introduction](#introduction)
- [ER diagram of the system](#er-diagram-of-the-system)
- [Technology Stack](#technology-stack)
- [Running](#installations-and-running)
- [Contributors](#contributors)



## Introduction

---


---

## Class diagram of the system
---
<img src = "class diagram.jpg">

## Technology Stack

---

- Java
- Netbeans

## Running

---

- Clone this repository

  ```
  git clone https://github.com/aanshi18/online_fashion_store.git
  ```
 
- Here the main java file is 
  ```
  path
  ```
- In this project we had used MySQL database. whose connections are written here.
    ```
    String username = "root";
    String password = "";
    String driverName = "com.mysql.jdbc.Driver";
    String dbName = "fashion_store_db";
    String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
    ResultSet rs;
    Connection conn;
    Statement stmt;
    
    try {
            Class.forName(driverName);
            //OBTAIN DATABASE CONNECTION
            conn = DriverManager.getConnection(dbURL, username, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Exception e = " + e);
        }
    ```




## Contributors

---

| [Dipika Pawar](https://github.com/DipikaPawar12)                                                                                                            | [Aanshi Patwari](https://github.com/aanshi18)                                                                                                            | [Miracle Rindani](https://github.com/mrindani)                                                                                                |
