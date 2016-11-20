package com.what.frontend_customer;

import backendMock.DummyCustomerBackend;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import generalstuff.LineSummary;
import generalstuff.ReservationIdentifier;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MakeReservation", urlPatterns = {"/MakeReservation"})
public class MakeReservation extends HttpServlet {

    DummyCustomerBackend mock = new DummyCustomerBackend();
    private static final Gson gson = new Gson();

    //See reservation
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        LineSummary[] lines;

        try {
            String linesDtoString = "[{\"id\":1,\"departurePort\":\"Kalundborg\",\"destinationPort\":\"Island 1\",\"duration\":20},"
                    + "{\"id\":2,\"departurePort\":\"Island 1\",\"destinationPort\":\"Kalundborg\",\"duration\":20}]";
            lines = gson.fromJson(linesDtoString, LineSummary[].class);
//            gson.fromJson(new String(delivery.getBody()), LineSummary.class);

            for (LineSummary line : lines) {
                System.out.println(line.getDeparturePort()+" - "+line.getDestinationPort());
            }
            request.setAttribute("lines", lines);

            request.getRequestDispatcher("MakeReservation.jsp").forward(request, response);

        } catch (JsonSyntaxException | IOException | ServletException e) {
            out.println("<h2>" + e.getMessage() + "</h2>");
            out.print("<hr/><pre>");
            e.printStackTrace(out);
            out.println("</pre>");
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
