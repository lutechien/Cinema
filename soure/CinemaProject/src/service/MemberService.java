package service;

import model.Member;

public interface MemberService 
{
	//查詢(登入)
	Member Login(String username,String password);
	
	//查詢(尋找帳號)
	boolean findByUsername(String username);
	
	//查詢(找id)
	Member findId(Integer id);
	
	//新增
	void addMember(Member m);
	
	//更新(儲值)
	void updateCash(Integer id,Integer cash);
	
	//更新(改會員資料)
	void udateMember(Integer id,String name,String username,String password );

}
