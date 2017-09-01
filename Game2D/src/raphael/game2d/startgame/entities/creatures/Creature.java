package raphael.game2d.startgame.entities.creatures;

import raphael.game2d.startgame.Game;
import raphael.game2d.startgame.Handler;
import raphael.game2d.startgame.entities.Entity;
import raphael.game2d.startgame.tiles.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 5.0f;
	static double scale = 0.7;
	public static final int DEFAULT_WIDTH = (int) (111 * scale);
	public static final int DEFAULT_HEIGHT = (int) (123 * scale);

	protected int health;
	protected float speed;
	protected int width;
	protected int height;

	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		this.width = width;
		this.height = height;
		xMove = 0;
		yMove = 0;

	}

	public void move() {
		moveX();
		moveY();

	}

	public void moveX() {
		if(xMove > 0){//move right
			//x right corner
			int xR = (int) (x + bounds.x + xMove + bounds.width) / Tile.TILEWIDTH;
			
			if((!collisionWithTile(xR, (int)(y + bounds.y) / Tile.TILEHEIGHT))&& //right upper corner
					(!collisionWithTile(xR, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))){	//right bottom corner
				x += xMove;
			}else{
				x = xR * Tile.TILEWIDTH - bounds.x - bounds.width-1;
			
			}
		}else if(xMove < 0){
			//x left corner
			int xL = (int)(x + bounds.x + xMove) / Tile.TILEWIDTH; 
			if((!collisionWithTile(xL, (int)(y + bounds.y) / Tile.TILEHEIGHT))&& //left upper corner
					(!collisionWithTile(xL, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT))){ //left bottom corner
				x += xMove;
			}else{
				x = (xL+1)* Tile.TILEWIDTH - bounds.x;
			}
		}


	}

	public void moveY() {
		if(yMove > 0){ //move down
		//bottom corner
		int yL = (int)(y + bounds.y +bounds.height + yMove) / Tile.TILEHEIGHT;
		if((!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, yL ))&& //left bottom corner
				(!collisionWithTile((int)(x + bounds.x +bounds.width) / Tile.TILEWIDTH, yL))){ //right bottom corner
		y += yMove;
		}
		else{
			y = yL * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			
		}
		}
		
		if(yMove <0){
		//upper corner
			int yL = (int)(y + bounds.y + yMove) / Tile.TILEHEIGHT;
//			System.out.println("yL "+yL);
//			System.out.println("y "+y);
			if((!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, yL ))&& //left upper corner
					(!collisionWithTile((int)(x + bounds.x +bounds.width) / Tile.TILEWIDTH, yL))){ //right upper corner
			y += yMove;
			}
			else{
				y = (yL+1) * Tile.TILEHEIGHT - bounds.y;
				
//				System.out.println("yL "+yL);
//				System.out.println("y "+y);
			}
			}
	}
	
	public boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
		
	}

	// getters setters
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
