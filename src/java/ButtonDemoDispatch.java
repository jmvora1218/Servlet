import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ButtonDemoDispatch extends HttpServlet
{

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        String b1=req.getParameter("btnone");
        String b2=req.getParameter("btntwo");
        String b3=req.getParameter("btnthree");
        out.println(b1+" "+b2+" "+b3);
       System.out.println("method==="+req.getMethod());
        if(b1!=null)
        {
            out.println("b1 is Clicked...");
            
            String url="B1";
            
            RequestDispatcher rd=req.getRequestDispatcher(url);
            req.setAttribute("msg","ProcessedB1");
            req.setAttribute("greet","Wel-Come");
            rd.forward(req,res);
        }
         if(b2!=null)
        {
            out.println("b2 is Clicked...");
             
            String url="B2";
            
            RequestDispatcher rd=req.getRequestDispatcher(url);
            req.setAttribute("msg","ProcessedB2");
            req.setAttribute("greet","Wel-Come");
            rd.forward(req, res);
        }
        if(b3!=null)
        {
            out.println("b3 is Clicked...");
            
            String url="B3";
            
            RequestDispatcher rd=req.getRequestDispatcher(url);
            req.setAttribute("msg","ProcessedB3");
            req.setAttribute("greet","Wel-Come");
            rd.forward(req, res);
        }
    }
         public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        
        res.setContentType("text/html");
        PrintWriter out =res.getWriter();
        
        out.println("<html><body>");
        out.println("<form name='submit1' method='post' action='ButtonDemoDispatch'>");
        out.println("<input type='submit' name='btnone' value='b1' > ");
        out.println("<input type='submit' name='btntwo' value='b2' > ");
        out.println("<input type='submit' name='btnthree' value='b3' > ");
        out.println("</form></html></body>");
    }
    
}