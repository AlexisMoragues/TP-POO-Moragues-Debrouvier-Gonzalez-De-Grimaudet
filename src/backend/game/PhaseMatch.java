package backend.game;

/**
 * Una clase que guarda la estapa en la cual se esta en el Match. Que puede ser:
 * Deploy, Jugar y Fin.
 */
public class PhaseMatch {

	public static final int DEPLOYING = 0;
	public static  final int PLAYING = 1;
	public static  final int END = 2;
		
	private int actualPhase;
	

	public PhaseMatch(){
		this.actualPhase=DEPLOYING;
	}
	
	public void setTypeToDeploying(){
		actualPhase=DEPLOYING;
	}
	
	public void setTypeToPlaying(){
		actualPhase=PLAYING;
	}
	
	public void setTypeToEnd(){
		actualPhase=END;
	}
	
	public boolean isTypeDeploying(){
		return actualPhase == DEPLOYING;
	}
	
	public boolean isTypePlaying(){
		return actualPhase == PLAYING;
	}
	
	public boolean isTypeEnd(){
		return actualPhase == END;
	}
	
}
