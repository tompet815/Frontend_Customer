<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#myreservation").hide();

            $("#gotReservation").change(function () {
                alert($("#gotReservation").val());
                if ($("#gotReservation").val() = "yes"){
                    alert("Handler for .change() called.");
                }
            })
        });</script>
<html>
    <title>Your reservation</title>
</head>
<body>
    <div class="col-md-12">
        <h1>Your reservation</h1>
        <hr/>
        <div class="col-md-12">
            <form method="get" class="form-inline">
                <div class ="form-group">
                    <label for="reservationno" >Your reservation no: </label>
                    <input class="form-control" name="reservationno" placeholder="your reservation no"/>
                </div>
                <button type="submit" class="btn btn-info ">Show your reservation</button>
                <input id="gotReservation"  value="${gotReservation}">
            </form>
        </div>
        <div id="myreservation">

            <table class="table table-striped">
                <tbody>
                    <tr>
                        <td>Reservation no</td><td>${reservation.id}</td>                 
                    </tr>
                    <tr>
                        <td>From</td><td>${reservation.originalHarbour}</td>   
                    </tr>
                    <tr>
                        <td>To</td><td>${reservation.destinationHarbour}</td>   
                    </tr>
                    <tr>
                        <td>Departure date</td><td>${reservation.departureDate}</td>   
                    </tr>
                    <tr>
                        <th>Departure time</th><td>${reservation.departureTime}</td>   
                    </tr>
                    <tr>
                        <th>Travel duration</th><td>${reservation.duration}</td>   
                    </tr>
                    <tr>
                        <th>Passenger(Non-resident)</th><td>${reservation.otherPassengerNumber}</td>   
                    </tr>
                    <tr>
                        <th>Passenger(Resident)</th><td>${reservation.islandResidentNumber}</td>   
                    </tr>
                    <tr>
                        <th>Vehicle type</th><td>${reservation.vehicleType}</td>   
                    </tr>
                    <tr>
                        <th>Total price</th><td>${reservation.totalPrice}</td>   
                    </tr>
                </tbody>
            </table>

            <button class="btn btn-info">Edit booking</button>
            <button class="btn btn-danger">Cancel booking</button>
        </div>
    </div>
</body>
</html>
