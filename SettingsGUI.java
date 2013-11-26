import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SettingsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsGUI frame = new SettingsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SettingsGUI() {
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblTempUnits = new JLabel("Temperature units");
		lblTempUnits.setBounds(22, 11, 94, 14);
		contentPane.add(lblTempUnits);
		
		JRadioButton rdbtnCelsius = new JRadioButton("Celsius");
		rdbtnCelsius.setBounds(21, 31, 109, 23);
		contentPane.add(rdbtnCelsius);
		
		JRadioButton rdbtnFahrenheit = new JRadioButton("Fahrenheit");
		rdbtnFahrenheit.setBounds(22, 57, 109, 23);
		contentPane.add(rdbtnFahrenheit);
		
		JLabel lblClothesYouHave = new JLabel("Clothes you have:");
		lblClothesYouHave.setBounds(22, 104, 94, 14);
		contentPane.add(lblClothesYouHave);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(201, 11, 46, 14);
		contentPane.add(lblLocation);
		
		textField = new JTextField();
		textField.setBounds(201, 32, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblclothingList = new JLabel("(clothing list)");
		lblclothingList.setBounds(32, 129, 73, 14);
		contentPane.add(lblclothingList);
	}
}
