package backend.weapons.rangerweapon;

import java.util.ArrayList;

import backend.skills.rangerSkills.archerSkills.ArrowToTheKnee;
import backend.skills.rangerSkills.archerSkills.HealingElfRoot;
import backend.skills.rangerSkills.archerSkills.SandAttack;
import backend.skills.skillType.Skill;
import backend.weapons.WeaponConstants;

public class ShortBow extends RangerWeapon implements WeaponConstants{
	
	private static final int SHORTBOW_DAMAGE = 15;
	private static final int SHORTBOW_RANGE = 5;
	private static final int SHORTBOW_COST = 1;

	public ShortBow() {
		super(SHORTBOW_DAMAGE, SHORTBOW_RANGE, SHORTBOW_COST, "ShortBow");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new HealingElfRoot());
		skills.add(new ArrowToTheKnee());
		skills.add(new SandAttack());

	}
	
	public static int getClassDamage(){
		return SHORTBOW_DAMAGE;
	}
	
	public static int getClassRange(){
		return SHORTBOW_RANGE;
	}
	
	public static int getClassCost(){
		return SHORTBOW_COST;
	}
	
	
}
