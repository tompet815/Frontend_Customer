
function resetSaveButton() {
    if (document.getElementById("routeSelectBox").selectedIndex !== 0 &&
//            some more validation from the passengers & cars
            document.getElementById("departureHoursSelectBox").selectedIndex !== 0) {

        var selectedH = document.getElementById("departureHoursSelectBox").value;
        var departures = JSON.parse(document.getElementById("departureDetailsJSON").getAttribute("data-info"));
        for (var i = 0; i < departures.length; i++) {
            var d = new Date(departures[i].departureTimeInMilis);
            if (d.toTimeString().substring(0, 5) === selectedH) {
                var input = $("<input>")
                        .attr("type", "hidden")
                        .attr("name", "departureId").val(departures[i].id.toString());
                $('#reservationForm').append($(input));
                break;
            }
        }

        document.getElementById("customerNameRow").style.display = '';
        document.getElementById("saveReservationButton").disabled = false;
    } else {
        document.getElementById("customerNameRow").style.display = 'none';
        document.getElementById("saveReservationButton").disabled = true;
    }
}
