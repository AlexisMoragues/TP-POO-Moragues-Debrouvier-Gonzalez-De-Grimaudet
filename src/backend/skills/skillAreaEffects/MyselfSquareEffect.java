package backend.skills.skillAreaEffects;


import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;

public class MyselfSquareEffect implements AreaOfEffect { //Se pierde el cursor

	
	private int squareDimension;
	
	public MyselfSquareEffect(int squareDimension){
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
				if(startingTile.getPositionX()+i>=0 && startingTile.getPositionX()+i<match.getHeight()){
					if(startingTile.getPositionY()+j>=0 && startingTile.getPositionY()+j<match.getWidth()){
						if(targetTile==startingTile){
						Tile newTargetTile = match.getTile(startingTile.getPositionX()+i, startingTile.getPositionY()+j);
						targetTiles.add(newTargetTile);
						}
					}
				}
			}
		}
		
		return targetTiles;
	}

}
