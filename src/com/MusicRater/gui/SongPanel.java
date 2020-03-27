package src.com.MusicRater.gui;

import java.awt.*;

import javax.swing.*;
import src.com.MusicRater.logic.*;

public class SongPanel extends JPanel {

	JLabel sTitle, sArtist, sRating;

	public SongPanel(Song s) {
		JPanel songStack = new JPanel();
		songStack.setLayout(new BoxLayout(songStack, BoxLayout.Y_AXIS));

		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		songStack.setBorder(BorderFactory.createLineBorder(Color.black));

		sTitle = new JLabel(s.title());
		sArtist = new JLabel(s.artist());
		sRating = new JLabel(s.rating().toString());

		sRating.setSize(120, 120);
		songStack.setSize(480, 120);

		sRating.setBorder(BorderFactory.createLineBorder(Color.black));
		sTitle.setFont(new Font(sTitle.getFont().getName(), Font.BOLD, (int) (sTitle.getFont().getSize() * 1.5)));
		sRating.setFont(new Font(sTitle.getFont().getName(), Font.BOLD, sTitle.getFont().getSize() * 2));
		songStack.add(sTitle);
		songStack.add(sArtist);

		sTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		sArtist.setAlignmentX(Component.LEFT_ALIGNMENT);

		this.setLayout(new BorderLayout(5, 5));
		this.setMaximumSize(new Dimension(480, 60));
		
		this.setSize(480, 120);
		this.add(songStack, BorderLayout.WEST);
		this.add(sRating, BorderLayout.EAST);
	}
}