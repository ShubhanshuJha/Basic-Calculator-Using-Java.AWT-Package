import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Basic_Calc extends Frame{
	public static void main(String[] args) {
		Basic_Calc frame = new Basic_Calc("BASIC CALCULATOR");
	}

	private Label l1, l2, l3, l4;
	// TextField t1, t2, t3, t4;
	private TextField t1, t2, t3;
	private Label t4, l5, prevRes;
	protected String defaultStr = " Result Area";
	private Button b1, b2;

	Basic_Calc(String s){
		setTitle(s);
		setVisible(true);
		setSize(650, 400);
		setLocation(300, 200);
		setForeground(Color.RED);
		// Font fn = new Font("Forte", Font.BOLD, 30);
		Font fn = new Font("Forte", Font.ROMAN_BASELINE, 30);
		setFont(fn);

		MenuBar mb = new MenuBar();  
		Menu menu = new Menu("Supported Operations");  

		MenuItem item1 = new MenuItem("Addition");
	    MenuItem item2 = new MenuItem("Subtraction");
	    MenuItem item3 = new MenuItem("Multiplication");
	    MenuItem item4 = new MenuItem("Division");
	    MenuItem item5 = new MenuItem("MOD");
	    MenuItem item6 = new MenuItem("LCM");
	    MenuItem item7 = new MenuItem("HCF or GCD");
	    MenuItem item8 = new MenuItem("A To Power B");

	    menu.add(item1);
	    menu.add(item2);
	    menu.add(item3);
	    menu.add(item4);
	    menu.add(item5);
	    menu.add(item6);
	    menu.add(item7);
	    menu.add(item8);

		mb.add(menu);
		setMenuBar(mb);

		l1 = new Label("Give Input 1:");
		l2 = new Label("Give Input 2:");
		l3 = new Label("  Operation:");
		l4 = new Label("  Result: ");
		l5 = new Label("Previous Result:");

		t1 = new TextField(9);
		t2 = new TextField(9);
		t3 = new TextField(9);
		// t4 = new TextField(20);
		t4 = new Label(defaultStr);
		prevRes = new Label(" 0 ");

		b1 = new Button("EVAL");
		b2 = new Button("CLEAR");

		add(l1);
		add(t1);

		add(l2);
		add(t2);

		add(l3);
		add(t3);

		add(l4);
		add(t4);

		add(l5);
		add(prevRes);

		add(b1);
		add(b2);

		// setLayout(new FlowLayout());
		setLayout(new GridLayout(6, 2, 10, 15));
		// setBackground(Color.RED);
		setResizable(false);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		t1.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10){
					// doAction(t1);
					// e.setKeyCode(java.awt.event.KeyEvent.VK_TAB); //Not needed & not working too
				}
				if(e.getKeyCode() == 27){
					clearTypingField(t1);
				}
			}
			public void keyReleased(KeyEvent e) {}
    		public void keyTyped(KeyEvent e) {}
		});
		t2.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10){
					// doAction(t2);
					// e.setKeyCode(java.awt.event.KeyEvent.VK_TAB); //Not needed & not working too
				}
				if(e.getKeyCode() == 27){
					clearTypingField(t2);
				}
			}
			public void keyReleased(KeyEvent e) {}
    		public void keyTyped(KeyEvent e) {}
		});
		t3.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10){
					// doAction(t3);
					doAction();
				}
				if(e.getKeyCode() == 27){
					clearTypingField(t3);
				}
			}
			public void keyReleased(KeyEvent e) {}
    		public void keyTyped(KeyEvent e) {}
		});
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doAction();
				// try{
				// 	String val1 = t1.getText();
				// 	String val2 = t2.getText();
				// 	String oper = t3.getText();
				// 	t4.setText(calc(val1, val2, oper.toCharArray()));
				// } catch(Exception ex){}
			}
		});
		b1.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10){
					doAction();
					// try{
					// 	String val1 = t1.getText();
					// 	String val2 = t2.getText();
					// 	String oper = t3.getText();
					// 	t4.setText(calc(val1, val2, oper.toCharArray()));
					// } catch(Exception ex){}
				}
			}
			public void keyReleased(KeyEvent e) {}
    		public void keyTyped(KeyEvent e) {}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				clearTypingField(t1);
				clearTypingField(t2);
				clearTypingField(t3);
				// clearTypingField(t4);
				prevRes.setText(t4.getText());
				t4.setText(defaultStr);
			}
		});
		b2.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10){
					clearTypingField(t1);
					clearTypingField(t2);
					clearTypingField(t3);
					// clearTypingField(t4);
					prevRes.setText(t4.getText());
					t4.setText(defaultStr);
				}
			}
			public void keyReleased(KeyEvent e) {}
    		public void keyTyped(KeyEvent e) {}
		});
		setBackground(Color.gray);
	}
	// protected void doAction(TextField tf){
	// 	if (tf == t1){}
	// 	else if (tf == t2){}
	// 	else if (tf == t3){
	// 		try{
	// 			String val1 = t1.getText();
	// 			String val2 = t2.getText();
	// 			String oper = t3.getText();
	// 			if (!t4.getText().equals(defaultStr)) {
	// 				prevRes.setText(t4.getText());
	// 			}
	// 			t4.setText(calc(val1, val2, oper.toCharArray()));
	// 		} catch(Exception ex){}
	// 	}
	// }
	protected void doAction(){
		try{
			String val1 = t1.getText();
			String val2 = t2.getText();
			String oper = t3.getText();
			if (!t4.getText().equals(defaultStr)) {
				prevRes.setText(t4.getText());
			}
			t4.setText(calc(val1, val2, oper.toCharArray()));
		} catch(Exception ex){}
	}
	protected void clearTypingField(TextField tf){
		try{
			tf.setText("");
		} catch(Exception ex){}
	}
	protected String calc(String s1, String s2, char[] op){
		long result;
		long a = Long.parseLong(s1);
		long b = Long.parseLong(s2);

		if (op[0] == '+') {
			result = (a + b);
		}
		else if (op[0] == '-') {
			result = (a - b);
		}
		else if (op[0] == '*' || op[0] == 'x') {
			result = (a * b);
		}
		else if (op[0] == '/') {
			result = (a / b);
		}
		else if (op[0] == '%') {
			result = (a % b);
		}
		else if (op[0] == '^') {
			result = (long)Math.pow(a, b);
		}
		else if (op[0] == 'L' || op[0] == 'l') {
			if (op.length > 1) {
				if (op[1] == 'C' || op[1] == 'c') {
					if (op.length > 2) {
						if (op[2] == 'M' || op[2] == 'm') {
							result = lcm(a, b);
						} else {
							return "Wrong Input Format!!!";
						}
					}
				} else {
					return "Wrong Input Format!!!";
				}
			}
			// result = lcm(a, b);
			return "Wrong Input Format!!!";
		}
		else if (op[0] == 'G' || op[0] == 'g' || op[0] == 'H' || op[0] == 'h') {
			if (op.length > 1) {
				if (op[1] == 'C' || op[1] == 'c' || op[1] == 'C' || op[1] == 'c') {
					if (op.length > 2) {
						if (op[2] == 'D' || op[2] == 'd' || op[2] == 'F' || op[2] == 'f') {
							result = gcd(a, b);
						} else {
							return "Wrong Input Format!!!";
						}
					}
				} else {
					return "Wrong Input Format!!!";
				}
			}
			// result = gcd(a, b);
			return "Wrong Input Format!!!";
		}
		else if (op[0] == '%' || op[0] == 'M' || op[0] == 'm') {
			if (op.length > 1) {
				if (op[1] == 'O' || op[1] == 'o') {
					if (op.length > 2) {
						if (op[2] == 'D' || op[2] == 'd') {
							result = a % b;
						} else {
							return "Wrong Input Format!!!";
						}
					}
				}else {
					return "Wrong Input Format!!!";
				}
			}
			result = a % b;
		}
		else{
			return "Wrong Input Format!!!";
		}
		return String.valueOf(result);
	}
	protected long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    protected long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}