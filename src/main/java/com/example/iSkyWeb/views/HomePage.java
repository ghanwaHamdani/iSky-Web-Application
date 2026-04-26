package com.example.iSkyWeb.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("home")
public class HomePage extends AppLayout {
    public HomePage() {
        //create header
        H1 logo = new H1("iSky Airline Portal");

        //naviagtion links
        HorizontalLayout links = new HorizontalLayout(
                new RouterLink("Booking", FlightView.class),
                new RouterLink("Query Flight Status", DummyView.class),
                new RouterLink("Query Ticket Status", DummyView.class),
                new RouterLink("Confirm Passenger Ticket", DummyView.class)
        );

        links.getStyle().set("margin-left", "auto");

        HorizontalLayout header = new HorizontalLayout(logo, links);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.setPadding(true);
        addToNavbar(header);
    }
}
