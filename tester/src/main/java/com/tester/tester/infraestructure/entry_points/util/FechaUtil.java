package com.tester.tester.infraestructure.entry_points.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaUtil {
    public final static String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    public static LocalDateTime toLocalDateTime(String strDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return LocalDateTime.parse(strDateTime, formatter);
    }
}
