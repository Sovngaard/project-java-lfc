package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

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
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
		//graphics.drawImage(this.getViewFrame().getModel().HerogetImage(), this.getViewFrame().getModel().HerogetX()*64, this.getViewFrame().getModel().HerogetY()*64, 64, 64, viewFrame);
	
	for(int y=0 ; y<12 ; y++)
	{
		for(int x=0; x<20 ; x++)
		{
			graphics.drawImage(this.getViewFrame().getModel().ElementFixegetImage(x, y), x*64, y*64, 64, 64, viewFrame);
		}
	}
	graphics.drawImage(this.getViewFrame().getModel().HerogetImage(), this.getViewFrame().getModel().HerogetX()*64, this.getViewFrame().getModel().HerogetY()*64, 64, 64, viewFrame);
	} 
}