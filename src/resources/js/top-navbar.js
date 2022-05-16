    let dropdown = document.getElementById("myDropdown");

    function dropdownClickHandler() {
        dropdown.classList.toggle('show');


        dropdown.addEventListener("pointerleave", function ()  {
            window.onclick = function(e) {
                if (!e.target.matches('.dropdown') ) {
                    var myDropdown = document.getElementById("myDropdown");
                    if (myDropdown.classList.contains('show')) {
                        myDropdown.classList.remove('show');
                        window.onclick = null;
                    }
                }
            }
        });

        dropdown.addEventListener('pointerenter', function () {

            window.onclick = null;
        })
        document.getElementById("dropdown-arrow").onclick = function (ev) {
            ev.stopPropagation();
            dropdownClickHandler();
        }
    }



