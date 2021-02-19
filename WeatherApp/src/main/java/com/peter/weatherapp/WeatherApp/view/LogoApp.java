package com.peter.weatherapp.WeatherApp.view;


import com.vaadin.server.ClassResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import static com.peter.weatherapp.WeatherApp.view.MainView.mainLayout;

public class LogoApp {

    public void setLogo() {
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Image icon = new Image(null, new ClassResource("/weather_icon.png"));
        icon.setWidth("125px");
        icon.setHeight("125px");

        logoLayout.addComponents(icon);

        mainLayout.addComponents(logoLayout);

    }

}
