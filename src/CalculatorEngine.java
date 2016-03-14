import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CalculatorEngine implements ActionListener {
	Calculator parent; // ������ �� ������� ����������� 
	
	char selectedAction = ' '; // ���� ��� + - / *
	double currentResult = 0;

	// ���������� ��������� ������ �� ���� ������������
	// � ���������� ��������� ������
	CalculatorEngine (Calculator parent){
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// �������� �������� �������
		// ��������������{���� ����} ��������� ����� ������ ������ �������
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
		
		// �������� ������� �� ������
		//(old) String clickedButtonLabel = clickedButton.getText();
		
		
		// ��������� ������� � ���� ���������		
		//(old) JOptionPane.showConfirmDialog(null ,clickedButtonLabel ,"��������� ��� �����" , JOptionPane.PLAIN_MESSAGE);
		
		String dispFieldText = parent.displayField.getText();
		double displayValue = 0;
		
		// �������� ����� �� ������� ������������
		// ���� �� �� ������
		
		if (!"".equals(dispFieldText)) {
			displayValue = Double.parseDouble(dispFieldText);
		}
		
		Object src = e.getSource();
		
		// ��� ������ ������ ��������������� ��������
		// ��������� ��� : +, -, /, *. ��������� ������� �����
		// � ���������� currentResult, � �������� �������
		// ��� ����� ������ �����
		
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
			// ��������� �������������� �������� � �����������
			// �� selectedAction, �������� ���������� currentResult
			// � �������� ��������� �� �������
			if (selectedAction=='+') {
				currentResult += displayValue;
				// ��������������� ��������� � ������
				// ��������� ��� � ������ ������ � ����������
				parent.displayField.setText(""+currentResult);
			} else if (selectedAction=='-') {
				currentResult -= displayValue;
				// ��������������� ��������� � ������
				// ��������� ��� � ������ ������ � ����������
				parent.displayField.setText(""+currentResult);
			} else if (selectedAction=='/') {
				if (displayValue == 0) {
					parent.displayField.setText("�� ���� ������ ������!");					
				} else {
					currentResult /= displayValue;
					// ��������������� ��������� � ������
					// ��������� ��� � ������ ������ � ����������
					parent.displayField.setText(""+currentResult);					
				}
				
			} else if (selectedAction=='*') {
				currentResult *= displayValue;
				// ��������������� ��������� � ������
				// ��������� ��� � ������ ������ � ����������
				parent.displayField.setText(""+currentResult);
			}			 
		} else {
			// ��� ���� �������� ������ ������������ �������
			// �� ������ � �������
			String clickedButtonLabel = clickedButton.getText();
			
			parent.displayField.setText(dispFieldText+clickedButtonLabel);
			if (parent.displayField.getText().indexOf(".") != parent.displayField.getText().lastIndexOf(".")) {
				dispFieldText = parent.displayField.getText().substring(0, parent.displayField.getText().length()-1);
				parent.displayField.setText(dispFieldText);
			}
		}    		
	}
}
