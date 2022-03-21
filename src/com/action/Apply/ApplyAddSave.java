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

	//������Action�����ڷ�װ�û��������������
	    private String Ino ;
	   
	    public String getIno() {
			return Ino;
		}

		public void setIno(String ino) {
			Ino = ino;
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
		
		
		//��� Ͷ�ݳɹ���һ�����ԣ��������ԣ����Գɹ�
		
		if (null == new ApplyDao().CheckApply((String)session.getAttribute("id"), Ino)) {
			ApplyBean cnbean=new ApplyBean();
			cnbean.setIno(Ino);
			cnbean.setSnoemployee((String)session.getAttribute("id"));
			cnbean.setAppStatus("Ͷ�ݳɹ�");
			
			Date date = new Date();
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
			
			cnbean.setAppTime(dateFormat.format(date));
			
			new ApplyDao().Add(cnbean);
			    
			//��ת
			out.print("<script language='javascript'>alert('����ɹ���');window.location='InternshipManager.action';</script>");
		}else {
			out.print("<script language='javascript'>alert('�����������ʵϰ�������ظ����룡');window.location='InternshipManager.action';</script>");
		}
		
		
		
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
