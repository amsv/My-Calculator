import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
// дл¤ установки размера кнопки  import java.awt.Dimension;

public class Calculator {
	// объ¤вление всех компонентов калькул¤тора
	
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

		// ¬ конструкотре создаютьс¤ все компоненты
		// и добовл¤ютьс¤ на фрейм с помощью комбинации
		// Borderlayout , Gridlayout
		Calculator(){
			
			// создаем схему дл¤ этой панели
			BorderLayout bl = new BorderLayout(); 
			windowContent.setLayout(bl);
			
			// —оздаем и отображаем поле
			// ?обавл¤ем его в северную область окна			
			windowContent.add("North",displayField);
			
			// —оздаем кнопки, использу¤ конструктор
			// класса JButton, который принимает текст
			// кнопки в качестве параметра
			/* новое
			numButtons= new JButton[10];
			for (int i = 0; i < numButtons.length; i++) {
				numButtons[i] = new JButton(Integer.toString(i));
			}
			*/
			
			// —оздаем панель с GridLayout
			// котора¤ содержит 12 кнопок
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
			
			// ѕомещ¤ем панель pl в центр окна
			windowContent.add("Center",pl);
			
			// создаем панель p2
			JPanel p2 = new JPanel();
			
			//установим схему дл¤ кнопок внутри p2
			GridLayout gl2 = new GridLayout(4,1);
			p2.setLayout(gl2);
			
			// добавл¤ем на панель P2  кнопки
			p2.add(buttonPlus);
			p2.add(buttonMinus);
			p2.add(buttonMultiplication);
			p2.add(buttonDivide);
			
			// распологаем панель p2  на восточной облости
			windowContent.add("East",p2);			

			// —оздаем фрейм и задаем его основную панель
			JFrame frame = new JFrame("Calculator");
			frame.setContentPane(windowContent);
			
			// делаем размер окна достаточный
			// - чтобы все компоненты вместить
			frame.pack();
			
			// отображаем окно
			frame.setVisible(true);
			
			//добавляем события на кнопки
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
