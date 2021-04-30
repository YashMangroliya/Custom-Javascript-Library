package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class ServletTwo extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e)
{

}
}
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
try{
response.setContentType("application/json");
response.setCharacterEncoding("utf-8");
pw=response.getWriter();
int code=Integer.parseInt(request.getParameter("code"));
try{
DesignationDTO designation=new DesignationDAO().getByCode(code);
Gson gson=new Gson();
String jsonString=gson.toJson(designation);
pw.print(jsonString);
System.out.print(jsonString);
}catch(DAOException daoException)
{
pw.print("INVALID");
}
}catch(Exception e)
{
try{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception eee)
{

}
}
}
}