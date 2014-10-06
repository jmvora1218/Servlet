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
public class showcookie extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("Text/html");
    PrintWriter out=res.getWriter();
    doPost(req,res);
}
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
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
    //out.print("<h1> All Cookies has been Written </h1>");
    Cookie c[]=req.getCookies();
    
    String x="",y="";
    
    if(req.getParameter("all")!=null)
    {
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
    if(req.getParameter("first")!=null)
    {
        x=c[0].getName();
        y=c[0].getValue();
    }
    if(req.getParameter("last")!=null)
    {
        int u=c.length-1;
        x=c[u].getName();
        y=c[u].getValue();
    }
    if(req.getParameter("add")!=null){
    Cookie nv=new Cookie(req.getParameter("tname"),req.getParameter("tpass"));
    res.addCookie(nv);
    }
    if(req.getParameter("delete")!=null){
        Cookie dc=new Cookie(req.getParameter("tname"),req.getParameter("tpass"));
        dc.setMaxAge(0);
        res.addCookie(dc);
    }
    if(req.getParameter("previous")!=null)
    {
        try{
        String pn=req.getParameter("tname");
        String pp=req.getParameter("tpass");
        for(int i=0;i<c.length;i++){
            if(c[i].getName().equals(pn))
            {
                x=c[i-1].getName();
                y=c[i-1].getValue();
            }
        }
        }catch(Exception e){
            out.print("No Previous data!!!");
        }
    }
    if(req.getParameter("next")!=null)
    {  try{  
       String nn=req.getParameter("tname");
       String np=req.getParameter("tpass");
       for(int i=0;i<c.length;i++){
           if(c[i].getName().equals(nn))
            {
                x=c[i+1].getName();
                y=c[i+1].getValue();
            }
        }
        }catch(Exception e){
            out.print("No Coockie awalable...");
        }
    }
    
    out.print("<html><body>");
    out.print("<form name=cookie method='get' action='showcookie'>");
    out.print("Name: <input type='text' name='tname' value='"+x+"'>");
    out.print("Pass: <input type='text' name='tpass' value='"+y+"'>");
    out.print("<input type='submit' name='all' value='Show All'>");
    out.print("<input type='submit' name='first' value='First'>");
    out.print("<input type='submit' name='last' value='Last'>");
    out.print("<input type='submit' name='add' value='ADD'>");
    out.print("<input type='submit' name='delete' value='DELETE'>");
    out.print("<input type='submit' name='previous' value='PREVIOUS'>");
    out.print("<input type='submit' name='next' value='NEXT'>");
    out.print("</form></body></html>");
}
}
