/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ProductionControl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author dmitriy.mamishev
 */
public class Test {

    int i = 7;

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }
    

    public static String getCurrentDateTime() {
        SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMMMM yyyy H:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+03"));
        String date = format.format(new Date());
        return getFirstUpperCase(date);
    }
    static String s = "some string";
    
    public static String getFirstUpperCase(String str){
        StringBuilder sb = new StringBuilder();
        str = str.toLowerCase();
        for(String s : str.split(" ")){
            sb.append(s.substring(0,1).toUpperCase());
            sb.append(s.substring(1));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void prt(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] arg) {
        prt(Test.getCurrentDateTime());
        s = s.toUpperCase();
        prt(s);

    }

}
