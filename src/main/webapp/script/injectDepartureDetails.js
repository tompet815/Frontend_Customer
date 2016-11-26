function loadDepartureDetails(routeValue, dateValue) {
    $.ajax({
        "url": window.location.href + "?lineId=1&date=" + dateValue,
        "type": "GET",
        "headers": {"Content-Type": "application/json"},
        "error": function () {
            alert('Could not get departure hours from server.');
        },
        "success": function(data) {
            injectScriptWithDepartureDetails(data);
            resetSelectBoxOptions();
        }
    });
}

function injectScriptWithDepartureDetails(data){
    $('head').append('<script type="text/javascript" id="departureDetailsJSON" data-info=' + JSON.stringify(data) + '></script>');
}

function resetSelectBoxOptions(){
    var hours = JSON.parse(document.getElementById("departureDetailsJSON").getAttribute("data-info"));
    var optionTags = "<option>- Please choose -</option>";
    for (var i = 0; i < hours.length; i++) {
        optionTags += "<option>" + hours[i] + "</option>";
    }
    document.getElementById("departureHoursSelectBox").innerHTML = optionTags;
}