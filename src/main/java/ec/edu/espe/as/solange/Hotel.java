package ec.edu.espe.as.solange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jhona
 */
public class Hotel {

    String hot = "nan";
    int weekdayRg;
    int weekdayRw;
    int weekendRg;
    int weekendRw;
    int rate;
    int TL = 0;
    int TB = 0;
    int TR = 0;
    int price[] = {0, 0, 0};

    public String findHotel(String[] days, String type) {
        String aux = "";
        for (String d : days) {
            switch (d) {
                case "sat":
                    aux = "weekend";
                    break;
                case "sun":
                    aux = "weekend";
                    break;
                default:
                    aux = "weekday";
            }
            //poner los hoteles en orden de Rating, de menor rating a mayor en el caso de requerir mas hoteles
            price[0] = price[0] + operate("Lakewood", aux, type);
            price[1] = price[1] + operate("Bridgewood", aux, type);
            price[2] = price[2] + operate("Ridgewood", aux, type);
        }

        String foundHotel = "";

        int iMenor = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] < price[iMenor]) {
                iMenor = i;
            }
            if (price[i] == price[iMenor]) {
                iMenor=i;
            }
        }
        switch (iMenor) {
            case 0:
                foundHotel = "Lakewood";
                break;
            case 1:
                foundHotel = "Bridgewood";
                break;
            case 2:
                foundHotel = "Ridgewood";
                break;
        }
        price[0] = 0;
        price[1] = 0;
        price[2] = 0;
        return foundHotel;
    }


    private int operate(String hotel, String dayType, String cusType) {
        int dayValue = 0;
        switch (hotel) {
            case "Lakewood":
                if (dayType.equals("weekday") && cusType.equals("Regular")) {
                    dayValue = 110;
                }
                if (dayType.equals("weekday") && cusType.equals("Rewards")) {
                    dayValue = 80;
                }
                if (dayType.equals("weekend") && cusType.equals("Regular")) {
                    dayValue = 90;
                }
                if (dayType.equals("weekend") && cusType.equals("Rewards")) {
                    dayValue = 80;
                }
                break;
            case "Bridgewood":
                if (dayType.equals("weekday") && cusType.equals("Regular")) {
                    dayValue = 160;
                }
                if (dayType.equals("weekday") && cusType.equals("Rewards")) {
                    dayValue = 110;
                }
                if (dayType.equals("weekend") && cusType.equals("Regular")) {
                    dayValue = 60;
                }
                if (dayType.equals("weekend") && cusType.equals("Rewards")) {
                    dayValue = 50;
                }
                break;
            case "Ridgewood":
                if (dayType.equals("weekday") && cusType.equals("Regular")) {
                    dayValue = 220;
                }
                if (dayType.equals("weekday") && cusType.equals("Rewards")) {
                    dayValue = 100;
                }
                if (dayType.equals("weekend") && cusType.equals("Regular")) {
                    dayValue = 150;
                }
                if (dayType.equals("weekend") && cusType.equals("Rewards")) {
                    dayValue = 40;
                }
                break;
        }
        return dayValue;
    }
}
