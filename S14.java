import java.io.*;
 
public class SearchThread extends Thread
{
 File f1;
 String fname;
 static String str;
 String line;
 LineNumberReader reader = null;
 SearchThread(String fname)
 {
 this.fname=fname;
 f1=new File(fname);
 }
 public void run()
 { 
 try
 { 
 FileReader fr=new FileReader(f1);
 reader=new LineNumberReader(fr);
 while((line=reader.readLine())!=null)
 {
 if(line.indexOf(str)!=-1)
 {
 System.out.println("string found in "+fname+"at 
"+reader.getLineNumber()+"line");
 stop();
 }
 }
 }
 catch(Exception e)
 {
 }
 } 
 public static void main(String[] args) throws IOException
 {
 Thread t[]=new Thread[20];
 BufferedReader br=new BufferedReader(new
InputStreamReader(System.in));
 System.out.println("Enter String to search");
 str=br.readLine();
 
 FilenameFilter filter = new FilenameFilter()
 {
 public boolean accept(File file, String name) 
 {
 if (name.endsWith(".txt")) 
 {
 return true;
 }
 else
 {
 return false;
 }
 }
 };
 
 File dir1 = new File(".");
 File[] files = dir1.listFiles(filter);
 if (files.length == 0) 
 {
 System.out.println("no files available with this extension");
 } 
 else
 {
 for(int i=0;i<files.length;i++)
 {
 for (File aFile : files) 
 {
 t[i]=new SearchThread(aFile.getName());
 t[i].start();
 }
 }
 } 
 }
}












HTML FILE
<!DOCTYPE html>
<html>
<body>
<form method=post action="Slip7.jsp">
Enter Any Number : <Input type=text name=num><br><br>
<input type=submit value=Display>
</form>
</body>
</html>
JSP FILE:
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%! int n,rem,r; %>
<% n=Integer.parseInt(request.getParameter("num"));
 if(n<10)
 { 
 out.println("Sum of first and last digit is ");
%><font size=18 color=red><%= n %></font>
<%
 }
 else
 {
 rem=n%10;
 do{
 r=n%10;
 n=n/10;
 }while(n>0);
 n=rem+r;
 out.println("Sum of first and last digit is ");
%><font size=18 color=red><%= n %></font>
<%
 }
%>
</body>
</html>
