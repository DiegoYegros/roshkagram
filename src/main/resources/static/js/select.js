// //js para el select
// const select = document.querySelector('#select');
// const opciones = document.querySelector('#opciones');
// const contenidoSelect = document.querySelector('#select .contenido-select');
// const hiddenInput = document.querySelector('#inputSelect');
//
// document.querySelectorAll('#opciones > .opcion').forEach((opcion) => {
//     opcion.addEventListener('click', (e) => {
//         e.preventDefault();
//         contenidoSelect.innerHTML = e.currentTarget.innerHTML;
//         select.classList.toggle('active');
//         opciones.classList.toggle('active');
//         hiddenInput.value = e.currentTarget.querySelector('.valor').innerText;
//     });
// });
//
// select.addEventListener('click', () => {
//     select.classList.toggle('active');
//     opciones.classList.toggle('active');
// });
// //js para el calendario