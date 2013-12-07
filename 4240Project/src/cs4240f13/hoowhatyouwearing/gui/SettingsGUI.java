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
import cs4240f13.hoowhatyouwearing.objects.Article.ArticleType;
import cs4240f13.hoowhatyouwearing.objects.Article.Clothing;
import cs4240f13.hoowhatyouwearing.objects.ClothingList;
import cs4240f13.hoowhatyouwearing.objects.User;

import javax.swing.JCheckBox;


public class SettingsGUI extends JFrame {

	private static SettingsGUI instance;
	private JPanel contentPane;
	private JTextField textField;
	private static ClothingList clothing = new ClothingList();

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
		lblClothesYouHave.setBounds(22, 87, 108, 14);
		contentPane.add(lblClothesYouHave);
		
		
		JLabel lblLocation = new JLabel("Current location:");
		lblLocation.setBounds(185, 11, 133, 14);
		contentPane.add(lblLocation);
		
		textField = new JTextField();
		textField.setBounds(328, 32, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
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
		btnSubmit.setBounds(323, 63, 156, 23);
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
		btnOk.setBounds(408, 263, 89, 23);
		contentPane.add(btnOk);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCelsius);
		buttonGroup.add(rdbtnFahrenheit);
		

		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 113, 188, 173);
		contentPane.add(textArea);
		textArea.setEditable(false);
		textArea.setText(clothing.listClothing());
		
		final JCheckBox chckbxTshirt = new JCheckBox("T-shirt");
		chckbxTshirt.setBounds(204, 114, 97, 23);
		contentPane.add(chckbxTshirt);
		
		
		final JCheckBox chckbxLongSleeveT = new JCheckBox("Long Sleeve T");
		chckbxLongSleeveT.setBounds(204, 138, 97, 23);
		contentPane.add(chckbxLongSleeveT);
		
		JLabel lblTops = new JLabel("Tops");
		lblTops.setBounds(208, 102, 46, 14);
		contentPane.add(lblTops);
		
		JLabel lblOuterwear = new JLabel("Outerwear");
		lblOuterwear.setBounds(208, 165, 62, 14);
		contentPane.add(lblOuterwear);
		
		final JCheckBox chckbxSweater = new JCheckBox("Sweater");
		chckbxSweater.setBounds(204, 179, 97, 23);
		contentPane.add(chckbxSweater);
		
		final JCheckBox chckbxWinterJacket = new JCheckBox("Winter Jacket");
		chckbxWinterJacket.setBounds(204, 205, 97, 23);
		contentPane.add(chckbxWinterJacket);
		
		JLabel lblRainGear = new JLabel("Rain Gear");
		lblRainGear.setBounds(208, 231, 62, 14);
		contentPane.add(lblRainGear);
		
		final JCheckBox chckbxRainJacket = new JCheckBox("Rain Jacket");
		chckbxRainJacket.setBounds(204, 242, 97, 23);
		contentPane.add(chckbxRainJacket);
		
		JLabel lblBottoms = new JLabel("Bottoms");
		lblBottoms.setBounds(307, 102, 46, 14);
		contentPane.add(lblBottoms);
		
		final JCheckBox chckbxPants = new JCheckBox("Pants");
		chckbxPants.setBounds(303, 114, 108, 23);
		contentPane.add(chckbxPants);
		
		final JCheckBox chckbxShorts = new JCheckBox("Shorts");
		chckbxShorts.setBounds(303, 138, 97, 23);
		contentPane.add(chckbxShorts);
		
		JLabel lblFootwear = new JLabel("Footwear");
		lblFootwear.setBounds(307, 165, 46, 14);
		contentPane.add(lblFootwear);
		
		final JCheckBox chckbxFlipflops = new JCheckBox("Flip-Flops");
		chckbxFlipflops.setBounds(303, 179, 97, 23);
		contentPane.add(chckbxFlipflops);
		
		final JCheckBox chckbxShoes = new JCheckBox("Shoes");
		chckbxShoes.setBounds(303, 205, 97, 23);
		contentPane.add(chckbxShoes);
		
		JLabel lblAddremoveClothes = new JLabel("Add/Remove Clothes");
		lblAddremoveClothes.setBounds(208, 87, 110, 14);
		contentPane.add(lblAddremoveClothes);
		
		JButton btnSubmitClothes = new JButton("Submit Clothes");
		btnSubmitClothes.setBounds(307, 231, 120, 23);
		contentPane.add(btnSubmitClothes);
		btnSubmitClothes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (chckbxTshirt.isSelected() && !(clothing.containsClothing(ArticleType.TOP, Clothing.TSHIRT))){
						 clothing.addClothing(ArticleType.TOP, Clothing.TSHIRT);
					}
					if (chckbxLongSleeveT.isSelected() && !(clothing.containsClothing(ArticleType.TOP, Clothing.LONGSLEEVET))){
						 clothing.addClothing(ArticleType.TOP, Clothing.LONGSLEEVET);
					}
					if (chckbxSweater.isSelected() && !(clothing.containsClothing(ArticleType.OUTERWEAR, Clothing.SWEATER))){
						 clothing.addClothing(ArticleType.OUTERWEAR, Clothing.SWEATER);
					}
					if(chckbxWinterJacket.isSelected() && !(clothing.containsClothing(ArticleType.OUTERWEAR, Clothing.WINTERJACKET))){
						clothing.addClothing(ArticleType.OUTERWEAR, Clothing.WINTERJACKET);
					}
					if(chckbxRainJacket.isSelected() && !(clothing.containsClothing(ArticleType.RAINGEAR, Clothing.RAINJACKET))){
						clothing.addClothing(ArticleType.RAINGEAR, Clothing.RAINJACKET);
					}
					if(chckbxShorts.isSelected() && !(clothing.containsClothing(ArticleType.BOTTOMS, Clothing.SHORTS))){
						clothing.addClothing(ArticleType.BOTTOMS, Clothing.SHORTS);
					}
					if(chckbxPants.isSelected() && !(clothing.containsClothing(ArticleType.BOTTOMS, Clothing.PANTS))){
						clothing.addClothing(ArticleType.BOTTOMS, Clothing.PANTS);
					}
					if(chckbxFlipflops.isSelected() && !(clothing.containsClothing(ArticleType.FOOTWEAR, Clothing.FLIPFLOPS))){
						clothing.addClothing(ArticleType.FOOTWEAR, Clothing.FLIPFLOPS);
					}
					if(chckbxShoes.isSelected() && !(clothing.containsClothing(ArticleType.FOOTWEAR, Clothing.SHOES))){
						clothing.addClothing(ArticleType.FOOTWEAR, Clothing.SHOES);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static synchronized SettingsGUI getInstance()
	{
		if (instance == null)
			instance = new SettingsGUI();

		return instance;
	}
	
	
	public static ClothingList getClothing(){
//		ClothingList clothing = new ClothingList();
//		clothing.addClothing(Article.ArticleType.TOP, Article.Clothing.TSHIRT);
//		clothing.addClothing(Article.ArticleType.TOP, Article.Clothing.LONGSLEEVET);
//		clothing.addClothing(Article.ArticleType.OUTERWEAR, Article.Clothing.SWEATER);
//		clothing.addClothing(Article.ArticleType.OUTERWEAR, Article.Clothing.WINTERJACKET);
//		clothing.addClothing(Article.ArticleType.RAINGEAR, Article.Clothing.RAINJACKET);
//		clothing.addClothing(Article.ArticleType.BOTTOMS, Article.Clothing.SHORTS);
//		clothing.addClothing(Article.ArticleType.BOTTOMS, Article.Clothing.PANTS);
//		clothing.addClothing(Article.ArticleType.FOOTWEAR, Article.Clothing.FLIPFLOPS);
//		clothing.addClothing(Article.ArticleType.FOOTWEAR, Article.Clothing.SHOES);
		return clothing;
	}
}
