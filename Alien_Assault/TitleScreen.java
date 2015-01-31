package Alien_Intruders;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;





@SuppressWarnings("serial")
public class TitleScreen extends JFrame implements ActionListener
{
	int jFrameWidth = 330;
	static int jFrameHeight = 285;
	int taskbarSize = 40;
	JTextArea controlsLabel;
	JTextField GameLabel, CameronLabel, SamLabel;
	int MINDIFF = 1;
	int MAXDIFF = 5;
	int INIT = 1;
	int SliderValue = 1;
	JButton OKbutton, Closebutton;
	
	Font calibri20 = new Font("Calibri", Font.BOLD, 20);
	static TitleScreen title;
	
	
	public TitleScreen()
	{
		setTitle("Start Screen");
		setSize(jFrameWidth, jFrameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Center JFrame
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		setLocation((d.width - jFrameWidth)/2, (d.height - jFrameHeight)/2); //Place at the bottom middle of screen
		
		
		GameLabel = new JTextField("Alien Assault");
		GameLabel.setHorizontalAlignment(JTextField.CENTER);
		GameLabel.setFont(calibri20);
		GameLabel.setEditable(false);
		
		
		CameronLabel = new JTextField("Design & Coding:    Cameron O'Neil");
		CameronLabel.setFont(calibri20);
		CameronLabel.setEditable(false);
		
		SamLabel = new JTextField    ("Graphics of/by:              Sam Ebe");
		SamLabel.setFont(calibri20);
		SamLabel.setEditable(false);
		
		controlsLabel = new JTextArea("Controls: \nLeft: Left-Arrow or A \nRight: Right-Arrow or D \nLaser Sight: R\nContinuous Fire: B\nToggle Window Border: V\nPause/Play: P \nQuit: Esc");
		controlsLabel.setEditable(false);
		
        
        JPanel jpNorth = new JPanel();
		jpNorth.setLayout(new GridLayout(3,0));
		jpNorth.add(GameLabel);
		jpNorth.add(CameronLabel);
		jpNorth.add(SamLabel);
		
		
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(1,0));
		jpCenter.add(controlsLabel);
		
        
		OKbutton = new JButton("Let's Go");
		Closebutton = new JButton("I can't handle it");
		
		JPanel jpSouth = new JPanel();		
		jpSouth.setLayout(new GridLayout(0,2));
		jpSouth.add(OKbutton);
		jpSouth.add(Closebutton);
		
		//Create Container
//		Container content = getContentPane();
		setLayout(new BorderLayout());
		
		add("North", jpNorth); //Center
		add("Center" , jpCenter);
		add("South", jpSouth); //Center
		
//		setUndecorated(true);
		
		
		OKbutton.addActionListener(this);
		Closebutton.addActionListener(this);
	}
	

	
	public static void main (String Args[])
	{
		title = new TitleScreen();
		title.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		Object source = ae.getSource();
		
		if (source == OKbutton)
		{
			title.setVisible(false);
			
			Main MainScreen = new Main();
			MainScreen.setVisible(true);
			
			title.dispose();
		}
		
		if (source == Closebutton)
		{
			System.exit(0);
		}
	}


	

}