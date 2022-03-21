<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
          <%@ include file="../Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">招聘管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <%-- <form name="form1" method="post" action="BuildingManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 查看：
                     <a href="Report.action?id=${id}" style="color: blue">举报</a> <a href="ReportFb.action?id=${id}" style="color: blue">举报回馈</a>
                      <a href="InternRate.action?Ino=${Ino}&Snoemployee=${Snoemployee}" style="color: blue">实习评价</a> <a href="EmployeeRate.action?Ino=${Ino}&Snoemployee=${Snoemployee}" style="color: blue">实习生评价</a></td>
                    <!-- <td width="72%">名称：
                      
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>-->
                  </tr>
                </table>
              </form>  --%>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>招聘信息编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>求职者</strong></td>
                    <td bgcolor="#D5E4F4"><strong>申请状态</strong></td>
                    <td bgcolor="#D5E4F4"><strong>申请后时长</strong></td>
                    <%--<td bgcolor="#D5E4F4"><strong>举报回馈</strong></td><%-- 
                    <td bgcolor="#D5E4F4"><strong>实习生评价</strong></td> --%>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list" >
                    <tr align="center">
                      <%-- <td height="25" align="center">${Ino}</td>--%>
                      <td height="25" align="center"><a href="InternshipUpdate.action?Ino=${Ino}">${Ino}</a></td>
                      <td><a href="EmployeeUpdate.action?Snoemployee=${Snoemployee}" >${Snoemployee}</a></td>
                      <td>${AppStatus}</td>
                      <td>${AppTime}</td>
                     <%--  <td>${AppReportFb}</td>
                      <td>${EmployeeRate}</td> --%>
                      <td align="center">
                    
                      <%if(!session.getAttribute("type").toString().equals("2")){%>
                       <s:if test='AppStatus!="面试成功"'>
                        <a href="Report.action?id=${id}">举报</a> 
                        <a href="ReportFb.action?id=${id}">举报回馈</a>
                        </s:if>
                        <%}%>
                          <s:if test='AppStatus=="面试成功"'>
                           <%if(!session.getAttribute("type").toString().equals("2")){%>
                        <a href="InternRate.action?Ino=${Ino}&Snoemployee=${Snoemployee}">实习评价</a> 
                        <%}%>
                        <%if(!session.getAttribute("type").toString().equals("3")){%>
                        <a href="EmployeeRate.action?Ino=${Ino}&Snoemployee=${Snoemployee}">评价实习生</a>
                         <%}%>
                        </s:if>
                         <%if(!session.getAttribute("type").toString().equals("3")){%>
                        <a href="AppStatusUpdate.action?id=${id}" >修改申请状态</a>
                         <%if(session.getAttribute("type").toString().equals("1")){%>
                        <a href="ApplyDel.action?id=${id}" onClick="return confirm('确定要删除该招聘吗？')">删除</a>
                        <%}%>
                         
                        <%}%>
                        
                        <%if(session.getAttribute("type").toString().equals("3")){%>
                        <s:if test='AppStatus!="面试成功"'>
                        <a href="ApplyDel.action?id=${id}" onClick="return confirm('确定要删除该招聘吗？')">删除</a>
                        </s:if>
                        <%}%>
                      </td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
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
