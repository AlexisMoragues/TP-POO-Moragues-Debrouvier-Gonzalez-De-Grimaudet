package backend.skills.rangerSkills.javelinRanger;


import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.LinearEffect;
import backend.skills.skillType.SkillTarget;

public class PiercingJavelin extends  SkillTarget{

	public PiercingJavelin(){
		super(PIERCING_JAVELIN_RANGE ,PIERCING_JAVELIN_CHARGES ,PIERCING_JAVELIN_DESCRIPTION);
		areaOfEffect = new LinearEffect(PIERCING_JAVELIN_LENGTH);
	}


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
					newTargetPiece.receiveDamage((int) (PIERCING_JAVELIN_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
					newTargetPiece.resetDmgReceivedModifier();
					newTargetPiece.modifyMovementModifier(PIERCING_JAVELIN_MOVEMENTMODIFIER);
					newTargetPiece.modifyAttackModifier(PIERCING_JAVELIN_ATTACKMODIFIER);
					newTargetPiece.modifyDmgReceivedModifier(PIERCING_JAVELIN_DEFENCEMODIFIER);
				}
			}
				myselfPiece.resetAttackModifier();
				
	}
				


	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match){
		if(super.checkValidTarget(startingTile, targetTile,match)){
			if(startingTile!=targetTile){//Equals de Tile?
				return true;
			}
		}
		return false;
	}

	
}
