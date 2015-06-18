package backend.skills.skillAreaEffects;

import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;

public interface AreaOfEffect {

	public ArrayList<Tile> getAreaOfEffect(Tile startingTile, Tile targetTile, MatchModel match);
}
