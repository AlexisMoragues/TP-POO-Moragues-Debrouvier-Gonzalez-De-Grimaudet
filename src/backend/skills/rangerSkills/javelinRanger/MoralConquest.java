package backend.skills.rangerSkills.javelinRanger;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SquareEffect;
import backend.skills.skillType.SkillTarget;

public class MoralConquest extends SkillTarget{

	public MoralConquest(){
		super(MORAL_CONQUEST_RANGE,MORAL_CONQUEST_CHARGES , MORAL_CONQUEST_DESCRIPTION);
		areaOfEffect = new SquareEffect(MORAL_CONQUEST_DIMENSION);
	}
	/**
	 * No se puede usar el for each del area en este caso porque la habilidad actua de una manera muy especifica
	 */
	public void useSkill(Tile startingTile, Tile targetTile, MatchModel match){ 
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
		Piece myselfPiece=startingTile.getPiece();
		for (int i=-MORAL_CONQUEST_DIMENSION; i<=MORAL_CONQUEST_DIMENSION; i++){
			for(int j=-MORAL_CONQUEST_DIMENSION; j<=MORAL_CONQUEST_DIMENSION; j++){
			
				if(startingTile.getPositionX()+i>=0 && startingTile.getPositionX()+i<match.getHeight()){
				
					if(startingTile.getPositionY()+j>=0 && startingTile.getPositionY()+j<match.getWidth()){
					
						Piece newTargetPiece = match.getPiece(match.getTile(targetTile.getPositionX()+i, targetTile.getPositionY()+j));
						
						if(newTargetPiece!=null){
							if(newTargetPiece.getTeam() == myselfPiece.getTeam()){

								newTargetPiece.modifyAttackModifier(MORAL_CONQUEST_ALLY_ATTACKMODIFIER);
							}
							else{
								newTargetPiece.modifyAttackModifier(MORAL_CONQUEST_ENEMY_ATTACKMODIFIER);
							}
							if(i==0 && j==0){
								newTargetPiece.receiveDamage((int) (MORAL_CONQUEST_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
								newTargetPiece.resetDmgReceivedModifier();
								myselfPiece.resetAttackModifier();	
							}
						}
					}
				}
			}
		}
	}
}
