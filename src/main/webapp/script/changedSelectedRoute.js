
function changedSelectedRoute() {
    var selectBox = document.getElementById("routeSelectBox");
    var departureDateRow = document.getElementById("departureDateRow");
    var routeValue = selectBox.options[selectBox.selectedIndex].value;
    if (routeValue === '- Please choose -') {
        resetSaveButton();
        document.getElementById("departureHoursRow").display = false;
        document.getElementById("nonResidentPassengersRow").display = false;
        document.getElementById("residentPassengersRow").display = false;
        document.getElementById("departureHoursRow").display = false;
    } else {
        departureDateRow.style.display = '';
        dateValue = $('#datepicker').datepicker().val();
        if(dateValue !== ''){
            document.getElementById("nonResidentPassengersRow").display = true;
            document.getElementById("residentPassengersRow").display = true;
            document.getElementById("departureHoursRow").display = true;
            loadDepartureDetails(routeValue, dateValue);
        }
    }
}
