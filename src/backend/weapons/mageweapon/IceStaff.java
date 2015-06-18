package backend.weapons.mageweapon;


import java.util.ArrayList;

import backend.skills.mageSkill.iceMageSkills.Blizzard;
import backend.skills.mageSkill.iceMageSkills.Eisklinge;
import backend.skills.mageSkill.iceMageSkills.IceArmor;
import backend.skills.skillType.Skill;

public class IceStaff extends MageWeapon{


	public IceStaff() {
		super(ICE_STAFF_DAMAGE, ICE_STAFF_RANGE, ICE_STAFF_COST, "Ice Staff");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new IceArmor());
		skills.add(new Blizzard());
		skills.add(new Eisklinge());
	}
	
	public static int getClassDamage(){
		return ICE_STAFF_DAMAGE;
	}
	
	public static int getClassRange(){
		return ICE_STAFF_RANGE;
	}
	
	public static int getClassCost(){
		return ICE_STAFF_COST;
	}
	
	
}
