import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SHREEJI
 */
public class SCAE implements ServletContextAttributeListener{

    
    public void attributeAdded(ServletContextAttributeEvent scae) {
    String an=scae.getName();
    Date d=new Date();
    String t=d.toString();
    System.out.println(an+"added= "+ t);
    }
    
    public void attributeRemoved(ServletContextAttributeEvent scae) {
    String an=scae.getName();
    Date d=new Date();
    String t=d.toString();
    System.out.println(an+"added= "+ t);
    }
    
    public void attributeReplaced(ServletContextAttributeEvent scae) {
    String an=scae.getName();
    Date d=new Date();
    String t=d.toString();
    System.out.println(an+"added= "+ t);
    }
}
