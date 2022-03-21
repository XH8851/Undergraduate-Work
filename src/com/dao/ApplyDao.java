package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.ApplyBean;
import com.bean.EmployeeBean;
import com.db.DBHelper;

public class ApplyDao {
	
	//验证登录
	public String CheckApply(String Snoemployee, String ino){
		String id = null;
		String sql="select * from tb_apply where Snoemployee='"+Snoemployee+"' and ino='"+ino+"' ";
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
	public List<ApplyBean> GetAllList(String strwhere,String strorder){
		String sql="select distinct ta.* from tb_apply ta,tb_internship ti ";
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
		List<ApplyBean> list=new ArrayList<ApplyBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ApplyBean cnbean=new ApplyBean();
				cnbean.setId(rs.getInt("id"));
				cnbean.setIno(rs.getString("Ino"));
				cnbean.setSnoemployee(rs.getString("Snoemployee"));
				cnbean.setAppStatus(rs.getString("AppStatus").trim());
				cnbean.setAppTime(rs.getString("AppTime"));
				cnbean.setAppReport(rs.getString("AppReport"));
				cnbean.setAppReportFb(rs.getString("AppReportFb"));
				
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
	
	
	//获取所有列表
		public List<ApplyBean> GetErList(String Snoemployer){
			String sql="select te.* from tb_evaluation te,tb_internship ti where te.Ino = ti.Ino and Snoemployer='"+Snoemployer+"'";
//			System.out.println(sql);
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			List<ApplyBean> list=new ArrayList<ApplyBean>();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					ApplyBean cnbean=new ApplyBean();
					cnbean.setInternRate(rs.getString("InternRate"));
					
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
	
	
	
	//获取所有列表
		public List<ApplyBean> GetEeList(String Snoemployee){
			String sql="select * from tb_evaluation  where Snoemployee='"+Snoemployee+"'";
			
//			System.out.println(sql);
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			List<ApplyBean> list=new ArrayList<ApplyBean>();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					ApplyBean cnbean=new ApplyBean();
					cnbean.setEmployeeRate(rs.getString("EmployeeRate"));
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
	public EmployeeBean GetAllBean(int id){
		String sql="select * from tb_employee where id="+id;
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
		public ApplyBean GetAppStatusBean(int id){
			String sql="select * from tb_apply where id="+id;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			ApplyBean cnbean=new ApplyBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					cnbean.setId(rs.getInt("id"));
					cnbean.setAppStatus(rs.getString("AppStatus"));
					cnbean.setIno(rs.getString("Ino"));
					cnbean.setSnoemployee(rs.getString("Snoemployee"));
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
				public ApplyBean GetAppReportBean(int id){
					String sql="select * from tb_apply where id="+id;
					Statement stat = null;
					ResultSet rs = null;
					Connection conn = new DBHelper().getConn();
					ApplyBean cnbean=new ApplyBean();
					try{
						stat = conn.createStatement();
						rs = stat.executeQuery(sql);
						while(rs.next()){
							cnbean.setId(rs.getInt("id"));
							cnbean.setAppReport(rs.getString("AppReport"));
							cnbean.setIno(rs.getString("Ino"));
							cnbean.setSnoemployee(rs.getString("Snoemployee"));
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
				public ApplyBean GetAppReportFbBean(int id){
					String sql="select * from tb_apply where id="+id;
					Statement stat = null;
					ResultSet rs = null;
					Connection conn = new DBHelper().getConn();
					ApplyBean cnbean=new ApplyBean();
					try{
						stat = conn.createStatement();
						rs = stat.executeQuery(sql);
						while(rs.next()){
							cnbean.setId(rs.getInt("id"));
							cnbean.setAppReportFb(rs.getString("AppReportFb"));
							cnbean.setIno(rs.getString("Ino"));
							cnbean.setSnoemployee(rs.getString("Snoemployee"));
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
		public ApplyBean GetEmployeeRateBean(String Ino,String Snoemployee){
			String sql="select * from tb_Evaluation where Ino='"+Ino+"' and Snoemployee='"+Snoemployee+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			ApplyBean cnbean=new ApplyBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					cnbean.setId(rs.getInt("id"));
					cnbean.setEmployeeRate(rs.getString("EmployeeRate"));
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
				public ApplyBean GetInternRateBean(String Ino,String Snoemployee){
					String sql="select * from tb_Evaluation where Ino='"+Ino+"' and Snoemployee='"+Snoemployee+"'";
					Statement stat = null;
					ResultSet rs = null;
					Connection conn = new DBHelper().getConn();
					ApplyBean cnbean=new ApplyBean();
					try{
						stat = conn.createStatement();
						rs = stat.executeQuery(sql);
						while(rs.next()){
							cnbean.setId(rs.getInt("id"));
							cnbean.setInternRate(rs.getString("InternRate"));
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
	public void Add(ApplyBean cnbean){
		String sql="insert into tb_apply (";
		sql+="Ino,Snoemployee,AppStatus,AppTime";
		sql+=") values(";
		sql+="'"+cnbean.getIno()+"','"+cnbean.getSnoemployee()+"','"+cnbean.getAppStatus()+"','"+cnbean.getAppTime()+"'";
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
	
	
	public void AddEvaluation(String Ino,String Snoemployee){
		String sql="insert into tb_evaluation (";
		sql+="Ino,Snoemployee";
		sql+=") values(";
		sql+="'"+Ino+"','"+Snoemployee+"'";
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
	
	
	//修改
		public void UpdateAppStatus(ApplyBean cnbean){
			String sql="update tb_apply set ";
			sql+="AppStatus='"+cnbean.getAppStatus()+"'";
			
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
		
		//修改
				public void UpdateReport(ApplyBean cnbean){
					String sql="update tb_apply set ";
					sql+="AppReport='"+cnbean.getAppReport()+"'";
					
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
				
				//修改
				public void UpdateReportFb(ApplyBean cnbean){
					String sql="update tb_apply set ";
					sql+="AppReportFb='"+cnbean.getAppReportFb()+"'";
					
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
		
		
		//修改
				public void UpdateEmployeeRate(ApplyBean cnbean){
					String sql="update tb_Evaluation set ";
					sql+="EmployeeRate='"+cnbean.getEmployeeRate()+"'";
					
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
				
				
				//修改
				public void UpdateInternRate(ApplyBean cnbean){
					String sql="update tb_Evaluation set ";
					sql+="InternRate='"+cnbean.getInternRate()+"'";
					
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
		String sql="delete from tb_apply where ";
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

