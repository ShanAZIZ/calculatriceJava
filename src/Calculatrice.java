
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Calculatrice extends JFrame implements ActionListener, MouseListener {

	/** Calculatrice - JAVA
	 * By Shan AZIZ
	 * Date 19/01/202020
	 * 107,107,111, 80
	 * 

	 */
	
	private Color txtBackground = new Color (77,76,83);
	private Color btnBackground = new Color (107,107,111);
	private Color btnBackground2 = new Color (129,129,132);
	private Color btnBackgroundOrange = new Color (255,159,10);
	
	//TXT FIELD
	private JTextField txtEntree = new JTextField();
	Font txtFont = new Font("Helvetica Neue ", Font.PLAIN, 30);
	Font buttonFont = new Font("Helvetica Neue", Font.BOLD, 20);
	
	
	//BUTTONS
	//first line
	private JButton ac = new JButton("AC");
	private JButton invertSign = new JButton("+/-");
	private JButton modulo = new JButton("%");
	private JButton divide = new JButton("/");
	
	//Second line
	private JButton number7 = new JButton("7");
	private JButton number8 = new JButton("8");
	private JButton number9 = new JButton("9");
	private JButton multiply = new JButton("X");
	
	//third line
	private JButton number4 = new JButton("4");
	private JButton number5 = new JButton("5");
	private JButton number6 = new JButton("6");
	private JButton mines = new JButton("-");
	
	//fourth line
	private JButton number1 = new JButton("1");
	private JButton number2 = new JButton("2");
	private JButton number3 = new JButton("3");
	private JButton add = new JButton("+");
	
	//fifth line
	private JButton number0 = new JButton("0");
	private JButton coma = new JButton(",");
	private JButton equal = new JButton("=");
	
	private boolean isOperationClicked = false;
	private boolean numberUpdate = false;
	private boolean isEqualClicked = false;
	
	private float temp = 0;
	private String lastOperation = "";
	
	private static final long serialVersionUID = 1L;
	
	public Calculatrice () throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		//FENETRE PRINCIPALE
		this.setBounds(240,335,240, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(54, 55, 60));
		this.setLayout(null);
		
		//Make Native
		//System.setProperty("apple.laf.useScreenMenuBar", "true");
		//System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//this.setUndecorated(true); 
		//this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME); 
		
		//Barre de titre
		//this.setTitle("Calculatrice");
		
		//Entree de valeur
		this.txtEntree.setBackground(this.txtBackground);
		this.txtEntree.setBorder(BorderFactory.createLineBorder (new Color (0, 0, 0, 0), 1));
		this.txtEntree.setBounds(0,0,240,70);
		this.txtEntree.setForeground(Color.white);
		this.txtEntree.setFont(txtFont);
		this.add(this.txtEntree);
		
		//LES BOUTTONS
		this.buttonDisplay(this.ac, this.btnBackground, 0, 70); 
		this.buttonDisplay(this.invertSign, this.btnBackground, 60, 70); 
		this.buttonDisplay(this.modulo, this.btnBackground, 120, 70); 
		this.buttonDisplay(this.divide, this.btnBackgroundOrange, 180, 70); 
		
		this.buttonDisplay(this.number7, this.btnBackground2, 0, 119); 
		this.buttonDisplay(this.number8, this.btnBackground2, 60, 119); 
		this.buttonDisplay(this.number9, this.btnBackground2, 120, 119); 
		this.buttonDisplay(this.multiply, this.btnBackgroundOrange, 180, 119); 
		
		this.buttonDisplay(this.number4, this.btnBackground2, 0, 168); 
		this.buttonDisplay(this.number5, this.btnBackground2, 60, 168); 
		this.buttonDisplay(this.number6, this.btnBackground2, 120, 168); 
		this.buttonDisplay(this.mines, this.btnBackgroundOrange, 180, 168); 
		
		this.buttonDisplay(this.number1, this.btnBackground2, 0, 217); 
		this.buttonDisplay(this.number2, this.btnBackground2, 60, 217); 
		this.buttonDisplay(this.number3, this.btnBackground2, 120, 217); 
		this.buttonDisplay(this.add, this.btnBackgroundOrange, 180, 217); 
				
		
		this.number0.setBorder(BorderFactory.createLineBorder (this.txtBackground, 1));
		this.number0.setForeground(Color.white);
		this.number0.setFont(buttonFont);
		this.number0.setBounds(0,266,120,49);
		this.number0.setBackground(btnBackground2);
		this.number0.setOpaque(true);
		this.add(this.number0);
		this.number0.addActionListener(this);
		this.number0.addMouseListener(this);
		this.buttonDisplay(this.coma, this.btnBackground2, 120, 266);
		
		this.buttonDisplay(this.equal, this.btnBackgroundOrange, 180, 266); 
		//Rendre visible
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch(e.getActionCommand()) {
				case "AC" :
					this.txtEntree.setText("");
					this.isOperationClicked = false;
					this.numberUpdate = false;
					this.temp = 0;
					break;
				
				//Entree des nombres dans la case de texte
				case "0" :
				case "1" :
				case "2" :
				case "3" :
				case "4" :
				case "5" :
				case "6" :
				case "7" :
				case "8" :
				case "9" :
					if(this.isOperationClicked == true && this.numberUpdate == false) {
						this.txtEntree.setText(e.getActionCommand());
						this.numberUpdate = true;
	
						
					}
					else {
						this.txtEntree.setText(this.txtEntree.getText() + e.getActionCommand());
						break;
					}
					break;
				case "+" :
				case "-" :
				case "/" :
				case "X" :
						
							if(isOperationClicked == false) {
								this.lastOperation = e.getActionCommand();
								//Assigner le nombre afficher dans une variable
								this.temp = Float.parseFloat(this.txtEntree.getText());
							}
							
							//Le boutton a ete clicker
							this.isOperationClicked = true;
							
							if(this.numberUpdate) {
								this.txtEntree.setText(calcul(this.lastOperation, this.temp));
								this.lastOperation = e.getActionCommand();
								this.temp = Float.parseFloat(this.txtEntree.getText());
	
								this.numberUpdate = false;
							}
						
					break;
				
				case "=" :
					this.txtEntree.setText(calcul(this.lastOperation, this.temp));
					this.temp = Float.parseFloat(this.txtEntree.getText());
					this.numberUpdate = false;
					this.isOperationClicked = false;
					this.isEqualClicked = true;
					break;
					
				
				case "%" :
					this.txtEntree.setText( Float.toString(Float.parseFloat(this.txtEntree.getText()) /100));
					break;
				case "+/-" :
					this.txtEntree.setText( Float.toString(Float.parseFloat(this.txtEntree.getText()) * -1));
					break;
				
				case "," :
					if(!this.txtEntree.getText().contains(".")) {
						if(this.isOperationClicked && this.numberUpdate == false) {
							this.txtEntree.setText("0.");
							this.numberUpdate = true;
						}else {
							this.txtEntree.setText(this.txtEntree.getText() + ".");
						}
						
					}
					break;
			}
		}catch(NumberFormatException exp) {
			JOptionPane.showMessageDialog(this, "Format Incorrect");
			this.txtEntree.setText("");
			this.isOperationClicked = false;
			this.numberUpdate = false;
			this.temp = 0;
		}
	}
	
	public String calcul(String action, float nombre) {
		System.out.println(action);
		float value;
		if(action == "+"){
			value =temp + Float.parseFloat(this.txtEntree.getText());
			return Float.toString(value);
		}
		if (action == "-") {
			value = temp - Float.parseFloat(this.txtEntree.getText());
			return Float.toString(value);

		}
		if (action == "/") {
			float diviseur = Float.parseFloat(this.txtEntree.getText());
			if (diviseur != 0 ) {
				value = temp / diviseur;
				return Float.toString(value);
			}
			else {
				return ("Division par 0");
			}
			
		}
		if (action == "X") {
			value = temp * Float.parseFloat(this.txtEntree.getText());
			return Float.toString(value);
		}
		else {
			return Float.toString(nombre);
		}

	}

	
	public void buttonDisplay(JButton button, Color bgColor, int  x, int y) {
		button.setBorder(BorderFactory.createLineBorder (this.txtBackground, 1));
		button.setForeground(Color.white);
		button.setFont(buttonFont);
		button.setBounds(x,y,60,49);
		button.setBackground(bgColor);
		button.setOpaque(true);
		this.add(button);
		button.addActionListener(this);
		button.addMouseListener(this);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		new Calculatrice();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(
				e.getSource() == this.number0 ||
				e.getSource() == this.number1 ||
				e.getSource() == this.number2 ||
				e.getSource() == this.number3 ||
				e.getSource() == this.number4 ||
				e.getSource() == this.number5 ||
				e.getSource() == this.number6 ||
				e.getSource() == this.number7 ||
				e.getSource() == this.number8 ||
				e.getSource() == this.number9 ||
				e.getSource() == this.coma		
		) {
			((JComponent) e.getSource()).setBackground(new Color ( 120, 120, 117));
		}
		else if(
				e.getSource() == this.ac ||
				e.getSource() == this.invertSign ||
				e.getSource() == this.modulo
		) {
			((JComponent) e.getSource()).setBackground(this.btnBackground2);
		}
		else {
			((JComponent) e.getSource()).setBackground(new Color (213,133,10));
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(
				e.getSource() == this.number0 ||
				e.getSource() == this.number1 ||
				e.getSource() == this.number2 ||
				e.getSource() == this.number3 ||
				e.getSource() == this.number4 ||
				e.getSource() == this.number5 ||
				e.getSource() == this.number6 ||
				e.getSource() == this.number7 ||
				e.getSource() == this.number8 ||
				e.getSource() == this.number9 ||
				e.getSource() == this.coma		
		) {
			((JComponent) e.getSource()).setBackground(this.btnBackground2);
		}
		else if(
				e.getSource() == this.ac ||
				e.getSource() == this.invertSign ||
				e.getSource() == this.modulo
		) {
			((JComponent) e.getSource()).setBackground(this.btnBackground);
		}
		else {
			((JComponent) e.getSource()).setBackground(this.btnBackgroundOrange);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
