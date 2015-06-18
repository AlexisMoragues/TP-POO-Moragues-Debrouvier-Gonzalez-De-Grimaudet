package backend.skills.skillAreaEffects;

import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;

public class AllAllyTeamEffect implements AreaOfEffect {

	@Override
	public ArrayList<Tile> getAreaOfEffect(Tile startingTile, Tile targetTile,
			MatchModel match) {
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
			for(Piece piece: match.getPieces().get(match.getPlayerTurn()-1)){
	            if(piece.getHealth()>0){
	            	if(piece.getPosition()!=null){
		            	targetTiles.add(piece.getPosition());	
		            }
				}
		    }
			return targetTiles;
		}

}
