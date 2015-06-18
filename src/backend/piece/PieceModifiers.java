package backend.piece;

public class PieceModifiers { //Posta rever que esto no sea un java bean. QUzas usar constantes.
	

	
	private double attackModifier;
	private double dmgRecievedModifier;
	private int movementModifier;
	
	public PieceModifiers(){ 
		this.attackModifier=1;
		this.dmgRecievedModifier=1;
		this.movementModifier=0;
	}
	
	public double getDmgRecievedModifier(){
		return dmgRecievedModifier;
	}

	public double getAttackModifier(){
		return attackModifier;
	}

	public int getMovementModifier(){
		return movementModifier;
	}

	private void setAttackModifier(double attackModifier){
		this.attackModifier =  attackModifier;
	}

	private void setDmgRecievedModifier(double dmgRecievedModifier){
		this.dmgRecievedModifier =  dmgRecievedModifier;
	}

	private void setMovementModifier(int movementModifier){
		this.movementModifier =  movementModifier;
	}

	
	public void modifyAttackModifier(double modifier){
		this.setAttackModifier(attackModifier*modifier);
	}

	public void modifyMovementModifier(int modifier){
		this.setMovementModifier(movementModifier+modifier);
	}
	
	public void modifyDmgRecievedModifier(double modifier){
		this.setDmgRecievedModifier(dmgRecievedModifier*modifier);
	}
	
	public void resetAttackModifier (){
		this.setAttackModifier(1);
	}
	
	public void resetMovementModifier (){
		this.setMovementModifier(0);
	}
	
	public void resetDmgReceivedModifier (){
		this.setDmgRecievedModifier(1.0);
	}

	@Override
	public String toString() {
		return "PieceModifiers [attackModifier=" + attackModifier
				+ ", dmgRecievedModifier=" + dmgRecievedModifier
				+ ", movementModifier=" + movementModifier + "]";
	}
	
}


