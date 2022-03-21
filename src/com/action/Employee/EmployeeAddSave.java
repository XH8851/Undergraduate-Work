package com.action.Employee;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class EmployeeAddSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	    private String Snoemployee ;
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
	    
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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

	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//��ѯ�û����Ƿ����
		List<EmployeeBean> list=new EmployeeDao().GetAllList("Snoemployee='"+Snoemployee+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('�û����Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//���
		EmployeeBean cnbean=new EmployeeBean();
		cnbean.setSnoemployee(Snoemployee);
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
		new EmployeeDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='EmployeeManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}
	
}
