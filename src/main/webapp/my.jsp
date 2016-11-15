<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
    <title>Your reservation</title>
</head>
<body>
       <div class="container">
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
                            <td>Reservation no</td><td>${detail.id}</td>                 
                        </tr>
                        <tr>
                            <td>Name</td><td>${detail.customerName}</td>   
                        </tr>
                        <tr>
                            <td>From</td><td>${detail.departureSummary.lineSummary.departurePort}</td>   
                        </tr>
                        <tr>
                            <td>To</td><td>${detail.departureSummary.lineSummary.destinationPort}</td>   
                        </tr>
                        <tr>
                            <td>Departure date & time</td><td>${detail.departureSummary.departureTime}</td>   
                        </tr>

                        <tr>
                            <td>Travel duration</td><td>${detail.departureSummary.lineSummary.duration}</td>   
                        </tr>
                        <tr>
                            <td>Passenger(Non-resident)</td><td>${detail.numberOfPeople}</td>   
                        </tr>
                        <tr>
                            <td>Passenger(Resident)</td><td>${detail.numberOfResidents}</td>   
                        </tr>
                        <tr>
                            <td>Car</td><td>${detail.numberOfCars}</td>   
                        </tr>
                        <tr>
                            <td>Lorry</td><td>${detail.numberOfLorries}</td>   
                        </tr>
                        <tr>
                            <td>Heavy machinery</td><td>${detail.numberOfHeavyMachinery}</td>   
                        </tr>
                        <tr>
                            <td>Total price</td><td></td>   
                        </tr>
                    </tbody>
                </table>

                <div class="pull-right">
                    <button class="btn btn-info">Edit booking</button>
                    <form method="post" style="display:inline-block">
                        <input name="reservationno" hidden value="${reservationno}">
                        <button type="submit"class="btn btn-danger">Cancel booking</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
