import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	
	public GUI () {
		super("Bank Account");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(200, 200, 500, 350);
		
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
		
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new GUI();
	}

}
