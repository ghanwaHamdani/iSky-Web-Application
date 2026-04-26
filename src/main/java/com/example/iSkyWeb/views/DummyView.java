package com.example.iSkyWeb.views;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "dummy", layout = HomePage.class)
public class DummyView extends VerticalLayout {
    public DummyView() {
        add(new Span("Coming soon ..."));
    }
}
