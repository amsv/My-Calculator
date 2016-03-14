import javax.swing.*;
import java.awt.FlowLayout;

public class SimpleCalculator {

	public static void main(String[] args) {
		// создаем панель
		JPanel windowContent = new JPanel();
		
		//Менеджер отоброжения для этой панели 
		FlowLayout f1 = new FlowLayout();
		windowContent.setLayout(f1);
				
		// создаем компонеты в памяти 
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("Number 2:");
		JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("Сумма:");
		JTextField result = new JTextField(10);
		JButton go = new JButton("Add");
		
		//Добавляем компонеты на панель
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(result);
		windowContent.add(go);
	
		// создаем фрайм и задаем для него панель
		JFrame frame = new JFrame("Мой первый калькулятор");
		frame.setContentPane(windowContent);
		
		// задаем размер и делаем фрейм видимым
		frame.setSize(400, 100);
		frame.setVisible(true);	
		
	}

}
