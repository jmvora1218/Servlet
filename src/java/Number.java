
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Number extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
         out.println("<html><body>");
         for(int i=0;i<5;i++)
         {
             out.println("<h1>"+ i + "<h1>");
         }
         out.println("</body></html>");
    }
}