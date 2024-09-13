package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.login.AddMemberUI;

public class Cal 
{
	private int total;
	private int pay;
	private static int change;
	private int membercash;
	//切換到註冊
	public static void gotoAddMemberUI()
	{
		AddMemberUI a =new AddMemberUI();
		a.setVisible(true);
	}
	
	//存檔
	public static void SaveObject(Object o,String filename)
	{
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(o);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	//讀取
	public static Object ReadObject(String filename) 
	{
		Object o=null;
		try 
		{
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;	
	}

	
	//現金付款
	public static Integer CashPay (Integer total,Integer pay)
	{
		change=(Integer)(pay-total);
		return change;
	}
	//會員付款
	public static  Integer MemberPay (Integer total,Integer membercash)
	{
		total=(int)total;
		membercash=(int)(membercash-total);	
		return membercash;
	} 
	
	//現金交易成功
	public static String Cashpayshow(Integer total,Integer pay,Integer change) 
	{
		return ("【交易成功】"+
				"\n商品金額"+"\t"+total+"元"+
				"\n交易金額"+"\t"+pay+"元"+
				"\n找零"+"\t"+change+"元"+
				"\n祝您觀影愉快ヽ(∀ﾟ )人(ﾟ∀ﾟ)人( ﾟ∀)人(∀ﾟ )"
				);
				}
	
	//會員交易成功
	public static String Memberpayshow(Integer total,Integer membercashbefore,Integer membercashafter) 
	{
		return ("【交易成功】"+
				"\n商品金額"+"\t"+total+"元"+				
				"\n扣款前會員金"+"\t"+membercashbefore+"元"+
				"\n當前會員金"+"\t"+membercashafter+"元"+
				"\n祝您觀影愉快ヽ(∀ﾟ )人(ﾟ∀ﾟ)人( ﾟ∀)人(∀ﾟ )"
				);}
	

}
