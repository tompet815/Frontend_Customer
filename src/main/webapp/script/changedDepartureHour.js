
function resetSaveButton() {
    if (document.getElementById("routeSelectBox").selectedIndex !== 0 &&
//            some more validation from the passengers & cars
            document.getElementById("departureHoursSelectBox").selectedIndex !== 0) {
        document.getElementById("saveReservationButton").disabled = false;
    } else {
        document.getElementById("saveReservationButton").disabled = true;
    }
}
