package com.action.Employer;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class EmployerUpdate extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String id;
	private String Snoemployer;
	private EmployerBean cnbean;
	private List<ApplyBean> aybean;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmployerBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(EmployerBean cnbean) {
		this.cnbean = cnbean;
	}
	

	public String getSnoemployer() {
		return Snoemployer;
	}

	public void setSnoemployer(String snoemployer) {
		Snoemployer = snoemployer;
	}
	
	
	public List<ApplyBean> getAybean() {
		return aybean;
	}

	public void setAybean(List<ApplyBean> aybean) {
		this.aybean = aybean;
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
		if(Snoemployer==null){
			cnbean=new EmployerDao().GetBean(Integer.parseInt(id),Snoemployer);
		}else{
			cnbean=new EmployerDao().GetBean(0,Snoemployer);
			aybean = new ApplyDao().GetErList(Snoemployer);
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
