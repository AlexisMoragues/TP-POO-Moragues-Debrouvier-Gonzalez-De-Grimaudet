package backend.skills.skillAreaEffects;

import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;

public class SingleTargetEffect implements AreaOfEffect {

	public ArrayList<Tile> getAreaOfEffect(Tile startingTile, Tile targetTile, MatchModel match){
		if(startingTile == null){
			throw new NullPointerException();
		}
		if(startingTile.getPiece() == null){
			throw new NullPointerException();
		}
		if(match == null){
			throw new NullPointerException();
		}
		if(targetTile == null){
			throw new NullPointerException();
		}
		ArrayList<Tile> targetTiles = new ArrayList<Tile>();
		targetTiles.add(targetTile);
		return targetTiles;
	}
}
