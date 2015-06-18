package backend.skills.warriorSkill.shortSword;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillEmptyTileTarget;

public class TacticalWithdrawal extends SkillEmptyTileTarget{
	public TacticalWithdrawal(){
		super(TACTICAL_WITHDRAWAL_RANGE ,TACTICAL_WITHDRAWAL_CHARGES ,TACTICAL_WITHDRAWAL_DESCRIPTION);
		areaOfEffect = new SingleTargetEffect();
	}

	@Override
	/**
	 * Permite mover la pieza una segunda vez sin tener en cuenta el mov modifier.
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
		match.removePiece(myselfPiece);
		match.putPiece(myselfPiece, targetTile);
		myselfPiece.setPosition(targetTile);
		
	}
}
