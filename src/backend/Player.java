package backend;

/**
 * Representa un jugador 
 */
public class Player {

	private int team;
	private int resources;
	
/**
 * Crea un jugador
 * @param team Equipo del jugador
 * @param resources Cantidad de recursos que puede gastar
 */
	public Player(int team, int resources){
		if(team <0 || resources<0){
			throw new IllegalArgumentException();
		}
		this.team=team;
		this.resources=resources;
	}
		
	public int getTeam(){
		return this.team;
	}
	
	/**
	 * Deduce de la cantidad de recursos del jugador una pieza
	 * @param cost Valor de la pieza a deducir
	 */
	public void useResources(int cost){
		if(cost<=0){
			throw new IllegalArgumentException();
		}
		this.resources-=cost;
	}
	public int getResources(){
		return this.resources;
	}
	
}

