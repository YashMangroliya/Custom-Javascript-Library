package com.thinking.machines.hr.servlets;
import java.io.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EmployeesJS extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try{
PrintWriter pw=response.getWriter();
ServletContext servletContext=getServletContext();

File file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}

List<EmployeeDTO> employees=new EmployeeDAO().getAll();
response.setContentType("text/javascript");
pw.print("var employee;"+"\n");
int index=0;
for(EmployeeDTO employeeDTO : employees)
{
pw.print("employee=new Employee();\n");
pw.print("employee.employeeId=\""+employeeDTO.getEmployeeId()+"\";\n");
pw.print("employee.name=\""+employeeDTO.getName()+"\";\n");
pw.print("employee.designationCode="+employeeDTO.getDesignationCode()+";\n");
pw.print("employee.designation=\""+employeeDTO.getDesignation()+"\";\n");
pw.print("employee.dateOfBirth=\""+employeeDTO.getDateOfBirth()+"\";\n");
pw.print("employee.basicSalary="+employeeDTO.getBasicSalary()+";\n");
pw.print("employee.gender=\""+employeeDTO.getGender()+"\";\n");
pw.print("employee.isIndian="+employeeDTO.getIsIndian()+";\n");
pw.print("employee.panNumber=\""+employeeDTO.getPANNumber()+"\";\n");
pw.print("employee.aadharCardNumber=\""+employeeDTO.getAadharCardNumber()+"\";\n");
pw.print("employees["+index+"]=employee;\n");
index++;
}
}catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}