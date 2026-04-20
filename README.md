# 🛒 Product Management System (Spring Boot)

A RESTful backend application for managing users, products, carts, and orders with role-based access (`USER`, `ADMIN`, `SUPERADMIN`).

---

## 🚀 Features

- User Registration & Authentication
- Role-based APIs (User / Admin / SuperAdmin)
- Product Management
- Cart Management
- Order Placement & Tracking

---

## ⚙️ Tech Stack

- Java
- Spring Boot
- Spring Security
- JPA / Hibernate
- Lombok
- Maven

---


# 📌 API LIST

## 👑 SUPER ADMIN

POST   /superadmin/admin  
GET    /superadmin  
GET    /superadmin/order  

---

## 👤 USER

POST   /user/auth  
GET    /user/me  

---

## 📦 PRODUCT (ADMIN)

POST   /admin/products  
PATCH  /admin/products/{id}  
GET    /admin/products  
GET    /admin/products/categories/{category}  
PATCH  /admin/products/{id}/isEnabled/{true|false}  

---
## 🛍️ PRODUCT (USER)

GET    /user/products/categories/{category}  
---
## 🛒 CART

POST   /user/cart/pid/{pid}/qty/{qty}  
GET    /user/cart  
DELETE /user/cart/{id}  
---

## 📦 ORDER

POST   /user/addorder  
