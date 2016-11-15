$(document).ready(function () {
    if ($("#gotReservation").val() === "yes") {
        $("#myreservation").show();

    } else {
        $("#myreservation").hide();
    }
    if ($("#errorMsg").text() !== "") {
        $("#reservationNoInput").css("background-color", "#ff9999");

    }
});
