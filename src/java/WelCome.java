import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelCome extends HttpServlet
{
   
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        /*  out.println("<html><body>");
        out.println("<h1>g</h1>");
        out.println("<h2>Name=+n</h2>");
        out.println("<h2>Password=p</h2>");
        out.println("</body></html>");*/
        
        
        String g=req.getParameter("greet");
        String n=req.getParameter("name");
        String p=req.getParameter("password");
        out.println(g+"  "+n+""+p);
      

    }
     
}

