package backend.weapons.warriorweapon;

import java.util.ArrayList;

import backend.skills.skillType.Skill;
import backend.skills.warriorSkill.halberd.BattleCry;
import backend.skills.warriorSkill.halberd.JumpAttack;
import backend.skills.warriorSkill.halberd.SpinToWin;

public class Halberd extends WarriorWeapon {
	
	

	public Halberd() {
		super(HALBERD_DAMAGE, HALBERD_RANGE , HALBERD_COST , "Halberd");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new BattleCry());
		skills.add(new JumpAttack());
		skills.add(new SpinToWin());
	}
	
	public static int getClassDamage(){
		return HALBERD_DAMAGE;
	}
	
	public static int getClassRange(){
		return HALBERD_RANGE;
	}
	
	public static int getClassCost(){
		return HALBERD_COST;
	}
	

}
