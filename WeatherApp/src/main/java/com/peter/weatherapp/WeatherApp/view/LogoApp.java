package com.peter.weatherapp.WeatherApp.view;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.*;


public class LogoApp {

    public HorizontalLayout buildLogo() {

        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Image icon = new Image(null, new ClassResource("/weather_icon.png"));
        icon.setWidth("125px");
        icon.setHeight("125px");
        logoLayout.addComponents(icon);

        return logoLayout;
    }

}
