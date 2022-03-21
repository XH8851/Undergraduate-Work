package com.action.Internship;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class InternshipUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	 private int id ;
	    private String Ino ;
	    private String Inoold ;
	    private String Ifirm ;
	    private String Iindustry ;
	    private String Idpt ;
	    private String Ipst ;
	    private String Ilocation ;
	    private String Irqmt ;
	    private String Ihours ;
	    private String Ibonus ;
	    private String PostTime ;
	    private String Snoemployer ;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIno() {
			return Ino;
		}
		public void setIno(String ino) {
			Ino = ino;
		}
		public String getIfirm() {
			return Ifirm;
		}
		public void setIfirm(String ifirm) {
			Ifirm = ifirm;
		}
		public String getIindustry() {
			return Iindustry;
		}
		public void setIindustry(String iindustry) {
			Iindustry = iindustry;
		}
		public String getIdpt() {
			return Idpt;
		}
		public void setIdpt(String idpt) {
			Idpt = idpt;
		}
		public String getIpst() {
			return Ipst;
		}
		public void setIpst(String ipst) {
			Ipst = ipst;
		}
		public String getIlocation() {
			return Ilocation;
		}
		public void setIlocation(String ilocation) {
			Ilocation = ilocation;
		}
		public String getIrqmt() {
			return Irqmt;
		}
		public void setIrqmt(String irqmt) {
			Irqmt = irqmt;
		}
		public String getIhours() {
			return Ihours;
		}
		public void setIhours(String ihours) {
			Ihours = ihours;
		}
		public String getIbonus() {
			return Ibonus;
		}
		public void setIbonus(String ibonus) {
			Ibonus = ibonus;
		}
		public String getPostTime() {
			return PostTime;
		}
		public void setPostTime(String postTime) {
			PostTime = postTime;
		}
		public String getSnoemployer() {
			return Snoemployer;
		}
		public void setSnoemployer(String snoemployer) {
			Snoemployer = snoemployer;
		}
		public String getInoold() {
			return Inoold;
		}
		public void setInoold(String inoold) {
			Inoold = inoold;
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
		
		//查询是否存在
				List<InternshipBean> list=new InternshipDao().GetList("Ino='"+Ino+"'", "");
				if(list.size()>0&&!Inoold.equals(list.get(0).getIno()))
				{
					out.print("<script language='javascript'>alert('该招聘编号已存在！');history.back(-1);</script>");
					out.flush();out.close();return null;
				}
		//修改
		
		InternshipBean cnbean=new InternshipBean();
		cnbean.setId(id);
		cnbean.setIno(Ino);
		cnbean.setIfirm(Ifirm);
		cnbean.setIindustry(Iindustry);
		cnbean.setIdpt(Idpt);
		cnbean.setIpst(Ipst);
		cnbean.setIlocation(Ilocation);
		cnbean.setIrqmt(Irqmt);
		cnbean.setIhours(Ihours);
		cnbean.setIbonus(Ibonus);
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		
		cnbean.setPostTime(dateFormat.format(date));
		new InternshipDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='InternshipManager.action';</script>");
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
