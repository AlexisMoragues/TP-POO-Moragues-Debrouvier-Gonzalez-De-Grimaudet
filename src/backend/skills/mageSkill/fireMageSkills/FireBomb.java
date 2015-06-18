
package backend.skills.mageSkill.fireMageSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SquareEffect;
import backend.skills.skillType.SkillTarget;

public class FireBomb extends SkillTarget {

	public FireBomb() {
		super(FIREBOMB_RANGE,FIREBOMB_CHARGES,FIREBOMB_DESCRIPTION);
		areaOfEffect = new SquareEffect(1);
	}

	@Override
	/**
	 * Apunta un casillero y hace da�o a todos los casilleros limitrofes.
	 */
	public void useSkill(Tile startingTile, Tile targetTile, MatchModel match) {
		
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
				
				newTargetPiece.receiveDamage((int) (FIREBOMB_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
				newTargetPiece.modifyAttackModifier(FIREBOMB_ATTACK_MODIFIER);
				newTargetPiece.resetDmgReceivedModifier();
				
			}
		}
						
						
					
		myselfPiece.resetAttackModifier();
	}

	
}
