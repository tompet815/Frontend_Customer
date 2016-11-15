package com.what.frontend_customer;

import backendMock.DummyCustomerBackend;

import generalstuff.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import backendMock.DummyCustomerBackend;
import generalstuff.*;

@WebServlet( name = "Reservation", urlPatterns = { "/myreservation" } )
public class MyReservation extends HttpServlet {

    DummyCustomerBackend dummyCustomerBackend = new DummyCustomerBackend();
//    ReservationDetail rd= new ReservationDetail(null, null, null, null, 0, 0, 0, 0, 0, 0, 0);

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DummyCustomerBackend mock= new DummyCustomerBackend();
      
        System.out.println();
        String reservationNo;
        try {
            reservationNo = request.getParameter( "reservationno" );

            if ( reservationNo != null ) {
                int intResNo=Integer.parseInt(reservationNo);
   ReservationDetail detail=mock.getReservation(new ReservationIdentifier(intResNo));

   if(detail==null){
                //call backend and add logic if reservation no does not exist and so on...
                ReservationDetail reservationDetail = dummyCustomerBackend.getReservation( new ReservationIdentifier( Integer.parseInt( reservationNo ) ) );
                request.setAttribute( "error", "The reservation number does not exit" );
                request.setAttribute( "errorBgColor", "red" );
   }
   else {
   
                   request.setAttribute("detail", detail);//change (delete) this  later.
                request.setAttribute( "gotReservation", "yes" );//change (delete) this  later.
                request.setAttribute( "reservationotherPassengerNumber", reservationDetail.getNumberOfPeople());
//                request.setAttribute("reservation.otherPassengerNumber", reservationDetail.getNumberOfPeople());
   }         
   }
            request.setAttribute( "reservationno", reservationNo );
            
            request.getRequestDispatcher( "my.jsp" ).forward( request, response );

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
        String reservationNo;
        try {

            reservationNo = request.getParameter( "reservationno" );

            if ( reservationNo == null ) {
                request.setAttribute( "error", "Error. The reservation number is required" );
            } else {
                request.setAttribute( "success", "Your reservation has successfully cancelled." );
                System.out.println( "success" );
            }

            request.getRequestDispatcher( "my.jsp" ).forward( request, response );

        } catch ( Exception e ) {
            out.println( "<h2>" + e.getMessage() + "</h2>" );
            out.print( "<hr/><pre>" );
            e.printStackTrace( out );
            out.println( "</pre>" );
        }
    }
}
