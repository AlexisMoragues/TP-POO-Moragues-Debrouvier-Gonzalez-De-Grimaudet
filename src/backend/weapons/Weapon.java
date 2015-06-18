package backend.weapons;

import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.skills.skillType.Skill;

/**
 * Clase que representa las armas utilizada por las Pieces 
 */
public abstract class Weapon implements WeaponConstants{

	private int damage;
	private ArrayList<Skill> skills;
	private int range;
	private int cost;
	private String name;
	
	/**
	 * Crea un arma
	 * @param damage
	 * @param range 
	 * @param cost
	 * @param name
	 */
	public Weapon(int damage, int range, int cost, String name){
		if(damage<0 || range < 0 || cost<=0 || name == null){
			throw new IllegalArgumentException();
		}
		this.damage = damage;
		this.range = range;
		this.cost = cost;
		this.skills = new ArrayList<Skill>();
		this.name=name;
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public int getRange(){
		return this.range;
	}
	
	public ArrayList<Skill> getSkill(){
	  return this.skills;
	}
		
	/**
	 * Ejecuta el skill.
	 * @param startingTile
	 * @param targetTile
	 * @param skillNumber
	 * @param match
	 * @return
	 */
	public boolean tryToSkill(Tile startingTile, Tile targetTile, int skillNumber, MatchModel match){
		if(startingTile==null || targetTile==null || match==null || skillNumber<0){
			throw new IllegalArgumentException();
		}
		if(match.getPiece(startingTile)==null) {
			throw new IllegalArgumentException();
		}
		if(skills.size()<= skillNumber){
			return false;
		}
		if(skills.get(skillNumber).getSkillCharges()<= 0){
			return false;
		}
		if(skills.get(skillNumber).checkValidTarget(startingTile, targetTile, match)){
			skills.get(skillNumber).useSkill(startingTile, targetTile, match);
			skills.get(skillNumber).setSkillCharges(skills.get(skillNumber).getSkillCharges()-1);
			return true;
		}
		return false;
		
	}
	@Override
	public String toString() {
		return "Weapon [damage=" + damage + ", skills=" + skills + ", range="
				+ range + ", cost=" + cost + ", name=" + name + "]";
	}

	public int getCost(){
		return this.cost;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Object o){
		if(this.getClass() == o.getClass()){
			return true;
		}
		return false;
	}
}  

