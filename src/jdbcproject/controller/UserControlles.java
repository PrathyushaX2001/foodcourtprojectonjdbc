package jdbcproject.controller;

import jdbcproject.dao.UserTableCrud;
import java.util.Scanner;
import jdbcproject.dto.UserTable;

public class UserControlles {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		UserTableCrud uc=new UserTableCrud();
		boolean check=true;
        do {
        	 System.out.println("Enter your choice \n 1.Register \n 2.Login");
        	 int n=sc.nextInt();
        	 switch(n) {
        	 	case 1:{
        	 		       System.out.println("Enter your Name:");
        	 		       String name=sc.next();                             
        	 		       System.out.println("Enter your Email:");
        	 		       String email=sc.next();
        	 		       System.out.println("Enter the Password:");
        	 		       String password=sc.next();
        	 		       System.out.println("Enter the amount in your Wallet:");
        	 		       int wallet=sc.nextInt();
        	 		       System.out.println("Enter the Gender:");
        	 		       String gender=sc.next();
        	 		       System.out.println("Enter the Age:");
        	 		       int age=sc.nextInt();
        	 		       System.out.println("Enter your MobileNumber:");
        	 		       int phno=sc.nextInt();
        	 		       UserTable u=new UserTable(name,email,password,wallet,gender,age,phno);
        	 		       uc.register(u);
        	 	}break;
        	 	case 2:{
        	 		       System.out.println("Enter Your Email:");
        	 		       String email=sc.next();
        	 		       System.out.println("Enter the Password:");
        	 		       String password=sc.next();
        	 		       UserTable u=new UserTable();
        	 		       u.setEmail(email);
        	 		       u.setPassword(password);
        	 		       if(uc.login(u)){
        	 		        uc.fetch();
        	 	           boolean c1=true;
        	 		       do {
        	 		    	  System.out.println("Choose the option: \n 1.Press here to Choose the items\n 2.Add Amount \n 3.Please Exit");
        	 		    	  int a=sc.nextInt();
        	 		    	  switch(a) {
        	 		    	     case 1:{
        	 		    	    	  
        	 		    	    	  boolean b1=true;
        	 		    	    	  do {
        	 		    	    		 System.out.println("1.Hello I am Your Cook tell me Which Item You Want:\n2.Exit");
           	 		    	    	     int n1=sc.nextInt();
        	 		    	    		   switch(n1) {
        	 		    	    		      case 1:{
        	 		    	    		    	 System.out.println("Enter The Item Number From Menu:");
               	 		    	    		     int num=sc.nextInt();
               	 		    	    		     System.out.println("Enter the quantity:");
               	 		    	    		     int q=sc.nextInt();
               	 		    	    		     uc.choose(num,q);
               	 		    	    		     break;
        	 		    	    		      }
        	 		    	    		      case 2:{
        	 		    	    		    	 UserTable ut=new UserTable();
                	 		    	    		 int wallet=ut.getWallet();
                	 		    	    		 uc.choose1(email,password,wallet);
                	 		    	    		 int amount=uc.bill();
                	 		    	    		 uc.totalAmount(email,amount);
                	 		    	    	     b1=false;
                	 		    	    		 break;
        	 		    	    		      }
        	 		    	    		   }
        	 		    	         }while(b1);
        	 		    	     }break;	  
        	 		    	     case 2:{
        	 		    	    	 System.out.println("Enter the Amount :");
        	 		    	    	 int amount=sc.nextInt();
        	 		    	    	 int total=uc.upDateAmount(amount);
        	 		    	    	 uc.totalAmount(email,total);
        	 		    	    	 System.out.println("updated......");
        	 		    	      }break;
        	 		    	     case 3:{
        	 		    	    	 System.out.println("Thanks For Comming..............🤗🤗🤗🤗");
        	 		    	    	 c1=false;
        	 		    	    	 check=false;
        	 		    	     }break;
        	 		    	  }
        	 		          }while(c1);
        	 		       }
        	 		       
       	 		       }break;
        	 	}
        	 	
        }while(check);
	}
   
}
