package com.action.Employee;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class EmployeeUpdate extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String id;
	private String Snoemployee;
	private EmployeeBean cnbean;
	private List<ApplyBean> aybean;
	
	

	public List<ApplyBean> getAybean() {
		return aybean;
	}

	public void setAybean(List<ApplyBean> aybean) {
		this.aybean = aybean;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmployeeBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(EmployeeBean cnbean) {
		this.cnbean = cnbean;
	}
	
	public String getSnoemployee() {
		return Snoemployee;
	}

	public void setSnoemployee(String snoemployee) {
		Snoemployee = snoemployee;
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
		
		//查询
		
		if(Snoemployee==null){
			cnbean=new EmployeeDao().GetAllBean(Integer.parseInt(id),Snoemployee);
			
		}else{
			cnbean=new EmployeeDao().GetAllBean(0,Snoemployee);
			aybean = new ApplyDao().GetEeList(Snoemployee);
		}
		return SUCCESS;
		
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
