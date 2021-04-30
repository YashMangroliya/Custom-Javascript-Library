package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class ServletThree extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e)
{

}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
try{
response.setContentType("application/json");
pw=response.getWriter();
BufferedReader br=request.getReader();
StringBuffer sb=new StringBuffer();
String b;
while(true)
{
b=br.readLine(); 
if(b==null) break;
sb.append(b);
}
String rawData=sb.toString();
Gson gson=new Gson();
Costomer c=gson.fromJson(rawData,Costomer.class);
pw.print(gson.toJson(c));
pw.flush();
}catch(Exception e)
{
System.out.println(e);
try{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception eee)
{

}
}
}
}