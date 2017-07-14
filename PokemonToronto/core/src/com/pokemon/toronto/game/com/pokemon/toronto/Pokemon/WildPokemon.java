package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gregory on 6/11/2017.
 */
public class WildPokemon {
    private Pokemon pokemon;
    private double latitude;
    private double longitude;
    private String date;
    private String expirationString;
    private Date foundDate;
    private Date expirationDate;

    private int expirationMinute;
    private int expirationHour;
    private int expirationDay;
    private int expirationMonth;
    private int expirationYear;

    private final int JANUARY = 1;
    private final int FEBRUARY = 2;
    private final int JULY = 7;
    private final int DECEMBER = 12;
    private final int EXTRA_UNIT = 1;
    private final int FIRST_DAY = 1;

    public WildPokemon(Pokemon pokemon, double latitude, double longitude, Date foundDate, String date) {
        this.pokemon = pokemon;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.foundDate = foundDate;
        initExpirationDate();

    }

    public boolean isExpired() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date currentTime = new Date();
        if (currentTime.compareTo(expirationDate) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public Pokemon getPokemon() {
        return pokemon;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDate() { return date; }

    public String getYear() {
        return date.substring(0, 4);
    }

    public String getMonth() {
        return date.substring(5, 7);
    }

    public String getDay() {
        return date.substring(8, 10);
    }

    public String getHour() {
        return date.substring(11, 13);
    }

    public String getMinute() {
        return date.substring(14, 16);
    }
    public String getExpirationString() {
        return expirationString;
    }

    public String getFoundString() {
        return date;
    }
    private void initExpirationDate() {
        initExpirationMinute();
        initExpirationHour();
        initExpirationDay();
        initExpirationMonth();
        initExpirationYear();
        expirationString = Integer.toString(expirationYear) + "/" + Integer.toString(expirationMonth) + "/" +
                Integer.toString(expirationDay) + " " + Integer.toString(expirationHour) + ":" + Integer.toString(expirationMinute);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        try {
            expirationDate = dateFormat.parse(expirationString);
        } catch (Exception e) { expirationDate = foundDate; }
    }

    private void initExpirationMinute() {
        expirationMinute = Integer.parseInt(getMinute());
    }

    private void initExpirationHour() {
        int hour = Integer.parseInt(getHour());
        if (hour <= 21) {
            hour += (EXTRA_UNIT * 2);
        } else {
            hour = 24 % (hour + 2);
        }
        expirationHour = hour;
    }

    private void initExpirationDay() {
        int day = Integer.parseInt(getDay());
        int month = Integer.parseInt(getMonth());
        int daysInMonth;
        if (month == FEBRUARY) {
            daysInMonth = 28;
        } else if (month == JULY) {
            daysInMonth = 31;
        } else {
            daysInMonth = 30 + (month % 2);
        }
        //if the expiration hour is 1 am or 12 am, the day changed
        if (expirationHour <= 1) {
            if (day != daysInMonth) {
                expirationDay = day + EXTRA_UNIT;
            } else {
                expirationDay = FIRST_DAY;
            }
        } else {
            expirationDay = day;
        }

    }

    private void initExpirationMonth() {
        int month = Integer.parseInt(getMonth());
        //Month is the next month because the day went to day 1
        if (expirationDay < Integer.parseInt(getDay())) {
            if (month < DECEMBER) {
                expirationMonth = month + EXTRA_UNIT;
            } else {
                //The year changed so go back to january
                expirationMonth = JANUARY;
            }
        } else {
            //Still in the same month
            expirationMonth = month;
        }
    }

    private void initExpirationYear() {
        int year = Integer.parseInt(getYear());
        if (expirationMonth < Integer.parseInt(getMonth())) {
            expirationYear = year + EXTRA_UNIT;
        } else {
            expirationYear = year;
        }
    }

}
