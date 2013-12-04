package cs4240f13.hoowhatyouwearing.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cs4240f13.hoowhatyouwearing.utility.JsonParser;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private static MainGUI instance;
	private JPanel contentPane;
	private String strCity;
	private String settingsUnits;
	
	private String forecastURL;
	private String descURL;

	private String strCurrentTemp;
	private String strUnits;
	private String strDesc;
	private String strTodaysHigh;
	private String strTodaysLow;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedEncodingException 
	 */
	public MainGUI() throws UnsupportedEncodingException {
		strCity = SettingsGUI.getInstance().getCity();
		settingsUnits = SettingsGUI.getInstance().getUnits();
		forecastURL = "http://api.openweathermap.org/data/2.5/forecast/daily?q=" + URLEncoder.encode(strCity,"utf-8") + "&mode=json&units=" + settingsUnits + "&cnt=3";
		descURL = "http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(strCity,"utf-8") + "&mode=json&units=" + settingsUnits;
		strCurrentTemp = JsonParser.getCurrentTemp(descURL);
		strUnits = JsonParser.getCorF(descURL);
		strDesc = JsonParser.getCurrentDescription(descURL);
		strTodaysHigh = JsonParser.getTodaysHigh(descURL);
		strTodaysLow = JsonParser.getTodaysLow(descURL);
		
		initialize();
	}
	
	private String getLowHighTemp(int day, String minOrMax, String url){
		return JsonParser.getLowHigh(day,minOrMax,url);
	}
	
	private String getDayDescription(int day, String url){
		return JsonParser.getForecastDescriptions(day,url);
	}
	
	private void initialize(){
		setTitle("HooWhat You Wearing?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurrentWeather = new JLabel("Current weather for:");
		lblCurrentWeather.setBounds(30, 11, 124, 14);
		contentPane.add(lblCurrentWeather);
		
		JLabel lblCity = new JLabel(strCity);
		lblCity.setBounds(164, 11, 91, 14);
		contentPane.add(lblCity);
		
		JLabel lblCurrentTemp = new JLabel(strCurrentTemp);
		lblCurrentTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentTemp.setBounds(61, 39, 65, 14);
		contentPane.add(lblCurrentTemp);
		
		JLabel lblCurrentUnits = new JLabel(strUnits);
		lblCurrentUnits.setBounds(139, 39, 88, 14);
		contentPane.add(lblCurrentUnits);
		
		JLabel lblCurrentDescription = new JLabel(strDesc);
		lblCurrentDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentDescription.setBounds(30, 64, 176, 14);
		contentPane.add(lblCurrentDescription);
		
		JLabel lblOneHighUnits = new JLabel(strUnits);
		lblOneHighUnits.setBounds(177, 251, 70, 14);
		contentPane.add(lblOneHighUnits);
		
		JLabel lblOneDescription = new JLabel(getDayDescription(1, forecastURL));
		lblOneDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblOneDescription.setBounds(81, 297, 184, 14);
		contentPane.add(lblOneDescription);
		
		JLabel lblTwoDescription = new JLabel(getDayDescription(2, forecastURL));
		lblTwoDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwoDescription.setBounds(293, 297, 184, 14);
		contentPane.add(lblTwoDescription);
		
		JLabel lblThreeDescription = new JLabel(getDayDescription(3, forecastURL));
		lblThreeDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblThreeDescription.setBounds(487, 297, 184, 14);
		contentPane.add(lblThreeDescription);
		
		JLabel lblThreeDayForecast = new JLabel("3-day forecast");
		lblThreeDayForecast.setBounds(256, 199, 84, 14);
		contentPane.add(lblThreeDayForecast);
		
		JLabel lblDayOne = new JLabel("(Day 1)");
		lblDayOne.setBounds(151, 322, 46, 14);
		contentPane.add(lblDayOne);
		
		JLabel lblDayTwo = new JLabel("(Day 2)");
		lblDayTwo.setBounds(365, 322, 46, 14);
		contentPane.add(lblDayTwo);
		
		JLabel lblDayThree = new JLabel("(Day 3)");
		lblDayThree.setBounds(558, 322, 46, 14);
		contentPane.add(lblDayThree);
		
		JLabel lblYouShouldWear = new JLabel("You should wear:");
		lblYouShouldWear.setBounds(556, 11, 104, 14);
		contentPane.add(lblYouShouldWear);
		
		JLabel lblclothingToWear = new JLabel("(clothing to wear)");
		lblclothingToWear.setBounds(556, 39, 104, 14);
		contentPane.add(lblclothingToWear);
		
		JPanel panel = new JPanel();
		panel.setBounds(541, 68, 119, 79);
		contentPane.add(panel);
		
		JLabel lblpicturesOfClothing = new JLabel("(pictures of clothing)");
		panel.add(lblpicturesOfClothing);
		
		JLabel lblOneHigh = new JLabel(getLowHighTemp(1,"max",forecastURL));
		lblOneHigh.setBounds(97, 251, 70, 14);
		contentPane.add(lblOneHigh);
		
		JLabel lblOneLow = new JLabel(getLowHighTemp(1,"min",forecastURL));
		lblOneLow.setBounds(97, 272, 70, 14);
		contentPane.add(lblOneLow);
		
		JLabel lblOneLowUnits = new JLabel(strUnits);
		lblOneLowUnits.setBounds(177, 276, 77, 14);
		contentPane.add(lblOneLowUnits);
		
		JLabel lblTwoHigh = new JLabel(getLowHighTemp(2,"max",forecastURL));
		lblTwoHigh.setBounds(313, 251, 70, 14);
		contentPane.add(lblTwoHigh);
		
		JLabel lblTwoLow = new JLabel(getLowHighTemp(2,"min",forecastURL));
		lblTwoLow.setBounds(313, 272, 70, 14);
		contentPane.add(lblTwoLow);
		
		JLabel lblTwoHighUnits = new JLabel(strUnits);
		lblTwoHighUnits.setBounds(393, 251, 84, 14);
		contentPane.add(lblTwoHighUnits);
		
		JLabel lblTwoLowUnits = new JLabel(strUnits);
		lblTwoLowUnits.setBounds(393, 272, 65, 14);
		contentPane.add(lblTwoLowUnits);
		
		JLabel lblThreeHigh = new JLabel(getLowHighTemp(3,"max",forecastURL));
		lblThreeHigh.setBounds(521, 251, 70, 14);
		contentPane.add(lblThreeHigh);
		
		JLabel lblThreeLow = new JLabel(getLowHighTemp(3,"min",forecastURL));
		lblThreeLow.setBounds(521, 272, 70, 14);
		contentPane.add(lblThreeLow);
		
		JLabel lblThreeHighUnits = new JLabel(strUnits);
		lblThreeHighUnits.setBounds(601, 251, 70, 14);
		contentPane.add(lblThreeHighUnits);
		
		JLabel lblThreeLowUnits = new JLabel(strUnits);
		lblThreeLowUnits.setBounds(601, 272, 66, 14);
		contentPane.add(lblThreeLowUnits);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SettingsGUI settings = SettingsGUI.getInstance();
					settings.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSettings.setBounds(556, 433, 89, 23);
		contentPane.add(btnSettings);
		
		JLabel lblTodaysHigh = new JLabel("Today's high:");
		lblTodaysHigh.setBounds(262, 39, 77, 14);
		contentPane.add(lblTodaysHigh);
		
		JLabel lblTodaysLow = new JLabel("Today's low:");
		lblTodaysLow.setBounds(261, 64, 79, 14);
		contentPane.add(lblTodaysLow);
		
		JLabel lblTodaysHighUnits = new JLabel(strUnits);
		lblTodaysHighUnits.setBounds(413, 39, 84, 14);
		contentPane.add(lblTodaysHighUnits);
		
		JLabel lblTodaysLowUnits = new JLabel(strUnits);
		lblTodaysLowUnits.setBounds(413, 64, 84, 14);
		contentPane.add(lblTodaysLowUnits);
		
		JLabel lblTodaysHighTemp = new JLabel(strTodaysHigh);
		lblTodaysHighTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodaysHighTemp.setBounds(341, 39, 52, 14);
		contentPane.add(lblTodaysHighTemp);
		
		JLabel lblTodaysLowTemp = new JLabel(strTodaysLow);
		lblTodaysLowTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodaysLowTemp.setBounds(341, 64, 52, 14);
		contentPane.add(lblTodaysLowTemp);
		
		JLabel lblHighs = new JLabel("Highs:");
		lblHighs.setBounds(10, 251, 46, 14);
		contentPane.add(lblHighs);
		
		JLabel lblLows = new JLabel("Lows:");
		lblLows.setBounds(10, 272, 46, 14);
		contentPane.add(lblLows);
		

		
		/*BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("img/"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	public static synchronized MainGUI getInstance() throws UnsupportedEncodingException
	{
		if (instance == null)
			instance = new MainGUI();

		return instance;
	}
}
