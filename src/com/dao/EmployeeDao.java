package com.dao;

import com.db.DBHelper;
import com.bean.EmployeeBean;

import java.util.*;
import java.sql.*;

public class EmployeeDao {
	
	//验证登录
	public String CheckLogin(String Snoemployer, String password){
		String id = null;
		String sql="select * from tb_employee where Snoemployee='"+Snoemployer+"' and password='"+password+"' ";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("id");
			}
		}
		catch(SQLException ex){}
		return id;
	}
	
	
	//验证密码
	/*public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from tb_employee where Employee_ID='"+id+"' and Employee_Password='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ps=true;
			}
		}
		catch(SQLException ex){}
		return ps;
	}*/
	
	//获取所有列表
	public List<EmployeeBean> GetAllList(String strwhere,String strorder){
		String sql="select * from tb_employee";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
//		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				EmployeeBean cnbean=new EmployeeBean();
				cnbean.setId(rs.getInt("id"));
				cnbean.setSnoemployee(rs.getString("Snoemployee"));
				cnbean.setPassword(rs.getString("Password"));
				cnbean.setEmail(rs.getString("Email"));
				cnbean.setTel(rs.getString("Tel"));
				cnbean.setName(rs.getString("Name"));
				cnbean.setGender(rs.getString("Gender"));
				cnbean.setCollege(rs.getString("College"));
				cnbean.setMajor(rs.getString("Major"));
				cnbean.setGPA(rs.getString("GPA"));
				cnbean.setAwards(rs.getString("Awards"));
				cnbean.setSkill(rs.getString("Skill"));
				cnbean.setExperience(rs.getString("Experience"));
				cnbean.setComments(rs.getString("Comments"));
				cnbean.setIstatus(rs.getString("Istatus"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//获取列表
	/*public List<EmployeeBean> GetList(String strwhere,String strorder){
		String sql="select * from tb_employee";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
//		System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				EmployeeBean cnbean=new EmployeeBean();
				cnbean.setEmployee_ID(rs.getInt("Employee_ID"));
				cnbean.setEmployee_DomitoryID(rs.getInt("Employee_DomitoryID"));
				cnbean.setEmployee_Username(rs.getString("Employee_Username"));
				cnbean.setEmployee_Password(rs.getString("Employee_Password"));
				cnbean.setEmployee_Name(rs.getString("Employee_Name"));
				cnbean.setEmployee_Sex(rs.getString("Employee_Sex"));
				cnbean.setEmployee_Class(rs.getString("Employee_Class"));
				cnbean.setEmployee_State(rs.getString("Employee_State"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
				cnbean.setDomitory_Type(rs.getString("Domitory_Type"));
				cnbean.setDomitory_Number(rs.getString("Domitory_Number"));
				cnbean.setDomitory_Tel(rs.getString("Domitory_Tel"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}*/
	
	//获取指定ID的实体Bean
	/*public EmployeeBean GetAllFirstBean(String strwhere){
		String sql="select * from tb_employee where "+strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EmployeeBean cnbean=new EmployeeBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				cnbean.setEmployee_ID(rs.getInt("Employee_ID"));
				cnbean.setEmployee_DomitoryID(rs.getInt("Employee_DomitoryID"));
				cnbean.setEmployee_Username(rs.getString("Employee_Username"));
				cnbean.setEmployee_Password(rs.getString("Employee_Password"));
				cnbean.setEmployee_Name(rs.getString("Employee_Name"));
				cnbean.setEmployee_Sex(rs.getString("Employee_Sex"));
				cnbean.setEmployee_Class(rs.getString("Employee_Class"));
				cnbean.setEmployee_State(rs.getString("Employee_State"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}*/
	
	//获取指定ID的实体Bean
	/*public EmployeeBean GetFirstBean(String strwhere){
		String sql="select * from tb_employee where  "+strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EmployeeBean cnbean=new EmployeeBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				cnbean.setEmployee_ID(rs.getInt("Employee_ID"));
				cnbean.setEmployee_DomitoryID(rs.getInt("Employee_DomitoryID"));
				cnbean.setEmployee_Username(rs.getString("Employee_Username"));
				cnbean.setEmployee_Password(rs.getString("Employee_Password"));
				cnbean.setEmployee_Name(rs.getString("Employee_Name"));
				cnbean.setEmployee_Sex(rs.getString("Employee_Sex"));
				cnbean.setEmployee_Class(rs.getString("Employee_Class"));
				cnbean.setEmployee_State(rs.getString("Employee_State"));	
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}*/
	
	//获取指定ID的实体Bean
	public EmployeeBean GetAllBean(int id,String Snoemployee){
		String sql ="";
		if(id==0){
			sql="select * from tb_employee where Snoemployee='"+Snoemployee+"'";
		}else{
			sql="select * from tb_employee where id="+id;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EmployeeBean cnbean=new EmployeeBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setId(rs.getInt("id"));
				cnbean.setSnoemployee(rs.getString("Snoemployee"));
				cnbean.setPassword(rs.getString("Password"));
				cnbean.setEmail(rs.getString("Email"));
				cnbean.setTel(rs.getString("Tel"));
				cnbean.setName(rs.getString("Name"));
				cnbean.setGender(rs.getString("Gender"));
				cnbean.setCollege(rs.getString("College"));
				cnbean.setMajor(rs.getString("Major"));
				cnbean.setGPA(rs.getString("GPA"));
				cnbean.setAwards(rs.getString("Awards"));
				cnbean.setSkill(rs.getString("Skill"));
				cnbean.setExperience(rs.getString("Experience"));
				cnbean.setComments(rs.getString("Comments"));
				cnbean.setIstatus(rs.getString("Istatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//获取指定ID的实体Bean
	/*public EmployeeBean GetBean(int id){
		String sql="select * from Employee,Domitory,Building where Employee_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Employee_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EmployeeBean cnbean=new EmployeeBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setEmployee_ID(rs.getInt("Employee_ID"));
				cnbean.setEmployee_DomitoryID(rs.getInt("Employee_DomitoryID"));
				cnbean.setEmployee_Username(rs.getString("Employee_Username"));
				cnbean.setEmployee_Password(rs.getString("Employee_Password"));
				cnbean.setEmployee_Name(rs.getString("Employee_Name"));
				cnbean.setEmployee_Sex(rs.getString("Employee_Sex"));
				cnbean.setEmployee_Class(rs.getString("Employee_Class"));
				cnbean.setEmployee_State(rs.getString("Employee_State"));
				cnbean.setDomitory_Name(rs.getString("Domitory_Name"));
				cnbean.setBuilding_Name(rs.getString("Building_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}*/
	
	//添加
	public void Add(EmployeeBean cnbean){
		String sql="insert into tb_employee (";
		sql+="Snoemployee,Password,Email,Tel,Name,Gender,College,Major,GPA,Awards,Skill,Experience,Comments,Istatus";
		sql+=") values(";
		sql+="'"+cnbean.getSnoemployee()+"','"+cnbean.getPassword()+"','"+cnbean.getEmail()+"','"+cnbean.getTel()+"','"+cnbean.getName()+"',"
				+ "'"+cnbean.getGender()+"','"+cnbean.getCollege()+"','"+cnbean.getMajor()+"','"+cnbean.getGPA()+"','"+cnbean.getAwards()+"',"
						+ "'"+cnbean.getSkill()+"','"+cnbean.getExperience()+"','"+cnbean.getComments()+"','"+cnbean.getIstatus()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//修改
	public void Update(EmployeeBean cnbean){
		String sql="update tb_employee set ";
		sql+="Snoemployee='"+cnbean.getSnoemployee()+"',";
		sql+="Password='"+cnbean.getPassword()+"',";
		sql+="Email='"+cnbean.getEmail()+"',";
		sql+="Tel='"+cnbean.getTel()+"',";
		sql+="Name='"+cnbean.getName()+"',";
		sql+="Gender='"+cnbean.getGender()+"',";
		sql+="College='"+cnbean.getCollege()+"',";
		sql+="Major='"+cnbean.getMajor()+"',";
		sql+="GPA='"+cnbean.getGPA()+"',";
		sql+="Awards='"+cnbean.getAwards()+"',";
		sql+="Skill='"+cnbean.getSkill()+"',";
		sql+="Experience='"+cnbean.getExperience()+"',";
		sql+="Comments='"+cnbean.getComments()+"',";
		sql+="Istatus='"+cnbean.getIstatus()+"'";
		
		sql+=" where id="+cnbean.getId()+"";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete from tb_employee where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

