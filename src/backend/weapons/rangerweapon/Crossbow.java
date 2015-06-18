package backend.weapons.rangerweapon;

import java.util.ArrayList;

import backend.skills.rangerSkills.crossbowmanSkills.Focus;
import backend.skills.rangerSkills.crossbowmanSkills.HeadShot;
import backend.skills.rangerSkills.crossbowmanSkills.Reload;
import backend.skills.skillType.Skill;

public class Crossbow extends RangerWeapon{
	
	

	public Crossbow() {
		super(CROSSBOW_DAMAGE, CROSSBOW_RANGE, CROSSBOW_COST, "CrossBow");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new HeadShot());
		skills.add(new Reload());
		skills.add(new Focus());

	}
	
	public static int getClassDamage(){
		return CROSSBOW_DAMAGE;
	}
	
	public static int getClassRange(){
		return CROSSBOW_RANGE;
	}
	
	public static int getClassCost(){
		return CROSSBOW_COST;
	}
	
}
