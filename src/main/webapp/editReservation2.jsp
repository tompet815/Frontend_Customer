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
<html>
    <title>Your reservation</title>
</head>
<body>   <div id="background">
        <div class="container">
            <div class="col-md-12">
                <h1>Edit reservation</h1>
                <hr/>
                <div class="col-md-12">
                    <form method="get" class="form-inline">
                        <div class ="form-group"style="position: relative;z-index: 9999;">
                            <label for="reservationno" >Your reservation no: </label>
                            <input class="form-control" required id="reservationNoInput" value="${reservationno}" name="reservationno" placeholder="your reservation no"/>
                        </div>   
                        <span style="position: relative;z-index: 9999;">
                            <button type="submit" class="btn btn-info ">Show reservation</button>
                        </span>
                        <span id="errorMsg" style="color: red">${error}</span>                    
                    </form>
                    <span id="successMsg" style="color: green; margin-top: 10px; display:block">${success}</span>
                </div>
                <div  style="position: relative;z-index: 9999;" class="col-md-12" style="margin-top:15px" ${hidden} id="myreservation">
                    <form method="post" class="form-inline">
                        <table class="table" style="background-color: floralwhite">
                            <tbody>
                                <tr>
                                    <td>Reservation no</td><td>${reservationno}</td>                 
                                </tr>
                                <tr>
                                    <td>Name</td><td contenteditable='true'>${detail.customerName}</td>   
                                </tr>
                                <tr>
                                    <td>From</td><td><input style="border: none;" name="departurePort" value="${detail.departureSummary.lineSummary.departurePort}"></td>   
                                </tr>
                                <tr>
                                    <td>To</td><td><input style="border: none; " name="destinationPort" value="${detail.departureSummary.lineSummary.destinationPort}"></td>   
                                </tr>
                                <tr>
                                    <td>Departure date & time</td><td><input style="border: none; " name="departureDate" value="${detail.departureSummary.departureTime}"</td>   
                                </tr>
                                <tr>
                                    <td>Passenger(Non-resident)</td><td><input style="border: none;" name="numberOfPeople" value="${detail.numberOfPeople}"></td>   
                                </tr>
                                <tr>
                                    <td>Passenger(Resident)</td><td><input style="border: none;" name="numberOfResidents" value="${detail.numberOfResidents}"</td>   
                                </tr>
                                <tr>
                                    <td>Car</td><td><input style="border: none;" name="numberOfCars" value="${detail.numberOfCars}"</td>   
                                </tr>
                                <tr>
                                    <td>Lorry</td><td><input style="border: none;" name="numberOfLorries" value="${detail.numberOfLorries}"</td>   
                                </tr>
                                <tr>
                                    <td>Heavy machinery</td><td><input style="border: none;" name="numberOfHeavyMachineries" value="${detail.numberOfHeavyMachinery}"</td>   
                                </tr>
                            </tbody>
                        </table>
                        <button type="submit"class="btn btn-info">Save changes </button>
                    </form>
                </div>
                <div  style="position: relative;z-index: 9999;" class="col-md-12">

                    <div class="pull-right">            
                        <a href="./"><button class="btn btn-info" type="button">Back to Home <i class="fa fa-home" aria-hidden="true"></i></button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
