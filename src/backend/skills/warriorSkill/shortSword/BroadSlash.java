package backend.skills.warriorSkill.shortSword;


import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.RectangleEffect;
import backend.skills.skillType.SkillTarget;

public class BroadSlash extends SkillTarget {

	public BroadSlash() {
		super(BROADSLASH_RANGE,BROADSLASH_CHARGES,BROADSLASH_DESCRIPTION);
		areaOfEffect = new RectangleEffect(0,BROADSLASH_LENGTH);
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
				newTargetPiece.receiveDamage((int) (myselfPiece.getDamage()*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
				newTargetPiece.resetDmgReceivedModifier();
			}
		}
		myselfPiece.resetAttackModifier();
	}
			

	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match){
		if(super.checkValidTarget(startingTile, targetTile, match)){
			if(startingTile!=targetTile){//Equals de Tile?
				return true;
			}
		}
		return false;
	}
}
