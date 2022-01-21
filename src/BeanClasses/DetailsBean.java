/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;
import java.util.Date;
/**
 *
 * @author Haji Khokar
 */
public class DetailsBean {
    private int id;
    private String studentName;
    private String fatherName;
    private String caste;
    private int Class;
    private String section;
    private int fees;
       private Date dateandmonthofpayment; 
     private int balance;
    private String number;

    public void setId(int id)
    {
        this.id=id;
    }
   
   
    public void setStudentName(String studentName)
    {
        this.studentName=studentName;
    }
    
    public void setFatherName(String fatherName)
    {
        this.fatherName=fatherName;
    }
    
    public void setCaste(String caste)
    {
        this.caste=caste;
    }
    
    public void setCLass(int Class)
    {
        this.Class=Class;
    }
    
    public void setSection(String section)
    {
        this.section=section;
    }
   
    public void setFees(int fees)
    {
        this.fees=fees;
    }
    public void setDateandmonthofpayment(Date dateandmonthofpayment)
    {
    this.dateandmonthofpayment=dateandmonthofpayment;
    }
 public void setNumber(String number)
    {
        this.number=number;
    }
    
    public void setBalance(int balance)
    {
        this.balance=balance;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getStudentName()
    {
        return studentName;
    }
    
    public String getFaherName()
    {
        return fatherName;
    }
    
    public String getCaste()
    {
        return caste;
    }
    
    public int getCLass()
    {
        return Class;
    }

    public String getSection()
    {
        return section;
    }
    
    public int getFees()
    {
        return fees;
    }
    
    public Date getDateandmonthofpayment()
    {
        return dateandmonthofpayment;
    } 
    public String getNumber()
    {
        return number;
    }
    public int getBalance()
    {
        return balance;
    }
   public String toString()
	{
		return  ""+studentName;
	}


}



