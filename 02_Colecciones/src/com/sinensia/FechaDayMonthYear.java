/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import java.util.GregorianCalendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class FechaDayMonthYear extends GregorianCalendar{

    public FechaDayMonthYear(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
        this.set(year, month, dayOfMonth, 0, 0, 0);
    }

    public FechaDayMonthYear() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        if(obj instanceof FechaDayMonthYear){
            FechaDayMonthYear objFecha = (FechaDayMonthYear) obj;
            
            if (this.get(YEAR) == objFecha.get(YEAR) && this.get(MONTH) == objFecha.get(MONTH) && this.get(DAY_OF_MONTH) == objFecha.get(DAY_OF_MONTH)) {
                return true;
            }      
        }
        return false;
    }
       
    public Date getTimeWithoutSeconds(){
        Date fecha = new Date(((getTimeInMillis() + 86399) / 86400) * 86400);
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        return fecha;
    }   
}
