package backend.skills.mageSkill.fireMageSkills;


import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.LinearEffect;
import backend.skills.skillType.SkillTarget;

public class WildFire extends SkillTarget{
	
	public WildFire() {
		super(WILDFIRE_RANGE ,WILDFIRE_CHARGES,WILDFIRE_DESCRIPTION);
		areaOfEffect = new LinearEffect(WILDFIRE_LENGTH);
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
				newTargetPiece.receiveDamage((int) (WILDFIRE_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
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
