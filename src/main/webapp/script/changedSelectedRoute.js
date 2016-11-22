
function changedSelectedRoute() {
    var selectBox = document.getElementById("routeSelectBox");
    var departureDateRow = document.getElementById("departureDateRow");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    if (selectedValue === '- Please choose -') {
        if (document.getElementById("departureDateRow").style.display === '') {
            document.getElementById("departureDateRow").style.display = 'none';
        }
        if (document.getElementById("nonResidentPassengersRow").style.display === '') {
            document.getElementById("nonResidentPassengersRow").style.display = 'none';
        }
        if (document.getElementById("residentPassengersRow").style.display === '') {
            document.getElementById("residentPassengersRow").style.display = 'none';
        }
    } else {
        departureDateRow.style.display = '';
        if($('#datepicker').datepicker({ dateFormat: 'dd-mm-yy' }).val() !== ''){
            document.getElementById("nonResidentPassengersRow").style.display = '';
            document.getElementById("residentPassengersRow").style.display = '';
        }
    }
}
