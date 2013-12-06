package cs4240f13.hoowhatyouwearing.gui;
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

import javax.swing.JTextArea;

import cs4240f13.hoowhatyouwearing.objects.Article;
import cs4240f13.hoowhatyouwearing.objects.ClothingList;
import cs4240f13.hoowhatyouwearing.objects.User;


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
		final User user = User.getContext();
		
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
		
		
		
		final JLabel lblCity = new JLabel(user.getLocation());
		lblCity.setBounds(328, 11, 99, 14);
		contentPane.add(lblCity);
		
		JLabel lblInputNewLocation = new JLabel("Input new location:");
		lblInputNewLocation.setBounds(185, 35, 118, 14);
		contentPane.add(lblInputNewLocation);
		
		JButton btnSubmit = new JButton("Submit new location");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCity.setText(textField.getText());
				user.setLocation(textField.getText());
				if (rdbtnFahrenheit.isSelected()) {
					user.setTemperatureUnit("fahrenheit"); 
				}
				else {
					user.setTemperatureUnit("celcius");
				}
			}
		});
		btnSubmit.setBounds(296, 63, 183, 23);
		contentPane.add(btnSubmit);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (rdbtnFahrenheit.isSelected()) {
						user.setTemperatureUnit("fahrenheit"); 
					}
					else {
						user.setTemperatureUnit("celcius");
					}
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
		

		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 164, 118, 104);
		contentPane.add(textArea);
		textArea.setEditable(false);
		textArea.setText(getClothing().listClothing());
	}
	
	public static synchronized SettingsGUI getInstance()
	{
		if (instance == null)
			instance = new SettingsGUI();

		return instance;
	}
	
	public static ClothingList getClothing(){
		ClothingList clothing = new ClothingList();
		clothing.addClothing(Article.ArticleType.TOP, Article.Clothing.TSHIRT);
		clothing.addClothing(Article.ArticleType.TOP, Article.Clothing.LONGSLEEVET);
		clothing.addClothing(Article.ArticleType.OUTERWEAR, Article.Clothing.SWEATER);
		clothing.addClothing(Article.ArticleType.OUTERWEAR, Article.Clothing.WINTERJACKET);
		clothing.addClothing(Article.ArticleType.RAINGEAR, Article.Clothing.RAINJACKET);
		clothing.addClothing(Article.ArticleType.BOTTOMS, Article.Clothing.SHORTS);
		clothing.addClothing(Article.ArticleType.BOTTOMS, Article.Clothing.PANTS);
		clothing.addClothing(Article.ArticleType.FOOTWEAR, Article.Clothing.FLIPFLOPS);
		clothing.addClothing(Article.ArticleType.FOOTWEAR, Article.Clothing.SHOES);
		return clothing;
	}
}
