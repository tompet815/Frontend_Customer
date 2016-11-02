package com.what.frontend_customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Reservation", urlPatterns = {"/myreservation"})
public class MyReservation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String reservationNo;
        try {
            reservationNo = request.getParameter("reservationno");

            if (reservationNo != null) {

                //call backend and add logic if reservation no does not exist and so on...
                request.setAttribute("error", "The reservation number does not exit");
                request.setAttribute("errorBgColor","red");
                
                
                request.setAttribute("gotReservation", "yes");//change (delete) this  later.
            }
            request.setAttribute("reservationno", reservationNo);
            request.getRequestDispatcher("my.jsp").forward(request, response);

        }
        catch (Exception e) {
            out.println("<h2>" + e.getMessage() + "</h2>");
            out.print("<hr/><pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String reservationNo;
        try {

            reservationNo = request.getParameter("reservationno");

            if (reservationNo == null) {
                request.setAttribute("error", "Error. The reservation number is required");
            }
            else {
                request.setAttribute("success", "Your reservation has successfully cancelled.");
                System.out.println("success");
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
