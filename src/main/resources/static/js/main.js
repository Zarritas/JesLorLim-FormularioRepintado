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