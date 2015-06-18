package backend.weapons.mageweapon;

import java.util.ArrayList;

import backend.skills.mageSkill.fireMageSkills.Cleanse;
import backend.skills.mageSkill.fireMageSkills.FireBomb;
import backend.skills.mageSkill.fireMageSkills.WildFire;
import backend.skills.skillType.Skill;

public class FireStaff extends MageWeapon{
	
	
	public FireStaff(){
		super(FIRE_STAFF_DAMAGE, FIRE_STAFF_RANGE, FIRE_STAFF_COST, "Fire Staff");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new FireBomb());
		skills.add(new WildFire());
		skills.add(new Cleanse());
	}
	
	public static int getClassDamage(){
		return FIRE_STAFF_DAMAGE;
	}
	
	public static int getClassRange(){
		return FIRE_STAFF_RANGE;
	}
	
	public static int getClassCost(){
		return FIRE_STAFF_COST;
	}
	
}