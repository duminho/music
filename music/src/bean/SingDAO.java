package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SingDAO {
	
	String url="jdbc:mysql://localhost:3306/singer";
	String user="root";
	String password="1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList selectAll() {
		
		ArrayList list = new ArrayList();
		SingDTO dto=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 완료");
			
			String sql ="select * from sing";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new SingDTO();
				String name = rs.getString(1);
				String title = rs.getString(2);
				String genre = rs.getString(3);
				
				dto.setName(name);
				dto.setTitle(title);
				dto.setGenre(genre);
				
				list.add(dto);
			}
		} catch (Exception e) {
			
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				System.out.println("자원 해제중 에러 발생!!");
			}
		}
		
		return list;
	}
	
	public SingDTO select(String inputId) {
		SingDTO dto=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.드라이버 설정 완료");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 완료");
			
			String sql ="select * from sing where name =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			System.out.println("3.SQL문 객체화 완료");
			
			rs = ps.executeQuery();
			System.out.println("4.SQL문 전송 완료");
			
			if(rs.next()) {
				dto = new SingDTO();
				String name = rs.getString(1);
				String title = rs.getString(2);
				String genre = rs.getString(3);
				
				dto.setName(name);
				dto.setTitle(title);
				dto.setGenre(genre);
			}else {
				System.out.println("검색 결과가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("DB처리 중 에러발생...");
			System.out.println(e.getMessage());
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				System.out.println("자원 해제중 에러 발생!!");
			}
		}
		return dto;
	}
	public SingDTO select2(String inputt) {
		SingDTO dto=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.드라이버 설정 완료");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 완료");
			
			String sql ="select * from sing where title =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputt);
			System.out.println("3.SQL문 객체화 완료");
			
			rs = ps.executeQuery();
			System.out.println("4.SQL문 전송 완료");
			
			if(rs.next()) {
				dto = new SingDTO();
				String name = rs.getString(1);
				String title = rs.getString(2);
				String genre = rs.getString(3);
				
				dto.setName(name);
				dto.setTitle(title);
				dto.setGenre(genre);
			}else {
				System.out.println("검색 결과가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("DB처리 중 에러발생...");
			System.out.println(e.getMessage());
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				System.out.println("자원 해제중 에러 발생!!");
			}
		}
		return dto;
	}
	public SingDTO select3(String inputg) {
		SingDTO dto=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.드라이버 설정 완료");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 완료");
			
			String sql ="select * from sing where genre =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputg);
			System.out.println("3.SQL문 객체화 완료");
			
			rs = ps.executeQuery();
			System.out.println("4.SQL문 전송 완료");
			
			if(rs.next()) {
				dto = new SingDTO();
				String name = rs.getString(1);
				String title = rs.getString(2);
				String genre = rs.getString(3);
				
				dto.setName(name);
				dto.setTitle(title);
				dto.setGenre(genre);
			}else {
				System.out.println("검색 결과가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("DB처리 중 에러발생...");
			System.out.println(e.getMessage());
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				System.out.println("자원 해제중 에러 발생!!");
			}
		}
		return dto;
	}
}
