package com.action.Internship;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class InternshipUpdate extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String id;
	private String Ino;
	private InternshipBean cnbean;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIno() {
		return Ino;
	}

	public void setIno(String Ino) {
		this.Ino = Ino;
	}

	public InternshipBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(InternshipBean cnbean) {
		this.cnbean = cnbean;
	}

	/*private List<BuildingBean> list;
	public List<BuildingBean> getList() {
		return list;
	}
	public void setList(List<BuildingBean> list) {
		this.list = list;
	}*/
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
		
		//��ѯ����¥��
		/*list=new BuildingDao().GetList("","Building_Name");*/
		//��ѯ
		//cnbean=new InternshipDao().GetBean(Integer.parseInt(id));
		cnbean=new InternshipDao().GetBean(Ino);
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