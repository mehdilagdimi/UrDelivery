package com.urdelivery.urdelivery.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class RadioView {

    private String console;

//    @PostConstruct
//    public void init() {
//    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }


}
