package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
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
		Thread anime = new Thread(new animLorann());
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		anime.start();
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
	
	for(int y=0 ; y<12 ; y++)
	{
		for(int x=0; x<20 ; x++)
		{
			graphics.drawImage(this.getViewFrame().getModel().ElementFixegetImage(x, y), x*64, y*64, 64, 64, viewFrame);
		}
	}
	graphics.drawImage(this.getViewFrame().getModel().LoranngetImage(), this.getViewFrame().getModel().LoranngetX()*64, this.getViewFrame().getModel().LoranngetY()*64, 64, 64, viewFrame);
	}
	class animLorann implements Runnable{

		  public void run() {
		   int n=0;
		   Image img = null; 
		   while(true){
		    switch(n%8){
		    case 0:
		    	//System.out.println("test 0");
		     try {
		      img = ImageIO.read(new File("sprite/lorann_bl.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		    case 1:
		    	//System.out.println("test 1");
		     try {
		      img = ImageIO.read(new File("sprite/lorann_b.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		     
		    case 2 : 
		     try {
		      img = ImageIO.read(new File("sprite/lorann_br.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		     
		    case 3 : 
		     try {
		      img = ImageIO.read(new File("sprite/lorann_r.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		    
		    case 4 :
		     try {
		      img = ImageIO.read(new File("sprite/lorann_ur.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		     
		    case 5 : 
		     try {
		      img = ImageIO.read(new File("sprite/lorann_u.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		     
		    case 6:
		     try {
		      img = ImageIO.read(new File("sprite/lorann_ul.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		     
		    case 7 :
		     try {
		      img = ImageIO.read(new File("sprite/lorann_l.png"));
		     } catch (IOException e1) {e1.printStackTrace();}
		     getViewFrame().getModel().LorannsetImage(img);
		     break;
		    
		    }
		    n++;
		    //System.out.println("test 2");
		    try {
		     Thread.sleep(100);
		    } catch (InterruptedException e) {
		     e.printStackTrace();
		    }
		    //System.out.println("test 3");
		    repaint(0,0,getWidth(),getHeight());
		   }
		  }
		  
		 }
}
