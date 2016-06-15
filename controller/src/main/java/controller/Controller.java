package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc) test test test 
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Press key 'E', 'F', 'D','I' or 'M' to choose a level from 1 to 5");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case LEVEL1:
				this.model.loadMessage("AA");
				break;
			case LEVEL2:
				this.model.loadMessage("2");
				break;
			case LEVEL3:
				this.model.loadMessage("3");
				break;
			case LEVEL4:
				this.model.loadMessage("4");
				break;
			case LEVEL5:
				this.model.loadMessage("5");
				break;

			default:
				break;
		}
	}

}
