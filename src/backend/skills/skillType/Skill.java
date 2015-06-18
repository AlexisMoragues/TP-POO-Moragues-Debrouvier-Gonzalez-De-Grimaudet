package backend.skills.skillType;


import backend.game.MatchModel;
import backend.game.Tile;
import backend.skills.SkillConstants;
import backend.skills.skillAreaEffects.AreaOfEffect;
import backend.skills.skillAreaEffects.SingleTargetEffect;


public abstract class Skill implements SkillConstants{

	//Default es SingleTargetEffect
	public Skill(int skillCharges, String skillDescription){
		this.areaOfEffect = new SingleTargetEffect();
		this.skillCharges = skillCharges;
		this.skillDescription = skillDescription;
	}
	
	protected AreaOfEffect areaOfEffect;
	private int skillCharges;
	private String skillDescription;
	
	public abstract void useSkill(Tile startingTile, Tile targetTile, MatchModel match);
	
	/**
	 * Retorna True si el el lugar seleccionado es valido.
	 */
	public abstract boolean checkValidTarget(Tile startingTile, Tile targetTile, MatchModel match);
	
	public int getSkillCharges(){  
		return this.skillCharges;
	}
	
	public String getSkillDescription(){
		return this.skillDescription;
	}

	public void setSkillCharges(int skillCharges) {
		if(skillCharges>=0){
			this.skillCharges=skillCharges;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	

	public abstract int getRange();
	
	public AreaOfEffect getAreaOfEffect(){
		return this.areaOfEffect;
	}

	@Override
	public String toString() {
		return "Skill [skillCharges=" + skillCharges + ", skillDescription=" + skillDescription + "]";
	}
}


