package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService
{

	public static void main(String[] args) 
	{



	}
	
	
	public static MemberDaoImpl mdi=new MemberDaoImpl();

	@Override
	public Member Login(String username, String password) 
	{
		List<Member> l= mdi.selectMember(username,password);
		Member m=null;
		if(l.size()!=0) 
		{
			m=l.get(0);
		}
		return m;
	}

	@Override
	public boolean findByUsername(String username) 
	{
		List<Member> l= mdi.selectByUsername(username);
		boolean x=false;
		if(l.size()!=0)
		{
			x=true;
		}
		return x;
	}

	@Override
	public void addMember(Member m) {
		mdi.add(m);
		
	}

	@Override
	public void updateCash(Integer id,Integer cash) 
	{
		List<Member> l=mdi.selectByid(id);
		Member m=l.get(0);
		m.setCash(cash);
		mdi.update(m);
	}

	@Override
	public void udateMember(Integer id, String name, String username, String password) 
	{
		List<Member> l=mdi.selectByid(id);
		Member m=l.get(0);
		m.setName(name);
		m.setUsername(username);
		m.setPassword(password);
		mdi.update(m);
	}

	@Override
	public Member findId(Integer id) {
		List<Member> l= mdi.selectByid(id);
		Member m=null;
		if(l.size()!=0) 
		{
			m=l.get(0);
		}
		return m;
	}
}
