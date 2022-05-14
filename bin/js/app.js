    let dropdown = document.getElementById("myDropdown");
dropdown.addEventListener("pointerleave", () => {
    window.onclick = function(e) {
        if (!e.target.matches('.dropdown') ) {
            var myDropdown = document.getElementById("myDropdown");
            if (myDropdown.classList.contains('show')) {
                myDropdown.classList.remove('show');
            }
        }
    }
});
function dropdownClickHandler() {
       dropdown.classList.toggle('show');
    // dropdown.classList.toggle("show");
}
document.getElementById("dropdown-arrow").onclick = function (ev) {
    ev.stopPropagation();
    dropdownClickHandler();
}

// window.onclick = function(e) {
//     if (!e.target.matches('.dropdown') ) {
//         var myDropdown = document.getElementById("myDropdown");
//         if (myDropdown.classList.contains('show')) {
//             myDropdown.classList.remove('show');
//         }
//     }
// }

