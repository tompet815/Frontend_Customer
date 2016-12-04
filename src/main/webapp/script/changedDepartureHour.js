
function resetSaveButton() {
    if (document.getElementById("routeSelectBox").selectedIndex !== 0 &&
//            some more validation from the passengers & cars
            document.getElementById("departureHoursSelectBox").selectedIndex !== 0) {

        var selectedH = document.getElementById("routeSelectBox").value;
        var departures = JSON.parse(document.getElementById("departureDetailsJSON").getAttribute("data-info"));
        var selectedDepartureID;
        for (var i = 0; i < departures.length; i++) {
            var d = new Date(departures[i].departureTimeInMilis);
            if (d.toTimeString().substring(0, 5) === selectedH) {
                selectedDepartureID = departures[i].id;
                break;
            }
        }

        var input = $("<input>")
                .attr("type", "hidden")
                .attr("name", "departureId").val(selectedDepartureID);
        $('#reservationForm').append($(input));

        document.getElementById("saveReservationButton").disabled = false;
    } else {
        document.getElementById("saveReservationButton").disabled = true;
    }
}
