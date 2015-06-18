package backend.piece;


import java.util.ArrayList;

import backend.Constants;
import backend.game.MatchModel;
import backend.game.Tile;
import backend.skills.skillType.Skill;
import backend.weapons.Weapon;

/**
 * Clase que representa las piezas del juego 
 */
public abstract class Piece implements Constants{
	
	private MatchModel match;
	
	private Tile position=null;
	private int health;
	private int maxHealth;
	private Weapon weapon;
	private int team;
	private int movement;
	private String name;
	
	private PieceModifiers modifiers;
	
	private boolean moved;
	private boolean attacked;
	
	/**
	 * Crea una pieza
	 * @param maxHealth Vida m�xima 
	 * @param team 
	 * @param movement Cantidad de casilleros que la pieza puede moverse
	 * @param weapon Arma que utiliza la pieza
	 * @param name
	 */
	public Piece(int maxHealth, int team, int movement, Weapon weapon, String name, MatchModel match){
		if(maxHealth<0 || team < 0 || weapon == null || movement < 0 || name == null){
			throw new IllegalArgumentException();
		}
		
		this.match=match;
		this.health=maxHealth;
		this.maxHealth=maxHealth;
		this.team=team;
		this.weapon=weapon;
		this.movement=movement;
		this.name = name+ " " + team;
		this.moved = true;
		this.attacked = true;
		this.modifiers = new PieceModifiers();
		
		
	}
	
	public void setMatch(MatchModel match){
		this.match = match;
	}
	
	public double getDmgRecievedModifier(){
		return modifiers.getDmgRecievedModifier();
	}

	public double getAttackModifier(){
		return modifiers.getAttackModifier();
	}

	public int getMovementModifier(){
		return modifiers.getMovementModifier();
	}

	public void modifyAttackModifier(double modifier){
		modifiers.modifyAttackModifier(modifier);
	}

	public void modifyMovementModifier(int modifier){
		modifiers.modifyMovementModifier(modifier);
	}
	
	public void modifyDmgReceivedModifier(double modifier){
		
		modifiers.modifyDmgRecievedModifier(modifier);
	}
	
	public void resetAttackModifier (){
		modifiers.resetAttackModifier();
	}
	
	public void resetMovementModifier (){
		modifiers.resetMovementModifier();
	}
	
	public void resetDmgReceivedModifier (){
		modifiers.resetDmgReceivedModifier();
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * Reduce la health de la pieza.
	 * @param damage Da�o realizado sobre la pieza
	 * @return true Si mato a la pieza
	 * 			false Caso contrario
	 */
	public boolean receiveDamage(int damage){
		if (damage < 0){
			throw new IllegalArgumentException("Damage can't be negative");
		}
		if(health<=damage){
			this.setHealth(0);
			match.removePiece(this);
			return true;
		}
		this.setHealth(health-damage);
		return false;
	}
	
	public boolean heal(int hp){
		
		if (hp<0){
			throw new IllegalArgumentException();
		}
				
		if(this.health==this.maxHealth){
			return false;
		}
		if(this.health+hp>=this.maxHealth){
			this.setHealth(this.maxHealth);
			return true;
		}
		this.health+=hp;
		return true;
	}
	
	public boolean changeMaxHealth(int hp) {// puede ser void
		if (hp<0){
			return false;
		}
		if (this.health>hp){
			this.setHealth(hp);
		}
		this.setMaxHealth(hp);
	
		return true;	
	}
	
	public boolean getMoved(){
		return this.moved;
	}
	
	public boolean getAttacked(){
		return this.attacked;
	}
	
	public void setMoved(boolean moved){
		this.moved=moved;
	}
	
	public void setAttacked(boolean attacked){
		this.attacked=attacked;
	}
	
	public void setPosition(Tile tile){
		if(tile!=null){
			this.position=tile;
			tile.putPiece(this);
		}		
	}
	public Tile getPosition(){
		return this.position;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public int getMovement(){
		return this.movement;
	}
	
	public int getMaxHealth(){
		return this.maxHealth;
	}
	
	public int getTeam(){
		return this.team;
	}
	
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	private void setHealth(int health){
		if (health < 0){
			throw new IllegalArgumentException("The health can't be negative");
		}
		this.health=health;
	}
	
	public int getDamage(){
		return this.weapon.getDamage();
	}
	
	public ArrayList<Skill> getSkill(){
		return weapon.getSkill();
	}
	
	public int getCost(){
		return this.weapon.getCost();
	}
	
	public int getRange(){
		return this.weapon.getRange();
	}
	/**
	 * @see weapon.tryToSkill
	 */
	public boolean tryToSkill(Tile StartingTile, Tile TargetTile, int skillNumber){
		if(match==null){
			throw new IllegalArgumentException("Match can't be null");
		}
		if(!match.getPhaseMatch().isTypePlaying()){
			return false;
		}
		if(attacked==true){
			return false;
		}
		 if(weapon.tryToSkill(StartingTile,TargetTile, skillNumber, match)){
			 setMoved(true);
			 setAttacked(true);
			 return true;
		 }
		 return false;
	}
	
	/**
	 * Imprime todas las propiedades de la pieza
	 */
	
	
	@Override
	public String toString() {
		return "Piece [name =" + name + ", position=" + position + ", health=" + health +
				", maxHealth=" + maxHealth + ", team=" + team +
				", movement=" + movement + ", weapon=" + weapon  + ", modifiers=" + modifiers + ", moved=" + moved
				+ ", attacked=" + attacked + "]";
	}
	
	public int hashcode(){
		return health + maxHealth + movement + team;
	}
	
	public boolean equals(Piece piece){
		if(this == (Object)piece){
			return true;
		}
		return false;
	}

	/**
	 * Resetea el estado de attacked y moved a falso
	 */
	public void reset(){
		setAttacked(false);
		setMoved(false);
	}
	
	/**
	 * Ataca a la pieza ubicada en una tile
	 * @param targetTile Tile donde debe efectuarse el ataque
	 * @return true si pudo atacar a la pieza
	 * false si no habia pieza, se encuentra fuera de rango o es del mismo equipo
	 */
	public boolean attack(Tile targetTile){
		if(targetTile==null){
			throw new IllegalArgumentException("TargetTile can't be null");
		}
		if(match==null){
			throw new IllegalArgumentException("Match can't be null");
		}
		if(!match.getPhaseMatch().isTypePlaying()){
			return false;
		}
		if(match.getPiece(targetTile)==null){
			return false;
		}
		if(attacked==true){
			return false;
		}
		if(match.getDistance(this.getPosition(),targetTile) > this.getRange()){
			return false;
		}
		if(this.getTeam() == match.getPiece(targetTile).getTeam()){
			return false;
		}
		Piece targetPiece = match.getPiece(targetTile);
		targetPiece.receiveDamage((int) (this.getDamage()*this.getAttackModifier()*targetPiece.getDmgRecievedModifier()));
		this.setAttacked(true);
		this.setMoved(true);
		this.resetAttackModifier();
		targetPiece.resetDmgReceivedModifier();
		return true;
	}
	
	/**
	 * Mueve la pieza a otra Tile.
	 * @param targetTile Tile a donde se mover�a la pieza
	 * @return true si la pieza se pudo mover
	 * false si la Tile est� ocupada o fuera de rango o si la pieza ya se movi�
	 */
	public boolean move(Tile targetTile){
		if(targetTile==null){
			throw new IllegalArgumentException("TargetTile can't be null");
		}
		if(match==null){
			throw new IllegalArgumentException("Match can't be null");
		}
		if(!match.getPhaseMatch().isTypePlaying()){
			return false;
		}
		if(targetTile.getPiece()!=null){
			return false;
		}
		if(moved==true){
			return false;
		}
		int newMovement = this.getMovementModified();
		if(match.getDistance(this.getPosition(),targetTile) > newMovement){
			return false;
		}
		match.removePiece(this);
		match.putPiece(this, targetTile);
		this.setPosition(targetTile);
		this.setMoved(true);
		this.resetMovementModifier();
		return true;
	}
	
	/**
	 * 
	 * @return El movimiento de la pieza despues de recibir las modificaciones del MovementModifier. Retorna minimo 1.
	 */
	public int getMovementModified() {
		int newMovement = this.getMovement()+this.getMovementModifier();
		if(newMovement<1){ 
			newMovement=1;//Movimiento minimo 1
		}
		return newMovement;
	}

	private void setMaxHealth(int maxHealth){
		if (maxHealth < 0){
			throw new IllegalArgumentException("The maximum health can't be negative");
		}
		this.maxHealth=maxHealth;
	}

}
