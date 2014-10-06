/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
public class readcookie extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("Text/html");
    PrintWriter out=res.getWriter();
    
    Cookie c[]=req.getCookies();
    
    out.print("<html><body>");
    out.print("<table border='1'>");
    out.print("<th> Name </th> <th> Value </th>");
    for(int i=0;i<c.length;i++){
        out.print("<tr>");
        out.print("<td>"+c[i].getName()+"</td>");
        out.print("<td>"+c[i].getValue()+"</td>");
        out.print("</tr>");
    }
    out.print("</table></body></html>");
}
}
