package backend.skills.skillAreaEffects;


import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;


public class ConeEffect implements AreaOfEffect {

	private int length;
	
	public ConeEffect(int length){
		this.length = length;
	}

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
		Direction direction;
		direction = differenceTile(startingTile,targetTile);
		ArrayList<Tile> targetTiles = new ArrayList<Tile>();
		for(int i=0;i<length;i++){
			for(int j=-i; j<=i; j++){
				int newX = targetTile.getPositionX()+i*direction.getX()+j*direction.getY();
				int newY = targetTile.getPositionY()+i*direction.getY()+j*direction.getX();
				
				if(newX>=0 && newX<match.getHeight()){
					if(newY>=0 && newY<match.getWidth()){
							Tile newTargetTile=match.getTile(newX,newY);
							targetTiles.add(newTargetTile);
						}
					}
				}
			}
		return targetTiles;
	}

	private Direction differenceTile(Tile startingTile, Tile targetTile) {
		int x = targetTile.getPositionX() - startingTile.getPositionX();
		int y = targetTile.getPositionY() - startingTile.getPositionY();
		int[] xy = {x,y};
		return new Direction(xy);
	}

	
	
	private class Direction{
		private int[] direction;
		public Direction(int[] direction){
			this.direction = direction;
		}
		
		private int getX(){
			return direction[0];
		}
		private int getY(){
			return direction[1];
		}
	}
}
