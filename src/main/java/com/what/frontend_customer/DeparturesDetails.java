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
public class DeparturesDetails extends HttpServlet {

    DummyCustomerBackend mock = new DummyCustomerBackend();
    Gson gson = new Gson();

//  request to get departure details
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String dateString = request.getParameter("date");
        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        Date date;
        try {
            date = formatter.parse(dateString);
            LineIdentifier lineId = new LineIdentifier(request.getParameter("lineId"));
            Collection<DepartureDetail> departures = mock.getDepartures(lineId, date);
            System.out.println(departures);
            
//            I will assume that departures is an Array with departure dates:
            String[] hours = {"11:45", "12:45", "13:45"};
            String hoursString = gson.toJson(hours);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(hoursString);
        } catch (ParseException ex) {
            Logger.getLogger(DeparturesDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeparturesDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
