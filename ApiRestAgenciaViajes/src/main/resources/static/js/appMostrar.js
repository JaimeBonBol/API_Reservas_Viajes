// Función para mostrar hoteles
function mostrarHoteles() {
    fetch('/api/hoteles')
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('listaHoteles');
            lista.innerHTML = '';
            data.forEach(hotel => {
                const li = document.createElement('li');

                // Aquí creamos un div o lista con cada propiedad separada
                li.innerHTML = `
                    <strong>ID: ${hotel.id}</strong><br/>
                    <span class="hotel-nombre"><strong>${hotel.nombre}</strong></span><br/>
                    <span class="hotel-categoria">Categoría: ${hotel.categoria}</span><br/>
                    <span class="hotel-precio">Precio por noche: ${hotel.precio}€</span><br/>
                `;

                lista.appendChild(li);
            });

            //Mostrar la lista
            lista.style.display = 'block';

        })
        .catch(err => console.error('Error al cargar hoteles:', err));
}

// Ocultar hoteles
function ocultarHoteles() {
    document.getElementById('listaHoteles').style.display = 'none';
}

//Mostrar hoteles disponibles
function mostrarHotelesDisponibles() {
    fetch('/api/hoteles/disponibles')
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('listaHotelesDisponibles');
            lista.innerHTML = '';
            data.forEach(hotel => {
                const li = document.createElement('li');

                // Aquí creamos un div o lista con cada propiedad separada
                li.innerHTML = `
                    <strong>ID: ${hotel.id}</strong><br/>
                    <span class="hotel-nombre"><strong>${hotel.nombre}</strong></span><br/>
                    <span class="hotel-categoria">Categoría: ${hotel.categoria}</span><br/>
                    <span class="hotel-precio">Precio por noche: ${hotel.precio}€</span><br/>
                `;

                lista.appendChild(li);
            });

            //Mostrar la lista
            lista.style.display = 'block';

        })
        .catch(err => console.error('Error al cargar hoteles:', err));
}

//Ocultar hoteles disponibles.
function ocultarHotelesDisponibles() {
    document.getElementById('listaHotelesDisponibles').style.display = 'none';
}

//Buscar hotel por ID.
function buscarHotelPorId() {
    const id = parseInt(document.getElementById('inputHotelId').value, 10);

    console.log("ID buscado:", id);

    if (!id) {
        alert('Por favor, introduce un ID');
        return;
    }

    fetch(`/api/hoteles/id/${id}`)
        .then(res => {
            if (!res.ok) {
                throw new Error('Hotel no encontrado');
            }
            return res.json();
        })
        .then(hotel => {
            const resultado = document.getElementById('resultadoHotelPorId');
            resultado.innerHTML = `
                <strong>ID: ${hotel.id}</strong><br/>
                <span class="hotel-nombre"><strong>${hotel.nombre}</strong></span><br/>
                <span class="hotel-categoria">Categoría: ${hotel.categoria}</span><br/>
                <span class="hotel-precio">Precio por noche: ${hotel.precio}€</span><br/>
                <span class="hotel-disponibilidad">Disponible: ${hotel.disponibilidad ? 'Sí' : 'No'}</span>
            `;
        })
        .catch(error => {
            document.getElementById('resultadoHotelPorId').innerHTML = `<span style="color:red;">${error.message}</span>`;
            console.error('Error al buscar hotel:', error);
        });
}

//Buscar hotel por Nombre.
function buscarHotelPorNombre() {
    const nombre = document.getElementById('inputHotelNombre').value.trim();

    console.log("Buscando hotel con nombre:", nombre);

    if (!nombre) {
        alert('Por favor, introduce un nombre');
        return;
    }

    fetch(`/api/hoteles/nombre/${nombre}`)
        .then(res => {
            if (!res.ok) {
                throw new Error('Hotel no encontrado');
            }
            return res.json();
        })
        .then(hotel => {
            const resultado = document.getElementById('resultadoHotelPorNombre');
            resultado.innerHTML = `
                <strong>ID: ${hotel.id}</strong><br/>
                <span class="hotel-nombre"><strong>${hotel.nombre}</strong></span><br/>
                <span class="hotel-categoria">Categoría: ${hotel.categoria}</span><br/>
                <span class="hotel-precio">Precio por noche: ${hotel.precio}€</span><br/>
                <span class="hotel-disponibilidad">Disponible: ${hotel.disponibilidad ? 'Sí' : 'No'}</span>
            `;
        })
        .catch(error => {
            document.getElementById('resultadoHotelPorNombre').innerHTML = `<span style="color:red;">${error.message}</span>`;
            console.error('Error al buscar hotel:', error);
        });
}

// Función para mostrar vuelos
function mostrarVuelos() {
    fetch('/api/vuelos')
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('listaVuelos');
            lista.innerHTML = '';
            data.forEach(vuelo => {
                const li = document.createElement('li');

                li.innerHTML = `
                    <strong>ID: ${vuelo.id}</strong><br/>
                    <span class="vuelo-compania">${vuelo.compania}</span><br/>
                    <span class="vuelo-fecha">Fecha: ${vuelo.fecha}</span><br/>
                    <span class="vuelo-precio">Precio: ${vuelo.precio}€</span><br/>
                    <span class="vuelo-plazas">Plazas disponibles: ${vuelo.plazasDisponibles}</span>
                `;

                lista.appendChild(li);
            });

            //Mostrar la lista
            lista.style.display = 'block';
        })
        .catch(err => console.error('Error al cargar vuelos:', err));
}

function ocultarVuelos(){
    document.getElementById('listaVuelos').style.display = 'none';
}

//Mostrar vuelos con plazas disponibles.

function mostrarVuelosDisponibles() {
    fetch('/api/vuelos/disponibles')
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('listaVuelosDisponibles');
            lista.innerHTML = '';
            data.forEach(vuelo => {
                const li = document.createElement('li');

                li.innerHTML = `
                    <strong>ID: ${vuelo.id}</strong><br/>
                    <span class="vuelo-compania">${vuelo.compania}</span><br/>
                    <span class="vuelo-fecha">Fecha: ${vuelo.fecha}</span><br/>
                    <span class="vuelo-precio">Precio: ${vuelo.precio}€</span><br/>
                    <span class="vuelo-plazas">Plazas disponibles: ${vuelo.plazasDisponibles}</span>
                `;

                lista.appendChild(li);
            });

            //Mostrar la lista
            lista.style.display = 'block';
        })
        .catch(err => console.error('Error al cargar vuelos:', err));
}

//Ocultar vuelos con plazas disponibles

function ocultarVuelosDisponibles(){
    document.getElementById('listaVuelosDisponibles').style.display = 'none';
}

//Buscar vuelo por ID.
function buscarVueloPorId() {
    const id = parseInt(document.getElementById('inputVueloId').value, 10);

    if (!id) {
        alert('Por favor, introduce un ID');
        return;
    }

    fetch(`/api/vuelos/${id}`)
        .then(res => {
            if (!res.ok) {
                throw new Error('Vuelo no encontrado');
            }
            return res.json();
        })
        .then(vuelo => {
            const resultado = document.getElementById('resultadoVueloPorId');
            resultado.innerHTML = `
                <strong>ID: ${vuelo.id}</strong><br/>
                    <span class="vuelo-compania">${vuelo.compania}</span><br/>
                    <span class="vuelo-fecha">Fecha: ${vuelo.fecha}</span><br/>
                    <span class="vuelo-precio">Precio: ${vuelo.precio}€</span><br/>
                    <span class="vuelo-plazas">Plazas disponibles: ${vuelo.plazasDisponibles}</span>
            `;
        })
        .catch(error => {
            document.getElementById('resultadoVueloPorId').innerHTML = `<span style="color:red;">${error.message}</span>`;
            console.error('Error al buscar vuelo:', error);
        });
}

// Función para mostrar reservas
function mostrarReservas() {
    fetch('/api/reservas')
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('listaReservas');
            lista.innerHTML = '';
            data.forEach(reserva => {
                const li = document.createElement('li');

                li.innerHTML = `
                    <span class="reserva-id">ID: ${reserva.id}</span><br/>
                    <span class="reserva-usuario"><strong> ${reserva.usuario}</strong> - DNI: ${reserva.dni}</span><br/>
                    <span class="reserva-vueloAsociado">Vuelo: ${reserva.vueloAsociado?.id} (${reserva.vueloAsociado?.compania || 'N/A'})</span><br/>
                    <span class="reserva-hotelAsociado">Hotel: ${reserva.hotelAsociado?.id} (${reserva.hotelAsociado?.nombre || 'N/A'})</span><br/>
                `;

                lista.appendChild(li);
            });

            //Mostrar la lista
            lista.style.display = 'block';

        })
        .catch(err => console.error('Error al cargar reservas:', err));
}

function ocultarReservas(){
    document.getElementById('listaReservas').style.display = 'none';
}

//Buscar reserva por ID.
function buscarReservaPorId() {
    const id = parseInt(document.getElementById('inputReservaId').value, 10);

    if (!id) {
        alert('Por favor, introduce un ID');
        return;
    }

    fetch(`/api/reservas/${id}`)
        .then(res => {
            if (!res.ok) {
                throw new Error('Reserva no encontrada');
            }
            return res.json();
        })
        .then(reserva => {
            const resultado = document.getElementById('resultadoReservaPorId');
            resultado.innerHTML = `
                <span class="reserva-id">ID: ${reserva.id}</span><br/>
                    <span class="reserva-usuario"><strong> ${reserva.usuario}</strong> - DNI: ${reserva.dni}</span><br/>
                    <span class="reserva-vueloAsociado">Vuelo: ${reserva.vueloAsociado?.id} (${reserva.vueloAsociado?.compania || 'N/A'})</span><br/>
                    <span class="reserva-hotelAsociado">Hotel: ${reserva.hotelAsociado?.id} (${reserva.hotelAsociado?.nombre || 'N/A'})</span><br/>
            `;
        })
        .catch(error => {
            document.getElementById('resultadoReservaPorId').innerHTML = `<span style="color:red;">${error.message}</span>`;
            console.error('Error al buscar reserva:', error);
        });
}

// Asignar eventos a botones
document.getElementById('btnMostrarHoteles').addEventListener('click', mostrarHoteles);
document.getElementById('btnMostrarHotelesDisponibles').addEventListener('click', mostrarHotelesDisponibles);

document.getElementById('btnBuscarHotelPorId').addEventListener('click', buscarHotelPorId);
document.getElementById('btnBuscarHotelPorNombre').addEventListener('click', buscarHotelPorNombre);

document.getElementById('btnMostrarVuelos').addEventListener('click', mostrarVuelos);
document.getElementById('btnMostrarVuelosDisponibles').addEventListener('click', mostrarVuelosDisponibles);

document.getElementById('btnBuscarVueloPorId').addEventListener('click', buscarVueloPorId);

document.getElementById('btnMostrarReservas').addEventListener('click', mostrarReservas);

document.getElementById('btnBuscarReservaPorId').addEventListener('click', buscarReservaPorId);


document.getElementById('btnOcultarHoteles').addEventListener('click', ocultarHoteles);
document.getElementById('btnOcultarHotelesDisponibles').addEventListener('click', ocultarHotelesDisponibles);
document.getElementById('btnOcultarVuelos').addEventListener('click', ocultarVuelos);
document.getElementById('btnOcultarVuelosDisponibles').addEventListener('click', ocultarVuelosDisponibles);
document.getElementById('btnOcultarReservas').addEventListener('click', ocultarReservas);
