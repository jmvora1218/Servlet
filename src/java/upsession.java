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
public class upsession extends HttpServlet {
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
    hs.setAttribute("unsession",req.getParameter("txtname"));
    
    out.println("<html><body>");
    out.println("<form name='un' method='get' action='citysession'>");
    out.println("PassWord : <input type='text' name='txtpass' value=' '>");
    out.println("<input type='Submit' name='Next' value='next'>");
    out.println("</form></body></html>");
    }
}
