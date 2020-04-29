package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.entity.Book;
import com.ss.lms.entity.BookCopies;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.LibraryBranch;

public class BookLoansDAO {

	public Connection conn = null;

	public BookLoansDAO(Connection conn) {
		this.conn = conn;
	}

	public List<BookCopies> readAvailibleBooksByBranch(LibraryBranch b) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(
				"select b.bookId, title, group_concat(authorName separator', ') as authors, noOfCopies from tbl_book b join tbl_book_authors ba on b.bookId = ba.bookId join tbl_author a on a.authorId = ba.authorId join tbl_book_copies c on b.bookId = c.bookId join tbl_library_branch l on l.branchId = c.branchId where l.branchId = ? and noOfCopies > 0 group by bookId");
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
	
	public List<Book> booksBorrowed(LibraryBranch b, Borrower br) throws SQLException{
		List<Book> borrowedBooks = new ArrayList<Book>();
		PreparedStatement pstmt = conn.prepareStatement(
				"select b.bookId, b.title, dateOut, dueDate from tbl_book b join tbl_book_loans bl on b.bookId = bl.bookId join tbl_borrower br on br.cardNo = bl.cardNo where bl.cardNo = ? and bl.branchId = ? and bl.dateIn is null");
		pstmt.setObject(1, br.getCardNo());
		pstmt.setObject(2, b.getBranchId());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setTitle(rs.getString("title"));
			borrowedBooks.add(book);
		}
		return borrowedBooks;
	}

	public void borrowBook(LibraryBranch lb, Borrower br, Book bk, LocalDateTime out, LocalDateTime due) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(
				"Insert into tbl_book_loans (BookId, branchId, CardNo, dateOut, dueDate) values (?,?,?,?,?)");
		
		pstmt.setObject(1, bk.getBookId());
		pstmt.setObject(2, lb.getBranchId());
		pstmt.setObject(3, br.getCardNo());
		pstmt.setObject(4, Timestamp.valueOf(out));
		pstmt.setObject(5, Timestamp.valueOf(due));
		
		pstmt.executeUpdate();

		
	}
	
	public void returnBook(LibraryBranch lb, Borrower br, Book bk, LocalDateTime in) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(
				"update tbl_book_loans set dateIn = ? where bookId = ? and branchId = ? and cardNo = ?");
		
		pstmt.setObject(1, Timestamp.valueOf(in));
		pstmt.setObject(2, bk.getBookId());
		pstmt.setObject(3, lb.getBranchId());
		pstmt.setObject(4, br.getCardNo());
		
		pstmt.executeUpdate();

		
	}
	
	public void reduceCopies(LibraryBranch lb, Book bk) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(
				"update tbl_book_copies set noOfCopies = noOfCopies -1 where bookId = ? and branchId = ?");
		
		pstmt.setObject(1, bk.getBookId());
		pstmt.setObject(2, lb.getBranchId());
		pstmt.executeUpdate();

		
	}
	
	public void addCopies(LibraryBranch lb, Book bk) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(
				"update tbl_book_copies set noOfCopies = noOfCopies +1 where bookId = ? and branchId = ?");
		
		pstmt.setObject(1, bk.getBookId());
		pstmt.setObject(2, lb.getBranchId());
		pstmt.executeUpdate();

		
	}

}
