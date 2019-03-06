package ec.edu.espe.as.solange;


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
            switch (d.toLowerCase()) {
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
        //borrar esto 
        System.out.println("Total L=" + price[0]);
        System.out.println("Total B=" + price[1]);
        System.out.println("Total R=" + price[2]);
        /****/
        
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
                if (dayType.equals("weekday") && cusType.toLowerCase().equals("regular")) {
                    dayValue = 110;
                }
                if (dayType.equals("weekday") && cusType.toLowerCase().equals("rewards")) {
                    dayValue = 80;
                }
                if (dayType.equals("weekend") && cusType.toLowerCase().equals("regular")) {
                    dayValue = 90;
                }
                if (dayType.equals("weekend") && cusType.toLowerCase().equals("rewards")) {
                    dayValue = 80;
                }
                break;
            case "Bridgewood":
                if (dayType.equals("weekday") && cusType.toLowerCase().equals("regular")) {
                    dayValue = 160;
                }
                if (dayType.equals("weekday") && cusType.toLowerCase().equals("rewards")) {
                    dayValue = 110;
                }
                if (dayType.equals("weekend") && cusType.toLowerCase().equals("regular")) {
                    dayValue = 60;
                }
                if (dayType.equals("weekend") && cusType.toLowerCase().equals("rewards")) {
                    dayValue = 50;
                }
                break;
            case "Ridgewood":
                if (dayType.equals("weekday") && cusType.toLowerCase().equals("regular")) {
                    dayValue = 220;
                }
                if (dayType.equals("weekday") && cusType.toLowerCase().equals("rewards")) {
                    dayValue = 100;
                }
                if (dayType.equals("weekend") && cusType.toLowerCase().equals("regular")) {
                    dayValue = 150;
                }
                if (dayType.equals("weekend") && cusType.toLowerCase().equals("rewards")) {
                    dayValue = 40;
                }
                break;
        }
        return dayValue;
    }
}
