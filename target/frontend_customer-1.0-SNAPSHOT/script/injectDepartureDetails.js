function loadDepartureDetails(routeValue, dateValue) {


    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("departureHoursSelectBox").innerHTML = this.responseText;
            alert(this.responseText);

//            var optionsString = '';
//            for (var i = 0; i < this.responseText.length; i++) {
//                optionsString = optionsString + '<option>' + this.responseText[i] + '</option>';
//            }
//            document.getElementById("departureHoursSelectBox").innerHTML = optionsString;
        }
    };
    xhttp.open("GET", "MakeReservation?lineId=1&date=" + dateValue, true);
    xhttp.send();
}