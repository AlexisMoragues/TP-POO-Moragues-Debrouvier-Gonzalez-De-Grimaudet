package backend.skills.warriorSkill.halberd;
import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SquareEffect;
import backend.skills.skillType.SkillEmptyTileTarget;

public class JumpAttack extends SkillEmptyTileTarget{

	public JumpAttack(){
		super(JUMP_ATTACK_RANGE ,JUMP_ATTACK_CHARGE ,JUMP_ATTACK_DESCRIPTION);
		areaOfEffect = new SquareEffect(JUMP_ATTACK_LENGTH);
	}

	@Override
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
		Piece myselfPiece =startingTile.getPiece();
		match.removePiece(myselfPiece);
		match.putPiece(myselfPiece, targetTile);
		myselfPiece.setPosition(targetTile);
		
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(myselfPiece.getPosition(), targetTile, match)){
			
			Piece newTargetPiece = newTargetTile.getPiece();
			if(newTargetPiece!=null){
				if(newTargetPiece!=myselfPiece){
					newTargetPiece.receiveDamage((int) (JUMPATTACK_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
					newTargetPiece.resetDmgReceivedModifier();
				}
			}
		}
		myselfPiece.resetAttackModifier();
	}
}


