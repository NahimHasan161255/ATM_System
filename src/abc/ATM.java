package abc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JSeparator;



public class ATM {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM window = new ATM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 550, 500);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// ATM Login system Label code 
		
		
		JLabel lblNewLabel = new JLabel("ATM Login System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(170, 30, 190, 35);
		frame.getContentPane().add(lblNewLabel);
		
		
		// UserName Label code 
	
		
				JLabel lblUserName = new JLabel("UserName");
				lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblUserName.setBounds(60, 115, 150, 30);
				frame.getContentPane().add(lblUserName);
				
		// UserName text field bar code;
		

		txtUserName = new JTextField();
		txtUserName.setBounds(280, 115, 160, 30);
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
			
		// password Label code 
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(60, 215, 150, 30);
		frame.getContentPane().add(lblPassword);
		
		
		// UserName Password field bar code 
		
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(280, 215, 160, 30);
		frame.getContentPane().add(txtPassword);
		
		
		
		
	
		
		
		
		
		

		//login Button code
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// create object
				
		User user = new User(txtUserName.getText(),txtPassword.getText());
				String a = user.getUserName()+" "+user.getPassword();
				// creating file
				
				FileReader in = null;
				FileWriter out = null;
				String thisLine = null;
				
				try{
					 in = new FileReader("Input.txt");
					 BufferedReader br = new BufferedReader(in);
					

					 int k=0;
					  while ((thisLine = br.readLine()) != null) {
				          if(thisLine.compareTo(a)==0)
				          {
				        	  
				        	  k=1;
				        	  break;
				          }
				         } 
					 br.close();
				
					 if(k==1){
							frame.setVisible(false);
							// creating new frame
							
							frame = new JFrame();
							frame.getContentPane().setForeground(Color.WHITE);
							frame.getContentPane().setBackground(Color.DARK_GRAY);
							frame.setBounds(300, 300, 550, 500);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.getContentPane().setLayout(null);
							frame.setVisible(true);
							
							// check Balance Button code
							
							JButton btnNewButton = new JButton("Check Balance");
							btnNewButton.setBackground(Color.CYAN);
							btnNewButton.setFont(new Font("Stencil Std", Font.BOLD, 16));
							btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									Account ac = new Account();
									// call check Balance function from account
									String balance = ac.checkBalance(txtUserName.getText())+" Tk";
									JOptionPane.showMessageDialog(null,"                              "+
									balance,"Your Balance",JOptionPane.CLOSED_OPTION);
								}
							});
							btnNewButton.setBounds(94, 60, 325, 43);
							frame.getContentPane().add(btnNewButton);
							
							
							//withdraw money Button code
							
							
							JButton btnNewButton_1 = new JButton("Withdraw Money");
							btnNewButton_1.setBackground(Color.CYAN);
							btnNewButton_1.setFont(new Font("Stencil Std", Font.BOLD, 16));
							btnNewButton_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									frame.setVisible(false);
									//create new frame for money withdraw
									
									JFrame frame3 = new JFrame();
									frame3.setBounds(300, 300, 550, 500);
									frame3.getContentPane().setLayout(null);
									frame3.setVisible(true);
									
									// label for entering amount of money
									
									JLabel lblNewLabel = new JLabel("Enter Amount of Money");
									lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
									lblNewLabel.setBounds(150, 80, 250, 35);
									frame3.getContentPane().add(lblNewLabel);
									
									//create an amount field
									
									JTextField txtAmount = new JTextField();
									txtAmount.setBounds(150, 140 , 250, 35);
									txtAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
									frame3.getContentPane().add(txtAmount);
									
									JButton btnok= new JButton("Ok");
									btnok.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											Account ac = new Account ();
								
										String wb=null;
										try {
											wb = ac.withdraw(txtUserName.getText(),txtAmount.getText());
										} catch (IOException e1) {
											e1.printStackTrace();
										}
						                 
											if(wb.compareTo("0")==0){
								
												// call check Balance function from account
												String balance = ac.checkBalance(txtUserName.getText())+" Tk";
												JOptionPane.showMessageDialog(null, "Not Enough Balance."
														+ "Your Current Balance is "+balance,
														 "Balance Status",JOptionPane.CLOSED_OPTION);
												}
											else{
												JOptionPane.showMessageDialog(null, " you Successfully withdraw "+
											txtAmount.getText()+"tk"
														,"Balance Status",JOptionPane.CLOSED_OPTION);
												}
											
											txtAmount.setText(null);
											
											}
										
									});
									 btnok.setFont(new Font("Stencil Std", Font.BOLD, 20));
									 btnok.setBounds(40, 300, 120, 45);
									frame3.getContentPane().add( btnok);
									
									
									
									// back button code
									
									
									JButton btnBack = new JButton("Back");
									btnBack.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
												frame3.setVisible(false);
												frame.setVisible(true);
											}
									});
									btnBack.setFont(new Font("Stencil Std", Font.BOLD, 20));
									btnBack.setBounds(200, 300 , 120 , 45);
									frame3.getContentPane().add(btnBack);
									
									//Exit button code
									
									JButton btnExit= new JButton("Exit");
									btnExit.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											frame = new JFrame("Exit");
											if(JOptionPane.showConfirmDialog(frame, "Confirm if u want to Exit","ATM Login System"
													,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
												System.exit(0);
											}
											
										}
									});
									 btnExit.setFont(new Font("Stencil Std", Font.BOLD, 20));
									 btnExit.setBounds(380, 300, 120, 45);
									frame3.getContentPane().add( btnExit);
								}
							});
							btnNewButton_1.setBounds(94, 136, 325, 43);
							frame.getContentPane().add(btnNewButton_1);
							
							
							//transfer money Button code
							
							JButton btnNewButton_2 = new JButton("Transfer Money");
							btnNewButton_2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									frame.setVisible(false);
									JFrame frame3 = new JFrame();
									frame3.setBounds(300, 300, 550, 500);
									frame3.getContentPane().setLayout(null);
									frame3.setVisible(true);
									
									//label for enter account number
									
									JLabel lblNewLabel = new JLabel("Enter Account Number");
									lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
									lblNewLabel.setBounds(150, 40, 250, 35);
									frame3.getContentPane().add(lblNewLabel);
									
									//account field 
									
									JTextField txtAccountNum = new JTextField();
									txtAccountNum.setBounds(150, 100 , 250, 35);
									txtAccountNum.setFont(new Font("Tahoma", Font.BOLD, 20));
									frame3.getContentPane().add(txtAccountNum);
									
									//amount label
									
									JLabel lblNewLabel_2 = new JLabel("Enter Amount");
									lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
									lblNewLabel_2.setBounds(150, 150, 250, 35);
									frame3.getContentPane().add(lblNewLabel_2);
									
									//amount field
									
									JTextField txtAmount1 = new JTextField();
									txtAmount1.setBounds(150, 210 , 250, 35);
									txtAmount1.setFont(new Font("Tahoma", Font.BOLD, 20));
									frame3.getContentPane().add(txtAmount1);
									
									//OK button
									
									JButton btnok= new JButton("Ok");
									
									btnok.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											
											Account act = new Account ();
											String accountNum = txtAccountNum.getText();
											String amount1 = txtAmount1.getText();
											double amount = Double.parseDouble(amount1);
											 String loginUser = txtUserName.getText();
											
													int TransferMoney=-1 ;
													String userBalance = act.checkBalance(loginUser);
													double UserBalance = Double.parseDouble(userBalance);
													if(UserBalance>amount && amount>0){
														try {
															TransferMoney = act.transferMoney(accountNum,amount1);
														} catch (IOException e2) {
															// TODO Auto-generated catch block
															e2.printStackTrace();
														}
												
													if(TransferMoney==0)
													{
													JOptionPane.showMessageDialog(null, "            "+
												" this Account doesn't exist ","Account Status",JOptionPane.CLOSED_OPTION);
													}
													
													else{
														
														
														String withdrawMoney=null;
														try {
															withdrawMoney = act.withdraw(txtUserName.getText(),amount1);
														} catch (IOException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
										                 
															if(withdrawMoney.compareTo("0")==0){
																JOptionPane.showMessageDialog(null, "          Not Enough Balance ",
																		 "Balance Status",JOptionPane.CLOSED_OPTION);
																}
															else{
																JOptionPane.showMessageDialog(null, "          you Successfully "
																		+ "transfer your money ",
																		 "Transfer Status",JOptionPane.CLOSED_OPTION);
																txtAccountNum.setText(null);
													            txtAmount1.setText(null);
																}
														
														
													}
													
													}
													else
													{
													JOptionPane.showMessageDialog(null, "            "+
												"   Not enough balance.your current balance is "+userBalance+"tk","Account Status",JOptionPane.CLOSED_OPTION);
													}
											
											
											
									}
									});
									
									 btnok.setFont(new Font("Stencil Std", Font.BOLD, 20));
									 btnok.setBounds(40, 350, 120, 45);
									frame3.getContentPane().add( btnok);
									
									
									
									// back button code
									
									
									JButton btnBack = new JButton("Back");
									btnBack.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
												frame3.setVisible(false);
												frame.setVisible(true);
											}
									});
									btnBack.setFont(new Font("Stencil Std", Font.BOLD, 20));
									btnBack.setBounds(200, 350 , 120 , 45);
									frame3.getContentPane().add(btnBack);
									
									//Check Account Detail code
									
									JButton btnCheck= new JButton("Check Account");
									btnCheck.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											JFrame frame4 = new JFrame("Details");
											frame4.setBounds(300, 300, 550, 500);
											frame4.getContentPane().setBackground(Color.CYAN);
											frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
											frame4.getContentPane().setLayout(null);
											frame4.setVisible(true);
											AccountDetails ad = new AccountDetails(txtUserName.getText(),txtPassword.getText());
										    ad.accountDetails(txtAccountNum.getText());
											String thisLine = null;
											 String name=null,age=null,address=null,acNum=null;
											try{
											FileReader in = new FileReader("detailsOutput.txt");
											 BufferedReader br = new BufferedReader(in);
											
											 while ((thisLine = br.readLine()) != null) {
												  String[] s	=   thisLine.split(" ");
												  name = s[0];
												  acNum = s[1];
												  age = s[3];
												  address = s[4];
											 }
											 br.close();
											}
											catch(IOException E){
												E.printStackTrace();
											}
												  JLabel lblNewLabel = new JLabel("Name = "+name);
													lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
													lblNewLabel.setBounds(100, 30, 250, 35);
													frame4.getContentPane().add(lblNewLabel);
													JLabel lblNewLabel2 = new JLabel("Account Number = "+acNum);
													lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 20));
													lblNewLabel2.setBounds(100, 80, 350, 35);
													frame4.getContentPane().add(lblNewLabel2);
													JLabel lblNewLabel3 = new JLabel("Age = "+age);
													lblNewLabel3.setFont(new Font("Tahoma", Font.BOLD, 20));
													lblNewLabel3.setBounds(100, 120, 250, 35);
													frame4.getContentPane().add(lblNewLabel3);
													JLabel lblNewLabel4 = new JLabel("Address = "+address);
													lblNewLabel4.setFont(new Font("Tahoma", Font.BOLD, 20));
													lblNewLabel4.setBounds(100, 170, 250, 35);
													frame4.getContentPane().add(lblNewLabel4);
													JButton btnBack = new JButton("Back");
													btnBack.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
																frame4.setVisible(false);
																frame3.setVisible(true);
															}
													});
													btnBack.setFont(new Font("Stencil Std", Font.BOLD, 20));
													btnBack.setBounds(200, 350 , 120 , 45);
													frame4.getContentPane().add(btnBack);
											   
												  
												  
											 
											
										
										}
									});
									 btnCheck.setFont(new Font("Stencil Std", Font.BOLD, 12));
									 btnCheck.setBounds(360, 350, 150, 45);
									frame3.getContentPane().add( btnCheck);
							
									
								}
							});
							
							btnNewButton_2.setBackground(Color.CYAN);
							btnNewButton_2.setFont(new Font("Stencil Std", Font.BOLD, 16));
							btnNewButton_2.setBounds(94, 212, 325, 43);
							frame.getContentPane().add(btnNewButton_2);
							
							// change password Button code
							
							JButton btnNewButton_3 = new JButton("Change Password");
							btnNewButton_3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									frame.setVisible(false);
									//new password take frame code
									//
									// new frame code
									JFrame frame2 = new JFrame();
									frame2.setBounds(300, 300, 550, 500);
									frame2.getContentPane().setLayout(null);
									frame2.setVisible(true);
									
									
									//change password
									//Enter new password label code
									
									
									JLabel lblNewLabel = new JLabel("Enter New Password");
									lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
									lblNewLabel.setBounds(170, 40, 250, 35);
									frame2.getContentPane().add(lblNewLabel);
									
									//
					                //password field code
									
									
									JPasswordField txtPassword2 = new JPasswordField(null);
									txtPassword2.setBounds(170, 90 , 250, 35);
									txtPassword2.setFont(new Font("Tahoma", Font.BOLD, 20));
									frame2.getContentPane().add(txtPassword2);
									
									
									//Confirm New Password label code
									
									
									JLabel lblNewLabel2 = new JLabel("Confirm New Password");
									lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 20));
									lblNewLabel2.setBounds(170, 150 , 250, 35);
									frame2.getContentPane().add(lblNewLabel2);

									// Confirm New Password field code
									
									
									JPasswordField txtPassword3 = new JPasswordField();
									txtPassword3.setBounds(170 , 200 , 250, 35);
									txtPassword3.setFont(new Font("Tahoma", Font.BOLD, 20));
									frame2.getContentPane().add(txtPassword3);
					 				
									
									//back button code
									
									JButton btnBack = new JButton("Back");
									btnBack.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
												frame2.setVisible(false);
												frame.setVisible(true);
											}
									});
									btnBack.setBounds(315, 300 , 120 , 35);
									frame2.getContentPane().add(btnBack);
				                    
									
									//OK button code
									
									JButton btnok = new JButton("ok");
									btnok.addActionListener(new ActionListener() {
										@SuppressWarnings("deprecation")
										public void actionPerformed(ActionEvent e) {
									if(txtPassword2.getText().compareTo(txtPassword3.getText())==0)
												{
													frame2.setVisible(false);
													String a = txtPassword2.getText();
													System.out.println (a);
							               User user = new User(txtUserName.getText(),txtPassword.getText());
							               try {
											user.changePassword(a);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
												JOptionPane.showMessageDialog(null, " you Successful change your password ",
														 "Change Password",JOptionPane.CLOSED_OPTION);
												}
									else 
									{
										JOptionPane.showMessageDialog(null, "password didnot matched",
												 "Change Password",JOptionPane.CLOSED_OPTION);
										}
										
									}
											
									});
									btnok.setBounds(115, 300 , 120 , 35);
									frame2.getContentPane().add(btnok);
									
								}
							});
							btnNewButton_3.setBackground(Color.CYAN);
							btnNewButton_3.setFont(new Font("Stencil Std", Font.BOLD, 16));
							btnNewButton_3.setBounds(94, 289, 325, 43);
							frame.getContentPane().add(btnNewButton_3);
							
							//exit button code;
							
							JButton btnExit= new JButton("Exit");
							btnExit.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									frame = new JFrame("Exit");
									if(JOptionPane.showConfirmDialog(frame, "Confirm if u want to Exit","ATM Login System"
											,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
										System.exit(0);
									}
									
								}
							});
							 btnExit.setBackground(Color.RED);
							 btnExit.setFont(new Font("Stencil Std", Font.BOLD, 16));
							 btnExit.setBounds(203, 369, 115, 43);
							frame.getContentPane().add( btnExit);
						 
					 }
					 else{
						 
					JOptionPane.showMessageDialog(null, "Invalid Login Details",
								 "Login Error",JOptionPane.ERROR_MESSAGE);
						 txtPassword.setText(null);
							txtUserName.setText(null);							
						 
					 }
					 
					}
					catch(IOException E){
						E.printStackTrace();
					}
			}
		});
		btnLogin.setBounds(60, 350 , 120 , 35);
		frame.getContentPane().add(btnLogin);
		
		//login Exit code
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if u want to Exit","ATM Login System"
						,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
				
			}
		});
		btnExit.setBounds(315, 350 , 120 , 35);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 95, 445, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 300, 445, 2);
		frame.getContentPane().add(separator_2);
		
		
		
	}
	

	public String txtUserName() {
		
		return txtUserName.getText();
	}

	public String txtPassword() {
		return txtPassword.getText();
	}
}
