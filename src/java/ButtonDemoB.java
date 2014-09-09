import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ButtonDemoB extends HttpServlet
{

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/http");
        PrintWriter out=res.getWriter();
        
        String b1=req.getParameter("btnoue");
        String b2=req.getParameter("btntwo");
        String b3=req.getParameter("btnthree");
        out.println(b1+" "+b2+" "+b3);
        
        if(b1!=null)
        {
            out.println("b1 is Clicked...");
        }
         if(b2!=null)
        {
            out.println("b2 is Clicked...");
        }
        if(b3!=null)
        {
            out.println("b3 is Clicked...");
        }
    }
         public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out =res.getWriter();
        out.println("<html><body>");
        out.println("<form name='submit' method='post' action='ButtonDemo'>");
        out.println("<input type='submit' name='bone' value='b1' > ");
        out.println("<input type='submit' name='btwo' value='b2' > ");
        out.println("<input type='submit' name='bthree' value='b3' > ");
        out.println("</form></html></body>");
    }
    
}