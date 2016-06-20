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
	private int compteur =0;
	private Image image = null;
	private Lorann hero;
	private char[] ch =null;
	private int cpt = 0;
	private Fixe[][] fixe = new Fixe[20][12];//elements fixes sur la grille
	private Image ima =null;
	private int x;
	private int y;
	public static int level =1;//debut level 1

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
		loadMessage(""+level);
		initHero();
		System.out.println("héro a été init");//msg erreur
		initFixe();
		System.out.println("elements fixes OK");
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
		this.notifyObservers();//utilisation observeurs
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

	
	public void cpt(int i)
	{
		compteur  = compteur+i;
		System.out.println("cpt :" + compteur);
		
	}

	public void initHero()//init lorann
	{
		try {
			  image = ImageIO.read(new File("sprite/lorann_l.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		hero = new Lorann(1,1,image);		
	}
	public void initFixe()
	{	
		fixe = new Fixe[20][12];//elements fixes
	System.out.println("element fixe reset");//msg erreurs
	 	ch =null;
		System.out.println("obj init fixe");
		cpt = 0;
		
		 ch = message.toCharArray();
		 System.out.println("ch init");
		 System.out.println(ch[0]);
		
	for(y=0 ; y <= 11 ;y++)
	{//System.out.println("for y init");
		 for(x=0 ; x <=19 ; x++)
		 { 	
			 
			 switch(ch[cpt])
			 {
			 case 'S' :
				 try {
					image = ImageIO.read(new File("sprite/Sortilege.png"));					
				 	} catch (IOException e) {e.printStackTrace();}		
				 	fixe[x][y] = new Fixe(x,y,image, false, false, 25);
				 	fixe[x][y].setPenetrableOFF();//dit si un élément fixe peut etre penetré ou pas
				 break;
				 
			 case 'X' :
				 try {
					image = ImageIO.read(new File("sprite/gate_closed.png"));						
					} catch (IOException e) {e.printStackTrace();}
				 	fixe[x][y] = new Fixe(x,y,image, false, false, 1);
				 	
				 break;
			 case '|' :
				 
				 try {
					image = ImageIO.read(new File("sprite/vertical_bone.png"));						
					} catch (IOException e) {e.printStackTrace();}
				 	fixe[x][y] = new Fixe(x,y,image,false,false,2);
				 	
				 	
				 break;
				 
			 case '-' :			
				 try{
				 	image = ImageIO.read(new File("sprite/horizontal_bone.png"));					
					} catch (IOException e) {e.printStackTrace();}				
					fixe[x][y] = new Fixe(x,y,image, false, false, 3);		
					
				 break;
				 
			 case 'c' :
				
				 	try{
				 	image = ImageIO.read(new File("sprite/bone.png"));					
					} catch (IOException e) {e.printStackTrace();}	
					fixe[x][y] = new Fixe(x,y,image,false,false,4);
					
					
				 break;
				 
			 
			 case ':' :
				 try{
				 	image = ImageIO.read(new File("sprite/NoSprite.png"));					
					} catch (IOException e) {e.printStackTrace();}				
					fixe[x][y] = new Fixe(x,y,image,true,false,5);
					
				 break;
			 case'O':
				 try{
					 	image = ImageIO.read(new File("sprite/crystal_ball.png"));					
						} catch (IOException e) {e.printStackTrace();}				
						fixe[x][y] = new Fixe(x,y,image,true,true,6);
						
						break;
			 case'U': 
				 
				 hero.ResetX(x);
				 hero.ResetY(y);
			 default :
				 try{
					 	image = ImageIO.read(new File("sprite/NoSprite.png"));					
						} catch (IOException e) {e.printStackTrace();}				
						fixe[x][y] = new Fixe(x,y,image,true,false,5);
						
					 break;		 
			 		}cpt++;
			 
	 }
	 }
}
	
	
	
	public int HerogetX()//les coordonées du héros
	{	int x = hero.getX();
		return x;
	}
	public int HerogetY()
	{
		int y = hero.getY();
		return y;
	}
	public Image HerogetImage()
	{	
		Image ima = hero.getImg();
		return ima;
	}
	public void HerosetX(int i)
	{	hero.setX(i);
		
	}
	public void HerosetY(int i)
	{
		hero.setY(i);
		
	}
	public void HerosetImage(Image img)
	{
		hero.setImg(img);
	}
	public Image FixegetImage(int x, int y)
	{
		ima =fixe[x][y].getImg();
		return ima;
	}
	public boolean FixegetPenetrable(int x,int y)
	{
		boolean Penetrable = this.fixe[x][y].getPenetrable();
		return Penetrable;
	}
	public boolean FixegetPickable(int x,int y) {
		return fixe[x][y].Pickable();
	}
	public void FixedisableSprite(int x,int y)
	{
		int id =fixe[x][y].disableSprite();
		ElementChangeState(id);
	}
	public void ElementChangeState(int id)
	{
		switch(id) 
		{
		case 1:
			level++;
			loadMessage(""+level);//chargement du level
			initFixe();
		case 6:
			for(y=0;y<=11;y++)
			{
				for(x=0;x<=19;x++)
				{
					if (fixe[x][y].getid() == 1)
					{
						fixe[x][y].changeState();//change etat
					}
				}
			}
			break;
			}

	}
	public void MoveUp()
	{Image img = null;
		if(FixegetPenetrable(HerogetX(), HerogetY()-1) ==true)
		{if(FixegetPickable(HerogetX(), HerogetY()-1) == true)
		{
			FixedisableSprite(HerogetX(), HerogetY()-1);
		}
		HerosetY(-1);
		
		try { img =ImageIO.read(new File("sprite/lorann_u.png"));
		} catch (IOException e) {e.printStackTrace();}
			HerosetImage(img);
		}
	}
	public void MoveRight()
	{
		Image img = null;
		if(FixegetPenetrable(HerogetX()+1, HerogetY()) ==true)
		{if(FixegetPickable(HerogetX()+1, HerogetY()) == true)
		{
			ElementFixedisableSprite(HerogetX()+1, HerogetY());
		}
		HerosetX(1);
		
		try { img =ImageIO.read(new File("sprite/lorann_r.png"));
		} catch (IOException e) {e.printStackTrace();}
			HerosetImage(img);
		}
	}
	public void MoveLeft()
	{
		Image img = null;
		if(FixegetPenetrable(HerogetX()-1, HerogetY()) ==true)
		{if(FixegetPickable(HerogetX()-1, HerogetY()) == true)
		{
			ElementFixedisableSprite(HerogetX()-1, HerogetY());
		}
		HerosetX(-1);
		
		try { img =ImageIO.read(new File("sprite/lorann_l.png"));
		} catch (IOException e) {e.printStackTrace();}
			HerosetImage(img);
		}
	}	
	public void MoveDown()
	{
		Image img = null;
		if(FixegetPenetrable(HerogetX(), HerogetY()+1) ==true)
		{if(FixegetPickable(HerogetX(), HerogetY()+1) == true)
		{
			FixedisableSprite(HerogetX(), HerogetY()+1);
		}
		HerosetY(1);
		
		try { img =ImageIO.read(new File("sprite/lorann_b.png"));
		} catch (IOException e) {e.printStackTrace();}
			HerosetImage(img);
		}
	}

	public Image FixegetImage1(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean FixegetPickable1(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean FixegetPickable2(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public void FixedisableSprite1(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	


}
