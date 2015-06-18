package backend.skills.mageSkill.arcaneMageSkills;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillAreaEffects.ConeEffect;
import backend.skills.skillType.SkillTarget;

	public class StraffeGottes extends SkillTarget{


		public StraffeGottes(){
				super(STRAFFE_GOTTES_RANGE,STRAFFE_GOTTES_CHARGES,STRAFFE_GOTTES_DESCRIPTION);
				areaOfEffect = new ConeEffect(STRAFFE_GOTTES_LENGHT);
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
					newTargetPiece.receiveDamage((int) (STRAFFE_GOTTES_DAMAGE*myselfPiece.getAttackModifier()*newTargetPiece.getDmgRecievedModifier()));
					newTargetPiece.resetDmgReceivedModifier();
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
	

