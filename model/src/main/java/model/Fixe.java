package model;

import java.awt.Image; //les différentes librairies
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Fixe {
	private int id;
	private int x;
	private int y;
	private Image img; 
	private boolean Penetrable = false;	//boolean permet de savoir si oui ou non on peut faire une action
	private boolean Pickable = false;//objet ramassable
	Fixe(int x,int y,Image img, boolean Penetrable , boolean Recuperable, int id)
	{	this.img = null;
		this.id =id;
		this.x = x;
		this.y = y ;
		this.img = img;//récupération des images
		this.Penetrable = Penetrable;
		this.Pickable = Recuperable;
		
	}
	
	Fixe()
	{
		System.out.println("Erreur de la classe FIXE pour les objets");//voir si la classe bug
	}

	public int getX() {//get : sert à récupérer les coordonnées de l affichage
		return x;
	}
	public void setX(int x) {// set pour placer un objet
		this.x = this.x+x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = this.y + y;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public void setPenetrableON()//savoir si l objet est pénétrable ou non
	{
		Penetrable =true;		
	}
	public void setPenetrableOFF()
	{
		Penetrable =false;
	}
	public void setPickableON()
	{
		Pickable = true;
	}
	public void setPickableOFF()
	{
		Pickable = false;
	}
	public boolean getPenetrable(){
		
		return Penetrable;
	}
	public boolean Pickable(){
		
		return Pickable;
	}
	public int getid()//identifier les élèments créeés
	{
		return id;
	}
	public int disableSprite()
	{
		try {
			img = ImageIO.read(new File("sprite/NoSprite.png"));//sprite nul pour le fond noir
		} catch (IOException e) {e.printStackTrace();}
		return id;
		
	}
	public void changeState()//changer l'état de la porte
	{
		switch(id)
		{
		case 1 :
			
			try {
				this.img = ImageIO.read(new File("sprite/gate_open.png"));//gate changer d'état : ouvert ou pas
			} catch (IOException e) {e.printStackTrace();}
			setPenetrableON();
			setPickableON();
		break;
		}
}
}		