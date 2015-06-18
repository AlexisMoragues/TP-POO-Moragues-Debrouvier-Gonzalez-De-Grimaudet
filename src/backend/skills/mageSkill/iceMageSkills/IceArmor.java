package backend.skills.mageSkill.iceMageSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SquareEffect;
import backend.skills.skillType.SkillTarget;

public class IceArmor extends SkillTarget {

	public IceArmor() {
		super(ICEARMOR_RANGE,ICEARMOR_CHARGES, ICEARMOR_DESCRIPTION);
		areaOfEffect = new SquareEffect(ICEARMOR_DIMENSION);
	}
 
	@Override
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
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
			if(newTargetPiece!=null){
				newTargetPiece.modifyDmgReceivedModifier(ICEARMOR_ARMORMODIFIER);
			}
		}
	}

}
