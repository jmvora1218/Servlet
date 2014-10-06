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

/**
 *
 * @author SHREEJI
 */
public class unsession extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("Text/html");
    PrintWriter out=res.getWriter();

    out.println("<html><body>");
    out.println("<form name='un' method='get' action='upsession'>");
    out.println("UserName: <input type='text' name='txtname' value=' '>");
    out.println("<input type='Submit' name='Next' value='next'>");
    out.println("</form></body></html>");
    }
}
