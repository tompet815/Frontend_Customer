package com.what.frontend_customer;

import backendMock.DummyCustomerBackend;
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

//  request to get Lines and render the page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Collection<LineSummary> lines;
        lines = mock.getLines();

        request.setAttribute("lines", lines);

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
        DepartureIdentifier di = new DepartureIdentifier(request.getIntHeader("departureId"));
        int residentsNb = request.getIntHeader("residentsNb");
        int nonResidentsNb = request.getIntHeader("nonResidentsNb");
        int carsNb = request.getIntHeader("carsNb");
        int heavyMachineryNb = request.getIntHeader("heavyMachineryNb");
        int lorriesNb = request.getIntHeader("lorriesNb");

        rs = mock.saveReservation(di, nonResidentsNb, residentsNb, true, heavyMachineryNb, lorriesNb);
//      rs = mock.saveReservation(di, nonResidentsNb, residentsNb, carsNb, heavyMachineryNb, lorriesNb);
        if (rs instanceof ReservationSummary) {
            request.setAttribute("hidden", "hidden");
            request.setAttribute("success", "Your reservation has been successfully saved!");
            request.getRequestDispatcher("MakeReservation.jsp").forward(request, response);
        } else {
            request.setAttribute("hidden", "hidden");
            request.setAttribute("failure", "Your reservation failed to save!");
            request.getRequestDispatcher("MakeReservation.jsp").forward(request, response);
        }

    }
}
