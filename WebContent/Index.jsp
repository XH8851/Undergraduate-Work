<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校友平台求职招聘系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
  
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校友平台求职招聘系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="middle" bgcolor="#F6F9FE">
           <%if(session.getAttribute("type").toString().equals("1")){%>
          <h1>管理员<SPAN style="color: BLUE">admin</SPAN>，您好！<br/>
			欢迎使用校友平台求职招聘系统。
			<%}%>
			
			<%if(session.getAttribute("type").toString().equals("2")){%>
          <h1>招聘者<SPAN style="color: BLUE"><%=session.getAttribute("id").toString() %></SPAN>，您好！<br/>
			欢迎使用校友平台求职招聘系统。
			<%}%>
			
			<%if(session.getAttribute("type").toString().equals("3")){%>
          <h1>求职者<SPAN style="color: BLUE"><%=session.getAttribute("id").toString() %></SPAN>，您好！<br/>
			欢迎使用校友平台求职招聘系统。
			<%}%>
         </h1></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
