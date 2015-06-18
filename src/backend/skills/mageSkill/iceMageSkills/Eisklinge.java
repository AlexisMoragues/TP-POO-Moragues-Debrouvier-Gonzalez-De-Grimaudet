package backend.skills.mageSkill.iceMageSkills;


import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.CrossSpikesEffect;
import backend.skills.skillType.SkillNoTarget;

public class Eisklinge extends SkillNoTarget{

	public Eisklinge() {
		super(EISKLINGE_CHARGES, EISKLINGE_DESCRIPTION);
		areaOfEffect = new CrossSpikesEffect(EISKLINGE_DIMENSION);
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
		Piece myselfPiece = startingTile.getPiece();
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
			Piece newTargetPiece = newTargetTile.getPiece();
				if(newTargetPiece!=null){
					newTargetPiece.receiveDamage((int) (EISKLINGE_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
					newTargetPiece.resetDmgReceivedModifier();	
				}	
			}
		myselfPiece.resetAttackModifier();
	}

	
	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match) {
		return true;
	}
	
	
	
}
