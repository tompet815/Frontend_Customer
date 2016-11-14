<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script>
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
    </script>
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
                    <input class="form-control" required id="reservationNoInput" value="${reservationno}" name="reservationno" placeholder="your reservation no"/>
                </div>                
                <button type="submit" class="btn btn-info ">Show reservation</button>
                <span id="errorMsg" style="color: red">${error}</span>


                <input hidden id="gotReservation"  value="${gotReservation}">
            </form>
            <span id="successMsg" style="color: green; margin-top: 10px; display:block">${success}</span>
        </div>
        <div class="col-md-12" style="margin-top:15px" id="myreservation">
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
                        <td>Departure time</td><td>${reservation.departureTime}</td>   
                    </tr>
                    <tr>
                        <td>Travel duration</td><td>${reservation.duration}</td>   
                    </tr>
                    <tr>
                        <td>Passenger(Non-resident)</td><td>${reservationotherPassengerNumber}</td>   
                    </tr>
                    <tr>
                        <td>Passenger(Resident)</td><td>${reservation.islandResidentNumber}</td>   
                    </tr>
                    <tr>
                        <td>Vehicle type</td><td>${reservation.vehicleType}</td>   
                    </tr>
                    <tr>
                        <td>Total price</td><td>${reservation.totalPrice}</td>   
                    </tr>
                </tbody>
            </table>
            <div class="pull-right">
                <a href="editReservation.jsp"><button class="btn btn-info" type="button">Edit booking</button></a>
                <form method="post" style="display:inline-block">
                    <input name="reservationno" hidden value="${reservationno}">
                    <button type="submit"class="btn btn-danger">Cancel booking</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
