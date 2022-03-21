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

	//下面是Action内用于封装用户请求参数的属性
	private List<ApplyBean> list;
	public List<ApplyBean> getList() {
		return list;
	}
	public void setList(List<ApplyBean> list) {
		this.list = list;
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
		//查询条件
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
			strWhere+=" and Apply_State='入住'";
		}*/
		//查询所有
		
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
		    System.out.println("两个时间之间的天数差为：" + days);
		    list.get(i).setAppTime(String.valueOf(days));
		}
	
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		 Date fromDate1 = simpleFormat.parse("2018-03-01 12:00");  
		    Date toDate1 = simpleFormat.parse("2018-03-12 12:00");  
		    long from1 = fromDate1.getTime();  
		    long to1 = toDate1.getTime();  
		    int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));  
		    System.out.println("两个时间之间的天数差为：" + days);
	}
	
}
