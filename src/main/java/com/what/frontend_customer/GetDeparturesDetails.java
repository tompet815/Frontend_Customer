package com.what.frontend_customer;

import backendMock.DummyCustomerBackend;
import com.google.gson.Gson;
import generalstuff.DepartureDetail;
import generalstuff.LineIdentifier;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeparturesDetails", urlPatterns = {"/DeparturesDetails"})
public class GetDeparturesDetails extends HttpServlet {

    DummyCustomerBackend mock = new DummyCustomerBackend();
    Gson gson = new Gson();

    //See reservation
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String dateString;
        dateString = request.getParameter("date");
//      if (lineId != null && dateString != null) {error handling here}

//      request to get departure details
        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        try {
            Date date = formatter.parse(dateString);
//              Collection<DepartureDetail> departures;
//              departures = mock.getDepartures(new LineIdentifier(request.getParameter("lineId")), date);
//            I will assume that departures is an Array with departure dates:
            String[] hours = {"11:45", "12:45", "13:45"};
            String hoursString = gson.toJson(hours);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(hoursString);

        } catch (ParseException | IOException ex) {
            Logger.getLogger(MakeReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
