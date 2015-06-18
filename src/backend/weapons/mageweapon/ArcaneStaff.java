package backend.weapons.mageweapon;

import java.util.ArrayList;

import backend.skills.mageSkill.arcaneMageSkills.AncestralHealing;
import backend.skills.mageSkill.arcaneMageSkills.SongOfTheAncestors;
import backend.skills.mageSkill.arcaneMageSkills.StraffeGottes;
import backend.skills.skillType.Skill;

public class ArcaneStaff extends MageWeapon{
	


	public ArcaneStaff() {
		super(ARCANE_STAFF_DAMAGE, ARCANE_STAFF_RANGE, ARCANE_STAFF_COST, "Arcane Staff");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new SongOfTheAncestors());
		skills.add(new AncestralHealing());
		skills.add(new StraffeGottes());
	}

	public static int getClassDamage(){
		return ARCANE_STAFF_DAMAGE;
	}
	
	public static int getClassRange(){
		return ARCANE_STAFF_RANGE;
	}
	
	public static int getClassCost(){
		return ARCANE_STAFF_COST;
	}
	
}
