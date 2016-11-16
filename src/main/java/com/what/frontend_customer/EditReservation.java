package com.what.frontend_customer;

import backendMock.DummyCustomerBackend;
import generalstuff.DepartureIdentifier;
import generalstuff.ReservationDetail;
import generalstuff.ReservationIdentifier;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.swing.JOptionPane.showMessageDialog;

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

    //edit reservation
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String reservationNo;
        try {

            reservationNo = request.getParameter( "reservationno" );
            

            if ( reservationNo.equals( "") ) {
                request.setAttribute( "hidden", "hidden" );
                request.setAttribute( "error", "Error. The reservation number is required" );
            } else {
                int intResNo = Integer.parseInt( reservationNo );
                String numberOfOtherPeople = request.getParameter( "detail.numberOfPeople" );
                int intNumberOfOtherPeople = Integer.parseInt( numberOfOtherPeople );
                String numberOfResidents = request.getParameter( "detail.numberOfResidents" );
                int intNumberOfResidents = Integer.parseInt( numberOfResidents );
                ReservationDetail detail = mock.getReservation( new ReservationIdentifier( intResNo ) );
                ReservationIdentifier ri = new ReservationIdentifier( intResNo );
                DepartureIdentifier di = new DepartureIdentifier( detail.getDepartureSummary().getId() );
                boolean car = false;
//                if ( !request.getAttribute( "reservationVehicleType" ).equals( "" ) ) {
//                    car = true;
//                }
//                mock.updateReservation( ri, di, Integer.parseInt( ( String ) request.getAttribute( "reservation.numberOfPeople" ).toString() ),
//                                        Integer.parseInt( ( String ) request.getAttribute( "reservation.numberOfResidents" ).toString() ), car );
                mock.updateReservation( ri, di, intNumberOfOtherPeople, intNumberOfResidents, false );
                request.setAttribute( "hidden", "hidden" );
                request.setAttribute( "success", "Your reservation has successfully edited." );
            }
            request.getRequestDispatcher( "editReservation.jsp" ).forward( request, response );

        } catch ( Exception e ) {
            out.println( "<h2>" + e.getMessage() + "</h2>" );
            out.print( "<hr/><pre>" );
            e.printStackTrace( out );
            out.println( "</pre>" );
        }
    }

}
