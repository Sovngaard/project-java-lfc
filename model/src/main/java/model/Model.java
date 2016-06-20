package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import javax.imageio.ImageIO;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;
	private Image img;
	private  char ch[];

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public Image pik(int cpt) throws IOException{
		
		switch (cpt) {

		case 'X' : 
			img = ImageIO.read(new File("sprite/lorann_l.png"));
			break;
		case '1' :
			img = ImageIO.read(new File("sprite/Background.png"));
			break;
		case 'B' :
			img = ImageIO.read(new File("sprite/bone.png"));
			break;
		case '!' :
			img = ImageIO.read(new File("sprite/horizontal_bone.png"));
			break;
		case '-' :
			img = ImageIO.read(new File("sprite/vertical_bone.png"));
			break;
		case 'P' : 
			img = ImageIO.read(new File("sprite/purse.png"));
			break;
		case 'C' :
			img = ImageIO.read(new File("sprite/gate_closed.png"));
			break;
		case 'S' :
			img = ImageIO.read(new File("sprite/Crystal_ball.png	"));
			break;
		default :
			img = ImageIO.read(new File("sprite/lorann_l.png"));
		
		
	}
		return img;
}

	public Image sld(Object cpt) {
		// TODO Auto-generated method stub
		return null;
	}}
