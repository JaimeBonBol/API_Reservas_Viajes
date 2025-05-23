# Primer_MicroServicio
Mi primer microservicio
Capa	                Responsabilidad principal
Controlador	            Recibe peticiones HTTP, las valida superficialmente y llama al servicio.
Servicio	            Contiene la lógica de negocio (como verificar plazas y actualizar vuelo).
Repositorio	            Accede a la base de datos (CRUD, consultas, etc.).
