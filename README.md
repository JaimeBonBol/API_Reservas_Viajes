\# API REST Agencia de Viajes

API para gestionar reservas de vuelos y hoteles en una agencia de viajes.

Permite crear, consultar, modificar y eliminar reservas, vuelos y hoteles.

\---

\## Tecnologías usadas

- Java 17+
- Spring Boot
- Hibernate / JPA
- Base de datos relacional (H2, MySQL, PostgreSQL, etc.)

\---

\## Cómo ejecutar el proyecto

1. Clona el repositorio:

\```bash

git clone https://github.com/tu\_usuario/ApiRestAgenciaViajes.git

cd ApiRestAgenciaViajes

Configura la base de datos en application.properties.

La API estará disponible en http://localhost:8080/api.

Endpoints y ejemplos de uso

Entidad: Reservas

Método	Endpoint	Descripción

GET	/api/reservas	Obtener todas las reservas

GET	/api/reservas/{id}	Obtener reserva por ID

POST	/api/reservas	Crear una nueva reserva

PUT	/api/reservas/{id}	Actualizar reserva por ID

DELETE	/api/reservas/{id}	Eliminar reserva por ID

Ejemplos

GET /api/reservas

Obtiene una lista con todas las reservas existentes.

GET /api/reservas/5

Obtiene la reserva con ID 5.

POST /api/reservas

Crea una nueva reserva.

Body JSON ejemplo:

{

"usuario": "Juan Martínez",

"dni": "12345678A",

"vueloAsociado": { "id": 1 },

"hotelAsociado": { "id": 2 }

}

PUT /api/reservas/5

Actualiza la reserva con ID 5.

Body JSON ejemplo:

{

"usuario": "Juan Martínez",

"dni": "12345678A",

"vueloAsociado": { "id": 1 },

"hotelAsociado": { "id": 3 }

}

DELETE /api/reservas/5

Elimina la reserva con ID 5.

Entidad: Vuelos

Método	Endpoint	Descripción

GET	/api/vuelos	Obtener todos los vuelos

GET	/api/vuelos/{id}	Obtener vuelo por ID

POST	/api/vuelos	Crear un vuelo

PUT	/api/vuelos/{id}	Actualizar vuelo por ID

DELETE	/api/vuelos/{id}	Eliminar vuelo por ID

Ejemplos

GET /api/vuelos

Obtiene todos los vuelos disponibles.

GET /api/vuelos/1

Obtiene el vuelo con ID 1.

POST /api/vuelos

Crea un nuevo vuelo.

Body JSON ejemplo:

{

"compania": "Iberia",

"fecha": "2025-07-15T10:00:00",

"precio": 199.99,

"plazasDisponibles": 150

}

PUT /api/vuelos/1

Actualiza el vuelo con ID 1.

Body JSON ejemplo:

{

"compania": "Iberia",

"fecha": "2025-07-15T12:00:00",

"precio": 210.00,

"plazasDisponibles": 140

}

DELETE /api/vuelos/1

Elimina el vuelo con ID 1.

Entidad: Hoteles

Método	Endpoint	Descripción

GET	/api/hoteles	Obtener todos los hoteles

GET	/api/hoteles/{id}	Obtener hotel por ID

POST	/api/hoteles	Crear un hotel

PUT	/api/hoteles/{id}	Actualizar hotel por ID

DELETE	/api/hoteles/{id}	Eliminar hotel por ID

Ejemplos

GET /api/hoteles

Obtiene todos los hoteles disponibles.

GET /api/hoteles/2

Obtiene el hotel con ID 2.

POST /api/hoteles

Crea un nuevo hotel.

Body JSON ejemplo:

{

"nombre": "Hotel Gran Plaza",

"direccion": "Calle Mayor 123",

"categoria": 4,

"precioNoche": 89.99,

"habitacionesDisponibles": 20

}

PUT /api/hoteles/2

Actualiza el hotel con ID 2.

Body JSON ejemplo:

{

"nombre": "Hotel Gran Plaza",

"direccion": "Calle Mayor 123",

"categoria": 5,

"precioNoche": 95.00,

"habitacionesDisponibles": 18

}

DELETE /api/hoteles/2

Elimina el hotel con ID 2.
