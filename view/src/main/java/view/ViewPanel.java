package view;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
//extend model.Model;


/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
    public int i= 2;
	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {

		int cpt = 0;
	
		graphics.setColor(Color.BLACK);
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(Color.red);
		graphics.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
		String message = "11111111111111111111111111B!B!!!!!!!!!B1111B!!B1-111111111BB111-1111-1111111111-B!!B1111-11P1111111--1P1B!!!B!!!!!!B111B-P11P1111111S1111X1C-1P1B!!!B!!!!!!B111BB!!B1111-11P1111111-111-1111-1111111111-111B!!B1-111111111BB111111B!B!!!!!!!!!B111111111111111111111";
		char ch[] = message.toCharArray();
		
		
		for(int y = 0; y < 12; y++)
        {
			for(int x = 0; x < 20; x++)
            {
				try {
					graphics.drawImage(getViewFrame().getModel().pik(ch[cpt]), x*64, y*64, 64, 64, this.getViewFrame());

                 // TODO Auto-generated catch block 

                    } catch (IOException e) {
                        	e.printStackTrace();
                    }
				cpt++; 
                        
            }
        }}
}	

