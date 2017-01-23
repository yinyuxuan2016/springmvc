package org.emall.cn.common;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/21
 */
public class DateUtils {

    public static final String DATE = "yyyy-MM-dd";
    public static final String DATE_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String DATE_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_HH_MM_SS_Z1 = "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'";
    public static final String DATE_HH_MM_SS_Z2 = "yyyy-MM-dd\'T\'HH:mm:ssZ";
    public static final String DATE_HH_MM_SS_Z3 = "yyyy-MM-dd\'T\'HH:mm:ssz";
    public static final String DATE_HH_MM_SS_A = "MM/dd/yyyy HH:mm:ss a";
    public static final String DATE_HHMMSS = "yyyyMMddHHmmss";
    private static List<DateFormat> formats = new ArrayList();

    public DateUtils() {
    }

    public static synchronized Date parse(String dateString) {
        if(dateString == null) {
            return null;
        } else {
            Iterator i$ = formats.iterator();

            while(i$.hasNext()) {
                DateFormat format = (DateFormat)i$.next();

                try {
                    return format.parse(dateString);
                } catch (ParseException var4) {
                    ;
                }
            }

            return null;
        }
    }

    public static Date parse(String str, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;

        try {
            date = format.parse(str);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return date;
    }

    public static synchronized String format(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static String format(Date date, String pattern) {
        return date == null?"": DateFormatUtils.format(date, pattern);
    }

    public static List<Date> splitByDay(Date startDate, Date endDate) {
        ArrayList dayList = new ArrayList();
        String startDateStr = DateFormatUtils.format(startDate, "yyyy-MM-dd");
        Date startDate1 = parse(startDateStr);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate1);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(startDate1);
        tempCal.add(5, 1);

        while(tempCal.before(endCal)) {
            dayList.add(startCal.getTime());
            startCal.add(5, 1);
            tempCal.add(5, 1);
        }

        dayList.add(startCal.getTime());
        return dayList;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        String date1Str = DateFormatUtils.format(date1, "yyyy-MM-dd");
        String date2Str = DateFormatUtils.format(date2, "yyyy-MM-dd");
        return date1Str.equals(date2Str);
    }

    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(2) == cal2.get(2);
    }

    public static boolean isSameQuarter(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int month1 = cal1.get(2);
        int month2 = cal2.get(2);
        return month1 >= 0 && month1 <= 2 && month2 >= 0 && month2 <= 2 || month1 >= 3 && month1 <= 5 && month2 >= 3 && month2 <= 5 || month1 >= 6 && month1 <= 8 && month2 >= 6 && month2 <= 8 || month1 >= 9 && month1 <= 11 && month2 >= 9 && month2 <= 11;
    }

    public static long betDate(Date date, Date otherDate) {
        return date.getTime() - otherDate.getTime();
    }

    public static long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Calendar getCurrentCalendar() {
        return Calendar.getInstance();
    }

    public static String calendarToString(Calendar calendar, String template) {
        String stringCalendar = template.replace("{year}", String.valueOf(calendar.get(1)));
        stringCalendar = stringCalendar.replace("{month}", String.valueOf(calendar.get(2)));
        stringCalendar = stringCalendar.replace("{date}", String.valueOf(calendar.get(5)));
        stringCalendar = stringCalendar.replace("{hour}", String.valueOf(calendar.get(11)));
        stringCalendar = stringCalendar.replace("{minute}", String.valueOf(calendar.get(12)));
        stringCalendar = stringCalendar.replace("{second}", String.valueOf(calendar.get(13)));
        stringCalendar = stringCalendar.replace("{millisecond}", String.valueOf(calendar.get(14)));
        return stringCalendar;
    }

    public static String timeCompare(Date _now, Date _date) {
        Calendar now = Calendar.getInstance();
        now.setTime(_now);
        Calendar date = Calendar.getInstance();
        date.setTime(_date);
        int nowY = now.get(1);
        int dateY = date.get(1);
        int nowM = now.get(2);
        int dateM = date.get(2);
        int nowD = now.get(5);
        int dateD = date.get(5);
        long l = now.getTimeInMillis() - date.getTimeInMillis();
        long m = (long)(nowM - dateM);
        long day = (long)(nowD - dateD);
        int dateHour = date.get(11);
        int dateMinutes = date.get(12);
        long hour = l / 3600000L - day * 24L;
        long min = l / 60000L - day * 24L * 60L - hour * 60L;
        long y = (long)(nowY - dateY);
        String ret = "";
        if(y > 0L) {
            ret = ret + (dateY + 1900) + "-";
        }

        if(day > 0L || y > 0L || m > 0L) {
            if(dateM + 1 < 10) {
                ret = ret + "0";
            }

            ret = ret + (dateM + 1) + "-";
            if(dateD < 10) {
                ret = ret + "0";
            }

            ret = ret + dateD + " ";
        }

        if(hour > 0L || day > 0L || y > 0L || m > 0L) {
            if(dateHour < 10) {
                ret = ret + "0";
            }

            ret = ret + dateHour + ":";
            if(dateMinutes < 10) {
                ret = ret + "0";
            }

            ret = ret + dateMinutes;
        }

        if(y == 0L && day * 24L + hour == 0L && min != 0L) {
            ret = min + " 分前";
        }

        if(y == 0L && day * 24L + hour == 0L && min == 0L) {
            ret = "1  分前";
        }

        return ret;
    }

    public static long getFormatedTime(long time) {
        return getFormatedTime(new Date(time));
    }

    public static long getFormatedTime(Date date) {
        if(date == null) {
            return 0L;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            return (new Long(dateFormat.format(date))).longValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(getFormatedTime(new Date()));
    }

    static {
        formats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        formats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        formats.add(new SimpleDateFormat("yyyy-MM-dd"));
        formats.add(new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"));
        formats.add(new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ssZ"));
        formats.add(new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ssz"));
        formats.add(DateFormat.getDateTimeInstance());
        formats.add(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a", Locale.US));
        formats.add(new SimpleDateFormat("yyyyMMddHHmmss"));
        formats.add(DateFormat.getDateInstance());
    }
}
