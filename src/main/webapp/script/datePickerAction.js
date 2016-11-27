$(function () {
    $("#datepicker").datepicker({
        onSelect: function (dateValue) {
            document.getElementById("residentPassengersRow").style.display = '';
            document.getElementById("nonResidentPassengersRow").style.display = '';
            document.getElementById("smallCarsRow").style.display = '';
            document.getElementById("heavyMachineryRow").style.display = '';
            document.getElementById("lorriesRow").style.display = '';
            document.getElementById("departureHoursRow").style.display = '';

            var routeSelectBox = document.getElementById("routeSelectBox");
            var routeValue = routeSelectBox.options[routeSelectBox.selectedIndex].value;
            loadDepartureDetails(routeValue, dateValue);
        },
        dateFormat: "dd-mm-yy",
        minDate: +0 //you do not want to show previous date.
    });
});
