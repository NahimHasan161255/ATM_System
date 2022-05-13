package abc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User {
	// user attributes 
	
	private String userName;
	private String password;
	private String accountNumber;
	
	
	
	// constructor
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		
	}
	
	
// change password
	
	
  public void changePassword(String newPassword) throws IOException{
	  
	  
		String a = userName +" "+ password ;
	
		String thisLine = null;
		
		try{
			FileReader in = new FileReader("Input.txt");
			 BufferedReader br = new BufferedReader(in);
			 FileWriter out = new FileWriter("output.txt");
			 BufferedWriter bw = new BufferedWriter(out);
			 
			 
			  while ((thisLine = br.readLine()) != null) {
		          if(thisLine.compareTo(a)==0)
		          {
		        	  a = getUserName() + " " + newPassword;
		        	  bw.write(a+"\n");
		  
		          }
		          else
		          {
		        	  bw.write(thisLine+"\n");
		          }
		         } 
			 br.close();
			 bw.close();
		}
		catch(IOException E){
			E.printStackTrace();
		}

		try {
			FileReader i = new FileReader("output.txt");
			 BufferedReader brr = new BufferedReader(i);
			 FileWriter o = new FileWriter("Input.txt");
			 BufferedWriter bwr = new BufferedWriter(o);
		 String ThisLine = null;
		 while ((ThisLine = brr.readLine()) != null) {
	          {
	        	  bwr.write(ThisLine+"\n");
	          }
	         } 
		 brr.close();
		 bwr.close();
		
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	//getter_setter
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	

}
