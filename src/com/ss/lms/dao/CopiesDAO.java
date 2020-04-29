package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookCopies;
import com.ss.lms.entity.LibraryBranch;

public class CopiesDAO {
	
	public Connection conn = null;

	public CopiesDAO(Connection conn) {
		this.conn = conn;
	}

	public List<BookCopies> readAllBooksByBranch(LibraryBranch b) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement("select b.bookId, title, group_concat(authorName separator', ') as authors, noOfCopies from tbl_book b join tbl_book_authors ba on b.bookId = ba.bookId join tbl_author a on a.authorId = ba.authorId join tbl_book_copies c on b.bookId = c.bookId join tbl_library_branch l on l.branchId = c.branchId where l.branchId = ? group by bookId");		
		pstmt.setObject(1, b.getBranchId());
		List<BookCopies> copies = new ArrayList<>();
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setTitle(rs.getString("title"));
			book.setAuthorsString(rs.getString("authors"));
			BookCopies copy = new BookCopies();
			copy.setBook(book);
			copy.setBranch(b);
			copy.setNoOfCopies(rs.getInt("noOfCopies"));
			copies.add(copy);
		}			
		return copies;
	}
	
	public void updateNoCopies(BookCopies c) throws SQLException {
		String sql = "UPDATE tbl_book_copies SET noOfCopies = ? WHERE branchId = ? AND bookId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setObject(1, c.getNoOfCopies());
		pstmt.setObject(2, c.getBranch().getBranchId());
		pstmt.setObject(3, c.getBook().getBookId());		
		pstmt.executeUpdate();		
	}

}
