//Crear vuelo
document.getElementById('formCrearVuelo').addEventListener('submit', async (e) =>{
    e.preventDefault();

    const nuevoVuelo = {
        compania: document.getElementById('companiaVuelo').value,
        fecha: document.getElementById('fechaVuelo').value,
        precio: parseFloat(document.getElementById('precioVuelo').value),
        plazasDisponibles: parseInt(document.getElementById('plazasVuelo').value)
    };

    try {
        const respuesta = await fetch('/api/vuelos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevoVuelo)
        });

        if (respuesta.ok){
            alert('Vuelo creado correctamente');
            e.target.reset(); //vaciar los campos del formulario una vez que se ha enviado con éxito

        }else {
            const errorData = await respuesta.json();
            console.error("Respuesta de error (json):", errorData);
            alert(`Error: ${errorData.message || 'Error desconocido'}`);
        }
    }catch (error){
        console.error('Error: ',error);
        alert('Error en la conexión')
    }
});


//Actualizar vuelo
document.getElementById('formActualizarVuelo').addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = parseInt(document.getElementById('idVueloActualizar').value);
    const datosActualizar = {};

    const compania = document.getElementById('companiaVueloActualizar').value;
    if (compania){
        datosActualizar.compania = compania;
    }

    const fecha = document.getElementById('fechaVueloActualizar').value;
    if (fecha){
        datosActualizar.fecha = fecha;
    }

    const precio = document.getElementById('precioVueloActualizar').value;
    if (precio){
        datosActualizar.precio = parseFloat(precio);
    }

    const plazas = document.getElementById('plazasVueloActualizar').value;
    if (plazas){
        datosActualizar.plazasDisponibles = parseInt(plazas);
    }

    try {
        const respuesta = await fetch(`api/vuelos/${id}`, {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(datosActualizar)
        });

        if (respuesta.ok){
            alert('Vuelo actualizado correctamente.');
            e.target.reset();
        }else {
            const errorData = await respuesta.json();
            console.error("Respuesta de error (json):", errorData);
            alert(`Error: ${errorData.message || 'Error desconocido'}`);
        }
    }catch (error){
        console.error('Error: ', error);
        alert('Error en la conexión.')
    }
});


//Eliminar vuelo
document.getElementById('formEliminarVuelo').addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('idVueloEliminar').value;

    try {
        const respuesta = await fetch(`api/vuelos/${id}`, {
            method: `DELETE`
        });

        if (respuesta.ok){
            alert('Vuelo eliminado correctamente.');
            e.target.reset();
        }else {
            const errorData = await respuesta.json();
            console.error("Respuesta de error (json):", errorData);
            alert(`Error: ${errorData.message || 'Error desconocido'}`);
        }
    }catch (error){
        console.error('Error: ', error);
        alert('Error en la conexión.')
    }
});