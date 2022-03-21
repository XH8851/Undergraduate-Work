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

	//������Action�����ڷ�װ�û��������������
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
	
	//�޸�
	
	ApplyBean cnbean=new ApplyBean();
	cnbean.setId(id);
	cnbean.setAppReportFb(AppReportFb);
	
	new ApplyDao().UpdateReportFb(cnbean);
	    
	//��ת
	out.print("<script language='javascript'>alert('�ٱ������ɹ���');window.location='ApplyManager.action';</script>");
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
