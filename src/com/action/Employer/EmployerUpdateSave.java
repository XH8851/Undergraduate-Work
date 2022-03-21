package com.action.Employer;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class EmployerUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private int id ;
	private String Snoemployer ;
	private String Snoemployerold ;
    private String password ;
    private String Email ;
    private String Tel ;
    private String Name ;
    private String Gender ;
    private String Jno ;
    private String Firm ;
    private String Position ;
    private String Responsibility ;
    private String Industry ;
    private String Comments ;
	

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
				//List<EmployerBean> list=new EmployerDao().GetList("Snoemployer='"+Snoemployer+"'", "");
				//if(list.size()>0&&!Snoemployerold.equals(list.get(0).getSnoemployer()))
				//{
				//	out.print("<script language='javascript'>alert('学号已经存在！');history.back(-1);</script>");
				//	out.flush();out.close();return null;
				//}
		//修改
		
				EmployerBean cnbean=new EmployerBean();
				cnbean.setId(id);
				cnbean.setSnoemployer(Snoemployerold);
				cnbean.setPassword(password);
				cnbean.setEmail(Email);
				cnbean.setTel(Tel);
				cnbean.setName(Name);
				cnbean.setGender(Gender);
				cnbean.setJno(Jno);
				cnbean.setFirm(Firm);
				cnbean.setPosition(Position);
				cnbean.setResponsibility(Responsibility);
				cnbean.setIndustry(Industry);
				cnbean.setComments(Comments);
				
		new EmployerDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='EmployerManager.action';</script>");
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSnoemployer() {
		return Snoemployer;
	}

	public void setSnoemployer(String snoemployer) {
		Snoemployer = snoemployer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getJno() {
		return Jno;
	}

	public void setJno(String jno) {
		Jno = jno;
	}

	public String getFirm() {
		return Firm;
	}

	public void setFirm(String firm) {
		Firm = firm;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getResponsibility() {
		return Responsibility;
	}

	public void setResponsibility(String responsibility) {
		Responsibility = responsibility;
	}

	public String getIndustry() {
		return Industry;
	}

	public void setIndustry(String industry) {
		Industry = industry;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getSnoemployerold() {
		return Snoemployerold;
	}

	public void setSnoemployerold(String snoemployerold) {
		Snoemployerold = snoemployerold;
	}
	
	
	
	
}
