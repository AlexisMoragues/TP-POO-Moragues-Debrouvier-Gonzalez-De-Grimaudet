package backend.weapons.rangerweapon;

import java.util.ArrayList;

import backend.skills.rangerSkills.javelinRanger.MoralConquest;
import backend.skills.rangerSkills.javelinRanger.PiercingJavelin;
import backend.skills.rangerSkills.javelinRanger.SeekAndDestroy;
import backend.skills.skillType.Skill;

public class Javelin extends RangerWeapon {
	
	

	public Javelin() {
		super(JAVELIN_DAMAGE, JAVELIN_RANGE , JAVELIN_COST, "Javelin");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new MoralConquest());
		skills.add(new PiercingJavelin());
		skills.add(new SeekAndDestroy());
	}
	
	public static int getClassDamage(){
		return JAVELIN_DAMAGE;
	}
	
	public static int getClassRange(){
		return JAVELIN_RANGE;
	}
	
	public static int getClassCost(){
		return JAVELIN_COST;
	}
	

}
