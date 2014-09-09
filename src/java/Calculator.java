
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Calculator extends HttpServlet
{
    String d1=" ",d2=" ",ans=" ";
   
    public void doget(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        if(req.getParameter("btnadd")!=null){
            d1=req.getParameter("textdataone");
            d2=req.getParameter("textdatatwo");
            ans =(Integer.parseInt(d2)+Integer.parseInt(d1)+"");
        }
        if(req.getParameter("btnsub")!=null){
            d1=req.getParameter("textdataone");
            d2=req.getParameter("textdatatwo");
            ans =(Integer.parseInt(d2)-Integer.parseInt(d1)+"");
        }
        if(req.getParameter("btnmul")!=null){
            d1=req.getParameter("textdataone");
            d2=req.getParameter("textdatatwo");
            ans =(Integer.parseInt(d2)*Integer.parseInt(d1)+"");
        }
        if(req.getParameter("btndiv")!=null){
            d1=req.getParameter("textdataone");
            d2=req.getParameter("textdatatwo");
            ans =(Integer.parseInt(d2)/Integer.parseInt(d1)+"");
        }
        out.println("<html><body>");
        out.println("form action='Calculator',method='post'");
        out.println("data1:<input type='text' new='textdemo' value='"+d1+"'>");
        out.println("</form></body></html>");
    }
}