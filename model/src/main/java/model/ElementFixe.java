package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ElementFixe {
	private int id;
	private int x;
	private int y;
	private Image img; 
	private boolean Penetrable = false;	
	private boolean Recuperable = false;
	ElementFixe(int x,int y,Image img, boolean Penetrable , boolean Recuperable, int id)
	{	this.img = null;
		this.id =id;
		this.x = x;
		this.y = y ;
		this.img = img;
		this.Penetrable = Penetrable;
		this.Recuperable = Recuperable;
		//System.out.println(img);
		
	}
	
	ElementFixe()
	{
		System.out.println("Erreur d initialisation objet ElementFixe");
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
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
	public void setPenetrableON()
	{
		Penetrable =true;		
	}
	public void setPenetrableOFF()
	{
		Penetrable =false;
	}
	public void setRecuperableON()
	{
		Recuperable = true;
	}
	public void setRecuperableOFF()
	{
		Recuperable = false;
	}
	public boolean getPenetrable(){
		
		return Penetrable;
	}
	public boolean getRecuperable(){
		
		return Recuperable;
	}
	public int getid()
	{
		return id;
	}
	public int disableSprite()
	{
		try {
			img = ImageIO.read(new File("sprite/NoSprite.png"));
		} catch (IOException e) {e.printStackTrace();}
		return id;
		
	}
	public void changeState()
	{
		switch(id)
		{
		case 1 :
			
			try {
				this.img = ImageIO.read(new File("sprite/gate_open.png"));
			} catch (IOException e) {e.printStackTrace();}
			setPenetrableON();
			setRecuperableON();
		break;
		}
}
}		
	
		
	
	

	
