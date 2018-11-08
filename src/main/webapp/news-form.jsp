<%@page import="pkg.Article"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>News</title>
</head>
<body>
	<%
	ArrayList<pkg.Article> newsDate=(ArrayList<pkg.Article>)request.getAttribute("newsDate");
	for(int i=0;i < newsDate.size();i++){
		Article oneDate = newsDate.get(i);;
		out.print("<p><font size='7'><b>Title:      </font><font color='brown' size='7'>"+oneDate.getTitles()+"<br></b></font></p>");
		out.print("<p><font size='5'><b>Link:		</font><font color='blue' size='5'> <a href='"+oneDate.getLinks()+"'>"+oneDate.getLinks()+"</a><br></b></font></p>");
		out.print("<p><font size='5'><b>PubDate:	</font><font color='red' size='5'>" +oneDate.getPubDates()+"<br></font></p>");
		out.print("<p><font size='5'><b>Description:</font><font  size='5'>	"		  +oneDate.getDescriptions()+"<br><hr><br></font></p>");
	}
	%>
</body>
</html>