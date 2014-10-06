/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SHREEJI
 */
public class citysession extends HttpServlet {
 public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("Text/html");
    PrintWriter out=res.getWriter();
    
    int c=0;
    
    HttpSession hs=req.getSession(true);
    if(hs.isNew())
    {
        out.print("New Session with ID: "+hs.getId());
    }
    else
    {
        c=Integer.parseInt((String)hs.getAttribute("counter"));
        out.print("Old Session with ID: "+hs.getId());
    }
    
    c=c+1;
    out.print("Visited user: "+c);
    hs.setAttribute("counter",c+"");
    
    hs.setAttribute("upsession",req.getParameter("txtpass"));
    
    out.println("<html><body>");
    out.println("<form name='city' method='post' action='citysession'>");
    out.println("City: <input type='text' name='txtcity' value=' '>");
    out.println("<input type='Submit' name='Next' value='next'>");
    out.println("</form></body></html>");
    }
 
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("Text/html");
    PrintWriter out=res.getWriter();
    
     HttpSession hs=req.getSession(true);
    if(hs.isNew())
    {
        out.print("New Session with ID: "+hs.getId());
    }
    else
    {
         out.print("Old Session with ID: "+hs.getId());
    }
    
    String unsession=(String)hs.getAttribute("unsession");
    String upsession=(String)hs.getAttribute("upsession");
    String citysession=req.getParameter("txtcity");
    
    out.print("   name: "+unsession+"   pass: "+upsession+"   City: "+citysession);
    
 }
 }