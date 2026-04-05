#  Sistema de Reciclaje - Backend API

Bienvenido al repositorio del Backend del Sistema de Reciclaje. Esta API RESTful fue desarrollada para gestionar usuarios, centros de acopio, actividades de reciclaje y un sistema de recompensas basado en puntos.

## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java 17+
* **Framework:** Spring Boot
* **Seguridad:** Spring Security con JSON Web Tokens (JWT)
* **Base de Datos:** PostgreSQL
* **ORM:** Hibernate / Spring Data JPA

## 📊 Diagrama Entidad-Relación (ER)

> <img width="1581" height="1277" alt="image" src="https://github.com/user-attachments/assets/53dc11a1-4929-4c70-a235-0d229a888384" />


## ⚙️ Características Principales
* **Autenticación y Autorización:** Endpoints protegidos mediante JWT, separando roles (Ej. `ADMI`, `CLIENTE`).
* **Gestión de Usuarios y Roles:** Registro seguro con contraseñas encriptadas (Bcrypt).
* **Transacciones:** Lógica de acumulación de puntos por actividad y canje de recompensas.
* **Integridad de Datos:** Base de datos relacional completamente normalizada.

---
*Desarrollado para la evaluación técnica.*
