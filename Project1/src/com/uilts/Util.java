package com.uilts;

import java.sql.Connection;

public class Util {

	public static Connection getConn(){
		return new Jdbc().getConn();
	}
	
}
