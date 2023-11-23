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
document.getElementById("idioma").addEventListener("change",cambioIdioma)
function cambioIdioma(){
    let selectedOption = document.getElementById("idioma").value;
    if (selectedOption !== '') {
        window.location.replace('?lang=' + selectedOption);
        document.getElementById("idioma").value = selectedOption
    }
}