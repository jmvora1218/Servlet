import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class productselection extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        HttpSession hs=req.getSession(true);
        String n=(String)hs.getAttribute("un");
        out.println("user:  "+n);
         out.println("<html><body>");
        out.println("<a href='belt'>BELT  </a>");
         out.println("<a href='mouse'>MOUSE  </a>");
          out.println("<a href='signout'>SignOut</a>");
        out.println("</body></html>");



    }

}