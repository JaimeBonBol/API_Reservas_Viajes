//Crear reserva
document.getElementById('formCrearReserva').addEventListener('submit', async (e) => {
    e.preventDefault();

    const nuevaReserva = {
        usuario: document.getElementById('usuarioReserva').value,
        dni: document.getElementById('dniReserva').value,
        vueloAsociado: {id: parseInt(document.getElementById('idVueloReserva').value)},
        hotelAsociado: {id: parseInt(document.getElementById('idHotelReserva').value)}
    };

    try{
        const respuesta = await fetch('/api/reservas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevaReserva)
        });

        if (respuesta.ok){
            alert('Reserva creada correctamente.')
            e.target.reset();
        }else {
            alert('Error al crear la reserva.')
        }
    }catch (error) {
        console.error('Error: ', error)
        alert('Error en la conexión')
    }
});

//Actualizar reserva
document.getElementById('formActualizarReserva').addEventListener('submit', async (e) => {
   e.preventDefault();

   const id = parseInt(document.getElementById('idReservaActualizar').value);
   const datosActualizar = {};

   const usuario = document.getElementById('usuarioReservaActualizar').value;
   if (usuario){
       datosActualizar.usuario = usuario;
   }

   const dni = document.getElementById('dniReservaActualizar').value;
   if (dni){
       datosActualizar.dni = dni;
   }

   const vueloAsociado = {id: parseInt(document.getElementById('idVueloReservaActualizar').value)};
   if (vueloAsociado){
       datosActualizar.vueloAsociado = vueloAsociado;
   }

    const hotelAsociado = {id: parseInt(document.getElementById('idHotelReservaActualizar').value)};
   if (hotelAsociado){
       datosActualizar.hotelAsociado = hotelAsociado;
   }

   try {
       const respuesta = await fetch(`api/reservas/${id}`, {
           method: 'PUT',
           headers: {'Content-Type': 'application/json'},
           body: JSON.stringify(datosActualizar)
       });

       if (respuesta.ok){
           alert('Reserva actualizada correctamente.')
           e.target.reset();
       }else {
           alert('Error al actualizar la reserva.')
       }
   }catch (error) {
       console.error('Error: ',error)
       alert('Error en la conexión.')
   }
});

//Eliminar reserva
document.getElementById('formEliminarReserva').addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('idReservaEliminar').value;

    try{
        const respuesta = await fetch(`api/reservas/${id}`, {
            method: 'DELETE'
        });

        if (respuesta.ok){
            alert('Reserva eliminada correctamente.')
            e.target.reset();
        }else {
            alert('Error al eliminar la reserva.')
        }
    }catch (error) {
        console.error('Error: ',error);
        alert('Error en la conexión.')
    }
});