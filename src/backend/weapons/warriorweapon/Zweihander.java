package backend.weapons.warriorweapon;

import java.util.ArrayList;

import backend.skills.skillType.Skill;
import backend.skills.warriorSkill.zweihander.OstoppbarKraft;
import backend.skills.warriorSkill.zweihander.Taunt;
import backend.skills.warriorSkill.zweihander.UndyingMight;

public class Zweihander extends WarriorWeapon {
	
		

	public Zweihander() {
		super(ZWEIHANDER_DAMAGE, ZWEIHANDER_RANGE, ZWEIHANDER_COST, "Zweihander");
		ArrayList<Skill> skills = super.getSkill();
		skills.add(new OstoppbarKraft());
		skills.add(new UndyingMight());
		skills.add(new Taunt());
	}
	
	public static int getClassDamage(){
		return ZWEIHANDER_DAMAGE;
	}
	
	public static int getClassRange(){
		return ZWEIHANDER_RANGE;
	}
	
	public static int getClassCost(){
		return ZWEIHANDER_COST;
	}
	

}
