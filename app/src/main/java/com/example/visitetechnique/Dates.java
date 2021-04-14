package com.example.visitetechnique;

import java.time.LocalDate;
import java.util.Date;

public class Dates {
    private LocalDate date;

    public Dates(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
