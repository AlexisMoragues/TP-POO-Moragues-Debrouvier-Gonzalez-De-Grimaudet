package backend.skills.warriorSkill.shortSword;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillPieceTargetEnemy;

//Falta El team. En la implementacion, deberia checkear si es valido el target, para luego atacar. 
public class DoubleStrike extends SkillPieceTargetEnemy{
	
	
	public DoubleStrike() {
		super(DOUBLESTRIKE_RANGE ,DOUBLESTRIKE_CHARGES ,DOUBLESTRIKE_DESCRIPTION);
		areaOfEffect = new SingleTargetEffect();
		
	}
	/**
	 * Ataca dos veces a una pieza
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
		Piece myselfPiece = startingTile.getPiece();
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
			if(newTargetPiece!=null){
				newTargetPiece.receiveDamage((int) (myselfPiece.getDamage()*2*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier())); 
				newTargetPiece.resetDmgReceivedModifier();
			}
		}
		myselfPiece.resetAttackModifier();
	}
}
		
			
		
