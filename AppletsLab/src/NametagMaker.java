import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;

/**
 * Generates fake nametags for the Olympics using Swing components in an 
 * in-browser Java applet.
 * 
 * @author Jamison Bryant <jbryan46@montgomerycollege.edu>
 */
public class NametagMaker extends JApplet {
	public void init() {
		setSize(new Dimension(300, 360));
	}
	
	public void paint(Graphics g) {
		Graphics2D drawing = (Graphics2D) g;
		FontMetrics metrics = drawing.getFontMetrics();
		
		// Define ring size/placement parameters
		int ringDiameter = 75;
		int ringHspace = 15;
		int ringVspace = 40;
		int ringStartX = (getWidth() / 2) - ((3 * ringDiameter) / 2) - ringHspace;
		int ringStartY = getHeight() / 15;
		
		drawing.setStroke(new BasicStroke(3.0f));
		
		// Draw bounding rectangle
		drawing.drawRect(ringStartX / 2, ringStartY / 2, 
			getWidth() - ringStartX, getHeight() - ringStartY);
		
		// Draw blue ring
		drawing.setColor(Color.blue);
		drawing.drawOval(ringStartX, ringStartY, ringDiameter, ringDiameter);		
		
		// Draw black ring
		drawing.setColor(Color.black);
		drawing.drawOval(ringStartX + ringHspace + ringDiameter, 
			ringStartY, ringDiameter, ringDiameter);
		
		// Draw red ring
		drawing.setColor(Color.red);
		drawing.drawOval(ringStartX + (2 * ringHspace) + (2 * ringDiameter), 
			ringStartY, ringDiameter, ringDiameter);
		
		// Draw yellow ring
		drawing.setColor(Color.yellow);
		drawing.drawOval(ringStartX + (ringDiameter / 2) + (ringHspace / 2),
			ringStartY + ringVspace, ringDiameter, ringDiameter);
		
		// Draw green ring
		drawing.setColor(Color.green);
		drawing.drawOval(
			ringStartX + ((3 * ringHspace) / 2) + ((3 * ringDiameter) / 2), 
				ringStartY + ringVspace, ringDiameter, ringDiameter);
		
		drawing.setColor(Color.black);
		drawing.setFont(new Font("Arial", Font.PLAIN, 15));
		
		// Draw name
		String name = "Jamison Bryant";
		drawing.drawString(name, (getWidth() - metrics.stringWidth(name)) / 2, 
			(7 * ringStartY) + metrics.getHeight());
		
		// Draw activity
		String activity = "Cat Herding";
		drawing.drawString(activity, 
			(getWidth() - metrics.stringWidth(activity)) / 2, 
				(7 * ringStartY) + (2 * metrics.getHeight()));
		
		// Draw location
		String location = "Gaithersburg, MD";
		drawing.drawString(location, 
			(getWidth() - metrics.stringWidth(location)) / 2, 
				(7 * ringStartY) + (3 * metrics.getHeight()));
		
		// Add flag image
		BufferedImage flag = null;
		
		try {
			flag = ImageIO.read(this.getClass().getResource("flag.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		drawing.drawImage((Image) flag, (getWidth() - flag.getWidth()) / 2, 
			(10 * ringStartY), this);
		
		// Add country name
		String country = "USA";
		drawing.drawString(country, 
			(getWidth() - metrics.stringWidth(country)) / 2, 
			(10 * ringStartY) + flag.getHeight() + 
				(2 * metrics.getHeight()));
	}
}