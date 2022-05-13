package abc;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Account{
	private double balance;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@SuppressWarnings("resource")
	
	
	String checkBalance(String userName){
String thisLine = null;
		int i =0;
		 
		try{
			FileReader in = new FileReader("aont.txt");
			 BufferedReader br = new BufferedReader(in);
			 
			 
			  while ((thisLine = br.readLine()) != null) {
				  String[] s	=   thisLine.split(" ");
					  if(userName.compareToIgnoreCase(s[i])==0){
						 String balance = (s[i+2]);
						 return balance ;
				  }
			  }
			 
			 br.close();
		}
		catch(IOException E){
			E.printStackTrace();
		}
		
		
		  return "0";
	}
	
	
	
	
	
	
	
	String withdraw(String userName,String withdrawBalance) throws IOException{
		
		String thisLine = null;
		int i =0,k=0;
		 String balance="0";
		try{
			FileReader in = new FileReader("aont.txt");
			 BufferedReader br = new BufferedReader(in);
			 FileWriter out = new FileWriter("output2.txt");
			 BufferedWriter bw = new BufferedWriter(out);
			 
			  while ((thisLine = br.readLine()) != null) {
				  String[] s	=   thisLine.split(" ");
					  if(userName.compareToIgnoreCase(s[i])==0){
						  balance = (s[2]);
						  double wb = Double.parseDouble(withdrawBalance);
						  double b = Double.parseDouble(balance);
						  if(wb>b)
						  {
							thisLine = userName+" "+s[1]+" "+s[2];
							bw.write(thisLine+"\n");
							k=1;
						  }
						  else
						  {
							  b=b-wb;
							  thisLine =  userName+" "+s[1]+" "+b;
							  bw.write(thisLine+"\n");
						  }
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
			FileReader ii = new FileReader("output2.txt");
			 BufferedReader brr = new BufferedReader(ii);
			 FileWriter o = new FileWriter("aont.txt");
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
		if(k==1)
			return "0";
		else
			return "1";
		
		
	}
	
	
	
	
	
	
	int transferMoney(String AccountNum,String Amount) throws IOException {

		int k=0;
		String thisLine = null;
		
		try{
			 FileReader in = new FileReader("aont.txt");
			 BufferedReader b = new BufferedReader(in);
			  FileWriter out = new FileWriter("output2.txt");
			 BufferedWriter bw = new BufferedWriter(out);
			 
			  while ((thisLine = b.readLine()) != null) {
				  
				  String[] s = thisLine.split(" ");
				  
				  
				   if(AccountNum.compareTo(s[1])!=0){
						 
						  bw.write(thisLine+"\n");
						 
						  }
					  else 
					  {
						  String balance = s[2];
						  double ts = Double.parseDouble(Amount);
						  double ba = Double.parseDouble(balance);
						  double bal=ba+ts;
							thisLine = s[0]+" "+AccountNum+" "+bal;
							bw.write(thisLine+"\n");
							k=1;
					  }
						 
				  }
			  
			 b.close();
			 bw.close();
		}
		catch(IOException E){
			E.printStackTrace();
		}
		try {
			FileReader ii = new FileReader("output2.txt");
			 BufferedReader brr = new BufferedReader(ii);
			 FileWriter o = new FileWriter("aont.txt");
			 BufferedWriter bwr = new BufferedWriter(o);
		 //String ThisLine = null;
		 while ((thisLine = brr.readLine()) != null) {
	          {
	        	  bwr.write(thisLine+"\n");
	          }
	         } 
		 brr.close();
		 bwr.close();
		
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k==1)
			return 1;
		else
			return 0;
		
	}
	

}
