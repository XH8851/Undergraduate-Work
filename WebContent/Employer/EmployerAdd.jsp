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
   if(isNull(form1.Snoemployer.value)){  
   alert("请输入学号！"); 
   return false;
   }
   
   if(isNull(form1.password.value)){
   alert("请输入密码！");
   return false;
   }
   if(isNull(form1.password2.value)){
   alert("请输入重复密码！");
   return false;
   }
   if (document.form1.password.value != document.form1.password2.value) { 
   alert("您两次输入的新密码不一致！请重新输入！"); 
   return false; 
   }  
   if(isNull(form1.Name.value)){
   alert("请输入姓名！");
   return false;
   }
   if(isNull(form1.Gender.value)){
   alert("请选择性别！");
   return false;
   }
   if(isNull(form1.Tel.value)){
   alert("请输入联系电话！");
   return false;
   }
   if(isNull(form1.Email.value)){
	   alert("请输入Email！");
	   return false;
	   }
   if(isNull(form1.Jno.value)){
	   alert("请输入工号！");
	   return false;
	   }
   if(isNull(form1.Firm.value)){
	   alert("请输入公司！");
	   return false;
	   }
   if(isNull(form1.Position.value)){
	   alert("请输入职位！");
	   return false;
	   }
   if(isNull(form1.Industry.value)){
	   alert("请输入联系行业！");
	   return false;
	   }
   if(isNull(form1.Responsibility.value)){
	   alert("请输入工作职责！");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加招聘者</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="EmployerAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>学号：</td>
                    <td><input name="Snoemployer" type="text" class="text2" id="Snoemployer"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>密码：</td>
                    <td><input name="password" type="password" class="text2" id="password"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>重复密码：</td>
                    <td><input name="password2" type="password" class="text2" id="password2"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>姓名：</td>
                    <td><input name="Name" type="text" class="text2" id="Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>性别：</td>
                    <td><select name="Gender" id="Gender">
                      <option value="">请选择</option>
                      <option value="男">男</option>
                      <option value="女">女</option>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>联系电话：</td>
                    <td><input name="Tel" type="text" class="text2" id="Tel"></td>
                  </tr>
                    <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>Email：</td>
                    <td><input name="Email" type="text" class="text2" id="Email"></td>
                  </tr>
                    <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>工号：</td>
                    <td><input name="Jno" type="text" class="text2" id="Jno"></td>
                  </tr>
                    <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>公司：</td>
                    <td><input name="Firm" type="text" class="text2" id="Firm"></td>
                  </tr>
                    <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>职位：</td>
                    <td><input name="Position" type="text" class="text2" id="Position"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>行业：</td>
                    <td><input name="Industry" type="text" class="text2" id="Industry"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>工作职责：</td>
                    <td><textarea rows="3" cols="25" name="Responsibility" id="Responsibility"></textarea></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;"></span>个人评价：</td>
                    <td><textarea rows="3" cols="25" name="Comments" id="Comments"></textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加招聘者">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
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
