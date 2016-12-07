function loadDepartureDetails() {
    var lines = JSON.parse(document.getElementById("linesDetailsJSON").getAttribute("data-info"));
    var selectedLineID = lines[document.getElementById("routeSelectBox").selectedIndex - 1].id;

    $.ajax({
        "url": "DeparturesDetails?lineId=" + selectedLineID + "&date=" + $('#datepicker').datepicker('getDate').getTime(),
        "type": "GET",
        "headers": {"Content-Type": "application/json"},
        "error": function () {
            alert('Could not get departure hours from server.');
        },
        "success": function (data) {
            injectScriptWithDepartureDetails(data);
            resetDepartureHoursSelectBoxOptions();
        }
    });
}

function injectScriptWithDepartureDetails(data) {
    $("#departureDetailsJSON").remove();
    $('head').append('<script type="text/javascript" id="departureDetailsJSON" data-info=' + JSON.stringify(data) + '></script>');
}

function resetDepartureHoursSelectBoxOptions() {
    var departures = JSON.parse(document.getElementById("departureDetailsJSON").getAttribute("data-info"));
    var optionTags = "<option>- Please choose -</option>";
    for (var i = 0; i < departures.length; i++) {
        var d = new Date(departures[i].departureTimeInMilis);
        optionTags += "<option>" + d.toTimeString().substring(0, 5) + "</option>";
    }
    document.getElementById("departureHoursSelectBox").innerHTML = optionTags;
}