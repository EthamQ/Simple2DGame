package raphael.game2d.startgame;

import raphael.game2d.frame.Display;;

public class Launcher {

	public static void main(String[] args) {
		int WIDTH = 600;
		int HEIGHT = WIDTH / 12 * 9;
		
		Game game = new Game("2D Game", WIDTH, HEIGHT);
		game.start();
	}
}
