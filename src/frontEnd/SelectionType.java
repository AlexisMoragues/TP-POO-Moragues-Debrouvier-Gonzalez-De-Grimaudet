package frontEnd;

/**
 * Una clase que guarda el tipo de selection que se esta haciendo en la vista. Que puede ser:
 * Nada, Deploy, Movimiento, Attaque y Skill (Que guarda tambien el numero del skill)
 */
public class SelectionType {
	
	public static final int DEPLOYING = -1;
	public static final int NOTHING = 0;
	public static  final int MOVEMENT = 1;
	public static  final int ATTACK = 2;
	public static  final int SKILL = 3;
	
	
	private int typeSelected;
	

	public SelectionType(){
		this.typeSelected=NOTHING;
	}
	
	public void setTypeToDeploying(){
		typeSelected=DEPLOYING;
	}
	
	public void setTypeToNothing(){
		typeSelected=NOTHING;
	}
	
	public void setTypeToMovement(){
		typeSelected=MOVEMENT;
	}
	
	public void setTypeToAttack(){
		typeSelected=ATTACK;
	}
	
	public void setTypeToSkill(int skillNumber){
		typeSelected=SKILL+skillNumber; //Para poder guardar todos los skills, aunque sean mas de 3.
	}
	
	public boolean isTypeMovement(){
		return typeSelected == MOVEMENT;
	}
	
	public boolean isTypeAttack(){
		return typeSelected == ATTACK;
	}
	
	public boolean isTypeDeploying(){
		return typeSelected == DEPLOYING;
	}
	
	public boolean isTypeSkill(){
		return typeSelected >= SKILL;
	}
	
	public boolean isTypeNothing() {
		return typeSelected==NOTHING;
	}
	
	public int getSkillSelected(){
		if(isTypeSkill()){
			return typeSelected-SKILL;
		}
		else{
			return 0; 
		}
		
	}
	
}
