
function changedSelectedRoute() {
    var departureDateRow = document.getElementById("departureDateRow");
    if (document.getElementById("routeSelectBox").selectedIndex === 0) {
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
            loadDepartureDetails(dateValue);
        }
    }
}
