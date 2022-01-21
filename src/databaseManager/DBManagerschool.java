/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManager;
import BeanClasses.DetailsBean;
import BeanClasses.ListBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Haji Khokar
 */


//import BeanClasses.DetailsBean;

/**
 *
 * @author Haji Khokar
 */
public class DBManagerschool {
   
    private static Connection con;
	static{
		init();
	}
	private static void init(){
		try{
                  
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    String path=new java.io.File("F:\\Schoolfinal\\db\\aceess\\SchoolDB.accdb").getAbsolutePath();
                    System.err.println(""+path);
                    String url="jdbc:ucanaccess://"+path;
                    con=DriverManager.getConnection(url);
		}catch(Exception e){
                    e.printStackTrace();
		}
        }
        public static Vector getDetail(int Class)throws Exception{
             String query="Select * from data where class="+Class;
	//String query="Select * from data";
         System.out.println(query);
	 Statement st = null;
         ResultSet result=null;
	try{
           st = con.createStatement();
           result=st.executeQuery(query);
           Vector v=new Vector();
            
            while(result.next()){
               
                DetailsBean bean = new DetailsBean();
                if(bean==null)break;
                bean.setCLass(result.getInt("class"));
                
                bean.setId(result.getInt("id"));
                bean.setStudentName(result.getString("student_name"));
                bean.setFatherName(result.getString("father_name"));
                bean.setCaste(result.getString("caste"));
       //         bean.setCLass(result.getInt("class"));
                bean.setFees(result.getInt("fees"));
                 bean.setDateandmonthofpayment(result.getDate("date_and_month_of_payment"));
                bean.setBalance(result.getInt("balance"));
                 bean.setNumber(result.getString("number"));
                
                 v.addElement(bean);

             }
             System.out.print(v.size());
		 return v;
	 }
    finally{
    if(result!=null)
               result.close();
           if(st!=null)
                st.close();
	 }
 }
        public static Vector getCLass()throws Exception{
	 String query="Select * from step";
         System.out.println(query);
	 Statement st = null;
         ResultSet result=null;
	try{
           st = con.createStatement();
           result=st.executeQuery(query);
           Vector v=new Vector();
            
            while(result.next()){
               
                ListBean bean = new ListBean();
                if(bean==null)break;
                bean.setCLass(result.getInt("class"));
                bean.setDarja(result.getString("darja"));
                
                 v.addElement(bean);

             }
             System.out.print(v.size());
		 return v;
	 }
    finally{
    if(result!=null)
               result.close();
           if(st!=null)
                st.close();
	 }
 }
       public static int deleteDetail(int Id)throws Exception
{
	String query="delete from data where id="+Id;
	System.out.println(query);
	Statement st=null;
	try
	{
		st=con.createStatement();
		int rows=st.executeUpdate(query);
		return rows;
	}finally{
		if(st!=null)st.close();
	}
 }
//public static int addDetail(int Class,String studentName,String fatherName,String caste,String Section,String Fees,String Dateandmonthofpayment,String Balance,String PhoneNumber)throws Exception
//{
//	String query="insert into data(class,student_name,father_name,caste,section,fees,date_and_month_of_payment,balance,number)values("+Class+",'"+studentName+"','"+fatherName+"','"+caste+"','"+Section+"','"+Fees+"','"+Dateandmonthofpayment+"','"+Balance+"','"+PhoneNumber+"')";
//	System.out.println(query);
//	Statement st=null;
//	try
//	{
//		st=con.createStatement();
//		int rows=st.executeUpdate(query);
//		return rows;
//	}finally{
//		if(st!=null)st.close();
//	}
// }
public static int addDetail(int Class,String studentName,String fatherName,String caste,String Section,int Fees,String Dateandmonthofpayment,int Balance,String PhoneNumber)throws Exception
{
	String query="insert into data(class,student_name,father_name,caste,section,fees,date_and_month_of_payment,balance,number)values("+Class+",'"+studentName+"','"+fatherName+"','"+caste+"','"+Section+"',"+Fees+",'"+Dateandmonthofpayment+"',"+Balance+",'"+PhoneNumber+"')";
	System.out.println(query);
	Statement st=null;
	try
	{
		st=con.createStatement();
		int rows=st.executeUpdate(query);
		return rows;
	}finally{
		if(st!=null)st.close();
	}
 }


public static int updateDetail(int CLass,int Id,String studentName,String fatherName,String Caste,String Section,int Fees,String Dateandmonthofpayment,int Balance,String PhoneNumber)throws Exception{   
	String query="update data set class="+CLass+",id="+Id+",student_name='"+studentName+"',father_name='"+fatherName+"',caste='"+Caste+"',section='"+Section+"',fees="+Fees+",date_and_month_of_payment='"+Dateandmonthofpayment+"',balance="+Balance+",number='"+PhoneNumber+"' where id="+Id;
	System.out.println(query);
	Statement st=null;
	try
	{
		st=con.createStatement();
		int rows=st.executeUpdate(query);
		return rows;
	}finally{
		if(st!=null)st.close();
	}
 }
public static Vector getDefaulter(String startDate,String endDate)throws Exception
{
//    if(startDate.trim().equals(""))
//        startDate=null;
//       else
//        startDate="#"+startDate+"#";
//    if(endDate.trim().equals(""))
//        endDate=null;
//    else
//        endDate="#"+endDate+"#";
//    //String query="select roll_no,std_name,f_name,sur_name,b.book_id,book_name,b.auther_name from bookissue bi,book b,student std where bi.std_id=std.std_id and bi.book_id and Date_of_issue>="+startDate+" are date_of_return<="+endDate;
    
    
    
    String query = "select class, id, student_name,father_name, caste, fees, section,balance,number"
            +" from data  "
            +" where date_and_month_of_payment >='"+startDate+"' and date_and_month_of_payment <='"+endDate+"'"
            +"and fees <=1";
    //    "select s.roll_no, s.std_name, s.f_name, s.sur_name, bi.date_of_issue, b.book_name, b.auther_name "
    //            + "from bookIssue bi, student s, book b "
    //            + "where bi.std_id = s.std_id "
    //            + "and bi.book_id = b.book_id "
    //            + "and date_of_issue >= '"+startDate+"' and date_of_issue <= '"+endDate+"'" 
    //            +"and bi.date_of_return is null";
    String query2="select class, id, student_name,father_name, caste, section,balance,number  "
            +"from data  "
            + " where date_and_month_of_payment >='"+startDate+"' and date_and_month_of_payment <='"+endDate+"'"
            +"and fees = 0";
    System.out.println(query);
    Statement st=null;
    ResultSet result=null;
    try{
        st=con.createStatement();
        result=st.executeQuery(query);
        Vector v=new Vector();
        DetailsBean DetailsBean=null;
        while(result.next()){
        DetailsBean=new DetailsBean();
       // while(result.next()){
        DetailsBean.setCLass(result.getInt("class"));
        DetailsBean.setId(result.getInt("id"));
        DetailsBean.setStudentName(result.getString("student_name"));
        DetailsBean.setFatherName(result.getString("father_name"));
        DetailsBean.setCaste(result.getString("caste"));
       DetailsBean.setSection(result.getString("section"));
       DetailsBean.setBalance(result.getInt("balance"));
       DetailsBean.setNumber(result.getString("number"));
       v.addElement(DetailsBean);
        }
        return v;
    }finally{
            if(result!=null)result.close();
            if(st!=null)st.close();
            }
} 
public static Vector getDefaulterbybalace(String startDate1,String endDate1)throws Exception
{
//    if(startDate.trim().equals(""))
//        startDate=null;
//       else
//        startDate="#"+startDate+"#";
//    if(endDate.trim().equals(""))
//        endDate=null;
//    else
//        endDate="#"+endDate+"#";
//    //String query="select roll_no,std_name,f_name,sur_name,b.book_id,book_name,b.auther_name from bookissue bi,book b,student std where bi.std_id=std.std_id and bi.book_id and Date_of_issue>="+startDate+" are date_of_return<="+endDate;
    
    
    
    String query = "select class, id, student_name,father_name, caste, section,balance,number"
            +" from data  "
            +" where date_and_month_of_payment >='"+startDate1+"' and date_and_month_of_payment <='"+endDate1+"'"
            +"and balance >= 1";
    //    "select s.roll_no, s.std_name, s.f_name, s.sur_name, bi.date_of_issue, b.book_name, b.auther_name "
    //            + "from bookIssue bi, student s, book b "
    //            + "where bi.std_id = s.std_id "
    //            + "and bi.book_id = b.book_id "
    //            + "and date_of_issue >= '"+startDate+"' and date_of_issue <= '"+endDate+"'" 
    //            +"and bi.date_of_return is null";
    String query2="select class, id, student_name,father_name, caste, section,balance,number  "
            +"from data  "
            + " where date_and_month_of_payment >='"+startDate1+"' and date_and_month_of_payment <='"+endDate1+"'"
            +"and balance = 0";
    System.out.println(query);
    Statement st=null;
    ResultSet result=null;
    try{
        st=con.createStatement();
        result=st.executeQuery(query);
        Vector v=new Vector();
        DetailsBean DetailsBean=null;
        while(result.next()){
        DetailsBean=new DetailsBean();
       // while(result.next()){
        DetailsBean.setCLass(result.getInt("class"));
        DetailsBean.setId(result.getInt("id"));
        DetailsBean.setStudentName(result.getString("student_name"));
        DetailsBean.setFatherName(result.getString("father_name"));
        DetailsBean.setCaste(result.getString("caste"));
       DetailsBean.setSection(result.getString("section"));
       DetailsBean.setBalance(result.getInt("balance"));
       DetailsBean.setNumber(result.getString("number"));
       v.addElement(DetailsBean);
        }
        return v;
    }finally{
            if(result!=null)result.close();
            if(st!=null)st.close();
            }
}
}

    


   
