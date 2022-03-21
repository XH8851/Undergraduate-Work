package com.action.Internship;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class InternshipManager extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private List<InternshipBean> list;
	public List<InternshipBean> getList() {
		return list;
	}
	public void setList(List<InternshipBean> list) {
		this.list = list;
	}
	private String SearchRow;
	private String SearchKey;
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	/*private List<BuildingBean> buildinglist;
	public List<BuildingBean> getBuildinglist() {
		return buildinglist;
	}
	public void setBuildinglist(List<BuildingBean> buildinglist) {
		this.buildinglist = buildinglist;
	}
	private String Internship_BuildingID;
	public String getInternship_BuildingID() {
		return Internship_BuildingID;
	}
	public void setInternship_BuildingID(String domitoryBuildingID) {
		Internship_BuildingID = domitoryBuildingID;
	}*/
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
		if(!(isInvalid(SearchKey)))
		{
			if("Ihours".equals(SearchRow)){
				strWhere+=" and "+SearchRow+" < "+SearchKey+"";
			}else if("Keyword".equals(SearchRow)){
				//(FirstName='Thomas' OR FirstName='William')
				strWhere+=" and (Ifirm like '%"+SearchKey+"%'";
				strWhere+=" or Iindustry like '%"+SearchKey+"%'";
				strWhere+=" or Idpt like '%"+SearchKey+"%'";
				strWhere+=" or Ipst like '%"+SearchKey+"%'";
				strWhere+=" or Ilocation like '%"+SearchKey+"%'";
				strWhere+=" or Irqmt like '%"+SearchKey+"%'";
				strWhere+=" or Ihours like '%"+SearchKey+"%'";
				strWhere+=" or Ibonus like '%"+SearchKey+"%')";
			}else{
				strWhere+=" and "+SearchRow+" like '%"+SearchKey+"%'";
			}
			
			
		}
		if("2".equals(session.getAttribute("type"))){
			strWhere+=" and Snoemployer='"+session.getAttribute("id")+"'";
		}
		/*if(!(isInvalid(Internship_BuildingID)))
		{
			strWhere+=" and Internship_BuildingID='"+Internship_BuildingID+"'";
		}*/
		
		//查询所有楼宇
		/*buildinglist=new BuildingDao().GetList("","Building_Name");*/
		
		//查询所有
		list=new InternshipDao().GetList(strWhere,"PostTime");
	
		return SUCCESS;
		
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
