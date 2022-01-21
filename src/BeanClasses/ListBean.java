/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author Haji Khokar
 */
public class ListBean {
     private int Class;
     private String darja;
     
     public void setCLass(int Class )
    {
        this.Class=Class;
    }
     
     public void setDarja(String darja)
     {
         this.darja=darja;
     }
     public int getCLass()
    {
        return Class;
    }
     public String getDarja()
     {
         return darja;
     }
     
     public String toString()
	{
		return  darja;
	}

    
}
