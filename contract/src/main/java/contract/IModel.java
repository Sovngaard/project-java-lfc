package contract;

import java.awt.Image;
import java.io.IOException;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {//

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	//Image pik(int cpt) throws IOException;

	void cpt(int i);

	int HerogetX();
	int HerogetY();
	Image HerogetImage();
	void HerosetX(int x);
	void HerosetY(int y);
	void HerosetImage(Image img);
	Image ElementFixegetImage(int x, int y);
	boolean ElementFixegetPenetrable(int x,int y);
	boolean ElementFixegetRecuperable(int x,int y);
	void ElementFixedisableSprite(int x,int y);
	void MoveRight();
	void MoveLeft();
	void MoveUp();
	void MoveDown();
	

}
