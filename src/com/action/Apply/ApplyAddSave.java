package com.action.Apply;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ApplyBean;
import com.dao.ApplyDao;
import com.opensymphony.xwork2.ActionSupport;


public class ApplyAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	    private String Ino ;
	   
	    public String getIno() {
			return Ino;
		}

		public void setIno(String ino) {
			Ino = ino;
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
		
		
		//添加 投递成功，一轮面试，二轮面试，面试成功
		
		if (null == new ApplyDao().CheckApply((String)session.getAttribute("id"), Ino)) {
			ApplyBean cnbean=new ApplyBean();
			cnbean.setIno(Ino);
			cnbean.setSnoemployee((String)session.getAttribute("id"));
			cnbean.setAppStatus("投递成功");
			
			Date date = new Date();
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			
			cnbean.setAppTime(dateFormat.format(date));
			
			new ApplyDao().Add(cnbean);
			    
			//跳转
			out.print("<script language='javascript'>alert('申请成功！');window.location='InternshipManager.action';</script>");
		}else {
			out.print("<script language='javascript'>alert('您已申请过该实习，请勿重复申请！');window.location='InternshipManager.action';</script>");
		}
		
		
		
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
