package raphael.game2d.startgame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import raphael.game2d.startgame.Game;
import raphael.game2d.startgame.Handler;
import raphael.game2d.startgame.gfx.Assets;
import raphael.game2d.startgame.gfx.ImageLoader;

public class Player extends Creature {


	private int width;
	private int height;
	
	Animation AnimationDown;
	Animation AnimationUp;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
	this.width  = super.width;
	this.height = super.height;
	
	bounds.x = 22;
	bounds.y = 35;
	bounds.width = 25;
	bounds.height = 48;
	
	AnimationDown = new Animation(500, Assets.playerDOWN);
	AnimationUp = new Animation(500, Assets.playerUP);
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	@Override
	public void tick() {

		AnimationDown.tick();
		AnimationUp.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
	}
	
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		
		
			
		}
		if(handler.getKeyManager().down){
			yMove = speed;
			
		
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		if(handler.getKeyManager().right){
			xMove = speed;
		}
	}

	
	@Override
	public void render(Graphics g) {
		if(handler.getKeyManager().down){
			g.drawImage(AnimationDown.getCurrentFrame(), (int)(x -handler.getGameCamera().getxOffset()), (int)(y -handler.getGameCamera().getyOffset()),width,height, null);
		}
		else if(handler.getKeyManager().up){
			g.drawImage(AnimationUp.getCurrentFrame(), (int)(x -handler.getGameCamera().getxOffset()), (int)(y -handler.getGameCamera().getyOffset()),width,height, null);
		}
		else{
			g.drawImage(Assets.playerDOWN[0], (int)(x -handler.getGameCamera().getxOffset()), (int)(y -handler.getGameCamera().getyOffset()),width,height, null);
		}
//		else {g.drawImage(Assets.playerDOWN[0], (int)(x -handler.getGameCamera().getxOffset()), (int)(y -handler.getGameCamera().getyOffset()),width,height, null);
//		}
		//		g.setColor(Color.RED);
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
	}

}
