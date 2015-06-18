package backend.skills.skillType;



public abstract class SkillNoTarget extends Skill {

	public SkillNoTarget(int skillCharges, String skillDescription){
		super(skillCharges, skillDescription);
	}
	
	
	public int getRange(){
		return 0;
	}

}
