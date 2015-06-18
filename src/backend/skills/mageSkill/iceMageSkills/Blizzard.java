package backend.skills.mageSkill.iceMageSkills;


import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.RectangleEffect;
import backend.skills.skillType.SkillTarget;

public class Blizzard extends SkillTarget{

	public Blizzard() {
		super(BLIZZARD_RANGE, BLIZZARD_CHARGES , BLIZZARD_DESCRIPTION);
		areaOfEffect = new RectangleEffect(BLIZZARD_HEIGTH ,BLIZZARD_WIDTH);
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
				newTargetPiece.receiveDamage((int) (BLIZZARD_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
				newTargetPiece.modifyMovementModifier(BLIZZARD_MOVEMENT_MODIFIER);
				newTargetPiece.resetDmgReceivedModifier();
			}
		}
		myselfPiece.resetAttackModifier();			
	}
	
	@Override
	public boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match){
		if(differenceX(startingTile,targetTile)==differenceY(startingTile,targetTile)){
			return false;
		}
		return super.checkValidTarget(startingTile, targetTile, match);
		
	}
	
	private int differenceX(Tile startingTile, Tile targetTile){
		return Math.abs(startingTile.getPositionX()-targetTile.getPositionX());
	}
	
	private int differenceY(Tile startingTile, Tile targetTile){
		return Math.abs(startingTile.getPositionY()-targetTile.getPositionY());
	}
	
	
}
