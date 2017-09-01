package raphael.game2d.startgame.states;

import java.awt.Graphics;

import raphael.game2d.startgame.Game;
import raphael.game2d.startgame.Handler;
import raphael.game2d.startgame.entities.creatures.Creature;
import raphael.game2d.startgame.entities.creatures.Player;
import raphael.game2d.startgame.gfx.Assets;
import raphael.game2d.startgame.tiles.Tile;
import raphael.game2d.startgame.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	private int spawnX;
	private float spawnY;
	private float spawnXcorrect, spawnYcorrect;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/world/world1.txt");
		handler.setWorld(world);
		this.spawnX = world.getSpawnX();
		this.spawnY = world.getSpawnY();
		this.spawnXcorrect = (handler.getWidth()/2)-(Creature.DEFAULT_WIDTH/2);
		this.spawnYcorrect = handler.getHeight()/2-Creature.DEFAULT_HEIGHT/2;
		
		player = new Player(handler, spawnXcorrect, spawnYcorrect);
		
		
		
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
		
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		
	}

}
