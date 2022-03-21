package com.dao;

import com.db.DBHelper;
import com.bean.InternshipBean;

import java.util.*;
import java.sql.*;

public class InternshipDao {
	
	//获取列表
	public List<InternshipBean> GetList(String strwhere,String strorder){
		String sql="select * from tb_Internship where 1=1";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<InternshipBean> list=new ArrayList<InternshipBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				InternshipBean cnbean=new InternshipBean();
				cnbean.setId(rs.getInt("id"));
				cnbean.setIno(rs.getString("Ino"));
				cnbean.setIfirm(rs.getString("Ifirm"));
				cnbean.setIindustry(rs.getString("Iindustry"));
				cnbean.setIdpt(rs.getString("Idpt"));
				cnbean.setIpst(rs.getString("Ipst"));
				cnbean.setIlocation(rs.getString("Ilocation"));
				cnbean.setIrqmt(rs.getString("Irqmt"));
				cnbean.setIhours(rs.getString("Ihours"));
				cnbean.setIbonus(rs.getString("Ibonus"));
				cnbean.setPostTime(rs.getString("PostTime"));
				cnbean.setSnoemployer(rs.getString("Snoemployer"));
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
	public InternshipBean GetBean(String Ino){
		String sql="select * from tb_Internship where Ino='"+Ino + "'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		InternshipBean cnbean=new InternshipBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setId(rs.getInt("id"));
				cnbean.setIno(rs.getString("Ino"));
				cnbean.setIfirm(rs.getString("Ifirm"));
				cnbean.setIindustry(rs.getString("Iindustry"));
				cnbean.setIdpt(rs.getString("Idpt"));
				cnbean.setIpst(rs.getString("Ipst"));
				cnbean.setIlocation(rs.getString("Ilocation"));
				cnbean.setIrqmt(rs.getString("Irqmt"));
				cnbean.setIhours(rs.getString("Ihours"));
				cnbean.setIbonus(rs.getString("Ibonus"));
				cnbean.setPostTime(rs.getString("PostTime"));
				cnbean.setSnoemployer(rs.getString("Snoemployer"));
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
	public void Add(InternshipBean cnbean){
		String sql="insert into tb_Internship (";
		sql+="Ino,Ifirm,Iindustry,Idpt,Ipst,Ilocation,Irqmt,Ihours,Ibonus,PostTime,Snoemployer";
		sql+=") values(";
		sql+="'"+cnbean.getIno()+"','"+cnbean.getIfirm()+"','"+cnbean.getIindustry()+"','"+cnbean.getIdpt()+"','"+cnbean.getIpst()+"'"
				+ ",'"+cnbean.getIlocation()+"','"+cnbean.getIrqmt()+"','"+cnbean.getIhours()+"','"+cnbean.getIbonus()+"','"+cnbean.getPostTime()+"','"+cnbean.getSnoemployer()+"'";
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
	public void Update(InternshipBean cnbean){
		String sql="update tb_Internship set ";
		sql+="Ino='"+cnbean.getIno()+"',";
		sql+="Ifirm='"+cnbean.getIfirm()+"',";
		sql+="Iindustry='"+cnbean.getIindustry()+"',";
		sql+="Idpt='"+cnbean.getIdpt()+"',";
		sql+="Ipst='"+cnbean.getIpst()+"',";
		sql+="Ilocation='"+cnbean.getIlocation()+"',";
		sql+="Irqmt='"+cnbean.getIrqmt()+"',";
		sql+="Ihours='"+cnbean.getIhours()+"',";
		sql+="Ibonus='"+cnbean.getIbonus()+"',";
		sql+="PostTime='"+cnbean.getPostTime()+"'";
		
		sql+=" where id='"+cnbean.getId()+"'";
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
		String sql="delete from tb_Internship where ";
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

