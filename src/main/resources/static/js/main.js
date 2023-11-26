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
function borrarCampos() {
    let formInputs = document.getElementsByTagName("input");
    for (let i = 0; i < formInputs.length; i++) {
        let type = formInputs[i].type.toLowerCase();
        switch (type) {
            case "text":
            case "password":
            case "file":
                formInputs[i].value = "";
                break;
            case "checkbox":
            case "radio":
                formInputs[i].checked = false;
                break;
        }
    }

    let formSelects = document.getElementsByTagName("select");
    for (let i = 0; i < formSelects.length; i++) {
        formSelects[i].selectedIndex = 0;
    }
    deseleccionarSelect("musicasSeleccionadas");

    let formTextareas = document.getElementsByTagName("textarea");
    for (let i = 0; i < formTextareas.length; i++) {
        formTextareas[i].value = "";
    }
}