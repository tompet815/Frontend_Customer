$(function () {
    $("#datepicker").datepicker({
        onSelect: function (date) {
            if (document.getElementById("nonResidentPassengersRow").style.display === 'none') {
                document.getElementById("nonResidentPassengersRow").style.display = '';
            }
            if (document.getElementById("residentPassengersRow").style.display === 'none') {
                document.getElementById("residentPassengersRow").style.display = '';
            }
        },
        dateFormat: "dd-mm-yy",
        minDate: +0 //you do not want to show previous date.
    });
});
