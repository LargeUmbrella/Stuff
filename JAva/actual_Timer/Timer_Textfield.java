package actual_Timer;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class Timer_Textfield extends JTextField implements Runnable {

	public Timer_Textfield(int x, int y) {
		this.setPreferredSize(new Dimension(x,y));
		this.setFont(new Font("Helvetica",Font.PLAIN,200));
		this.setText("000:00");
		this.setEditable(true);
	}
	
	@Override
	public void run() {
		int minutes =0;
		int seconds =0;
		String[] s =this.getText().split(":");
		minutes =Integer.parseInt(s[0]);
		seconds =Integer.parseInt(s[1]);
		
		while(!Thread.currentThread().isInterrupted() && (seconds + minutes) > 0) {
			if(seconds == 0) {
				minutes--;
				seconds =59;
			}else {
				seconds--;
			}
			this.setText(minutes +":"+ seconds);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
				//e.printStackTrace();
			}
			
		}

	}

}
