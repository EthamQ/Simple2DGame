package raphael.game2d.startgame.entities.creatures;

import java.awt.image.BufferedImage;



public class Animation {
	
	private long lastTime, delta;
	private BufferedImage[] bi;
	private int speed, index;
	
	public Animation(int speed, BufferedImage[] bi){
		this.speed = speed;
		this.bi = bi;
		lastTime = System.currentTimeMillis();
		index = 1;
	
		
	}
	
	public BufferedImage getCurrentFrame(){
		
			System.out.println(index);
		return bi[index];
		
	}
	
	
	public void tick(){

		delta += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(delta >= speed){
			delta = 0;
			index++;
		 if(index >= bi.length){
			index = 1;
		}
		}
		
		
	
		
	}
	

}
