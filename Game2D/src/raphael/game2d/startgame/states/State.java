package raphael.game2d.startgame.states;

import java.awt.Graphics;

import raphael.game2d.startgame.Game;
import raphael.game2d.startgame.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}

}
