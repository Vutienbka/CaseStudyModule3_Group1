function myFunction() {
    // Declare variables
    var input, filter, table, div, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    div = table.getElementsByTagName("div");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < div.length; i++) {
        td = div[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                div[i].style.display = "";
            } else {
                div[i].style.display = "none";
            }
        }
    }
}