package src.com.MusicRater.gui;

import javax.swing.*;
import java.awt.*;
import src.com.MusicRater.logic.*;

public class MFrame extends JFrame  {

	public MFrame(int width, int height) {
		super();
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		setSize(width, height);

		//centers the frame in the middle of the screen.
		setupDimensions();
		setUIFont(new javax.swing.plaf.FontUIResource(new Font("SansSerif", Font.PLAIN, 15)));
		
		container.add(new SongPanel(new Song("hello", "world")));

		this.add(container);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void setupDimensions() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = d.width / 2;
		int y = d.height / 2 - this.getHeight();
		this.setLocation(x, y);
		this.setLocationRelativeTo(null);
	}

	private static void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
		while(keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, f);
			}
		}
	}

	public static void main(String[] args) {
		new MFrame(900, 600);
	}
}