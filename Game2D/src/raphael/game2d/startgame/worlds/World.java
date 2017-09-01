package raphael.game2d.startgame.worlds;

import java.awt.Graphics;

import raphael.game2d.startgame.Game;
import raphael.game2d.startgame.Handler;
import raphael.game2d.startgame.gfx.Assets;
import raphael.game2d.startgame.tiles.Tile;
import raphael.game2d.startgame.utils.Utils;

public class World {
	
	private int spawnX, spawnY;
	private int width, height;
	private int[][] tiles;
	private Handler handler;
	
	public World(Handler handler, String path){
		this.handler=handler;
		loadWorld(path);
	}
	
	private void loadWorld(String path){
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		int z=4;
		for(int y = 0; y<height; y++){
			for(int x = 0; x<width; x++){
				tiles[x][y] = Utils.parseInt(tokens[z]);
				z++;
			}
		}
	}
	
	
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILEWIDTH+1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);;
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILEHEIGHT+1);
		
		for(int y = yStart; y<yEnd; y++){
			for(int x = xStart; x<xEnd; x++){
			getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int)(y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
		}
			
	}
	}
		
		public Tile getTile(int x, int y){
			if(x<0 || y<0 || x>=width || y >= height){
				return Tile.grasstile;
			}
			Tile t = Tile.tiles[tiles[x][y]];
			if(t == null){
				return Tile.grasstile;
			}
			return t;
		}

		public int getSpawnX() {
			return spawnX;
		}

		public void setSpawnX(int spawnX) {
			this.spawnX = spawnX;
		}

		public int getSpawnY() {
			return spawnY;
		}

		public void setSpawnY(int spawnY) {
			this.spawnY = spawnY;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

}
