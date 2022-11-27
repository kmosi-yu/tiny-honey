package com.kmosi.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-27 08:35
 * @description 日期转化工具类
 */
@SuppressWarnings("unused")
public class DateUtils {
    /**
     * 字符串转LocalDateTime
     *
     * @param date      2021-05-19 19:12:23
     * @param formatter 格式化
     * @return LocalDateTime
     */
    public static LocalDateTime strToLocalDateTime(String date, String formatter) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(formatter));
    }

    /**
     * 根据LocalDate和LocalTime生成LocalDateTime
     *
     * @param date date
     * @param time time
     * @return LocalDateTime
     */
    public static LocalDateTime dateTimeToLocalDateTime(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

    /**
     * 根据LocalDate和LocalTime生成LocalDateTime
     *
     * @param date      date
     * @param time      time
     * @param formatter 格式化
     * @return LocalDateTime
     */
    public static LocalDateTime dateTimeToLocalDateTime(String date, String time, String formatter) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(formatter));
        LocalTime localTime = LocalTime.parse(time);
        return LocalDateTime.of(localDate, localTime);
    }

    /**
     * LocalDateTime转字符串
     *
     * @param date      LocalDateTime
     * @param formatter 格式化
     * @return 2021-05-19 19:12:23
     */
    public static String localDateTimeToStr(LocalDateTime date, String formatter) {
        return DateTimeFormatter.ofPattern(formatter).format(date);
    }

    /**
     * LocalDateTime转Date
     *
     * @param date LocalDateTime
     * @return Date
     */
    public static Date localDateTimeToDate(LocalDateTime date) {
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转LocalDateTime
     *
     * @param date Date
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 字符串转LocalDate
     *
     * @param date      2021-05-19
     * @param formatter "YYYY-MM-DD"
     * @return LocalDate
     */
    public static LocalDate strToLocalDate(String date, String formatter) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(formatter));
    }

    /**
     * LocalDate转字符串
     *
     * @param date      LocalDate
     * @param formatter "YYYY-MM-DD"
     * @return 字符串
     */
    public static String localDateToStr(LocalDate date, String formatter) {
        return DateTimeFormatter.ofPattern(formatter).format(date);
    }

    /**
     * LocalDate转Date
     *
     * @param date LocalDate
     * @return Date
     */
    public static Date localDateToDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转LocalDate
     *
     * @param date Date
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 将date转换成String
     *
     * @param date      Date
     * @param formatter 样式
     * @return 字符串
     */
    public static String dateToStr(Date date, String formatter) {
        return DateTimeFormatter.ofPattern(formatter)
                .format(LocalDateTime
                        .ofInstant(date.toInstant(),
                                ZoneId.systemDefault()));
    }

    /**
     * 将字符串转换为Date
     *
     * @param date      字符串
     * @param formatter 样式
     * @return Date
     */
    public static Date strToDate(String date, String formatter) {
        return Date.from(LocalDateTime
                .parse(date, DateTimeFormatter.ofPattern(formatter))
                .atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将字符串转换为LocalTime
     *
     * @param date      字符串
     * @param formatter 样式
     * @return LocalTime
     */
    public static LocalTime strToLocalTime(String date, String formatter) {
        return LocalTime.parse(date, DateTimeFormatter.ofPattern(formatter));
    }

    /**
     * 将字符串转换为LocalTime
     *
     * @param date 字符串
     * @return LocalTime
     */
    public static LocalTime strToLocalTime(String date) {
        return LocalTime.parse(date);
    }
}
