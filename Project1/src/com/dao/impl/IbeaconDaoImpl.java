package com.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Ibeacon;
import com.uilts.Util;

public class IbeaconDaoImpl {

	

	public String checkIbeaconStatus(String ibeaconId) throws SQLException {
		
		System.out.println("ibeaconId = "+ibeaconId);
		StringBuffer sql = new StringBuffer();
		sql.append("select status from t_drp_ibeacon_status   ");
		sql.append(" where ibeacon_id = '"+ibeaconId+"'  ");
		Statement ps = null;
		Connection conn = Util.getConn();
		try{
			ps = conn.createStatement();
			ResultSet result = ps.executeQuery(sql.toString());
			String ibeaconStatus = "";
			while(result.next()){
				System.out.println("ibeaconStatus="+ibeaconStatus);
				ibeaconStatus = result.getString("status");
			}
			System.out.println("ibeaconStatus="+ibeaconStatus);
			return ibeaconStatus;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		
		
		
		
		
		return "ERROR";
		
		
	}

	public boolean updateIbeaconStatus(String ibeaconId,String oldStatus,String newStatus) throws SQLException {
		
		StringBuffer sql = new StringBuffer();
		sql.append("update t_drp_ibeacon_status  set status='"+newStatus+"' where    ibeacon_id ='"+ibeaconId+"'   and  status='"+oldStatus+"'  ");
		System.out.println(sql.toString());
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
			
			//TODO 異常 暫時不理會
			System.out.println(sql.toString());
			System.out.println("ibeacon_id="+ibeaconId);
			ps = conn.prepareStatement(sql.toString());
			
			
			
			ps.executeUpdate(sql.toString());
			ps.executeBatch();
			return true;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		return true;
	}

	public void insertIbeaconLog(String ibeaconId, BigDecimal drip, int timeClock, BigDecimal rssi, String ip) throws SQLException {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into t_drp_ibeacon_log (ibeacon_id,speed,drip,time_clock,insert_time,rssi_ip,rssi) ");
		sql.append(" values(?,?,?,?,?,?,?)");
		
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
			System.out.println(sql.toString());
			System.out.println("ibeacon_id="+ibeaconId);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, ibeaconId);
//			ps.setBigDecimal(2, speed);
			ps.setBigDecimal(3, drip);
			ps.setInt(4,timeClock);
			ps.setDate(5, new Date(new java.util.Date().getTime()));
			ps.setString(6,ip);
			ps.setBigDecimal(7, rssi);
					
			ps.executeBatch();
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
