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
	private String city = "Charlottesville";
	private boolean isFahrenheit = true;

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
		
		final JRadioButton rdbtnFahrenheit = new JRadioButton("Fahrenheit");
		rdbtnFahrenheit.setBounds(22, 57, 109, 23);
		rdbtnFahrenheit.setSelected(true);
		contentPane.add(rdbtnFahrenheit);
		
		
		
		JLabel lblClothesYouHave = new JLabel("Clothes you have:");
		lblClothesYouHave.setBounds(22, 104, 108, 14);
		contentPane.add(lblClothesYouHave);
		
		JLabel lblLocation = new JLabel("Current location:");
		lblLocation.setBounds(185, 11, 133, 14);
		contentPane.add(lblLocation);
		
		textField = new JTextField();
		textField.setBounds(328, 32, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblclothingList = new JLabel("(clothing list)");
		lblclothingList.setBounds(32, 129, 73, 14);
		contentPane.add(lblclothingList);
		
		
		
		final JLabel lblCity = new JLabel(city);
		lblCity.setBounds(328, 11, 99, 14);
		contentPane.add(lblCity);
		
		JLabel lblInputNewLocation = new JLabel("Input new location:");
		lblInputNewLocation.setBounds(185, 35, 118, 14);
		contentPane.add(lblInputNewLocation);
		
		JButton btnSubmit = new JButton("Submit new location");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCity.setText(textField.getText());
				city = textField.getText();
				isFahrenheit = rdbtnFahrenheit.isSelected();
				
			}
		});
		btnSubmit.setBounds(296, 63, 183, 23);
		contentPane.add(btnSubmit);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					isFahrenheit = rdbtnFahrenheit.isSelected();
					MainGUI main = new MainGUI();
					main.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnOk.setBounds(233, 234, 89, 23);
		contentPane.add(btnOk);
		
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
	
	public String getCity(){
		return city;
	}
	
	public String getUnits(){
		if(isFahrenheit){
			return "imperial";
		} else {
			return "metric";
		}
	}
}
