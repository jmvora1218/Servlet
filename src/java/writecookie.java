/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
public class writecookie extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("Text/html");
        PrintWriter out=res.getWriter();
        
        Cookie n=new Cookie("txtname","jv");
        res.addCookie(n);
        Cookie p=new Cookie("txtpass","1218");
        res.addCookie(p);
        
        Cookie q=new Cookie("Qualification","B.E.");
        q.setMaxAge(1*60*60);
        res.addCookie(q);
        Cookie add=new Cookie("Address","Rib");
        q.setMaxAge(1*60*60);
        res.addCookie(add);
        
        out.print("<h1> All Cookies has been Written </h1>");
        out.print("<a href='readcookie'> Show all Cookie </a>");
    }
}
