package backend.skills.mageSkill.arcaneMageSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.SingleTargetEffect;
import backend.skills.skillType.SkillPieceTarget;

public class SongOfTheAncestors extends SkillPieceTarget{
	public SongOfTheAncestors() {
		super(SONG_OF_THE_ANCESTORS_RANGE, SONG_OF_THE_ANCESTORS_CHARGES, SONG_OF_THE_ANCESTORS_DESCRIPTION);
		areaOfEffect = new SingleTargetEffect();
	}

	public void useSkill(Tile startingTile, Tile targetTile, MatchModel match){
		
		for(Tile newTargetTile: areaOfEffect.getAreaOfEffect(startingTile, targetTile, match)){
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
			Piece newTargetPiece = newTargetTile.getPiece();
			if (newTargetPiece!=null){
				if(targetTile.getPiece().getTeam()==startingTile.getPiece().getTeam()){
					newTargetPiece.modifyAttackModifier(SONG_OF_THE_ANCESTORS_ATTACKBUFF);
					newTargetPiece.modifyMovementModifier(SONG_OF_THE_ANCESTORS_MOVEMENTBUFF);
				}
				else{
					newTargetPiece.modifyAttackModifier(SONG_OF_THE_ANCESTORS_ATTACKDEBUFF);
					newTargetPiece.modifyMovementModifier(SONG_OF_THE_ANCESTORS_MOVEMENTDEBUFF);
				}
			}
		}
	}
}