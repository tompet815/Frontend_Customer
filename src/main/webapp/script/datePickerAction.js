$(function () {
    $("#datepicker").datepicker({
        onSelect: function (dateValue) {
            if (document.getElementById("nonResidentPassengersRow").style.display === 'none') {
                document.getElementById("nonResidentPassengersRow").style.display = '';
            }
            if (document.getElementById("residentPassengersRow").style.display === 'none') {
                document.getElementById("residentPassengersRow").style.display = '';
            }
            if (document.getElementById("departureHoursRow").style.display === 'none') {
                document.getElementById("departureHoursRow").style.display = '';
            }
            var routeSelectBox = document.getElementById("routeSelectBox");
            var routeValue = routeSelectBox.options[routeSelectBox.selectedIndex].value;
            loadDepartureDetails(routeValue, dateValue);
        },
        dateFormat: "dd-mm-yy",
        minDate: +0 //you do not want to show previous date.
    });
});
