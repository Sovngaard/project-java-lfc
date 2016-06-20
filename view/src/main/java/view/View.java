package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_A:
				return ControllerOrder.LEVEL1;
			case KeyEvent.VK_B:
				return ControllerOrder.LEVEL2;
			case KeyEvent.VK_C:
				return ControllerOrder.LEVEL3;
			case KeyEvent.VK_D:
				return ControllerOrder.LEVEL4;
			case KeyEvent.VK_E:
				return ControllerOrder.LEVEL5;
			default:
				return ControllerOrder.LEVEL1;
		}
	}

	/*
	 * (non-Javadoc) edr
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	//public void printMessage(final String message) {
		//this.viewFrame.printMessage(message);
	//}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	public void printMessage(String message) {
		// TODO Auto-generated method stub
		
	}
}
