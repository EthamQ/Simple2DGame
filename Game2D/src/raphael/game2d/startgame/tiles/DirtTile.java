package raphael.game2d.startgame.tiles;

import java.awt.image.BufferedImage;

import raphael.game2d.startgame.gfx.Assets;

public class DirtTile extends Tile{

	public DirtTile(int id) {
		super(Assets.dirt, id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid(){
		return false;
	}

}
