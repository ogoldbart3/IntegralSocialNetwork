package utils;

import java.util.Calendar;

public class DateUtil {
    public static String getCurrentDateTime() {
        return Calendar.getInstance().getTime().toString();
    }
}
