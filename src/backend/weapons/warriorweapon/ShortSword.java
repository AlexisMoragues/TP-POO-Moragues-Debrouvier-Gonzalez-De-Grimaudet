package backend.weapons.warriorweapon;


import java.util.ArrayList;

import backend.skills.skillType.Skill;
import backend.skills.warriorSkill.shortSword.BroadSlash;
import backend.skills.warriorSkill.shortSword.DoubleStrike;
import backend.skills.warriorSkill.shortSword.TacticalWithdrawal;

public class ShortSword extends WarriorWeapon {
	
	
	
	public ShortSword(){
		super(SHORTSWORD_DAMAGE, SHORTSWORD_RANGE, SHORTSWORD_COST, "ShortSword");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new DoubleStrike());
		skills.add(new TacticalWithdrawal());
		skills.add(new BroadSlash());
	}
	
	public static int getClassDamage(){
		return SHORTSWORD_DAMAGE;
	}
	
	public static int getClassRange(){
		return SHORTSWORD_RANGE;
	}
	
	public static int getClassCost(){
		return SHORTSWORD_COST;
	}
	
	
	
}
