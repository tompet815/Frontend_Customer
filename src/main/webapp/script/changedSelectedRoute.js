
function changedSelectedRoute() {
    var selectBox = document.getElementById("routeSelectBox");
    var departureDateRow = document.getElementById("departureDateRow");
    var routeValue = selectBox.options[selectBox.selectedIndex].value;
    if (routeValue === '- Please choose -') {
        resetSaveButton();
        departureDateRow.style.display = 'none';
        document.getElementById("residentPassengersRow").style.display = 'none';
        document.getElementById("nonResidentPassengersRow").style.display = 'none';
        document.getElementById("smallCarsRow").style.display = 'none';
        document.getElementById("heavyMachineryRow").style.display = 'none';
        document.getElementById("lorriesRow").style.display = 'none';
        document.getElementById("departureHoursRow").style.display = 'none';
    } else {
        departureDateRow.style.display = '';
        dateValue = $('#datepicker').datepicker().val();
        if (dateValue !== '') {
            document.getElementById("residentPassengersRow").style.display = '';
            document.getElementById("nonResidentPassengersRow").style.display = '';
            document.getElementById("smallCarsRow").style.display = '';
            document.getElementById("heavyMachineryRow").style.display = '';
            document.getElementById("lorriesRow").style.display = '';
            document.getElementById("departureHoursRow").style.display = '';
            loadDepartureDetails(routeValue, dateValue);
        }
    }
}
