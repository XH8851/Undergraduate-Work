package com.dao;

import com.db.DBHelper;
import com.bean.EmployerBean;

import java.util.*;
import java.sql.*;

public class EmployerDao {
	
	//验证登录
	public String CheckLogin(String Snoemployer, String password){
		String id = null;
		String sql="select * from tb_Employer where Snoemployer='"+Snoemployer+"' and password='"+password+"'";
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
	/*//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from Employer where Employer_ID='"+id+"' and Employer_Password='"+password+"'";
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
	//获取列表
	public List<EmployerBean> GetList(String strwhere,String strorder){
		String sql="select * from tb_Employer";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<EmployerBean> list=new ArrayList<EmployerBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				EmployerBean cnbean=new EmployerBean();
				cnbean.setId(rs.getInt("id"));
				cnbean.setSnoemployer(rs.getString("Snoemployer"));
				cnbean.setPassword(rs.getString("password"));
				cnbean.setEmail(rs.getString("Email"));
				cnbean.setTel(rs.getString("Tel"));
				cnbean.setName(rs.getString("Name"));
				cnbean.setGender(rs.getString("Gender"));
				cnbean.setJno(rs.getString("Jno"));
				cnbean.setFirm(rs.getString("Firm"));
				cnbean.setPosition(rs.getString("Position"));
				cnbean.setResponsibility(rs.getString("Responsibility"));
				cnbean.setIndustry(rs.getString("Industry"));
				cnbean.setComments(rs.getString("Comments"));
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
	
	//获取指定ID的实体Bean
	public EmployerBean GetBean(int id,String Snoemployer){
		String sql ="";
		if(id==0){
			sql="select * from tb_Employer where Snoemployer='"+Snoemployer+"'";
		}else{
			sql="select * from tb_Employer where id="+id;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EmployerBean cnbean=new EmployerBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setId(rs.getInt("id"));
				cnbean.setSnoemployer(rs.getString("Snoemployer"));
				cnbean.setPassword(rs.getString("password"));
				cnbean.setEmail(rs.getString("Email"));
				cnbean.setTel(rs.getString("Tel"));
				cnbean.setName(rs.getString("Name"));
				cnbean.setGender(rs.getString("Gender"));
				cnbean.setJno(rs.getString("Jno"));
				cnbean.setFirm(rs.getString("Firm"));
				cnbean.setPosition(rs.getString("Position"));
				cnbean.setResponsibility(rs.getString("Responsibility"));
				cnbean.setIndustry(rs.getString("Industry"));
				cnbean.setComments(rs.getString("Comments"));
				
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
	
	//添加
	public void Add(EmployerBean cnbean){
		
		
		String sql="insert into tb_Employer (";
		sql+="Snoemployer,password,Email,Tel,Name,Gender,Jno,Firm,Position,Responsibility,Industry,Comments";
		sql+=") values(";
		sql+="'"+cnbean.getSnoemployer()+"','"+cnbean.getPassword()+"','"+cnbean.getEmail()+"','"+cnbean.getTel()+"','"+cnbean.getName()+"','"+cnbean.getGender()+"'"
				;
		sql+=",'"+cnbean.getJno()+"','"+cnbean.getFirm()+"','"+cnbean.getPosition()+"','"+cnbean.getResponsibility()+"','"+cnbean.getIndustry()+"','"+cnbean.getComments()+"')";
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
    
	public void Update(EmployerBean cnbean){
		String sql="update tb_Employer set ";
		sql+="Snoemployer='"+cnbean.getSnoemployer()+"',";
		sql+="password='"+cnbean.getPassword()+"',";
		sql+="Email='"+cnbean.getEmail()+"',";
		sql+="Tel='"+cnbean.getTel()+"',";
		sql+="Name='"+cnbean.getName()+"',";
		sql+="Gender='"+cnbean.getGender()+"',";
		sql+="Jno='"+cnbean.getJno()+"',";
		sql+="Firm='"+cnbean.getFirm()+"',";
		sql+="Position='"+cnbean.getPosition()+"',";
		sql+="Responsibility='"+cnbean.getResponsibility()+"',";
		sql+="Industry='"+cnbean.getIndustry()+"',";
		sql+="Comments='"+cnbean.getComments()+"'";
		
		sql+=" where id="+cnbean.getId()+" ";
		Statement stat = null;
		ResultSet rs = null;
		System.out.print(sql);
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
		String sql="delete  from tb_Employer where ";
		sql+=strwhere+"  ";
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

