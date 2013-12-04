package cs4240f13.hoowhatyouwearing.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SettingsGUI extends JFrame {

	private static SettingsGUI instance;
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
	private SettingsGUI() {
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblTempUnits = new JLabel("Temperature units");
		lblTempUnits.setBounds(22, 11, 108, 14);
		contentPane.add(lblTempUnits);
		
		JRadioButton rdbtnCelsius = new JRadioButton("Celsius");
		rdbtnCelsius.setBounds(21, 31, 109, 23);
		contentPane.add(rdbtnCelsius);
		
		JRadioButton rdbtnFahrenheit = new JRadioButton("Fahrenheit");
		rdbtnFahrenheit.setBounds(22, 57, 109, 23);
		rdbtnFahrenheit.setSelected(true);
		contentPane.add(rdbtnFahrenheit);
		
		JLabel lblClothesYouHave = new JLabel("Clothes you have:");
		lblClothesYouHave.setBounds(22, 104, 108, 14);
		contentPane.add(lblClothesYouHave);
		
		JLabel lblLocation = new JLabel("Current location:");
		lblLocation.setBounds(185, 11, 89, 14);
		contentPane.add(lblLocation);
		
		textField = new JTextField();
		textField.setBounds(312, 32, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblclothingList = new JLabel("(clothing list)");
		lblclothingList.setBounds(32, 129, 73, 14);
		contentPane.add(lblclothingList);
		
		
		
		final JLabel lblCity = new JLabel("Charlottesville");
		lblCity.setBounds(312, 11, 99, 14);
		contentPane.add(lblCity);
		
		JLabel lblInputNewLocation = new JLabel("Input new location:");
		lblInputNewLocation.setBounds(185, 35, 108, 14);
		contentPane.add(lblInputNewLocation);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCity.setText(textField.getText());
				
			}
		});
		btnSubmit.setBounds(357, 234, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MainGUI main = MainGUI.getInstance();
					main.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnBack.setBounds(233, 234, 89, 23);
		contentPane.add(btnBack);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCelsius);
		buttonGroup.add(rdbtnFahrenheit);
		
	}
	
	public static synchronized SettingsGUI getInstance()
	{
		if (instance == null)
			instance = new SettingsGUI();

		return instance;
	}
}
