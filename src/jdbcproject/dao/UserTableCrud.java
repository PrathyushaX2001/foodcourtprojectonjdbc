package jdbcproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbcproject.dto.UserTable;

public class UserTableCrud {

      public void register(UserTable u) {
    	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprojec?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("insert into usertable values(?,?,?,?,?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPassword());
			ps.setInt(4,u.getWallet());
			ps.setString(5,u.getGender());
			ps.setInt(6,u.getAge());
			ps.setInt(7,u.getPhno());
			ps.execute();
			ps.close();
			con.close();
		 } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
      }
     public boolean login(UserTable u) {
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprojec?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("select * from usertable where password=?");
			ps.setString(1, u.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String email=(rs.getString(2));
			    String pass=(rs.getString(3));
			    if((email.equals(u.getEmail()))&&(pass.equals(u.getPassword()))) {
			      return true;
			     }else {
			    	System.out.println("Sorry.....!\n The Email or PassWord You Entered is wrong \nTry Enter the Correct Email or Password");
			    }
			 }
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		  return false;
	  }
	public void fetch() {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprojec?user=root&password=root");
	    	PreparedStatement ps1=con1.prepareStatement("select * from foodtable");
	    	ResultSet rs1=ps1.executeQuery();
	    	while(rs1.next()) {
	    		System.out.println("Item no :     "+rs1.getInt(1));
	    		System.out.println("Item Name :   "+rs1.getString(2));
	    		System.out.println("Quantity :    "+rs1.getInt(3));
	    		System.out.println("Price :       "+rs1.getInt(4));
	    		System.out.println();
	    	}
	    	ps1.close();
	    	con1.close();
	    } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	  }
	 int sum=0;
	 public void choose(int i,int quantity){
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprojec?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("select * from foodtable where slno=?");
			ps.setInt(1,i);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int m=rs.getInt(4);
				String item=rs.getString(2);
				int q=rs.getInt(3);
				System.out.println("The Item you choosed is  :"+item);
				System.out.println("The Quentity You get     :"+quantity);
				if(quantity>q) {
				   System.out.println("The Price of the items You Choosed is:"+(m*quantity));
				}else {
					System.out.println("The Price of the items You Choosed is:"+(m));
				}
				if(quantity<q) {
				  sum+=(m/2);
				}else if(quantity>q) {
					sum+=(m*quantity);
				}else if(quantity==q) {
					sum+=m;
				}
			}
			    
			    ps.close();
			    con.close();
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	 }
	 int wallet=0;
	 public int choose1(String email,String pass,int amount) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprojec?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("select * from usertable where (email=?) AND (password=?)");
			ps.setString(1,email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 wallet=(rs.getInt(4));
			}
			ps.close();
			con.close();
		   }
		  catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		   }
	      return wallet; 
	 }
       public int bill() {
    	int n=wallet-sum;
    	  if(wallet<sum) {
			System.out.println(".....>Amount In Your Wallet Is Not Wnough To Buy These Items\n.....>Kindly Add The Amount If You Want to Buy");
			System.out.println(".....>The Amonut You Need To Enter :"+(sum-wallet));
		}else {
	       System.out.println("The Amount Debeted From Wallet For Food Is:"+sum+"\n Remaining Amount In Your Wallet Is:"+n);
		}
    	return n;
     }
     public void totalAmount(String email,int total) {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprojec?user=root&password=root");
			PreparedStatement ps1=con1.prepareStatement("UPDATE `jdbcprojec`.`usertable` SET `wallet` = ? WHERE (`email` = ?);");
			ps1.setInt(1, total);
			ps1.setString(2, email);
	        ps1.execute();
	        ps1.close();
	        con1.close();
	        
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
			
	   }
     public int upDateAmount(int amount) {
    	 int r=amount+wallet;
    	 return r;
     }
}




















