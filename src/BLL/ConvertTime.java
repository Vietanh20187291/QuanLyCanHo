/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Vanh
 */
public class ConvertTime {
        public static String convertToDate(Long value) {
        Date date = new Date(value);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateText = df.format(date);
        return dateText;
    }

    public static Long convertDateToLong(String string_date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) formatter.parse(string_date);
        long mills = date.getTime();
        return mills;
    }
}
