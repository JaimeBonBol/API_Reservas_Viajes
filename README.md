# Primer_MicroServicio
Mi primer microservicio
Capa	                Responsabilidad principal
Controlador	            Recibe peticiones HTTP, las valida superficialmente y llama al servicio.
Servicio	            Contiene la lógica de negocio (como verificar plazas y actualizar vuelo).
Repositorio	            Accede a la base de datos (CRUD, consultas, etc.).

1. Controller (Capa web)

   📡 Se encarga de recibir y responder a las peticiones HTTP.

   ✅ Valida las entradas (con @RequestBody, @Valid, etc.).

   🚚 Pasa los datos a la capa de servicio para procesarlos.

   📦 Devuelve el resultado como respuesta al cliente.

No debe tener lógica compleja. Si metes lógica aquí, se vuelve difícil de mantener y probar.
2. Service (Capa de negocio)

   🧠 Aquí va la lógica de negocio: reglas, validaciones, cálculos, decisiones.

   Ejemplos:

        Hay plazas en el vuelo

        ¿El hotel está disponible?

        ¿Debo lanzar un error o guardar la reserva?

Es el corazón del sistema: el "qué hacer".
3. Repository (Capa de acceso a datos)

   💾 Se comunica directamente con la base de datos.

   No toma decisiones. Solo guarda, actualiza, busca o borra datos.