package com.what.frontend_customer;


import backendMock.DummyCustomerBackend;
import backendMockModel.ReservationDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SeeReservation", urlPatterns = {"/myreservation"})
public class MyReservation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //DummyCustomerBackend dcb = new DummyCustomerBackend();

        String reservationNo;
        try {
      
            reservationNo = request.getParameter("reservationno");
            System.out.println(request.getParameter("reservationno"));
            //ReservationDetail reservation = dcb.seeReservation(Integer.parseInt(reservationNo));
            //request.setAttribute("reservation", reservation);
            
            if (reservationNo == null) {
                System.out.println("here");
                request.setAttribute("error", "The reservation number does not exit");
            }
            else {
                
                request.setAttribute("gotReservation", "yes");
            }
            request.getRequestDispatcher("my.jsp").forward(request, response);

        }
        catch (Exception e) {
            out.println("<h2>" + e.getMessage() + "</h2>");
            out.print("<hr/><pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
    }
}
