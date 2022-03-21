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
   if(isNull(form1.Ino.value)){  
   alert("请输入招聘编号！"); 
   return false;
   }
   if(isNull(form1.Ifirm.value)){
   alert("请输入公司！");
   return false;
   }
   if(isNull(form1.Iindustry.value)){
   alert("请输入行业！");
   return false;
   }
   if(isNull(form1.Idpt.value)){
   alert("请输入部门！");
   return false;
   }
   if(isNull(form1.Ipst.value)){
   alert("请输入岗位！");
   return false;
   }
   if(isNull(form1.Ilocation.value)){
	   alert("请输入地点！");
	   return false;
	   }
   if(isNull(form1.Ihours.value)){
	   alert("请输入时长！");
	   return false;
	   }
   if(isNull(form1.Ibonus.value)){
	   alert("请输入薪酬！");
	   return false;
	   }
   if(isNull(form1.Irqmt.value)){
	   alert("请输入要求！");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加招聘信息</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="InternshipAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>招聘编号：</td>
                    <td><input name="Ino" type="text" class="text2" id="Ino"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>公司：</td>
                    <td><input name="Ifirm" type="text" class="text2" id="Ifirm"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>行业：</td>
                    <td><input name="Iindustry" type="text" class="text2" id="Iindustry"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>部门：</td>
                    <td><input name="Idpt" type="text" class="text2" id="Idpt"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>岗位：</td>
                    <td><input name="Ipst" type="text" class="text2" id="Ipst"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>地点：</td>
                    <td><input name="Ilocation" type="text" class="text2" id="Ilocation"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>时长：</td>
                    <td><input name="Ihours" type="text" class="text2" id="Ihours"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>薪酬：</td>
                    <td><input name="Ibonus" type="text" class="text2" id="Ibonus"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>要求：</td>
                    <td><textarea name="Irqmt" id="Irqmt" cols="45" rows="5"></textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加招聘信息">
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
