package backend.skills.skillAreaEffects;

import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;


public class CrossSpikesEffect implements AreaOfEffect {

	private int range;
	
	public CrossSpikesEffect(int range){
		this.range=range;
	}
	
	@Override
	public ArrayList<Tile> getAreaOfEffect(Tile startingTile, Tile targetTile, MatchModel match) {
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
		Direction[] directions = {new Direction(1,0), new Direction(0,1), new Direction(-1,0), new Direction(0,-1)};
		for(Direction direction: directions){
			int newX = startingTile.getPositionX()+range*direction.getX();
			int newY = startingTile.getPositionY()+range*direction.getY();
			if(newX<match.getHeight() && newX>=0){
				if(newY<match.getWidth() && newY>=0){
					Tile newTargetTile = match.getTile(newX,newY);
					targetTiles.add(newTargetTile);
				}
			}
		}
		return targetTiles;
	}

	private class Direction{
		private int x;
		private int y;
		public Direction(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		private int getX(){
			return x;
		}
		private int getY(){
			return y;
		}
	}
				
				
}
