package backend.skills.mageSkill.arcaneMageSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.AllAllyTeamEffect;
import backend.skills.skillType.SkillNoTarget;


public class AncestralHealing extends SkillNoTarget{


	public AncestralHealing(){
        super(ANCESTRAL_HEALING_CHARGES,ANCESTRAL_HEALING_DESCRIPTION);
        areaOfEffect = new AllAllyTeamEffect();
	}

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
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
	        if(newTargetPiece.getHealth()>0){
	        	newTargetPiece.heal(ANCESTRAL_HEALING_HEALING);
	        	newTargetPiece.modifyDmgReceivedModifier(ANCESTRAL_HEALING_DMG_RECEIVED_MODIFIER);
            }
		}
    }

	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match){
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
			return true;
	
	}
}