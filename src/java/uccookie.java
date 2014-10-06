/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
public class uccookie extends HttpServlet {

   
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    
    {
        res.setContentType("Text/html");
        PrintWriter out=res.getWriter();
        
        Cookie cp=new Cookie("txtpass",req.getParameter("txtpass"));
        res.addCookie(cp);
        
        out.println("<html><body>");
        out.println("<form name='City' method='post' action='uccookie'>");
        
        out.println("City: <input type='text' name='txtCity' value=' '>");
       
        out.println("<input type='Submit' name='Next' value='next'>");
        out.println("</form></body></html>");
    }   
     
     
     
     public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("Text/html");
        PrintWriter out=res.getWriter();
        
        String tn=null,tp=null;
        String cn="txtname",cp="txtpass";
        Cookie c[]=req.getCookies();
        for(int i=0;i<c.length;i++)
        {
            if(c[i].getValue().equals(cn))
            {
                tn=c[i].getValue();
            }
            if(c[i].getValue().equals(cp))
            {
                tn=c[i].getValue();
            }
        }
        String cety=req.getParameter("txtCity");
        out.println("Name= " +tn+ " Password= " +tp+ " City= "+cety);
    }
}