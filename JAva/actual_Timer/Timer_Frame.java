package actual_Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Timer_Frame extends JFrame implements ActionListener {
	
	JButton setTime;
	JButton stopTime;
	Timer_Textfield T;
	JTextField minutes;
	JTextField seconds;
	Thread timing = new Thread(T); 
	boolean going = false;
	public Timer_Frame() {
		//basic button configuration
		setTime = new JButton("Set Time");
		stopTime = new JButton("Stop/Start");
		setTime.addActionListener(this);
		stopTime.addActionListener(this);
		setTime.setPreferredSize(new Dimension(150,75));
		stopTime.setPreferredSize(new Dimension(150,75));
		setTime.setFocusable(false);
		stopTime.setFocusable(false);
		
		//basic frame configuration
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit on X
		this.setSize(700,700);
		this.setBackground(Color.white);
		this.setLayout(new FlowLayout());
		
		//panel declarations and configurations
		T = new Timer_Textfield(650,300);
		JPanel button_border = new JPanel();
		JPanel minSec_Textfields = new JPanel();
		JPanel Timer = new JPanel();
		JPanel Textfields_Buttons = new JPanel();
		minSec_Textfields.setPreferredSize(new Dimension(250,150));
		minSec_Textfields.setLayout(new FlowLayout(FlowLayout.CENTER,15,0));
		button_border.setPreferredSize(new Dimension(250,200));
		button_border.setLayout(new FlowLayout(FlowLayout.CENTER,150,0));
		Timer.setPreferredSize(new Dimension(700,350));
		Timer.setLayout(new FlowLayout(FlowLayout.CENTER));
		Textfields_Buttons.setPreferredSize(new Dimension(700,350));
		Textfields_Buttons.setLayout(new BorderLayout());
		
		//labels for texfield
		JLabel m = new JLabel("Minutes:");
		JLabel s = new JLabel("Seconds:");
		m.setPreferredSize(new Dimension(50,50));
		s.setPreferredSize(new Dimension(50,50));
		
		
		//Textfields
		minutes = new JTextField();
		seconds = new JTextField();
		minutes.setPreferredSize(new Dimension(200,100));
		minutes.setFont(new Font("Helvetica",Font.PLAIN,35));
		seconds.setPreferredSize(new Dimension(200,100));
		seconds.setFont(new Font("Helvetica",Font.PLAIN,35));
		
		//background for panels
		//minSec_Textfields.setBackground(Color.red);
		//button_border.setBackground(Color.green);
		//Timer.setBackground(Color.black);
		//Textfields_Buttons.setBackground(Color.BLUE);
		
		//Adds
		Timer.add(T);
		Textfields_Buttons.add(minSec_Textfields, BorderLayout.NORTH);
		Textfields_Buttons.add(button_border, BorderLayout.SOUTH);
		button_border.add(setTime);
		button_border.add(stopTime);
		minSec_Textfields.add(m);
		minSec_Textfields.add(minutes);
		minSec_Textfields.add(s);
		minSec_Textfields.add(seconds);
		this.add(Timer);
		this.add(Textfields_Buttons);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == setTime) {
			if(timing.isAlive()) {
				timing.interrupt();
			}
			if(Integer.parseInt(seconds.getText()) > 59) {
				seconds.setText("59");
			}
			T.setText(minutes.getText() + ":" + seconds.getText());
		}
		if(e.getSource() == stopTime) {
			if(timing.isAlive()) {
				timing.interrupt();
			}else {
				timing = new Thread(T); 
				timing.start();
			}
			
		}

	}

}
