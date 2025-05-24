# API REST - Sistema de Reservas de una Agencia de Viajes

Esta es una API RESTful desarrollada como una aplicación monolítica utilizando **Spring Boot**, 
**Spring Data JPA** y una base de datos relacional (**PostgreSQL** o **MySQL**).

La API permite gestionar reservas de viajes, asociando vuelos y hoteles disponibles.  
Se implementan operaciones REST para consultar vuelos y hoteles, así como para crear y consultar reservas.

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL

## Para ejecutar el proyecto

1. [Enlace al repositorio](https://github.com/JaimeBonBol/Primer_MicroServicio)
2. Clonar el repositorio:
```bash

git clone https://github.com/JaimeBonBol/Primer_MicroServicio.git

```
> **Nota:**
> Recuerda configurar tu base de datos en `application.properties`

---

## Entidades y sus Atributos

### 🏨 Hotel
Representa un hotel disponible para reserva.

- `id` (Long) Identificador único generado automáticamente.
- `nombre` (String) Nombre del hotel.
- `categoria` (String) Categoría o clasificación del hotel (ej. "4 estrellas").
- `precio` (BigDecimal) Precio por noche en formato decimal.
- `disponibilidad` (Boolean) Indica si el hotel está disponible para reservas.



### ✈️ Vuelo
Representa un vuelo disponible para reserva.

- `id` (Long) Identificador único generado automáticamente.
- `compania` (String) Nombre de la compañía aérea.
- `fecha` (LocalDate) Fecha del vuelo (sin hora).
- `precio` (BigDecimal) Precio del vuelo en formato decimal.
- `plazasDisponibles` (Integer) Número de plazas disponibles para reserva.



### 📄 Reserva
Representa una reserva realizada por un usuario, vinculada a un vuelo y a un hotel.

- `id` (Long) Identificador único generado automáticamente.
- `usuario` (String) Nombre del usuario que realiza la reserva.
- `dni` (String) DNI o identificación del usuario.
- `vueloAsociado` (Vuelo) Vuelo reservado (relación ManyToOne).
- `hotelAsociado` (Hotel) Hotel reservado (relación ManyToOne).

---

> **Nota:**  
> Al crear una reserva, se verifica que el vuelo tenga plazas disponibles. Si no quedan plazas, la API devuelve un error y no se permite crear la reserva.

---

## 📦 Requisitos y funcionalidades principales

Esta API REST implementa una solución de gestión de reservas en una agencia de viajes.  
Los principales requisitos funcionales son:

- Aplicación monolítica con arquitectura por capas.
- Gestión de tres entidades: **Hotel**, **Vuelo** y **Reserva**.
- Las reservas se vinculan a un **vuelo** y a un **hotel**.
- No se permite crear una reserva en vuelos sin plazas disponibles y hoteles sin disponibilidad.

---

## 📂 Estructiura del proyecto

El proyecto está dividido en los siguientes paquetes:

````text
│
├── controller/    # Controladores REST (exponen los endpoints)
├── service/       # Lógica de negocio
├── repository/    # Interfaces de acceso a datos (Spring Data JPA)
└── model/         # Entidades JPA (Hotel, Vuelo, Reserva)
````

---

## 📡 Endpoints de la API

### Hotel

| Método | Endpoint                     | Descripción                                     | Body requerido |
|--------|------------------------------|-------------------------------------------------|----------------|
| GET    | `/api/hoteles`               | Listar todos los hoteles                        | ❌ No           |
| GET    | `/api/hoteles/disponibles`   | Listar hoteles con habitaciones disponibles     | ❌ No           |
| GET    | `/api/hoteles/id/{id}`       | Buscar hotel por ID                             | ❌ No           |
| GET    | `/api/hoteles/nombre/{nombre}` | Buscar hotel por nombre                         | ❌ No           |
| POST   | `/api/hoteles`               | Crear un nuevo hotel                            | ✅ Sí           |
| PUT    | `/api/hoteles/{id}`          | Actualizar datos de un hotel                    | ✅ Sí           |
| DELETE | `/api/hoteles/{id}`          | Eliminar un hotel por ID                        | ❌ No           |


Ejemplo de RequestBody:

```json
{
  "nombre": "Hotel Rio",
  "categoria": "5 estrellas",
  "precio": 168.50,
  "disponibilidad": true
}
```


### Vuelo

| Método | Endpoint                      | Descripción                                     | Body requerido |
|--------|-------------------------------|-------------------------------------------------|----------------|
| GET    | `/api/vuelos`                 | Listar todos los vuelos                         | ❌ No           |
| GET    | `/api/vuelos/disponibles`     | Listar vuelos con plazas disponibles            | ❌ No           |
| GET    | `/api/vuelos/{id}`            | Buscar vuelo por ID                             | ❌ No           |
| POST   | `/api/vuelos`                 | Crear un nuevo vuelo                            | ✅ Sí           |
| PUT    | `/api/vuelos/{id}`            | Actualizar datos de un vuelo                    | ✅ Sí           |
| DELETE | `/api/vuelos/{id}`            | Eliminar un vuelo por ID                        | ❌ No           |


Ejemplo de RequestBody:
```json
{
  "compania": "Ier",
  "fecha": "2025-04-12",
  "precio": 97.50,
  "plazasDisponibles": 150
}
```

### Reserva

| Método | Endpoint                  | Descripción                                     | Body requerido |
|--------|---------------------------|-------------------------------------------------|----------------|
| GET    | `/api/reservas`           | Listar todas las reservas                       | ❌ No           |
| GET    | `/api/reservas/{id}`      | Buscar reserva por ID                           | ❌ No           |
| POST   | `/api/reservas`           | Crear una nueva reserva (requiere hotel y vuelo)| ✅ Sí           |
| PUT    | `/api/reservas/{id}`      | Actualizar una reserva existente                | ✅ Sí           |
| DELETE | `/api/reservas/{id}`      | Eliminar una reserva por ID                     | ❌ No           |


Ejemplo de RequestBody:
```json
{
  "usuario": "Juan Martínez",
  "dni": "12345678A",
  "vueloAsociado": { "id": 1 },
  "hotelAsociado": { "id": 2 }
}
```

---

## 🌐 Vista / Interfaz de Usuario

La aplicación cuenta con una interfaz gráfica web para mostrar los hoteles, los vuelos
y las reservas de la base de datos.

### ¿Cóomo acceder?

La vista está despelgada en `http://localhost:8080/index.html`

---

## 🙋‍♂️ Sobre este proyecto

Este proyecto ha sido mi **primera experiencia desarrollando una API REST**, aplicando una arquitectura por capas y buenas prácticas con **Spring Boot** y **JPA**.  
He aprendido mucho sobre el diseño de entidades, relaciones, validaciones y la exposición de endpoints.

### 💬 ¿Tienes sugerencias o mejoras?

Estoy totalmente abierto a:

- Consejos sobre buenas prácticas o mejoras de diseño.
- Ideas para extender la funcionalidad (por ejemplo, autenticación, paginación, etc.).
- Feedback en general sobre la estructura del código, organización del proyecto o estilo de documentación.

Puedes contactarme si tienes alguna recomendación.  
¡Toda sugerencia es bienvenida y valiosa para seguir aprendiendo!

---
