package com.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.model.IbeaconLog;
import com.model.PatientSub;
import com.uilts.Log;
import com.uilts.Util;

public class IbeaconDaoImpl {

	

	public String checkIbeaconStatus(String ibeaconId) throws SQLException {
		
		Log.info(getClass().getSimpleName(), "ibeaconId = "+ibeaconId);
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
		Log.info(getClass().getSimpleName(), sql.toString());
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
			
			//TODO 異常 暫時不理會
			Log.info(getClass().getSimpleName(), "ibeacon_id="+ibeaconId);
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

	public void insertIbeaconLog(String ibeaconId, BigDecimal drip, int timeClock,BigDecimal speed, BigDecimal rssi, String ip) throws SQLException {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into t_drp_ibeacon_log (ibeacon_id,speed,drip,time_clock,insert_time,rssi_ip,rssi,history_flag) ");
		sql.append(" values(?,?,?,?,?,?,?,?)");
		
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
			
			Log.info(getClass().getSimpleName(), sql.toString());
			Log.info(getClass().getSimpleName(), "ibeacon_id="+ibeaconId);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, ibeaconId);
			ps.setBigDecimal(2, speed);
			ps.setBigDecimal(3, drip);
			ps.setInt(4,timeClock);
			ps.setTimestamp(5, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime())); 
			ps.setString(6,ip);
			ps.setBigDecimal(7, rssi);
			ps.setInt(8, 0);
			ps.addBatch();
			ps.executeBatch();
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		
		
	}

	
	public IbeaconLog loadIbeaconLog(String ibeaconId, BigDecimal drip, int timeClock, int historyFlag,String logTime) throws SQLException {
		//history_flag = 0
		
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from t_drp_ibeacon_log  ");
		sql.append(" where  ibeacon_id = ?  ");
		if(logTime.equals("PRE")){
			sql.append(" and drip < ?   ");
			sql.append(" and time_clock < ?  ");
		}else if(logTime.equals("SAME")){
			sql.append(" and drip = ?   ");
			sql.append(" and time_clock = ?  ");
		}
		sql.append(" and history_flag = ?   ");
		sql.append(" order by id desc");
		
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
			Log.info(getClass().getSimpleName(), sql.toString());
			Log.info(getClass().getSimpleName(), "ibeacon_id="+ibeaconId);
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, ibeaconId);
			ps.setBigDecimal(2, drip);
			ps.setInt(3,timeClock);
			ps.setInt(4, historyFlag);
			ResultSet result = ps.executeQuery();
			IbeaconLog model = null;
			
			while(result.next()){
				model = new IbeaconLog();
				model.setId(result.getInt("id"));
				model.setIbeaconId(result.getString("ibeacon_id"));
				model.setSpeed(result.getBigDecimal("speed"));
				model.setDrip(result.getBigDecimal("drip"));
				model.setTimeClock(result.getInt("time_clock"));
				model.setInsertTime(result.getDate("insert_time"));
				model.setRssiIp(result.getString("rssi_ip"));
				model.setRssi(result.getBigDecimal("rssi"));
				model.setHistoryFlag(result.getInt("history_flag"));
				break;
			}
			return model;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
