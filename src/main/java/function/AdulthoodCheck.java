package function;

import java.util.Date;

public class AdulthoodCheck {

    public static Boolean verifyIfUserHasEighteen(Date date) {
        Date currentDate = new Date();
        Long timeDistance = currentDate.getTime() - date.getTime();
        double years = timeDistance / 24 / 60 / 60 / 1000 / 365;
        return years >= 18.0;
    }
}
