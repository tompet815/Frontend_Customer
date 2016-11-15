package com.what.frontend_customer;

import backendMock.DummyCustomerBackend;
import generalstuff.ReservationDetail;
import generalstuff.ReservationIdentifier;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "editReservation", urlPatterns = { "/editReservation" } )
public class EditReservation extends HttpServlet {

    DummyCustomerBackend mock = new DummyCustomerBackend();

    //See reservation
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String reservationNo;
        try {
            reservationNo = request.getParameter( "reservationno" );

            if ( reservationNo != null ) {
                int intResNo = Integer.parseInt( reservationNo );
                ReservationDetail detail = mock.getReservation( new ReservationIdentifier( intResNo ) );

                if ( detail == null ) {
                    request.setAttribute( "error", "The reservation number does not exist" );
                    request.setAttribute( "errorBgColor", "red" );
                    request.setAttribute( "hidden", "hidden" );
                } else {
                    request.setAttribute( "detail", detail );
                    request.setAttribute( "hidden", "" );
                }
            } else {
                request.setAttribute( "hidden", "hidden" );
            }
            request.setAttribute( "reservationno", reservationNo );

            request.getRequestDispatcher( "editReservation.jsp" ).forward( request, response );

        } catch ( Exception e ) {
            out.println( "<h2>" + e.getMessage() + "</h2>" );
            out.print( "<hr/><pre>" );
            e.printStackTrace( out );
            out.println( "</pre>" );
        }
    }

}
