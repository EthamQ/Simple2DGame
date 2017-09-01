package raphael.game2d.startgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage mensch, baum, dirt, rock;
	public static BufferedImage[] playerDOWN;
	public static BufferedImage[] playerUP;
	
	public static void init(){
		playerDOWN = new BufferedImage[3];
		playerDOWN[0] = ImageLoader.loadImage("/textures/PlayerAnimations/PlayerDOWN.png");
		playerDOWN[1] = ImageLoader.loadImage("/textures/PlayerAnimations/PlayerDOWN1.png"); 
		playerDOWN[2] = ImageLoader.loadImage("/textures/PlayerAnimations/PlayerDOWN2.png"); 
		
		playerUP = new BufferedImage[3];
		playerUP[0] = ImageLoader.loadImage("/textures/PlayerAnimations/PlayerUP.png");
		playerUP[1] = ImageLoader.loadImage("/textures/PlayerAnimations/PlayerUP1.png");
		playerUP[2] = ImageLoader.loadImage("/textures/PlayerAnimations/PlayerUP2.png");
		
		mensch = ImageLoader.loadImage("/textures/PlayerAnimations/PlayerDOWN.png");
		baum = ImageLoader.loadImage("/textures/baum.png");
		dirt = ImageLoader.loadImage("/textures/dirt.png");
		rock = ImageLoader.loadImage("/textures/rock.png");
	}
}
