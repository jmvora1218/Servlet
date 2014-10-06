import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SHREEJI
 */
public class DBcontextListener implements ServletContextListener{
    Connection con=null;
    
    public void contextInitialized(ServletContextEvent sce) {
     ServletContext ctx=sce.getServletContext();
     String Driver=ctx.getInitParameter("driver");
     System.out.println("driverloaded");
     String url=ctx.getInitParameter("url");
     String un=ctx.getInitParameter("un");
     String up=ctx.getInitParameter("up");
        
        try{
            Class.forName(Driver);
            con=DriverManager.getConnection(url,un,up);
            ctx.setAttribute("mycon", "con");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void contextDestroyed(ServletContextEvent sce) {
    ServletContext ctx=sce.getServletContext();
    con=(Connection)ctx.getAttribute("mycon");
    try{
        con.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    
    }
}
