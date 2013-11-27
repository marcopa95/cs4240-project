import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;


public class MainGUI extends JFrame {

	private JPanel contentPane;

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
	 */
	public MainGUI() {
		initialize();
	}
	
	private void initialize(){
		setTitle("HooWhat You Wearing?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTodaysWeather = new JLabel("Today's weather:");
		lblTodaysWeather.setBounds(30, 11, 84, 14);
		contentPane.add(lblTodaysWeather);
		
		JLabel lblcurrentTemp = new JLabel("(current temp)");
		lblcurrentTemp.setBounds(22, 39, 70, 14);
		contentPane.add(lblcurrentTemp);
		
		JLabel lblunits = new JLabel("(units)");
		lblunits.setBounds(102, 39, 31, 14);
		contentPane.add(lblunits);
		
		JLabel lbldescription = new JLabel("(description)");
		lbldescription.setBounds(30, 64, 62, 14);
		contentPane.add(lbldescription);
		
		JLabel label = new JLabel("(current temp)");
		label.setBounds(10, 158, 70, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("(units)");
		label_1.setBounds(90, 158, 31, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("(description)");
		label_2.setBounds(18, 183, 62, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("(current temp)");
		label_3.setBounds(145, 158, 70, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("(units)");
		label_4.setBounds(225, 158, 31, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("(description)");
		label_5.setBounds(153, 183, 62, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("(current temp)");
		label_6.setBounds(275, 158, 70, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("(units)");
		label_7.setBounds(355, 158, 31, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("(description)");
		label_8.setBounds(283, 183, 62, 14);
		contentPane.add(label_8);
		
		JLabel lbldayForecast = new JLabel("3-day forecast");
		lbldayForecast.setBounds(30, 133, 84, 14);
		contentPane.add(lbldayForecast);
		
		JLabel lblday = new JLabel("(Day 1)");
		lblday.setBounds(41, 208, 46, 14);
		contentPane.add(lblday);
		
		JLabel lblday_1 = new JLabel("(Day 2)");
		lblday_1.setBounds(163, 208, 46, 14);
		contentPane.add(lblday_1);
		
		JLabel lblday_2 = new JLabel("(Day 3)");
		lblday_2.setBounds(299, 208, 46, 14);
		contentPane.add(lblday_2);
		
		JLabel lblYouShouldWear = new JLabel("You should wear:");
		lblYouShouldWear.setBounds(225, 11, 104, 14);
		contentPane.add(lblYouShouldWear);
		
		JLabel lblclothingToWear = new JLabel("(clothing to wear)");
		lblclothingToWear.setBounds(225, 39, 104, 14);
		contentPane.add(lblclothingToWear);
		
		JPanel panel = new JPanel();
		panel.setBounds(210, 68, 119, 79);
		contentPane.add(panel);
		
		JLabel lblpicturesOfClothing = new JLabel("(pictures of clothing)");
		panel.add(lblpicturesOfClothing);
		
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
}
