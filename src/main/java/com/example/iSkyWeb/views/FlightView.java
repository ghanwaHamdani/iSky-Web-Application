package com.example.iSkyWeb.views;

import com.example.iSkyWeb.domain.Flight;
import com.example.iSkyWeb.service.FlightService;
import com.example.iSkyWeb.service.PassengerService;
import com.example.iSkyWeb.service.ReservationService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Flight Management")
@Route(value = " " , layout = HomePage.class)
public class FlightView extends VerticalLayout {
    private final FlightService flightService;
    private final PassengerService passengerService;
    private final ReservationService reservationService;
    private TextField filterText = new TextField("Destination");

    //flight management grid
    Grid<Flight> flightGrid = new Grid<>();

    public FlightView(FlightService flightService) {
        this.flightService = flightService;
        this.passengerService = new PassengerService();
        this.reservationService = new ReservationService();

        setSizeFull();
        add(new H2("Flight Management"), filterText, flightGrid);

        populateGrid();
        add(flightGrid);

        updateFlightList();
    }

    private void populateGrid() {
        flightGrid.setSizeFull();

        //adding the columns
        flightGrid.addColumn(Flight::getFlightNumber).setHeader("Flight Number");
        flightGrid.addColumn(Flight::getOrigin).setHeader("Origin");
        flightGrid.addColumn(Flight::getDest).setHeader("Destination");
        flightGrid.addColumn(Flight::getDate).setHeader("Date");
        flightGrid.addColumn(Flight::getDepartureTime).setHeader("Departure");
        flightGrid.addColumn(Flight::getArrivalTime).setHeader("Arrival");

        //adding the column with the booking button
        flightGrid.addComponentColumn(f -> {
           Button book = new Button("Book this flight");
           book.addClickListener(e -> {
               Dialog createReservation = new Dialog();
               createReservation.setHeaderTitle("Create Reservation");

               //form setup
               TextField passengerName = new TextField("Passenger Name");
               TextField emailAddress = new TextField("Email Address");
               DatePicker travelDate = new DatePicker("Travel Date");

               TextField flightInfo = new TextField("Flight");
               flightInfo.setValue(f.getFlightNumber());
               flightInfo.setReadOnly(true);
               VerticalLayout dialogLayout = new VerticalLayout(flightInfo, passengerName, emailAddress, travelDate);
               createReservation.add(dialogLayout);

               Button save = new Button("Save", click -> {
                   Notification.show("Reserved");
                   createReservation.close();
               });

               Button cancel = new Button("Cancel", click -> {
                   createReservation.close();
               });

               createReservation.getFooter().add(save,cancel);
               createReservation.open();
           });
            return book;
        });
        flightGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateFlightList(){
        flightGrid.setItems(flightService.getAllFlights());
    }
}
