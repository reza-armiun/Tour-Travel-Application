
const sidebar = document.querySelector('.sidebar');
sidebar.addEventListener('animationstart', function () {
    window.onclick = function (e) {
        if(!sidebar.contains(e.target)) {
            if(sidebar.classList.contains('show')){
                sidebar.classList.remove('show');
                window.onclick = null;
            }
        }
    }
})
sidebar.addEventListener('pointerleave', function (e) {
    window.onclick = function (e) {
        if(!sidebar.contains(e.target)) {
            if(sidebar.classList.contains('show')){
                sidebar.classList.remove('show');
                window.onclick = null;
            }
        }
    }
});
sidebar.addEventListener('pointerenter' , () => {
    window.onclick = null;
});
function showSidebar(e) {

        if(sidebar.classList.contains('show')) {
            sidebar.classList.remove('show');
            window.onclick = null;
        }else {
            sidebar.classList.add('show');
        }
}




