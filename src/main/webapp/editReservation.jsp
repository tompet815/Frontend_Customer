<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="./style/ferrycss.css" rel="stylesheet">    
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="./script/ferryscript.js"></script>

    <!--    <script>
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
        </script>-->
<html>
    <title>Edit reservation</title>
</head>
<body>
    <div id="background">
        <div class="container">
            <div class="col-md-12">
                <h1>Edit reservation</h1>
                <hr/>
                <div class="col-md-12">
                    <form method="get" class="form-inline">
                        <div class ="form-group" style="position: relative;z-index: 9999;">
                            <label for="reservationno" >Your reservation no: </label>
                            <input class="form-control" required id="reservationNoInput" value="${reservationno}" name="reservationno" placeholder="your reservation no"/>
                        </div>                
                        <button type="submit" class="btn btn-info ">Show reservation</button>
                        <span id="errorMsg" style="color: red">${error}</span>


                        <input hidden id="gotReservation"  value="${gotReservation}">
                    </form>
                    <span id="successMsg" style="color: green; margin-top: 10px; display:block">${success}</span>
                </div>
                <div  style="position: relative;z-index: 9999;" class="col-md-12" style="margin-top:15px" ${hidden} id="myreservation">
                    <table class="table" style="background-color: floralwhite">
                        <tbody>
                            <tr>
                                <td width="20%">Reservation no</td>
                                <td>${reservationid}</td>                 
                            </tr>
                            <tr>
                                <td width="20%">From</td>
                                <td contenteditable='true'>${reservationOriginalHarbour}</td>   
                            </tr>
                            <tr>
                                <td width="20%">To</td>
                                <td contenteditable='true'>${reservation.destinationHarbour}</td>   
                            </tr>
                            <tr>
                                <td width="20%">Departure date</td>
                                <td contenteditable='true'>${reservation.departureDate}</td>   
                            </tr>
                            <tr>
                                <td width="20%">Departure time</td>
                                <td contenteditable='true'>${reservation.departureTime}</td>   
                            </tr>
                            <tr>
                                <td width="20%">Travel duration</td>
                                <td>${reservation.duration}</td>   
                            </tr>
                            <tr>
                                <td width="20%">Passenger(Non-resident)</td>
                                <td  contenteditable='true'>${reservation.otherPassengerNumber}</td>   
                            </tr>
                            <tr>
                                <td width="20%">Passenger(Resident)</td
                                <td contenteditable='true'>${reservation.islandResidentNumber}</td>   
                            </tr>
                            <tr>
                                <td width="20%">Vehicle type</td>
                                <td contenteditable='true'>${reservation.vehicleType}</td>   
                            </tr>
                            <tr>
                                <td width="20%">Total price</td>
                                <td>${reservation.totalPrice}</td>   
                            </tr>
                        </tbody>
                    </table>
                    <div class="pull-right">
                        <button class="btn btn-info">Save changes</button>
                        <form method="post" style="display:inline-block">
                            <input name="reservationno" hidden value="${reservationno}">
                            <button type="submit"class="btn btn-danger">Cancel booking</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
