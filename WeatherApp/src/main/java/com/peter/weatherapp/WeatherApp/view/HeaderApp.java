package com.peter.weatherapp.WeatherApp.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderApp {

    private String labelName = "Welcome in Weather App!";

    public HorizontalLayout buildHeader() {

        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label title = new Label(labelName);
        title.addStyleName(ValoTheme.LABEL_H1);
        title.addStyleName(ValoTheme.LABEL_HUGE);
        title.addStyleName(ValoTheme.LABEL_COLORED);

        headerLayout.addComponents(title);

        return headerLayout;
    }

    public String getLabelName() {
        return labelName;
    }

}
