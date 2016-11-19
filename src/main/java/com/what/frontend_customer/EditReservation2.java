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

@WebServlet( name = "editReservation2", urlPatterns = { "/editReservation2" } )
public class EditReservation2 extends HttpServlet {

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

            request.getRequestDispatcher( "editReservation2.jsp" ).forward( request, response );

        } catch ( Exception e ) {
            out.println( "<h2>" + e.getMessage() + "</h2>" );
            out.print( "<hr/><pre>" );
            e.printStackTrace( out );
            out.println( "</pre>" );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String reservationNo, numberOfPeople, numberOfResidents;
        try {

            reservationNo = request.getParameter( "reservationno" );
            numberOfPeople = request.getParameter( "numberOfPeople" );
            numberOfResidents= request.getParameter( "numberOfResidents" );
            if ( reservationNo == null ) {
                request.setAttribute( "hidden", "hidden" );
                request.setAttribute( "error", "Error. The reservation number is required" );
            } else {

                int intResNo = Integer.parseInt( reservationNo );
                int intNumberOfPeople = Integer.parseInt( numberOfPeople );
                int intNumberOfResidents = Integer.parseInt( numberOfResidents );
                mock.updateReservation( new ReservationIdentifier( intResNo ), null, intNumberOfPeople, intNumberOfResidents, false );
                request.setAttribute( "hidden", "hidden" );
                request.setAttribute( "success", "Your reservation has successfully updated." );
            }
            request.getRequestDispatcher( "editReservation2.jsp" ).forward( request, response );

        } catch ( Exception e ) {
            out.println( "<h2>" + e.getMessage() + "</h2>" );
            out.print( "<hr/><pre>" );
            e.printStackTrace( out );
            out.println( "</pre>" );
        }
    }
}
