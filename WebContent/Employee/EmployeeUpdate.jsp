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
<script language="JavaScript">


function mycheck(){
	   if(isNull(form1.Student_Username.value)){  
		   alert("请输入学号！"); 
		   return false;
		   }
		   if(isNull(form1.Student_Password.value)){
		   alert("请输入密码！");
		   return false;
		   }
		   if(isNull(form1.Student_Password2.value)){
		   alert("请输入重复密码！");
		   return false;
		   }
		   if (document.form1.Student_Password.value != document.form1.Student_Password2.value) { 
		   alert("您两次输入的新密码不一致！请重新输入！"); 
		   return false; 
		   }  
		   if(isNull(form1.Student_Name.value)){
		   alert("请输入姓名！");
		   return false;
		   }
		   if(isNull(form1.Student_Sex.value)){
		   alert("请选择性别！");
		   return false;
		   }
		   if(isNull(form1.Email.value)){
		   alert("请输入邮箱！");
		   return false;
		   }
		   if(isNull(form1.Tel.value)){
			   alert("请输入电话！");
			   return false;
			   }
		   if(isNull(form1.College.value)){
			   alert("请输入学院！");
			   return false;
			   }
		   if(isNull(form1.Major.value)){
			   alert("请输入专业！");
			   return false;
			   }
		   if(isNull(form1.Istatus.value)){
			   alert("请选择实习状态！");
			   return false;
			   }
		  
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
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
             <%if(!session.getAttribute("type").toString().equals("2")){%>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改求职者</td>
             <%}else{%>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">查看求职者</td>
              <%}%>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="EmployeeUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>学号：</td>
                    <td><input name="Snoemployee" type="text" class="text2" id="Snoemployee" disabled="disabled" value="<s:property value='cnbean.Snoemployee'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>密码：</td>
                    <td><input name="Password" type="password" class="text2" id="Password" value="<s:property value='cnbean.password'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>重复密码：</td>
                    <td><input name="Password2" type="password" class="text2" id="Password2" value="<s:property value='cnbean.password'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>姓名：</td>
                    <td><input name="Name" type="text" class="text2" id="Name" value="<s:property value='cnbean.Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>性别：</td>
                    <td><select name="Gender" id="Gender">
                      <option value="男" 
                      <s:if test='cnbean.Gender=="男"'>selected</s:if>
                      >男
                      </option>
                      <option value="女" 
                      <s:if test='cnbean.Gender=="女"'>selected</s:if>
                      >女
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>邮箱：</td>
                    <td><input name="Email" type="text" class="text2" id="Email" value="<s:property value='cnbean.Email'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>电话：</td>
                    <td><input name="Tel" type="text" class="text2" id="Tel" value="<s:property value='cnbean.Tel'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>学院：</td>
                    <td><input name="College" type="text" class="text2" id="College" value="<s:property value='cnbean.College'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>专业：</td>
                    <td><input name="Major" type="text" class="text2" id="Major" value="<s:property value='cnbean.Major'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;"></span>绩点：</td>
                    <td><input name="GPA" type="text" class="text2" id="GPA" value="<s:property value='cnbean.GPA'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;"></span>奖项：</td>
                    <td><input name="Awards" type="text" class="text2" id="Awards" value="<s:property value='cnbean.Awards'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;"></span>技能：</td>
                    <td><input name="Skill" type="text" class="text2" id="Skill" value="<s:property value='cnbean.Skill'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;"></span>实习经历：</td>
                    <td><textarea rows="3" cols="25" name="Experience" id="Experience"><s:property value='cnbean.Experience'/></textarea></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;"></span>个人评价：</td>
                    <td><textarea rows="3" cols="25" name="Comments" id="Comments"><s:property value='cnbean.Comments'/></textarea></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>实习状态：</td>
                    <td><select name="Istatus" id="Istatus">
                       <option value="是" 
                      <s:if test='cnbean.Istatus=="是"'>selected</s:if>
                      >是
                      </option>
                      <option value="否" 
                      <s:if test='cnbean.Istatus=="否"'>selected</s:if>
                      >否
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td><td>
                    <%if(!session.getAttribute("type").toString().equals("2")){%>
                    <input type="submit" name="button" id="button" value="修改求职者">
                      &nbsp;&nbsp;
                      <%} else{%>
                     	<span style="color:blue"> 评价:<br/>
                      <s:iterator id="aa" value="aybean" >
                      	<span style="color:green"> ${EmployeeRate}.</span><br/>
                      </s:iterator>
                      </span>
                      <%} %>
                      <br/>
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
                 <input type="hidden" name="id" value="<s:property value='cnbean.id'/>"/>
                 <input type="hidden" name="Snoemployeeold" value="<s:property value='cnbean.Snoemployee'/>"/>
              </form></td>
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
