
import java.net.*;  
class d{  
public static void main(String[] args){  
try{  
InetAddress ip=InetAddress.getByName("www.indusbook.pk");  
  
System.out.println("Host Name: "+ip.getHostName());  
System.out.println("HostAddress: "+ip.getHostAddress());  
System.out.println("Address: "+ip.getAddress()); 
System.out.println("hashCode: "+ip.hashCode());  
System.out.println("getClass: "+ip.getClass()); 
System.out.println("isLinkLocalAddress: "+ip.isLinkLocalAddress());  
System.out.println("isMulticastAddress: "+ip.isMulticastAddress());  
}catch(Exception e){System.out.println(e);}  
}  
}  