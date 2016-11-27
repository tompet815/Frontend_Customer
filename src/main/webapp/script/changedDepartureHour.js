
function resetSaveButton() {
    if (document.getElementById("routeSelectBox").selectedIndex !== 0 &&
//            some more validation from the passengers & cars
            document.getElementById("departureHoursSelectBox").selectedIndex !== 0) {

        var input = $("<input>")
                .attr("type", "hidden")
                .attr("name", "departureId").val("1");
        $('#reservationForm').append($(input));

        document.getElementById("saveReservationButton").disabled = false;
    } else {
        document.getElementById("saveReservationButton").disabled = true;
    }
}
