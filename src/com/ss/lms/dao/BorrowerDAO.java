package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ss.lms.entity.Borrower;

public class BorrowerDAO {
	
	public Connection conn = null;

	public BorrowerDAO(Connection conn) {
		this.conn = conn;
	}
	
	public Borrower getBorrowerByCardNo(Integer userCardNo) throws SQLException {
		
		String sql = "select * from tbl_borrower where cardNo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, userCardNo);
		ResultSet rs = pstmt.executeQuery();
		Borrower borrower = new Borrower();
		while(rs.next()) {			
			borrower.setCardNo(rs.getInt("cardNo"));
			borrower.setName(rs.getString("name"));
			borrower.setAddress(rs.getString("address"));
			borrower.setPhone(rs.getString("phone"));			
		}		
		return borrower;		
	}	

}
