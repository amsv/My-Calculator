import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
// �� ��������� ������� ������  import java.awt.Dimension;

public class Calculator {
	// ���������� ���� ����������� �����������
	
	JButton button0= new JButton("0");
	JButton button1= new JButton("1");
	JButton button2= new JButton("2");
	JButton button3= new JButton("3");
	JButton button4= new JButton("4");
	JButton button5= new JButton("5");
	JButton button6= new JButton("6");
	JButton button7= new JButton("7");
	JButton button8= new JButton("8");
	JButton button9= new JButton("9");
	JButton buttonPoint= new JButton(".");
	JButton buttonEqual= new JButton("=");
	JButton buttonPlus= new JButton("+");
	JButton buttonMinus= new JButton("-");
	JButton buttonMultiplication= new JButton("*");
	JButton buttonDivide= new JButton("/");
	
	JPanel windowContent= new JPanel();
	JTextField displayField = new JTextField(30);

		// � ������������ ��������� ��� ����������
		// � ���������� �� ����� � ������� ����������
		// Borderlayout , Gridlayout
		Calculator(){
			
			// ������� ����� �� ���� ������
			BorderLayout bl = new BorderLayout(); 
			windowContent.setLayout(bl);
			
			// ������� � ���������� ����
			// ?������� ��� � �������� ������� ����			
			windowContent.add("North",displayField);
			
			// ������� ������, �������� �����������
			// ������ JButton, ������� ��������� �����
			// ������ � �������� ���������
			/* �����
			numButtons= new JButton[10];
			for (int i = 0; i < numButtons.length; i++) {
				numButtons[i] = new JButton(Integer.toString(i));
			}
			*/
			
			// ������� ������ � GridLayout
			// ������ �������� 12 ������
			JPanel pl = new JPanel();
			GridLayout gl = new GridLayout(4,3);
			
			pl.setLayout(gl);
			pl.add(button1);
			pl.add(button2);
			pl.add(button3);
			pl.add(button4);
			pl.add(button5);
			pl.add(button6);
			pl.add(button7);
			pl.add(button8);
			pl.add(button9);
			pl.add(button0);
			
			pl.add(buttonPoint);
			pl.add(buttonEqual);
			
			// �������� ������ pl � ����� ����
			windowContent.add("Center",pl);
			
			// ������� ������ p2
			JPanel p2 = new JPanel();
			
			//��������� ����� �� ������ ������ p2
			GridLayout gl2 = new GridLayout(4,1);
			p2.setLayout(gl2);
			
			// �������� �� ������ P2  ������
			p2.add(buttonPlus);
			p2.add(buttonMinus);
			p2.add(buttonMultiplication);
			p2.add(buttonDivide);
			
			// ����������� ������ p2  �� ��������� �������
			windowContent.add("East",p2);			

			// ������� ����� � ������ ��� �������� ������
			JFrame frame = new JFrame("Calculator");
			frame.setContentPane(windowContent);
			
			// ������ ������ ���� �����������
			// - ����� ��� ���������� ��������
			frame.pack();
			
			// ���������� ����
			frame.setVisible(true);
			
			//��������� ������� �� ������
			CalculatorEngine calcEngine = new CalculatorEngine(this);
			button0.addActionListener(calcEngine);
			button1.addActionListener(calcEngine);
			button2.addActionListener(calcEngine);
			button3.addActionListener(calcEngine);
			button4.addActionListener(calcEngine);
			button5.addActionListener(calcEngine);
			button6.addActionListener(calcEngine);
			button7.addActionListener(calcEngine);
			button8.addActionListener(calcEngine);
			button9.addActionListener(calcEngine);
			
			buttonPlus.addActionListener(calcEngine);
			buttonMinus.addActionListener(calcEngine);
			buttonMultiplication.addActionListener(calcEngine);
			buttonDivide.addActionListener(calcEngine);
			buttonEqual.addActionListener(calcEngine);
			buttonPoint.addActionListener(calcEngine);

	}					
	public static void main(String[] args) {
			
		Calculator calc = new Calculator();
	}
	

}
