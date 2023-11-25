let mostrarClave = function() {
    let claveInput = document.getElementById('clave');
    let confirmarClaveInput = document.getElementById('confirmarClave');
    claveInput.type = 'text';
    confirmarClaveInput.type = 'text';
}
let ocultarClave = function() {
    let claveInput = document.getElementById('clave');
    let confirmarClaveInput = document.getElementById('confirmarClave');
    claveInput.type = 'password';
    confirmarClaveInput.type = 'password';
}
let funcionActual = mostrarClave;

function alternarFunciones() {
    if (funcionActual === ocultarClave) {
        funcionActual = mostrarClave;
    } else {
        funcionActual = ocultarClave;
    }
    funcionActual();
}

function deseleccionarSelect(nombreSelect) {
    let select = document.getElementById(nombreSelect);
    let opciones = select.options;
    for (let i = 0; i < opciones.length; i++) {
        opciones[i].selected = false;
    }
}
function seleccionarSelect(nombreSelect) {
    let select = document.getElementById(nombreSelect);
    let opciones = select.options;
    for (let i = 0; i < opciones.length; i++) {
        opciones[i].selected = true;
    }
}

function deseleccionarCheckbox(nombreCheckbox) {
    let checkboxes = document.getElementsByName(nombreCheckbox);
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = false;
    });
}
function seleccionarCheckbox(nombreCheckbox) {
    let checkboxes = document.getElementsByName(nombreCheckbox);
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = true;
    });
}

function deseleccionarRadio(nombreGrupo) {
    // Obtener todos los elementos de radio con el mismo nombre
    let radios = document.getElementsByName(nombreGrupo);

    // Iterar sobre los elementos y deseleccionarlos
    radios.forEach(function(radio) {
        radio.checked = false;
    });
}

















// function cambiarIdioma() {
//     let selectedOption = document.getElementById("idioma").value;
//     if (selectedOption !== '') {
//         // Asegúrate de construir correctamente la URL con el parámetro lang
//         let newUrl = window.location.pathname + '?lang=' + selectedOption;
//
//         // Verifica si hay parámetros de consulta existentes
//         let queryParams = window.location.search;
//         if (queryParams) {
//             // Reemplaza el valor del parámetro lang si ya existe
//             newUrl = newUrl.replace(/([&?]lang=)[^&]*/, '$1' + selectedOption);
//         }
//
//         // Realiza la recarga de la página con la nueva URL
//         window.location.replace(newUrl);
//     }
// }