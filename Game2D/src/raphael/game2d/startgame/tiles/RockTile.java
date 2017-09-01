package raphael.game2d.startgame.tiles;

import raphael.game2d.startgame.gfx.Assets;

public class RockTile extends Tile {
	
	public RockTile(int id) {
		super(Assets.rock, id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid(){
		return true;
	}

}
