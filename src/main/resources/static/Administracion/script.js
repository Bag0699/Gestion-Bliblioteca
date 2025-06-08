function mostrarSeccion(id) {
    const secciones = document.querySelectorAll('.contenido');
    const itemsNav = document.querySelectorAll('.navbar li');

    secciones.forEach(sec => sec.classList.remove('visible'));
    itemsNav.forEach(item => item.classList.remove('active'));

    document.getElementById(id).classList.add('visible');

    const activeItem = Array.from(itemsNav).find(item => item.dataset.id === id);
    if (activeItem) activeItem.classList.add('active');
}



function mostrarSeccion2(seccion) {
    const seccionLista = document.getElementById('seccion-lista');
    const seccionGenerar = document.getElementById('seccion-generar');
    const botonSolucionado = document.getElementById('botonSolucionado');
    const botonSeleccionar = document.getElementById('botonSeleccionar');

    if (seccion === 'lista') {
        seccionLista.classList.remove('oculto');
        seccionGenerar.classList.add('oculto');

        botonSolucionado.classList.remove('oculto');
        botonSeleccionar.classList.add('oculto');
    } else if (seccion === 'generar') {
        seccionLista.classList.add('oculto');
        seccionGenerar.classList.remove('oculto');

        botonSolucionado.classList.add('oculto');
        botonSeleccionar.classList.remove('oculto');
    }

    const menuItems = document.querySelectorAll('.menu-reporte li');
    menuItems.forEach(item => item.classList.remove('activo'));
    if (seccion === 'lista') {
        menuItems[0].classList.add('activo');
    } else {
        menuItems[1].classList.add('activo');
    }
}

function mostrarSeccion3(seccion) {
    const seccionLista = document.getElementById('seccion-lista-sancion');
    const seccionGenerar = document.getElementById('seccion-generar-sancion');

    if (seccion === 'lista') {
        seccionLista.classList.remove('oculto');
        seccionGenerar.classList.add('oculto');
    } else if (seccion === 'generar') {
        seccionLista.classList.add('oculto');
        seccionGenerar.classList.remove('oculto');
    }

    const menuItems = document.querySelectorAll('.menu-sancion li');
    menuItems.forEach(item => item.classList.remove('activo'));

    if (seccion === 'lista') {
        menuItems[0].classList.add('activo');
    } else {
        menuItems[1].classList.add('activo');
    }
}


//  MOSTRAR USUARIOS ===============================================
let usuarios1 = [];

function cargarUsers1(users) {
    const tbody = document.getElementById("users-tbody1");
    tbody.innerHTML = "";

    users.forEach(user => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td><input type="radio" data-id="${user.id}"></td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.dni}</td>
        `;
        tbody.appendChild(tr);
    });
}

function ObtenerUsuarios1() {
    fetch('/api/users')
        .then(response => response.json())
        .then(users => {
            usuarios1 = users;
            cargarUsers1(users);
        })
        .catch(error => console.error("Error al obtener los usuarios:", error));
}

document.addEventListener("DOMContentLoaded", function () {
    ObtenerUsuarios1();

    document.getElementById("mostrarTodos").addEventListener("click", () => {
        cargarUsers1(usuarios1);
    });

    document.getElementById("mostrarDisponibles").addEventListener("click", () => {
        const disponibles = usuarios.filter(user => user.available);
        cargarUsers1(disponibles);
    });
});


let usuarios2 = [];

function cargarUsers2(users) {
    const tbody = document.getElementById("users-tbody2");
    tbody.innerHTML = "";

    users.forEach(user => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td><input type="radio" data-id="${user.id}"></td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.dni}</td>
        `;
        tbody.appendChild(tr);
    });
}

function ObtenerUsuarios2() {
    fetch('/api/users')
        .then(response => response.json())
        .then(users => {
            usuarios2 = users;
            cargarUsers2(users);
        })
        .catch(error => console.error("Error al obtener los usuarios:", error));
}

document.addEventListener("DOMContentLoaded", function () {
    ObtenerUsuarios2();

    document.getElementById("mostrarTodos").addEventListener("click", () => {
        cargarUsers2(usuarios2);
    });

    document.getElementById("mostrarDisponibles").addEventListener("click", () => {
        const disponibles = usuarios.filter(user => user.available);
        cargarUsers2(disponibles);
    });
});


// Mostrar libros

let librosGlobal = [];

function cargarLibros(libros) {
    const tbody = document.getElementById("libros-tbody");
    tbody.innerHTML = "";

    libros.forEach(book => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td><input type="checkbox" data-id="${book.id}"></td>
            <td><${book.id}</td>
            <td><img src="#" alt="${book.title}" width="50"></td>
            <td>${book.title}</td>
            <td>${book.author.name}</td>
            <td>${book.category.name}</td>
            <td>${book.description}</td>
            <td>${book.quantity}</td>
            <td>${book.available ? 'Disponible' : 'No disponible'}</td>
        `;
        tbody.appendChild(tr);
    });
}

function obtenerLibros() {
    fetch('/api/books')
        .then(response => response.json())
        .then(books => {
            librosGlobal = books;
            cargarLibros(books);
        })
        .catch(error => console.error("Error al obtener los libros:", error));
}

document.addEventListener("DOMContentLoaded", function () {
    obtenerLibros();

    document.getElementById("mostrarTodos").addEventListener("click", () => {
        cargarLibros(librosGlobal);
    });

    document.getElementById("mostrarDisponibles").addEventListener("click", () => {
        const disponibles = librosGlobal.filter(libro => libro.available);
        cargarLibros(disponibles);
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const nombre = sessionStorage.getItem("nombreUsuario");
    const apellido = sessionStorage.getItem("apellidoUsuario");

    const nombreAdminDiv = document.getElementById("NombreAdmin");

    if (nombreAdminDiv) {
        if (nombre && apellido) {
            nombreAdminDiv.textContent = `${nombre} ${apellido}`;
        } else {
            nombreAdminDiv.textContent = "ADMINISTRADOR";
        }
    }
});
