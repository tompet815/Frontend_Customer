function loadArticleTypes(data, status) {
    var optionTags = "";
    for (var i = 0; i < data.length; i++) {
        optionTags += "<option>" + data[i] + "</option>";
    }
    document.getElementById("departureHoursSelectBox").innerHTML = optionTags;
}

function loadDepartureDetails(routeValue, dateValue) {
    $.ajax({
        "url": "/frontend_customer/MakeReservation?lineId=1&date=" + dateValue,
        "type": "GET",
        "headers": {"Content-Type": "application/json"},
        "data": {},
        "success": loadArticleTypes,
        "error": loadArticleTypes
    });
}