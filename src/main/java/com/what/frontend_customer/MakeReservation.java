package com.what.frontend_customer;

import com.what.frontend_customer.to_delete.DummyCustomerBackend;
import com.google.gson.Gson;
import generalstuff.DepartureIdentifier;
import generalstuff.LineSummary;
import generalstuff.ReservationSummary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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
    Gson gson = new Gson();

//  request to get Lines and render the page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Collection<LineSummary> lines;
        lines = mock.getLines();

        request.setAttribute("hideElements", "none");
        request.setAttribute("lines", lines);
        request.setAttribute("linesDetails", gson.toJson(lines));
        try {
            request.getRequestDispatcher("MakeReservation.jsp").forward(request, response);
        } catch (ServletException | IOException ex1) {
            Logger.getLogger(MakeReservation.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

//  request to create new Reservation
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationSummary rs;
        DepartureIdentifier di = new DepartureIdentifier(Integer.parseInt(request.getParameter("departureId")));
        int residentsNb = request.getIntHeader("residentsNb");
        int nonResidentsNb = request.getIntHeader("nonResidentsNb");
        int smallCarsNb = request.getIntHeader("carsNb");
        int heavyMachineryNb = request.getIntHeader("heavyMachineryNb");
        int lorriesNb = request.getIntHeader("lorriesNb");
        String customerName = request.getHeader("customerName");

        rs = mock.saveReservation(di, nonResidentsNb, residentsNb, true, heavyMachineryNb, lorriesNb, customerName);
//      rs = mock.saveReservation(di, nonResidentsNb, residentsNb, smallCarsNb, heavyMachineryNb, lorriesNb);
        if (rs instanceof ReservationSummary) {
            System.out.println(rs.getId());
            request.setAttribute("success", "Your reservation has been successfully saved!");
            request.setAttribute("hideElements", "");
            request.setAttribute("reservationId", Integer.toString(rs.getId()));
            request.setAttribute("price", "over 9000!");
        } else {
            request.setAttribute("hideElements", "none");
            request.setAttribute("error", "Your reservation failed to save!");
        }
        request.getRequestDispatcher("MakeReservation.jsp").forward(request, response);
    }
}
