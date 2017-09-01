package raphael.game2d.startgame;
import raphael.game2d.startgame.gfx.Assets;
import raphael.game2d.startgame.gfx.GameCamera;
import raphael.game2d.startgame.gfx.ImageLoader;
import raphael.game2d.startgame.states.GameState;
import raphael.game2d.startgame.states.MenuState;
import raphael.game2d.startgame.states.State;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import raphael.game2d.frame.Display;
import raphael.game2d.startgame.input.KeyManager;
import java.awt.event.KeyListener;



public class Game implements Runnable {

	private Display display;
	String title = "";
	private int WIDTH, HEIGHT;

	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;

	
	//States
	private State gameState;
	private State menuState;
	
	//input
	private KeyManager kM;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	Handler handler;
	


	public Game(String title, int width, int height) {
		this.title = title;
		WIDTH = width;
		HEIGHT = height;
		kM = new KeyManager();

	

	}
	
	public KeyManager getKeyManager(){
		return this.kM;
	}
	
	public GameCamera getGameCamera(){
		return this.gameCamera;
	}
	public int getWidth(){
		return this.WIDTH;
	}
	public int getHeight(){
		return this.HEIGHT;
	}

	private void init(){
		display = new Display(title, WIDTH, HEIGHT);
		display.getFrame().addKeyListener(kM);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	
	}
	
	
	@Override
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000d/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
			tick();
			render();
			ticks++;
			delta--;
			}
			
			if(timer>=1000000000){
//				System.out.println("Ticks and Frames: "+ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();

		
	}

	public synchronized void start() {
		if(!running){
		running = true;
		thread = new Thread(this);
		//calls the run method
		thread.start();
		}
		return;

	}

	public synchronized void stop() {
		if(running){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		return;

	}
	
	public void tick(){
		kM.tick();
		if(State.getState() != null){
			State.getState().tick();
		}
	
	}


	public void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		//Draw
		if(State.getState() != null){
			State.getState().render(g);
		}
	    
		//End drawing
		bs.show();
		g.dispose();
	}

}










//g.drawImage(bi, x, y, null);
//g.drawOval(x, x, 20, 20);
//if(x==200){
//	right= true;
//	left=false;
//}
//if(x==10){
// 	left= true;
// 	right=false;
//	}
//if(right){
//	x--;
//	y=50;
//}
//if(left){
//	x++;
//	y=30;
//}
