package controller;

import java.awt.Image;//libraires java
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		this.view.printMessage("'HAUT', ' BAS', 'GAUCHE' ou 'DROITE', afin de bouger");
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
		Image img = null;
		switch (controllerOrder) {
		case Up:
			this.model.MoveUp();//permet de bouger vers le haut
			this.view.ReUpdate();//update sprite lorann
			
			break;//faire une pause en attendant l'instruction suivante
		
		case Down:
			
			this.model.MoveDown();//permet de bouger vers le bas
			this.view.ReUpdate();//update sprite lorann
			
			break;
		
		case Right:
			this.model.MoveRight();//permet de bouger vers la droite
			this.view.ReUpdate();//update sprite lorann
			break;
		
		case Left:
			this.model.MoveLeft();//permet de bouger vers la gauche
			this.view.ReUpdate();//update sprite lorann
			
			break;
		

		default:
			try {img =ImageIO.read(new File("sprite/lorann_l.png"));//lire le sprite de lorann
			} catch (IOException e) {e.printStackTrace();}
				this.model.LorannsetImage(img);//initialise l'image de LORANN
				this.view.ReUpdate();//update sprite lorann
			break;
		}
	}

}
