package com.action.Apply;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ApplyBean;
import com.dao.ApplyDao;
import com.opensymphony.xwork2.ActionSupport;


public class ApplyManager extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<ApplyBean> list;
	public List<ApplyBean> getList() {
		return list;
	}
	public void setList(List<ApplyBean> list) {
		this.list = list;
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
		//��ѯ����
		String strWhere="1=1";
		/*if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}
		if(!(isInvalid(State)))
		{
			strWhere+=" and Apply_State='"+State+"'";
		}
		else
		{
			strWhere+=" and Apply_State='��ס'";
		}*/
		//��ѯ����
		
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		if("2".equals(session.getAttribute("type"))){
			strWhere+=" and ta.Ino = ti.Ino and ti.Snoemployer='"+session.getAttribute("id")+"'";
		}else if("3".equals(session.getAttribute("type"))){
			strWhere+=" and  ta.Snoemployee='"+session.getAttribute("id")+"'";
		}
		list=new ApplyDao().GetAllList(strWhere,"Ino");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");  
		System.out.println(formatter.format(date)); 
		for(int i=0;i<list.size();i++){
			
			Date fromDate1 = simpleFormat.parse(list.get(i).getAppTime()+" 12:00");  
		    Date toDate1 = simpleFormat.parse(formatter.format(date)+" 12:00");  
		    long from1 = fromDate1.getTime();  
		    long to1 = toDate1.getTime();  
		    int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));  
		    System.out.println("����ʱ��֮���������Ϊ��" + days);
		    list.get(i).setAppTime(String.valueOf(days));
		}
	
		return SUCCESS;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		 Date fromDate1 = simpleFormat.parse("2018-03-01 12:00");  
		    Date toDate1 = simpleFormat.parse("2018-03-12 12:00");  
		    long from1 = fromDate1.getTime();  
		    long to1 = toDate1.getTime();  
		    int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));  
		    System.out.println("����ʱ��֮���������Ϊ��" + days);
	}
	
}
