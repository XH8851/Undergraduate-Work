package com.action.Apply;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class AppStatusUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	 	private int id ;
	    private String AppStatus ;
	    private String Ino ;
	    private String Snoemployee ;
	    
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAppStatus() {
			return AppStatus;
		}

		public void setAppStatus(String appStatus) {
			AppStatus = appStatus;
		}
		
		

	public String getIno() {
			return Ino;
		}

		public void setIno(String ino) {
			Ino = ino;
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
		
		//修改
		
		ApplyBean cnbean=new ApplyBean();
		cnbean.setId(id);
		cnbean.setAppStatus(AppStatus);
		
		if("面试成功".equals(AppStatus)){
			new ApplyDao().AddEvaluation(Ino,Snoemployee);
		}
		
		new ApplyDao().UpdateAppStatus(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('申请状态修改成功！');window.location='ApplyManager.action';</script>");
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
