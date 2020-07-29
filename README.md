<h1 align = "center">
    Online shopping System
</h1>

---

<img alt="PyPI - Java Version 8" src="https://img.shields.io/badge/java%20-8-green"> 

<p>
<img src = "front screen.PNG">
</p>

<h1>Table of Content</h1>

- [Introduction](#introduction)
- [Class diagram of the system](#class-diagram-of-the-system)
- [Technology Stack](#technology-stack)
- [Running](#running)
- [Contributors](#contributors)



## Introduction
---
-It helps the individual shopkeepers spread their business through the portal.
-To help the customers shop online with a variety of clothes with no need to go out for shopping.


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
  path src\projectshopping\LoadScreen.java
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
