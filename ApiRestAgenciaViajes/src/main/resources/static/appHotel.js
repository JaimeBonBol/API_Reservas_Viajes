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