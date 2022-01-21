/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManager;

import java.text.SimpleDateFormat;

/**
 *
 * @author Haji Khokar
 */
public class Decoder {
    
    
    
     public static String DateFormate(java.util.Date date)
    {
     java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("dd-MMM-yyyy");
     String d=f.format(date);
    return d;
}

   public static String getDateFormat(java.util.Date date)
   {
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
       String dateFormat = sdf.format(date);
       return dateFormat;
 
   }
}
