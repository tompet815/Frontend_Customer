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
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
    <script src="./script/ferryscript.js"></script>
    <script src="./script/changedSelectedRoute.js"></script>
    <script src="./script/datePickerAction.js"></script>
<html>
    <title>Make new reservation</title>
</head>
<body>   <div id="background">
        <div class="container">
            <div class="col-md-12">
                <h1>Make new reservation</h1>
                <hr/>
                <div  style="position: relative;z-index: 9999;" class="col-md-12" style="margin-top:15px" ${hidden} id="myreservation">
                    <form method="post" class="form-inline">
                        <table class="table" style="background-color: floralwhite">
                            <tbody>
                                <tr>
                                    <td>Route</td>
                                    <td>
                                        <select id="routeSelectBox" required="required" onchange="changedSelectedRoute();">
                                            <option selected="selected">- Please choose -</option>
                                            <c:forEach var="line" items="${lines}">
                                                <option>${line.getDeparturePort()} - ${line.getDestinationPort()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr id="departureDateRow" style="display: none">
                                    <td>Departure date</td><td><input type="text" id="datepicker" readonly="true"></td>  
                                </tr>
                                <tr id="nonResidentPassengersRow" style="display: none">
                                    <td>Passengers number(Non-residents)</td><td><input style="border: none;" name="numberOfPeople"></td>   
                                </tr>
                                <tr id="residentPassengersRow" style="display: none">
                                    <td>Passenger number(Residents)</td><td><input style="border: none;" name="numberOfResidents"</td>   
                                </tr>
                            </tbody>
                        </table>
                        <button type="submit" class="btn btn-info">Save reservation</button>
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
