package com.sist.dao;
import java.sql.*;
import java.util.*;
public class MyDAO {
   // 연결 객체 
	private Connection conn;
   // SQL 전송 객체
	private PreparedStatement ps;
   // URL(오라클 주소)
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 드라이버 등록 
	public MyDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	// 연결 
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			// 오라클 ==> conn hr/happy
		}catch(Exception ex) {}
	}
	// 해제
	public void disConnection()
	{
		//exit
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	// JDBC (원시소스) => DBCP => ORM (MyBatis,Hibernate,JPA)
	// 기능 
	public String isLogin(String ename,int empno)
	{
		String result="";
		try
		{
			getConnection();
			// SQL문장 전송 
			String sql="SELECT COUNT(*) FROM emp "
					  +"WHERE ename=?";
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			ps.setString(1, ename);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);// 0,1
			rs.close();
			if(count==0)// 사원이름 존재하지 않는다 
			{
				result="NONAME";
			}
			else // 사원이름이 존재 
			{
				sql="SELECT empno FROM emp "
				   +"WHERE ename=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, ename);
				rs=ps.executeQuery();
				rs.next();// 데이터 있는 위치에 커서를 변경
				int db_empno=rs.getInt(1);
				rs.close();
				
				if(empno==db_empno) // 로그인
				{
					result=ename;
				}
				else  // 사번이 틀린상태
				{
					result="NOSABUN";
				}
				
			}
		}catch(Exception ex)
		{
			// 에러 처리
			System.out.println(ex.getMessage());
		}
		finally
		{
			// 닫기
			disConnection();
		}
		return result;
	}
	
}






