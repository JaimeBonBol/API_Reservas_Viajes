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
                    <strong>${hotel.nombre}</strong><br/>
                    Categoría: ${hotel.categoria}<br/>
                    Precio por noche: <span class="precio">${hotel.precio}€</span>
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
                    <strong>${vuelo.compania}</strong><br/>
                    Fecha: ${vuelo.fecha}<br/>
                    Precio: <span class="precio">${vuelo.precio}€</span><br/>
                    Plazas disponibles: ${vuelo.plazasDisponibles}
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
                    <strong>${reserva.usuario}</strong> - DNI: ${reserva.dni}<br/>
                    Vuelo: ${reserva.vueloAsociado?.id} (${reserva.vueloAsociado?.compania || 'N/A'})<br/>
                    Hotel: ${reserva.hotelAsociado?.id} (${reserva.hotelAsociado?.nombre || 'N/A'})
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

// Asignar eventos a botones
document.getElementById('btnMostrarHoteles').addEventListener('click', mostrarHoteles);
document.getElementById('btnMostrarVuelos').addEventListener('click', mostrarVuelos);
document.getElementById('btnMostrarReservas').addEventListener('click', mostrarReservas);


document.getElementById('btnOcultarHoteles').addEventListener('click', ocultarHoteles);
document.getElementById('btnOcultarVuelos').addEventListener('click', ocultarVuelos);
document.getElementById('btnOcultarReservas').addEventListener('click', ocultarReservas);
