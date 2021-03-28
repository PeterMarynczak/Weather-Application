package com.peter.weatherapp.WeatherApp.view;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.*;


public class LogoApp {

    private String logoAppLocation = "/weather_icon.png";

    public HorizontalLayout buildLogo() {

        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Image icon = new Image(null, new ClassResource(logoAppLocation));
        icon.setWidth("125px");
        icon.setHeight("125px");
        logoLayout.addComponents(icon);

        return logoLayout;
    }

    public String getLogoAppLocation() {
        return logoAppLocation;
    }
}
