//Crear hotel

document.getElementById('formCrearHotel').addEventListener('submit', async (e) =>{
    e.preventDefault();

    const nuevoHotel = {
        nombre: document.getElementById('nombreHotel').value,
        categoria: document.getElementById('categoriaHotel').value,
        precio: parseFloat(document.getElementById('precioHotel').value),
        disponibilidad: document.getElementById('disponibilidadHotel').checked
    };

    try {
        const respuesta = await fetch('/api/hoteles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevoHotel)
        });

        if (respuesta.ok){
            alert('Hotel creado correctamente');
            //mostrarHoteles();
            e.target.reset(); //vaciar los campos del formulario una vez que se ha enviado con éxito

        }else {
            alert('Error al crear hotel')
        }
    }catch (error){
        console.error('Error: ',error);
        alert('Error en la conexión')
    }
});


//Actualizar hotel.

document.getElementById('formActualizarHotel').addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = parseInt(document.getElementById('idHotelActualizar').value);
    const datosActualizar = {};

    const nombre = document.getElementById('nombreHotelActualizar').value;
    if (nombre){
        datosActualizar.nombre = nombre;
    }

    const categoria = document.getElementById('categoriaHotelActualizar').value;
    if (categoria){
        datosActualizar.categoria = categoria;
    }

    const precio = document.getElementById('precioHotelActualizar').value;
    if (precio){
        datosActualizar.precio = parseFloat(precio);
    }

    const disponibilidad = document.getElementById('disponibilidadHotelActualizar').checked;
    if (disponibilidad){
        datosActualizar.disponibilidad = disponibilidad;
    }

    try {
        const respuesta = await fetch(`api/hoteles/${id}`, {
           method: 'PUT',
           headers: {'Content-Type': 'application/json'},
           body: JSON.stringify(datosActualizar)
        });

        if (respuesta.ok){
            alert('Hotel actualizado correctamente.');
            e.target.reset();
        }else {
            alert('Error al actualizar el hotel.');
        }
    }catch (error){
        console.error('Error: ', error);
        alert('Error en la conexión.')
    }
});


// Eliminar hotel

document.getElementById('formEliminarHotel').addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('idHotelEliminar').value;

    try {
        const respuesta = await fetch(`api/hoteles/${id}`, {
           method: `DELETE`
        });

        if (respuesta.ok){
            alert('Hotel eliminado correctamente.');
            e.target.reset();
        }else {
            alert('Error al eliminar el hotel.');
        }
    }catch (error){
        console.error('Error: ', error);
        alert('Error en la conexión.')
    }
});