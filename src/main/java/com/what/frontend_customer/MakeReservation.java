package com.what.frontend_customer;

import backendMock.DummyCustomerBackend;
import generalstuff.DepartureDetail;
import generalstuff.LineIdentifier;
import generalstuff.LineSummary;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MakeReservation", urlPatterns = {"/MakeReservation"})
public class MakeReservation extends HttpServlet {

    DummyCustomerBackend mock = new DummyCustomerBackend();

    //See reservation
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String lineId, dateString;
        lineId = request.getParameter("lineId");
        dateString = request.getParameter("date");

        if (lineId != null && dateString != null) {
//            request to get departure details
            DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

            try {
                Date date = formatter.parse(dateString);
//                Collection<DepartureDetail> departures;
//                departures = mock.getDepartures(new LineIdentifier(request.getParameter("lineId")), date);
//              I will assume that departures is an Array with departure dates:
                Collection departureHours = new ArrayList<String>() {
                    {
                        add("11:45");
                        add("12:45");
                        add("13:45");
                    }
                };
                request.setAttribute("departureHours", departureHours);
                request.getRequestDispatcher("RenderDepartures.jsp").forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(MakeReservation.class.getName()).log(Level.SEVERE, null, ex);
                out.println("<h2>" + ex.getMessage() + "</h2>");
                out.print("<hr/><pre>");
                ex.printStackTrace(out);
                out.println("</pre>");
            }
        } else {
//          request to get lines
            Collection<LineSummary> lines;
            lines = mock.getLines();
            System.out.println("ma-ta!");
            System.out.println(mock.getDepartures(new LineIdentifier(request.getParameter("lineId")), new Date()).size());

            request.setAttribute("lines", lines);
            request.getRequestDispatcher("MakeReservation.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("here you gotta create the reservation!");
//        PrintWriter out = response.getWriter();
//        String reservationNo, numberOfPeople, numberOfResidents;
//        try {
//
//            reservationNo = request.getParameter("reservationno");
//            numberOfPeople = request.getParameter("numberOfPeople");
//            numberOfResidents = request.getParameter("numberOfResidents");
//            if (reservationNo == null) {
//                request.setAttribute("hidden", "hidden");
//                request.setAttribute("error", "Error. The reservation number is required");
//            } else {
//
//                int intResNo = Integer.parseInt(reservationNo);
//                int intNumberOfPeople = Integer.parseInt(numberOfPeople);
//                int intNumberOfResidents = Integer.parseInt(numberOfResidents);
//                mock.updateReservation(new ReservationIdentifier(intResNo), null, intNumberOfPeople, intNumberOfResidents, false);
//                request.setAttribute("hidden", "hidden");
//                request.setAttribute("success", "Your reservation has successfully updated.");
//            }
//            request.getRequestDispatcher("editReservation2.jsp").forward(request, response);
//
//        } catch (Exception e) {
//            out.println("<h2>" + e.getMessage() + "</h2>");
//            out.print("<hr/><pre>");
//            e.printStackTrace(out);
//            out.println("</pre>");
//        }
    }
}
