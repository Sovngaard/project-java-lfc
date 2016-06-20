package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lorann  {
	private int x;//les positions
	private int y;
	private Image img; //variable pour l image de lorann
	
	
	Lorann(int x,int y,Image imge)
	{
		this.x = x;
		this.y = y ;
		this.img = imge;
		
	}
	
	Lorann()
	{
		System.out.println("La classe Lorann a un probleme");
	}

	public int getX() {//prend les positions
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
	public void ResetX(int x) {
		this.x =  x;
	}
	public void ResetY(int y) {
		this.y =  y;
	}

	/*public void run() {
		try {
			setImg(ImageIO.read(new File("sprite/lorann_ur.png")));// images lorann left up
			
		} catch (IOException e) {e.printStackTrace();
		
		try {
			Thread.sleep(500) ;// permet de faire bouger lorann quand elle ne bouge pas de sa case
		} catch (InterruptedException e1) {	e1.printStackTrace();}
		
		
		try {setImg(ImageIO.read(new File("sprite/lorann_ul.png")));//image lorann right up
		} catch (IOException e1) {e1.printStackTrace();}
		
		}
		*/
		
	}
	


