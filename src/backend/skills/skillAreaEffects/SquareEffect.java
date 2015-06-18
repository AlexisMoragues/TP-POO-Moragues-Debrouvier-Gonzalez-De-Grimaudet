package backend.skills.skillAreaEffects;



import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;

public class SquareEffect implements AreaOfEffect {

	private int squareDimension;
	
	public SquareEffect(int squareDimension){
		this.squareDimension=squareDimension;
	}
	
	
	@Override
	public ArrayList<Tile> getAreaOfEffect(Tile startingTile, Tile targetTile,MatchModel match) {
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
		for (int i=-squareDimension; i<=squareDimension; i++){
			for(int j=-squareDimension; j<=squareDimension; j++){
				if(targetTile.getPositionX()+i>=0 && targetTile.getPositionX()+i<match.getHeight()){
				
					if(targetTile.getPositionY()+j>=0 && targetTile.getPositionY()+j<match.getWidth()){
						Tile newTargetTile = match.getTile(targetTile.getPositionX()+i, targetTile.getPositionY()+j);
						targetTiles.add(newTargetTile);
					}
				}
			}
		}
		
		return targetTiles;
	}

}
