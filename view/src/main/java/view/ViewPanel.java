package view;

import java.awt.Color;
import java.awt.Graphics;
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
		graphics.setColor(Color.BLACK);
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(Color.red);
		graphics.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
		
		for(int y = 0; y < 12; y++)
        {
     for(int x = 0; x < 20; x++)
                        {
                                       
          Object cpt;
		try {
                                                      
           graphics.drawImage(getViewFrame().getModel().sld(cpt), x*64, y*64, 64, 64, this.getViewFrame());
              } catch (IOException e) {
                 // TODO Auto-generated catch block
                      e.printStackTrace();
                                       
                  }cpt++;
                                       
                        }
     }
        }

		//try {
            //graphics.drawImage(ImageIO.read(new File("sprite/bone.png")), 205, 7, this.getViewFrame());
            //graphics.drawImage(ImageIO.read(new File("sprite/horizontal_bone.png")), 238, 7, this.getViewFrame());
            //graphics.drawImage(ImageIO.read(new File("sprite/bone.png")), 271, 7, this.getViewFrame());
            
            //     } catch (IOException e) {
           // e.printStackTrace();
      }
		
		
	
//}
		

