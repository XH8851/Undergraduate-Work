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

	//������Action�����ڷ�װ�û��������������
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
		
		//��ѯ
		if(Snoemployer==null){
			cnbean=new EmployerDao().GetBean(Integer.parseInt(id),Snoemployer);
		}else{
			cnbean=new EmployerDao().GetBean(0,Snoemployer);
			aybean = new ApplyDao().GetErList(Snoemployer);
		}
		return SUCCESS;
		
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
