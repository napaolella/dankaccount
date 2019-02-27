/**
 * @author Nathan Paolella pd 7
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	
	ArrayList<BankAccount> list = new ArrayList<BankAccount>();
	
	public GUI () {
		super("Bank Account");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(200, 200, 400, 300);
		
		JLabel n = new JLabel("Name: ");
		n.setBounds(25,25,50,25);
		setLayout(null);
		add(n);
		JTextField name = new JTextField();
		name.setBounds(75,25,200,25);
		add(name);
		
		JLabel t = new JLabel("Account Type: ");
		t.setBounds(25,75,100,25);
		add(t);
		String[] options = {"Savings","Checking"};
		JComboBox type = new JComboBox(options);
		type.setBounds(125, 75, 200, 25);
		add(type);
		
		JLabel d = new JLabel("Initial Deposit: ");
		d.setBounds(25,125,100,25);
		add(d);
		JTextField dep = new JTextField();
		dep.setBounds(125, 125, 200, 25);
		add(dep);
		
		JLabel i = new JLabel();
		i.setBounds(200, 150, 200, 25);
		add(i);
		
		
		JButton add = new JButton("Create Account");
		add.setBounds(25, 200, 150, 50);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type.getSelectedIndex()==0) {
					try {
						list.add(new SavingsAccount(name.getText(),Double.parseDouble(dep.getText()),0,0));
						name.setText("");
						dep.setText("");
						i.setText("Creation Successful");
					}
					catch (IllegalArgumentException oof){
						i.setText("Creation Unsuccessful");
						return;
					}
				}
				else {
					try {
						list.add(new CheckingAccount(name.getText(),Double.parseDouble(dep.getText()),0,0,1));
						name.setText("");
						dep.setText("");
						i.setText("Creation Successful");
					}
					catch (IllegalArgumentException oof){
						i.setText("Creation Unsuccessful");
						return;
					}
				}
			}
		});
		add(add);
		
		JButton display = new JButton("Display Accounts");
		display.setBounds(200, 200, 150, 50);
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (BankAccount a: list) {
					System.out.println(a.toString());
				}
			}
		});
		add(display);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new GUI();
	}

}
