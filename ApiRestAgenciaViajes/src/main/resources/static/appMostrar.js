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

// Asignar eventos a botones
document.getElementById('btnMostrarHoteles').addEventListener('click', mostrarHoteles);
document.getElementById('btnMostrarVuelos').addEventListener('click', mostrarVuelos);
document.getElementById('btnMostrarReservas').addEventListener('click', mostrarReservas);


document.getElementById('btnOcultarHoteles').addEventListener('click', ocultarHoteles);
document.getElementById('btnOcultarVuelos').addEventListener('click', ocultarVuelos);
document.getElementById('btnOcultarReservas').addEventListener('click', ocultarReservas);
