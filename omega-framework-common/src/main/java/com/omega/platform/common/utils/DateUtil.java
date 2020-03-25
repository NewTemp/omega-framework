package com.omega.platform.common.utils;


import com.omega.platform.common.usualenum.DateFormatEnum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description 时间格式化，时间计算工具类
 * @Author Allen.Lv
 * @Date 3/25/2020
 * @Time 3:05 PM
 */
public class DateUtil {
    private final static ThreadLocal<SimpleDateFormat> sdfYear = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormatEnum.YEAR.getValue());
        }
    };

    private final static ThreadLocal<SimpleDateFormat> sdfDay = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormatEnum.YMD.getValue());
        }
    };

    private final static ThreadLocal<SimpleDateFormat> sdfDays = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormatEnum.YMD_NUM.getValue());
        }
    };

    private final static ThreadLocal<SimpleDateFormat> sdfTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormatEnum.YMDHMS.getValue());
        }
    };

    private final static ThreadLocal<SimpleDateFormat> sdfTimes = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormatEnum.YMDHMS_NUM.getValue());
        }
    };


    private final static ThreadLocal<SimpleDateFormat> sdfTimes_sss = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateFormatEnum.YMDHMS_SSS_NUM.getValue());
        }
    };

    /**
     * 获取YYYY格式时间
     *
     * @return YYY格式时间
     */
    public static String getYear() {
        return sdfYear.get().format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式时间
     *
     * @return YYYY-MM-DD格式时间
     */
    public static String getDay() {
        return sdfDay.get().format(new Date());
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return YYYYMMDD格式
     */
    public static String getDays() {
        return sdfDays.get().format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     *
     * @return YYYY-MM-DD HH:mm:ss格式
     */
    public static String getTime() {
        return sdfTime.get().format(new Date());
    }

    /**
     * 获取yyyyMMddHHmmss格式
     *
     * @return yyyyMMddHHmmss格式
     */
    public static String getTimes() {
        return sdfTimes.get().format(new Date());
    }

    /**
     * 字符串日期大小比较
     *
     * @param s 时间字符串s
     * @param e 时间字符串e
     * @return (如果s > = e 返回true 否则返回false)
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 格式化日期为日期类型
     *
     * @param date 字符串日期
     * @return 返回时间类型日期
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期为日期类型
     *
     * @param date 字符串日期
     * @return 返回时间类型日期
     */
    public static Date fomatDate(String date, String dateFormat) {
        DateFormat fmt = new SimpleDateFormat(dateFormat);
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验日期是否合法
     *
     * @param s 字符串类型日期
     * @return 如果合法返回true 否则 false
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    /**
     * 日期字符串相减返回对应年分差
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 返回日期相减后的年分差，如果日期存在不合法或者空情况返回-1
     */
    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long aa = 0;
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return -1;
        }
    }

    /**
     * 日期字符串相减返回对应天数差
     *
     * @param beginDateStr 开始时间
     * @param endDateStr   结束时间
     * @return 返回日期相减后的天数差，如果日期存在不合法或者空情况返回0
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }

        return day;
    }

    /**
     * 获取得到n天之后的日期
     *
     * @param days n天数
     * @return 返回n天数后的日期格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 将字符串日期转换为long类型
     *
     * @param timeFormatStr 需要转换的时间字符串
     * @return 返回转换后的long类型日期
     */
    public static long fromDateStringToLong(String timeFormatStr) {
        Date date = null;   //定义时间类型
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = inputFormat.parse(timeFormatStr); //将字符型转换成日期型
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();   //返回毫秒数
    }

    /**
     * 将字符串日期转换为long类型
     *
     * @param date 需要转换的时间字符串
     * @return 返回转换后的long类型日期
     */
    public static long fromDateToLong(Date date) {
        return date.getTime();
    }

    /**
     * 两个时间戳相减（获取天、小时、分）
     *
     * @param beginDateStr 开始时间
     * @param endDateStr   结束时间
     * @return 返回n天n小时n分, 异常返回-1
     */
    public static String getTimeSub(String beginDateStr, String endDateStr) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = df.parse(beginDateStr);
            Date d2 = df.parse(endDateStr);
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            return "" + days + "天" + hours + "小时" + minutes + "分";
        } catch (ParseException e) {
            e.printStackTrace();
            return "-1";
        }
    }

    /**
     * 两个时间戳相减（获取天、小时、分、秒、毫秒）
     *
     * @param beginDateStr 开始时间
     * @param endDateStr   结束时间
     * @return 返回n天n小时n分n秒n毫秒, 异常返回-1
     */
    public static String getTimeSub2(String beginDateStr, String endDateStr) {
        try {
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long between = 0;
            try {
                Date begin = dfs.parse(beginDateStr);
                Date end = dfs.parse(endDateStr);
                between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            long day = between / (24 * 60 * 60 * 1000);
            long hour = (between / (60 * 60 * 1000) - day * 24);
            long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                    - min * 60 * 1000 - s * 1000);
            return day + "天" + hour + "小时" + min + "分" + s + "秒" + ms
                    + "毫秒";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }

    }

    /**
     * 时间相减返回秒数
     *
     * @param begin 开始时间
     * @param end   结束时间
     * @return 返回相减后的秒数
     */
    public static Long getTimeSub3(Date begin, Date end) {

        long between = 0;
        try {
            between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return between / 1000;

    }

    /**
     * n天之后是周几
     *
     * @param days n天
     * @return 返回 n天之后是周几
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取Unix时间戳（精确到秒）
     *
     * @return
     */
    public static Long getUnixTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * @param date 原始时间
     * @param day  要增加的天数
     * @return
     */
    public static Date increaseDay(Date date, Integer day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 将时间对象转换成字符串
     *
     * @param currDate 当前时间
     * @param format   转换为字符串的格式，参考DateFormatEnum枚举类，如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateToStr(Date currDate, String format) {
        if (StringUtil.isBlank(format)) {//未指定格式化类型时，默认为【yyyy-MM-dd HH:mm:ss】格式进行转换
            return sdfTime.get().format(currDate);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (currDate == null) {
            currDate = new Date();
        }

        return sdf.format(currDate);
    }
}
