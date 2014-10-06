import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class belt extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {

         res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        HttpSession hs=req.getSession(true);
        if(hs.isNew())
       {
         res.sendRedirect("sessionlogin");

       }
        String n=(String)hs.getAttribute("un");
        out.println("User is :  "+n);
        out.println("belt selection!!!");
          out.println("<html><body>");
          out.println("<a href='signout'>Sign_Out</a>");
        out.println("</body></html>");
    }


}