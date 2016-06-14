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
		this.view.printMessage("Push keys 'E', 'F', 'D','I' or 'M' to choose a level from 1 to 5");
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
			case English:
				this.model.loadMessage("GB");
				break;
			case Francais:
				this.model.loadMessage("FR");
				break;
			case Deutsch:
				this.model.loadMessage("DE");
				break;
			case Indonesia:
				this.model.loadMessage("ID");
				break;
			case Magreb:
				this.model.loadMessage("MA");
				break;

			default:
				break;
		}
	}

}
