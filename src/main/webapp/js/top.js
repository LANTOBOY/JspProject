function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show2");
}

function userFunction() {
    document.getElementById("userDropdown").classList.toggle("show");
}

window.onclick = function(event) {
    if (!event.target.matches('.dropbtn2')) {
    var dropdowns = document.getElementsByClassName("dropdown-content2");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
        }
    }
    }
    if (!event.target.matches('.dropbtn1')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show2')) {
            openDropdown.classList.remove('show2');
            }
        }
        }
}
