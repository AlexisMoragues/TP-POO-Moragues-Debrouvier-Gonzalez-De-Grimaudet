package backend.skills.skillAreaEffects;



import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;

public class RectangleEffect implements AreaOfEffect {

	
private int rectangleDimensionLarge;
private int rectangleDimensionLong;

	
	public RectangleEffect(int rectangleDimensionLong, int rectangleDimensionLarge){
		this.rectangleDimensionLong=rectangleDimensionLong;
		this.rectangleDimensionLarge=rectangleDimensionLarge;
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
		if(differenceX(startingTile,targetTile)>differenceY(startingTile,targetTile)){
			//Mismo eje X
			for(int i=-rectangleDimensionLarge; i<=rectangleDimensionLarge; i++){
				for(int j=-rectangleDimensionLong; j<=rectangleDimensionLong; j++){
					int newX = targetTile.getPositionX()+j; //Fila + j
					int newY = targetTile.getPositionY()+i; //Columna + i
					if(newY>=0 && newY<match.getWidth()){
						if(newX>=0 && newX<match.getHeight()){
							Tile newTargetTile = match.getTile(newX, newY);
							targetTiles.add(newTargetTile);
						}
					}
				}	
				}
			}
		else{
			//Mismo eje Y
			for(int i=-rectangleDimensionLong; i<=rectangleDimensionLong; i++){
				for(int j=-rectangleDimensionLarge; j<=rectangleDimensionLarge; j++){
					int newX = targetTile.getPositionX()+j; //Fila + j
					int newY = targetTile.getPositionY()+i; //Columna + i
					if(newY>=0 && newY<match.getWidth()){
						if(newX>=0 && newX<match.getHeight()){
							Tile newTargetTile = match.getTile(newX, newY);
							targetTiles.add(newTargetTile);
						}
					}
				}
			}
			}
		return targetTiles;
		
	}
	
	private int differenceX(Tile startingTile, Tile targetTile){
		return Math.abs(startingTile.getPositionX()-targetTile.getPositionX());
	}
	
	private int differenceY(Tile startingTile, Tile targetTile){
		return Math.abs(startingTile.getPositionY()-targetTile.getPositionY());
	}

}
