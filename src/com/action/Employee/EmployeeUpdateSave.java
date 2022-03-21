package com.action.Employee;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class EmployeeUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	 private int id ;
	    private String Snoemployee ;
	    private String Snoemployeeold ;
	    private String password ;
	    private String Email ;
	    private String Tel ;
	    private String Name ;
	    private String Gender ;
	    private String College ;
	    private String Major ;
	    private String GPA ;
	    private String Awards ;
	    private String Skill ;
	    private String Experience ;
	    private String Comments ;
	    private String Istatus ;
	    
	    
		public String getSnoemployeeold() {
			return Snoemployeeold;
		}
		public void setSnoemployeeold(String snoemployeeold) {
			Snoemployeeold = snoemployeeold;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSnoemployee() {
			return Snoemployee;
		}
		public void setSnoemployee(String snoemployee) {
			Snoemployee = snoemployee;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getTel() {
			return Tel;
		}
		public void setTel(String tel) {
			Tel = tel;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		public String getCollege() {
			return College;
		}
		public void setCollege(String college) {
			College = college;
		}
		public String getMajor() {
			return Major;
		}
		public void setMajor(String major) {
			Major = major;
		}
		public String getGPA() {
			return GPA;
		}
		public void setGPA(String gPA) {
			GPA = gPA;
		}
		public String getAwards() {
			return Awards;
		}
		public void setAwards(String awards) {
			Awards = awards;
		}
		public String getSkill() {
			return Skill;
		}
		public void setSkill(String skill) {
			Skill = skill;
		}
		public String getExperience() {
			return Experience;
		}
		public void setExperience(String experience) {
			Experience = experience;
		}
		public String getComments() {
			return Comments;
		}
		public void setComments(String comments) {
			Comments = comments;
		}
		public String getIstatus() {
			return Istatus;
		}
		public void setIstatus(String istatus) {
			Istatus = istatus;
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
		
		//查询用户名是否存在
		//List<EmployeeBean> list=new EmployeeDao().GetAllList("Snoemployee='"+Snoemployee+"' ", "");
		//if(list.size()>0&&!Snoemployeeold.equals(list.get(0).getSnoemployee()))
		//{
		//	out.print("<script language='javascript'>alert('用学号已经存在！');history.back(-1);</script>");
		//	out.flush();out.close();return null;
		//}
		//修改
		
		EmployeeBean cnbean=new EmployeeBean();
		cnbean.setId(id);
		cnbean.setSnoemployee(Snoemployeeold);
		cnbean.setPassword(password);
		cnbean.setEmail(Email);
		cnbean.setTel(Tel);
		cnbean.setName(Name);
		cnbean.setGender(Gender);
		cnbean.setCollege(College);
		cnbean.setMajor(Major);
		cnbean.setGPA(GPA);
		cnbean.setAwards(Awards);
		cnbean.setSkill(Skill);
		cnbean.setExperience(Experience);
		cnbean.setComments(Comments);
		cnbean.setIstatus(Istatus);
		new EmployeeDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='EmployeeManager.action';</script>");
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
