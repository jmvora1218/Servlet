import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class signout extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {

         res.setContentType("text/html");
        PrintWriter out=res.getWriter();
         HttpSession hs=req.getSession(true);
         hs.invalidate();
         res.sendRedirect("sessionlogin");
    }
}