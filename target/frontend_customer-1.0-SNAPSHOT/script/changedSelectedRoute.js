
function changedSelectedRoute() {
    var selectBox = document.getElementById("routeSelectBox");
    var departureDateRow = document.getElementById("departureDateRow");
    var routeValue = selectBox.options[selectBox.selectedIndex].value;
    if (routeValue === '- Please choose -') {
        if (document.getElementById("departureDateRow").style.display === '') {
            document.getElementById("departureDateRow").style.display = 'none';
        }
        if (document.getElementById("nonResidentPassengersRow").style.display === '') {
            document.getElementById("nonResidentPassengersRow").style.display = 'none';
        }
        if (document.getElementById("residentPassengersRow").style.display === '') {
            document.getElementById("residentPassengersRow").style.display = 'none';
        }
        if (document.getElementById("departureHoursRow").style.display === '') {
            document.getElementById("departureHoursRow").style.display = 'none';
        }
    } else {
        departureDateRow.style.display = '';
        dateValue = $('#datepicker').datepicker().val();
        if(dateValue !== ''){
            document.getElementById("nonResidentPassengersRow").style.display = '';
            document.getElementById("residentPassengersRow").style.display = '';
            document.getElementById("departureHoursRow").style.display = '';
            loadDepartureDetails(routeValue, dateValue);
        }
    }
}
