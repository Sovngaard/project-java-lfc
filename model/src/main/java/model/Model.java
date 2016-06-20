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
	private Lorann lorann;
	private char[] ch =null;
	private int cpt = 0;
	private ElementFixe[][] elementfixe = new ElementFixe[20][12];
	private Image ima =null;
	private int x;
	private int y;
	public static int level =1;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
		loadMessage(""+level);
		initLorann();
		System.out.println("Hero OK");
		initElementFixe();
		System.out.println("Elements fixes OK");
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

	
	public void cpt(int i)
	{
		compteur  = compteur+i;
		System.out.println("cpt :" + compteur);
		
	}

	public void initLorann()
	{
		try {
			  image = ImageIO.read(new File("sprite/lorann_l.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		lorann = new Lorann(1,1,image);		
	}
	public void initElementFixe()
	{	
		elementfixe = new ElementFixe[20][12];
	System.out.println("element fixe reset");
	 	ch =null;
		System.out.println("objets fixes init");
		cpt = 0;
		
		 ch = message.toCharArray();
		 System.out.println(message);
		 System.out.println("ch init");
		 System.out.println(ch[0]);
		
	for(y=0 ; y <= 11 ;y++)
	{//System.out.println("for y init");
		 for(x=0 ; x <=19 ; x++)
		 { 	
			 
			 switch(ch[cpt])
			 {
			// case 'S' :
			//	 try {
			//		image = ImageIO.read(new File("sprite/Sortilege.png"));					
			//	 	} catch (IOException e) {e.printStackTrace();}		
			//	 	elementfixe[x][y] = new ElementFixe(x,y,image, false, false, 25);
			//	 	elementfixe[x][y].setPenetrableOFF();
			//	 break;
				 
			 case 'C' :
				 try {
					image = ImageIO.read(new File("sprite/gate_closed.png"));						
					} catch (IOException e) {e.printStackTrace();}
				 	elementfixe[x][y] = new ElementFixe(x,y,image, false, false, 1);
				 	
				 break;
			 case '-' :
				 
				 try {
					image = ImageIO.read(new File("sprite/vertical_bone.png"));						
					} catch (IOException e) {e.printStackTrace();}
				 	elementfixe[x][y] = new ElementFixe(x,y,image,false,false,2);
				 	
				 	
				 break;
				 
			 case '!' :	
				
				 try{
				 	image = ImageIO.read(new File("sprite/horizontal_bone.png"));					
					} catch (IOException e) {e.printStackTrace();}				
					elementfixe[x][y] = new ElementFixe(x,y,image, false, false, 3);		
					
				 break;
				 
			 case 'V' :
					
				 	try{
				 	image = ImageIO.read(new File("sprite/bone.png"));					
					} catch (IOException e) {e.printStackTrace();}	
					elementfixe[x][y] = new ElementFixe(x,y,image,false,false,4);
					
					
				 break;
				 
			 
			 case '1' :
				 //System.out.println("test");
				 try{
				 	image = ImageIO.read(new File("sprite/NoSprite.png"));					
					} catch (IOException e) {e.printStackTrace();}				
					elementfixe[x][y] = new ElementFixe(x,y,image,true,false,5);
					
				 break;
			 case'P':
				
				 try{
					 	image = ImageIO.read(new File("sprite/crystal_ball.png"));					
						} catch (IOException e) {e.printStackTrace();}				
						elementfixe[x][y] = new ElementFixe(x,y,image,true,true,6);
						
						break;
			 case'X': 
				 
				 lorann.ResetX(x);
				 lorann.ResetY(y);
			 default : 
				 try{
					 	image = ImageIO.read(new File("sprite/NoSprite.png"));					
						} catch (IOException e) {e.printStackTrace();}				
						elementfixe[x][y] = new ElementFixe(x,y,image,true,false,5);
						
					 break;		 
			 		}cpt++;
			 
	 }
	 }
}
	
		 
 
	
	
	
	
	
	
	
	
	public int LoranngetX()
	{	int x = lorann.getX();
		return x;
	}
	public int LoranngetY()
	{
		int y = lorann.getY();
		return y;
	}
	public Image LoranngetImage()
	{	
		Image ima = lorann.getImg();
		return ima;
	}
	public void LorannsetX(int i)
	{	lorann.setX(i);
		
	}
	public void LorannsetY(int i)
	{
		lorann.setY(i);
		
	}
	public void LorannetImage(Image img)
	{
		lorann.setImg(img);
	}
	public Image ElementFixegetImage(int x, int y)
	{
		ima =elementfixe[x][y].getImg();
		return ima;
	}
	public boolean ElementFixegetPenetrable(int x,int y)
	{
		boolean Penetrable = this.elementfixe[x][y].getPenetrable();
		return Penetrable;
	}
	public boolean ElementFixegetRecuperable(int x,int y) {
		return elementfixe[x][y].getRecuperable();
	}
	public void ElementFixedisableSprite(int x,int y)
	{
		int id =elementfixe[x][y].disableSprite();
		ElementChangeState(id);
	}
	public void ElementChangeState(int id)
	{
		switch(id) 
		{
		case 1:
			level++;
			loadMessage(""+level);
			initElementFixe();
		case 6:
			for(y=0;y<=11;y++)
			{
				for(x=0;x<=19;x++)
				{
					if (elementfixe[x][y].getid() == 1)
					{
						elementfixe[x][y].changeState();
					}
				}
			}
			break;
			}

	}
	public void MoveUp()
	{Image img = null;
		if(ElementFixegetPenetrable(LoranngetX(), LoranngetY()-1) ==true)
		{if(ElementFixegetRecuperable(LoranngetX(), LoranngetY()-1) == true)
		{
			ElementFixedisableSprite(LoranngetX(), LoranngetY()-1);
		}
		LorannsetY(-1);
		
		try { img =ImageIO.read(new File("sprite/lorann_UP.png"));
		} catch (IOException e) {e.printStackTrace();}
			LorannsetImage(img);
		}
	}
	public void MoveRight()
	{
		Image img = null;
		if(ElementFixegetPenetrable(LoranngetX()+1, LoranngetY()) ==true)
		{if(ElementFixegetRecuperable(LoranngetX()+1, LoranngetY()) == true)
		{
			ElementFixedisableSprite(LoranngetX()+1, LoranngetY());
		}
		LorannsetX(1);
		
		try { img =ImageIO.read(new File("sprite/lorann_RIGHT.png"));
		} catch (IOException e) {e.printStackTrace();}
			LorannsetImage(img);
		}
	}
	public void MoveLeft()
	{
		Image img = null;
		if(ElementFixegetPenetrable(LoranngetX()-1, LoranngetY()) ==true)
		{if(ElementFixegetRecuperable(LoranngetX()-1, LoranngetY()) == true)
		{
			ElementFixedisableSprite(LoranngetX()-1, LoranngetY());
		}
		LorannsetX(-1);
		
		try { img =ImageIO.read(new File("sprite/lorann_LEFT.png"));
		} catch (IOException e) {e.printStackTrace();}
			LorannsetImage(img);
		}
	}	
	public void MoveDown()
	{
		Image img = null;
		if(ElementFixegetPenetrable(LoranngetX(), LoranngetY()+1) ==true)
		{if(ElementFixegetRecuperable(LoranngetX(), LoranngetY()+1) == true)
		{
			ElementFixedisableSprite(LoranngetX(), LoranngetY()+1);
		}
		LorannsetY(1);
		
		try { img =ImageIO.read(new File("sprite/lorann_DOWN.png"));
		} catch (IOException e) {e.printStackTrace();}
			LorannsetImage(img);
		}
	}

	public Image HerogetImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void LorannsetImage(Image img) {
		// TODO Auto-generated method stub
		
	}
	


}

