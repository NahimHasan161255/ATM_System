package abc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccountDetails extends User {

	private String NID; 
	public String getNID() {
		return NID;
	}
	public void setNID(String nID) {
		NID = nID;
	}
	public AccountDetails(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	void accountDetails(String accountNum){
		String thisLine = null;
	try{
	FileReader in = new FileReader("details.txt");
	 BufferedReader br = new BufferedReader(in);
	 FileWriter out = new FileWriter("detailsOutput.txt");
	 BufferedWriter bw = new BufferedWriter(out);
	 while ((thisLine = br.readLine()) != null) {
		  String[] s	=   thisLine.split(" ");
		  if(accountNum.compareTo(s[1])==0){
			  bw.write(thisLine);
		  }
	 }
		  br.close();
		  bw.close();
	 
	}
	catch(IOException E){
		E.printStackTrace();
	}
	}
}
