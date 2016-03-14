import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CalculatorEngine implements ActionListener {
	Calculator parent; // ссылка на новавый колькулятор 
	
	char selectedAction = ' '; // флаг для + - / *
	double currentResult = 0;

	// Коструктор сохраняет ссылку на окно калькулятора
	// в переменной экземпляр класса
	CalculatorEngine (Calculator parent){
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// получаем источник событий
		// предварительно{если надо} проверяем какой объект вызвал событие
		// JButton , JTextField 
		// 	JTextField myDisplayField=null;
		//	JButton clickedButton=null;
		//	Object eventSource = evt.hetSource();
		//	if (eventSource instanceof JButton){
		// 		clickedButton = (JButton) eventSource;
		//	}else if (eventSource instanceof JTextField){
		// 		myDisplayField = (JTextField)eventSource;
		//	}
		//}
		
		JButton clickedButton = (JButton)e.getSource();
		
		// получаем надпись на кнопке
		//(old) String clickedButtonLabel = clickedButton.getText();
		
		
		// добавляем надпись в окно сообщения		
		//(old) JOptionPane.showConfirmDialog(null ,clickedButtonLabel ,"Заголовок для теста" , JOptionPane.PLAIN_MESSAGE);
		
		String dispFieldText = parent.displayField.getText();
		double displayValue = 0;
		
		// получить число из дисплея калькулятора
		// если он не пустой
		
		if (!"".equals(dispFieldText)) {
			displayValue = Double.parseDouble(dispFieldText);
		}
		
		Object src = e.getSource();
		
		// для каждой кнопки арифмитического действия
		// запомнить его : +, -, /, *. Сохранить текущее число
		// в переменную currentResult, и очистить дисплей
		// для ввода нового числа
		
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
			
		} else if (src == parent.buttonMinus){
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
			
		} else if (src == parent.buttonDivide){
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMultiplication){
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonEqual){
			// совершить арифмитическое действие в зависимости
			// от selectedAction, обновить переменную currentResult
			// и показать результат на дисплее
			if (selectedAction=='+') {
				currentResult += displayValue;
				// сконвертировать результат в строку
				// добавляем его к пустой строку и показываем
				parent.displayField.setText(""+currentResult);
			} else if (selectedAction=='-') {
				currentResult -= displayValue;
				// сконвертировать результат в строку
				// добавляем его к пустой строку и показываем
				parent.displayField.setText(""+currentResult);
			} else if (selectedAction=='/') {
				if (displayValue == 0) {
					parent.displayField.setText("на ноль делить нельзя!");					
				} else {
					currentResult /= displayValue;
					// сконвертировать результат в строку
					// добавляем его к пустой строку и показываем
					parent.displayField.setText(""+currentResult);					
				}
				
			} else if (selectedAction=='*') {
				currentResult *= displayValue;
				// сконвертировать результат в строку
				// добавляем его к пустой строку и показываем
				parent.displayField.setText(""+currentResult);
			}			 
		} else {
			// для всех цифровых кнопок присоеденить надпись
			// на кнопке в дисплей
			String clickedButtonLabel = clickedButton.getText();
			
			parent.displayField.setText(dispFieldText+clickedButtonLabel);
			if (parent.displayField.getText().indexOf(".") != parent.displayField.getText().lastIndexOf(".")) {
				dispFieldText = parent.displayField.getText().substring(0, parent.displayField.getText().length()-1);
				parent.displayField.setText(dispFieldText);
			}
		}    		
	}
}
