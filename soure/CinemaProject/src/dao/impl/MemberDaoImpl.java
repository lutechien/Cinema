package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		// 測試看下面語法功能有沒有對
		//create
		/*
		Member m=new Member("m003","小章魚","qqq","888");
		new MemberDaoImpl().add(m);
		*/
		
		
		//Select
		//List<Member> l=new MemberDaoImpl().selectAll();
		//List<Member> l=new MemberDaoImpl().selectByid(4);
		//List<Member> l=new MemberDaoImpl().selectMember("aaa", "111");
		/*
		List<Member> l=new MemberDaoImpl().selectByUsername("qqq");
		for (Member m:l)
		{
			System.out.println(m.getId()+"\t"+m.getName());
		}
		*/
		
		//update
		List<Member> l=new MemberDaoImpl().selectByid(4);
		Member m=l.get(0); //只會有一個
		m.setName("貓貓章魚");
		new MemberDaoImpl().update(m);
		
		
		//delete
		//new MemberDaoImpl().delete(1);
	
	}

	
	
	@Override
	public void add(Member m1) 
	{
		Connection conn =DbConnection.getDb();
		String SQL="insert into member(memberno,name,username,password,cash)"
				+"values(?,?,?,?,?)";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m1.getMemberno());
			ps.setString(2, m1.getName());
			ps.setString(3, m1.getUsername());
			ps.setString(4, m1.getPassword());
			ps.setInt(5, 0);
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}

	@Override
	public List<Member> selectAll() 
	{
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<Member> l =new ArrayList();
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs =ps.executeQuery();
		
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setCash(rs.getInt("cash"));			
				l.add(m);
			}
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return l;
	}


	
	@Override
	public List<Member> selectByid(int id) 
	{
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where id=?";
		List<Member> l =new ArrayList();	
		try
		{
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setCash(rs.getInt("cash"));			
				l.add(m);
			}
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		return l;
	}
	
	

	@Override
	public List<Member> selectMember(String username, String password) 
	{
		Connection conn =DbConnection.getDb();
		String SQL="select * from member where username=? and password=?";
		List<Member> l=new ArrayList();		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setCash(rs.getInt("cash"));			
				l.add(m);
			}			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		Connection conn =DbConnection.getDb();
		String SQL="select * from member where username=?";
		List<Member> l=new ArrayList();		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);			
			ResultSet rs=ps.executeQuery();			
			if(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setCash(rs.getInt("cash"));			
				l.add(m);
			}			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Member m) 
	{
		Connection conn =DbConnection.getDb();
		String SQL="update member set name=?,username=?,password=?,cash=? where id=?";	
		try 
		{
			PreparedStatement ps =conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setInt(4,m.getCash());
			ps.setInt(5,m.getId());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{				
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) 
	{
		Connection conn=DbConnection.getDb();
		String SQL="delete from member where id=?";
		try 
		{
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
