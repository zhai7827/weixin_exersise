package com.zhai.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Date工具类
 */
public final class DateUtils {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private static final SimpleDateFormat simpleDateFormatEnglish = new SimpleDateFormat("MMM dd,yyyy", Locale.ENGLISH);

    public DateUtils() {

    }

    /**
     * 获取当前时间
     */
    public static Date currentDate(){
        return new Date();
    }

    /**
     * 获取当前时间String/"yyyy-MM-dd HH:mm:ss"
     */
    public static String currentDateTime(){
        return formatDefault(currentDate());
    }

    /**
     * 获取当前时间String/"yyyy-MM-dd"
     */
    public static String currentDateYear(){
        return formatSimple(currentDate());
    }

    /**
     * Date to String
     */
    public static String format(Date d, String formatPattern) {
        simpleDateFormat.applyPattern(formatPattern);
        return d == null ? null : simpleDateFormat.format(d);
    }

    /**
     * String to Date
     */
    public static Date parse(String date, String formatPattern) {
        try {
            if (date == null || date == "") {
                return null;
            }
            simpleDateFormat.applyPattern(formatPattern);
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回"yyyy-MM-dd HH:mm:ss"
     */
    public static String formatDefault(Date d) {
        return format(d, Constants.DATE_FORMAT_DEFAULT);
    }

    /**
     * 返回"yyyy-MM-dd HH:mm"
     */
    public static String formatYMDHM(Date d) {
        return format(d, Constants.DATE_FORMAT_YEAR_MINUTES);
    }

    /**
     * 返回"yyyy-MM-dd"
     */
    public static String formatSimple(Date d) {
        return format(d, Constants.DATE_FORMAT_SIMPLE);
    }

    /**
     * 返回"yyyyMMdd"
     */
    public static String formatSimple2(Date d) {
        return format(d, Constants.DATE_FORMAT_SIMPLE_COMPACT);
    }

    /**
     * 返回"yyyy/MM/dd"
     */
    public static String formatSimpleSlash(Date d) {
        return format(d, Constants.DATE_FORMAT_SIMPLE_SLASH);
    }

    /**
     * 返回"yyyy"
     */
    public static String formatYear(Date d) {
        return format(d, Constants.DATE_FORMAT_YEAR);
    }

    /**
     * 返回"yyyy-MM"
     */
    public static String formatYM(Date d) {
        return format(d, Constants.DATE_FORMAT_YEAR_MONTH);
    }

    /**
     * 返回"MM-dd"
     */
    public static String formatMD(Date d) {
        return format(d, Constants.DATE_FORMAT_MONTH_DAY);
    }

    /**
     * 返回"HH:mm:ss"
     */
    public static String formatTime(Date d) {
        return format(d, Constants.DATE_FORMAT_TIME);
    }

    /**
     * 返回"HH:mm"
     */
    public static String formatTimeMinutes(Date d) {
        return format(d, Constants.DATE_FORMAT_TIME_MINUTES);
    }

    /**
     * 返回 "Aug 01,2016"
     */
    public static String format2English(Date d) {
        return d == null ? null : simpleDateFormatEnglish.format(d);
    }

    /**
     * 返回java.util.Date("yyyy-MM-dd HH:mm:ss")
     */
    public static Date parseDefault(String date) {
        return parse(date, Constants.DATE_FORMAT_DEFAULT);
    }

    /**
     * 返回java.util.Date("yyyy-MM-dd")
     */
    public static Date parseSimple(String date) {
        return parse(date, Constants.DATE_FORMAT_SIMPLE);
    }

    /**
     * 返回java.util.Date("yyyyMMdd")
     */
    public static Date parseSimple2(String date) {
        return parse(date, Constants.DATE_FORMAT_SIMPLE_COMPACT);
    }

    /**
     * 返回java.util.Date("yyyy/MM/dd")
     */
    public static Date parseSimpleSlash(String date) {
        return parse(date, Constants.DATE_FORMAT_SIMPLE_SLASH);
    }

    /**
     * 返回java.util.Date("yyyy")
     */
    public static Date parseYear(String date) {
        return parse(date, Constants.DATE_FORMAT_YEAR);
    }

    /**
     * 返回java.util.Date("yyyy-MM")
     */
    public static Date parseYM(String date) {
        return parse(date, Constants.DATE_FORMAT_YEAR_MONTH);
    }

    /**
     * 返回java.util.Date("MM-dd")
     */
    public static Date parseMD(String date) {
        return parse(date, Constants.DATE_FORMAT_MONTH_DAY);
    }

    /**
     * 返回java.util.Date("HH:mm:ss")
     */
    public static Date parseTime(String date) {
        return parse(date, Constants.DATE_FORMAT_TIME);
    }

    /**
     * 返回java.util.Date("HH:mm")
     */
    public static Date parseTimeMinutes(String date) {
        return parse(date, Constants.DATE_FORMAT_TIME_MINUTES);
    }

    /**
     * 
     */
    public static Date getMonthFirst(String str, String pattern) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse(str, pattern));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return calendar.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getMonthEnd(String str, String pattern) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse(str, pattern));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return calendar.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getMonthFirstDay(String str, String pattern) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse(str, pattern));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return formatSimple(calendar.getTime());
        } catch (Exception e) {
            return null;
        }

    }

    public static String getMonthEndDay(String str, String pattern) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse(str, pattern));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return formatSimple(calendar.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 下一小时起始时间
     */
    public static Date getNextHourZeroDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 0);
        c.add(Calendar.HOUR_OF_DAY, 1);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 本小时起始时间
     */
    public static Date getHourZeroDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 0);
        c.add(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getNextZeroDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getZeroDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static int getIntevelDays(Date beginDate, Date endDate) {
        Calendar c = Calendar.getInstance();
        int day = 0;
        Date bDate = getNextZeroDate(beginDate);
        Date eDate = getZeroDate(endDate);
        for (c.setTime(bDate); c.getTime().before(eDate); c.add(Calendar.DAY_OF_MONTH, 1)) {
            day++;
        }
        return day;
    }

    public static int getIntervalMonths(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        start.setTime(date);
        return now.get(Calendar.MONTH) - start.get(Calendar.MONTH)
                + 12 * (now.get(Calendar.YEAR) - start.get(Calendar.YEAR));
        //                + (now.get(Calendar.DAY_OF_MONTH) - start.get(Calendar.DAY_OF_MONTH) + 1)/now.get(Calendar.DAY_OF_MONTH);
    }

    public static Date getFirstDayByNextMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MONTH, 1);
        return c.getTime();
    }

    public static Date getFirstDayByMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getMonthFirstDayByDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getNextDayByDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    public static Date getPreDayByDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.getTime();
    }

    public static Date getPreDayByDate(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_MONTH, -days);
        return c.getTime();
    }

    public static Date getPreDay000ByDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_MONTH, -1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);

        return c.getTime();
    }

    public static Date getLastDayByMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.getTime();
    }

    public static Date getDealDayByMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MONTH, 1);
        return c.getTime();
    }

    public static Date getLastMonthByDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    public static Date get30DayZeroClock(Date date) {
        return getDayZeroClock(date, 30);
    }

    /**
     * 给定时间之前多少 天的时间
     */
    public static Date getDayZeroClock(Date date, int beforeDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -beforeDay);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 
     */
    public static int getInt(Date date, int calendarType) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(calendarType);
    }

    public static String getNextHours(int hours) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, hours);
        return formatYMDHM(c.getTime());
    }

    public static Date getNextHoursByDate(int hours) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, hours);
        return c.getTime();
    }

    /**
     * 根据时间返回当前时间是周几 周日=1,周一=2....
     */
    public static int dayForWeek(Date pTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 根据时间返回当前的月份
     */
    public static int dayForMonth(Date pTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 根据时间返回当前的年份
     */
    public static int dayForYear(Date pTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        return c.get(Calendar.YEAR);
    }

    /**
     * 获得下月第一天
     */
    public static Date getNextMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取某年第一天日期
     * 
     * @param year
     *            年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * 
     * @param year
     *            年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    /**
     * 取得当月天数
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 得到指定月的天数
     */
    public static int getMonthtDays(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获得现在到明天凌晨的秒数
     */
    public static int getNow2NextDaySeconds() {
        Calendar now = Calendar.getInstance();
        Calendar tonight = Calendar.getInstance();
        tonight.set(Calendar.HOUR, 23);
        tonight.set(Calendar.MINUTE, 59);
        tonight.set(Calendar.SECOND, 59);
        return (int) ((tonight.getTimeInMillis() - now.getTimeInMillis()) / 1000);
    }

    /**
     * 获得两个时间具体相差多少时间
     * 
     * @return X天X小时X分X秒
     */
    public static String getDistanceTime(long beginTime, long endTime) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long diff;
        if (beginTime < endTime) {
            diff = endTime - beginTime;
        } else {
            diff = beginTime - endTime;
        }
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        return day + "天" + hour + "小时" + min + "分";// + sec + "秒";  
    }

    /**
     * 根据周几获得本周当日时间 周一 : 1, 周二: 2... 同理 上周日: 0, 上周六: -1... (返回周一(21号)结果为2016-03-21 15:28:38)
     */
    public static Date getWeekDateTime(int week) {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + week);
        return c.getTime();
    }

    /**
     * 周一开始 获取本周的 第一天 (周日为本周的 最后一天)
     */
    public static Date getWeekLastTime() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 2;
        c.add(Calendar.DATE, -day_of_week);
        Date date = c.getTime(); //本周第一天时间
        Date date2 = new Date(); //当前时间
        Date date3 = null;
        long time = date.getTime(); //转换为 毫秒值 移动 7天 到 上周
        if (date2.getTime() < date.getTime()) {
            date3 = new Date(time - 86400000 * 7);
        } else {
            date3 = date;
        }
        return date3;
    }

    /**
     * 判断今天是 本周第几天 (周一 开始)
     * 
     * @param time
     * @return
     */
    public static int getDayCount(Date time) {
        if (time == null) {
            time = new Date();
        }
        Calendar cd = new GregorianCalendar();
        cd.setTime(time);
        int dayCount = cd.get(cd.DAY_OF_WEEK);
        if (dayCount == 1) {
            return 7;
        } else {
            return dayCount - 1;
        }
    }

    /**
     * 日期 初始化 (默认)昨天凌晨
     */
    public static Date getFormateYesterday(String begin) {
        boolean b = begin==null || begin=="" ? true : false;
        if (b) {
            return getDayZeroClock(new Date(), 1);
        } else {
            if (begin.equals("null")) {
                return getDayZeroClock(new Date(), 1);
            }
            return parseSimple(begin);
        }
    }

    /**
     * 日期 初始化 (默认)今天凌晨
     */
    public static Date getFormateToday(String end) {
        boolean b = end==null || end=="" ? true : false;
        if (b) {
            return getDayZeroClock(new Date(), 0);
        } else {
            if (end.equals("null")) {
                return getDayZeroClock(new Date(), 0);
            }
            return parseSimple(end);
        }
    }

}
