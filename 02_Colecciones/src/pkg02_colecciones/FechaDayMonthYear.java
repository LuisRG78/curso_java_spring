/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02_colecciones;

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
    
    public Date getTimeWithoutSeconds(){
        Date fecha = new Date(((getTimeInMillis() + 86399) / 86400) * 86400);
        fecha.setHours(0);
        fecha.setMinutes(0);
        fecha.setSeconds(0);
        return fecha;
    }   
    
    
    
    
}
