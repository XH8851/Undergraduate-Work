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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">招聘信息管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="InternshipManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： 
                    
                    <%if(session.getAttribute("type").toString().equals("2")){%>
                    <a href="Internship/InternshipAdd.jsp" style="color: blue">添加招聘信息</a>
                    <%}%>
                    </td>
                     <td width="70%">查询：
                      <%-- <select name="Domitory_BuildingID" id="Domitory_BuildingID">
                      <option value="">全部楼宇</option>
                      <s:iterator value="buildinglist">
                      <option value="${Building_ID}">${Building_Name}</option>
                      </s:iterator>
                      </select> --%>
                      <select name="SearchRow" id="SearchRow">
                      	<option value="Keyword">关键字</option>
                        <option value="Ilocation">实习地点</option>
                        <option value="Iindustry">实习行业</option>
                        <option value="Ihours">实习时间小于(天/周)</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="查询"></td> 
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>招聘信息编号</strong></td>
                     <td bgcolor="#D5E4F4"><strong>发布者编号</strong></td>
                     <td bgcolor="#D5E4F4"><strong>实习地点</strong></td>
                      <td bgcolor="#D5E4F4"><strong>实习行业</strong></td>
                    <td bgcolor="#D5E4F4"><strong>公司</strong></td>
                     <td bgcolor="#D5E4F4"><strong>一周工作天数</strong></td>
                     <td bgcolor="#D5E4F4"><strong>岗位</strong></td>
                    <td bgcolor="#D5E4F4"><strong>薪酬</strong></td>
                    <td bgcolor="#D5E4F4"><strong>发布时间</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr> 
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Ino}</td>
                      <td height="25" align="center" ><a href="EmployerUpdate.action?Snoemployer=${Snoemployer}" >${Snoemployer}</a> </td>
                      <td>${Ilocation}</td>
                      <td>${Iindustry}</td>
                      <td>${Ifirm}</td>
                      <td>${Ihours}</td>
                      <td>${Ipst}</td>
                      <td align="center">${Ibonus}</td>
                      <td align="center">${PostTime}</td>
                      
                      <td align="center">
                      <%if(session.getAttribute("type").toString().equals("3")){%>
                      <a href="ApplyAddSave.action?Ino=${Ino}">申请</a> 
                      <%}%>
                      <%if(session.getAttribute("type").toString().equals("2")){%>
                      <a href="InternshipUpdate.action?id=${id}">修改</a> 
                      <%}%>
                      <%if(!session.getAttribute("type").toString().equals("2")){%>
                      <a href="InternshipUpdate.action?id=${id}">查看</a>
                      <%}%>
                      <%if(!session.getAttribute("type").toString().equals("3")){%>
                      <a href="InternshipDel.action?id=${id}" onClick="return confirm('确定要删除该招聘信息吗？')">删除</a>
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
