package com.action.Apply;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ReportFbSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
 	private int id ;
    private String AppReportFb ;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



public String getAppReportFb() {
		return AppReportFb;
	}

	public void setAppReportFb(String appReportFb) {
		AppReportFb = appReportFb;
	}

//处理用户请求的execute方法
public String execute() throws Exception {
	
	//解决乱码，用于页面输出
	HttpServletResponse response=null;
	response=ServletActionContext.getResponse();
	response.setContentType("text/html;charset=UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	
	//创建session对象
	HttpSession session = ServletActionContext.getRequest().getSession();
	//验证是否正常登录
	if(session.getAttribute("id")==null){
		out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
		out.flush();out.close();return null;
	}
	
	//修改
	
	ApplyBean cnbean=new ApplyBean();
	cnbean.setId(id);
	cnbean.setAppReportFb(AppReportFb);
	
	new ApplyDao().UpdateReportFb(cnbean);
	    
	//跳转
	out.print("<script language='javascript'>alert('举报反馈成功！');window.location='ApplyManager.action';</script>");
	out.flush();out.close();return null;
	
}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
