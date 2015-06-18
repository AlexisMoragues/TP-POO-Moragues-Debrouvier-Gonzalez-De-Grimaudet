package frontEnd;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import backend.game.MatchModel;
import backend.game.Tile;
import backend.piece.Piece;
import backend.skills.skillType.Skill;

public class MatchController {

	private int x;
	private int y;
	private MatchModel matchModel;
	
	private GameView view;
	private Tile tileSelected;
	private SelectionType selectedType;
	
	public MatchController(ArrayList<ArrayList<Piece>> deployPieces, GameView view, int width, int height){
		
		this.view=view;
		view.newMatchPanel(width, height);
		view.getMatchPanel().setVisible(true);
		
		matchModel = new MatchModel(width,height,deployPieces);
		
		this.tileSelected = new Tile(0,0); 
		
		this.x=0;
		this.y=0;
				
		
		this.selectedType = new SelectionType();
		selectedType.setTypeToDeploying();
		
		
		view.addKeyListener(new AL());
		
		
		
		printTurn();
		printNextDeploy();
		fillAndUpdate();
		
		
	}
	
	public Tile getTileSelected(){
		return tileSelected;
	}
	
	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	private void setX(int x){
		this.x = x;
	}

	private void setY(int y){
		this.y = y;
	}
	
	public Tile getCursorPosition() {
		return matchModel.getTile(x, y);
	}

	private void setTileSelected(Tile newTileSelected){
		tileSelected = newTileSelected;
		updateSelectedTileDescription();
	}
	
	private void printTurn(){
		view.getMatchPanel().printPlayerTurn("Turn: Player "+matchModel.getPlayerTurn());
	}
	
	private void printNextDeploy(){
		if(matchModel.getDeployPieces().get(matchModel.getPlayerTurn()-1).size()!=0)
		view.getMatchPanel().printNextDeploy("Next Deploy: " + matchModel.getLastPiece().getWeapon().getName() + " " + matchModel.getLastPiece().getName() );
		else
		view.getMatchPanel().printNextDeploy("");
	}
	
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			//Case
			if(keyCode==KeyEvent.VK_LEFT){
				
				moveCursor(0,-1);
				
			}
			if(keyCode==KeyEvent.VK_RIGHT){
				
				moveCursor(0,1);
				
			}
			if(keyCode==KeyEvent.VK_UP){
				
				moveCursor(-1,0);
			
			}
			if(keyCode==KeyEvent.VK_DOWN){
				
				moveCursor(1,0);
			
			}
			
			if(keyCode==KeyEvent.VK_ENTER){
				if(!selectedType.isTypeDeploying()){
					clearBackgroundBoard();
					matchModel.pass();
					printTurn();
					fillBackgroundBoard();
				}
				
			}
			
			if(keyCode==KeyEvent.VK_SPACE){
				
				clearBoard();
				Piece pieceSelected;
				if(tileSelected == null){
					pieceSelected = null;
				}
				else{
					pieceSelected = tileSelected.getPiece();
				}
				
				if(selectedType.isTypeMovement()){
					if(pieceSelected!=null){//Moviemiento
						if(matchModel.sameTeamPiece(pieceSelected)){
							if(pieceSelected.move(getCursorPosition() )){
								selectedType.setTypeToNothing();
							}
						}
					}
				}
				
				if(selectedType.isTypeAttack()){
					if(pieceSelected!=null){
						if(matchModel.sameTeamPiece(pieceSelected)){ 
							if(pieceSelected.attack(matchModel.getTile(x, y))){
								selectedType.setTypeToNothing();
							}
						}
					}
				}
				
				if(selectedType.isTypeSkill()){
					if(pieceSelected!=null){
						if(matchModel.sameTeamPiece(pieceSelected)){
							if(pieceSelected.tryToSkill(tileSelected,matchModel.getTile(x, y),selectedType.getSkillSelected())){
								selectedType.setTypeToNothing();
							}
						}
					}
				}
				
				fillAndUpdate();
				
			}
			
			
			if(keyCode == KeyEvent.VK_M){
				if(!selectedType.isTypeDeploying()){
					if(getCursorPosition()!=null){
						
						Piece pieceCursorPosition = getCursorPosition().getPiece();
						if(pieceCursorPosition!=null){//Selection
							
							if(matchModel.sameTeamPiece(pieceCursorPosition)){
								clearBackgroundBoard();
								setTileSelected(getCursorPosition());
								selectedType.setTypeToMovement();
								fillBackgroundBoard();
							}
						}
						
					}
				}
			}
			
			if(keyCode == KeyEvent.VK_A){
				if(!selectedType.isTypeDeploying()){
					if(getCursorPosition()!=null){
						Piece pieceCursorPosition = getCursorPosition().getPiece();
						if(pieceCursorPosition!=null){//Si no estoy en un null
						
							if(matchModel.sameTeamPiece(pieceCursorPosition)){//Si es de mi equipo
								
								if(getCursorPosition().getPiece().getAttacked()!=true){ //Si no ataco
									clearBackgroundBoard();
									setTileSelected(getCursorPosition());
									selectedType.setTypeToAttack();
									fillBackgroundBoard();
								}
							}
						}
					}
					
				}
			}
			
			if(keyCode == KeyEvent.VK_D){ 
				if(selectedType.isTypeDeploying()){
					clearBoard();
					matchModel.deployPiece(x, y);
					if(!matchModel.getPhaseMatch().isTypeDeploying()){
						selectedType.setTypeToNothing();
					}
					printNextDeploy();
					printTurn();
					fillAndUpdate();
				}	
			}
			
				
			if(keyCode == KeyEvent.VK_1){
				SelectSkill(0);
				
			}
			if(keyCode == KeyEvent.VK_2){
				SelectSkill(1);
				
			}
			if(keyCode == KeyEvent.VK_3){
				SelectSkill(2);
				
			}
						
		}

		private void moveCursor(int XToAdd, int YToadd) {
			clearBackgroundBoard();
			
			addXY(XToAdd,YToadd);
			
			fillBackgroundBoard();
			printPosition();
		}
	}//Fin del keyAdapter

	private void SelectSkill(int skillNumber){
		if(!selectedType.isTypeDeploying()){
			if(getCursorPosition().getPiece()!=null){ //Si no estoy en un null
				clearBackgroundBoard();
				setTileSelected(getCursorPosition());
				selectedType.setTypeToSkill(skillNumber);
				fillAndUpdate();
			}
		}
	}
	
	private void addXY(int XToAdd, int YToadd){
		if(this.x+XToAdd>=0 && this.x+XToAdd < matchModel.getHeight()){
			setX(this.x+XToAdd);
		}
		if(this.y+YToadd>=0 && this.y+YToadd < matchModel.getWidth()){
			setY(this.y+YToadd);
		}
	} 

	
	
	private void updateSelectedTileDescription() {
		String selectedUnitDescription = getTileDescription(getTileSelected());
		view.getMatchPanel().printSelectedTileDescription(selectedUnitDescription);
		
	}
	

	private void printPosition(){
		String tileDescription = getTileDescription(getCursorPosition());
		view.getMatchPanel().printCursorDescription(tileDescription);
		
	}
		
	private String getTileDescription(Tile pieceTile){
		String PieceDescription = "<html>";
		Piece piece = pieceTile.getPiece(); 
		if(piece != null){
			PieceDescription += piece.getWeapon().getName() + piece.getName();	
			PieceDescription += "<br>";	
			PieceDescription += "Health " + piece.getHealth() + "/" + piece.getMaxHealth();
			PieceDescription += "<br>";	
			PieceDescription += "Attack: " + piece.getDamage() + " Range: " + piece.getRange();
			PieceDescription += "<br>";
			PieceDescription += "Movement: " + piece.getMovement();
			PieceDescription += "<br>";	
			PieceDescription += "MovementModifier: " + piece.getMovementModifier();
			PieceDescription += "<br>";	
			PieceDescription += "AttackModifier: " + piece.getAttackModifier();
			PieceDescription += "<br>";	
			PieceDescription += "DmgReceivedModifier: " + piece.getDmgRecievedModifier();
			PieceDescription += "<br><br>";	
			for(Skill skill: piece.getSkill()){
				
				PieceDescription += "Skill " + (piece.getSkill().indexOf(skill)+1) + ": " + skill.getSkillDescription();
				PieceDescription += "<br>";	
				PieceDescription += "Charges: " + skill.getSkillCharges();
				PieceDescription += "<br><br>";	
							
			}
			
		}
		PieceDescription += "</html>";
		return PieceDescription;
	}
				
	public int coordinatesToInt(Tile cursorPosition) {
		return cursorPosition.getPositionX()*matchModel.getWidth()+cursorPosition.getPositionY();
	}
	
	/**
	 * Saca todos los colores del Background del VisualBoard.
	 */
	public void clearBackgroundBoard(){
		for(int i=0; i<matchModel.getPieces().size() ; i++){ //Para cada jugador de pieces
			for(Piece piece: matchModel.getPieces().get(i)){ //Para cada Pieza de cada Jugador
				if(piece.getPosition()!=null){ // No hay que pintar las piezas que no pusimos todavia.
					view.getMatchPanel().getVisualBoard().removeColor(coordinatesToInt(piece.getPosition()));
				}
			}
		}
		
		if(selectedType.isTypeDeploying()){
			for(Tile tileDeployable: getAreaDeployable()){
				view.getMatchPanel().getVisualBoard().removeColor(coordinatesToInt(tileDeployable));
			}
		}
		
		
		if(selectedType.isTypeMovement()){
			if(tileSelected.getPiece()!=null){//Pinta de color todo lo que esta  a distancia igual a movement Modified	
				int movementModified = tileSelected.getPiece().getMovementModified();
				paintColorInStar(movementModified, null, tileSelected);
			}
		}
		if(selectedType.isTypeAttack()){
			if(tileSelected.getPiece()!=null){//Pinta de color todo lo que esta  a distancia igual a movement Modified	
				int range = tileSelected.getPiece().getRange();
				paintColorInStar(range, null, tileSelected);
			}
		}
				
		view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(getCursorPosition()),null);
		
		
		if(selectedType.isTypeSkill()){
			if(matchModel.getPiece(tileSelected)!=null){
				if(tileSelected.getPiece().getSkill().size()> selectedType.getSkillSelected()){
					Skill skillSelected = tileSelected.getPiece().getSkill().get(selectedType.getSkillSelected());
					int rangeSkill = skillSelected.getRange();
					paintColorInStar(rangeSkill, null, tileSelected);
					for(Tile targetTiles : skillSelected.getAreaOfEffect().getAreaOfEffect(tileSelected, getCursorPosition(), matchModel)){
						view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(targetTiles),null);
					}
				}
			}
		}
		view.getMatchPanel().getVisualBoard().repaint();
		view.getMatchPanel().getVisualBoard().revalidate();
	}
	
	/**
	 * Saca todas las imagenes de las piezas del VisualBoard
	 */
	public void clearPieces(){
		for(int i=0; i<matchModel.getPieces().size() ; i++){ //Para cada jugador de pieces
			
			for(Piece piece: matchModel.getPieces().get(i)){ //Para cada Pieza de cada Jugador
				
				if(piece.getPosition()!=null){ // No hay que pintar las piezas que no pusimos todavia.
					
					view.getMatchPanel().getVisualBoard().removePiece(coordinatesToInt(piece.getPosition()));
					
				}
			}
		}
		view.getMatchPanel().getVisualBoard().repaint();
		view.getMatchPanel().getVisualBoard().revalidate();
	}
	

	
	/**
	 * @see clearBackgroundBoard
	 * @see clearPieces
	 */
	public void clearBoard(){
		clearBackgroundBoard();
		clearPieces();
	}
	
	
	/**
	 *Pone todas las imagenes de las piezas en el VisualBoard
	 */
	public void fillBackgroundBoard(){
		for(int i=0; i<matchModel.getPieces().size() ; i++){ //Para cada jugador de pieces
			for(Piece piece: matchModel.getPieces().get(i)){ //Para cada Pieza de cada Jugador.
				if(piece.getPosition()!=null){ // No hay que pintar las piezas que no pusimos todavia. 
					if(piece.getHealth()>0){
						if(matchModel.sameTeamPiece(piece)){
							if(!piece.getMoved()){
								view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(piece.getPosition()), Color.cyan);
							}
							else{
								if(!piece.getAttacked()){
									view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(piece.getPosition()), Color.magenta);
								}
								else{
									view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(piece.getPosition()), Color.gray);
								}
							}
						}else{
							view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(piece.getPosition()), Color.DARK_GRAY);
						}
					}
				}
			}
			
		}
		
		
		
		if(selectedType.isTypeDeploying()){
			for(Tile tileDeployable: getAreaDeployable()){
				view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(tileDeployable), Color.yellow);
			}
		}
		
		
		if(selectedType.isTypeMovement()){
			if(tileSelected!=null){
				Piece pieceSelected = tileSelected.getPiece();
				if(pieceSelected!=null){
					if(matchModel.sameTeamPiece(pieceSelected)){
						if(!pieceSelected.getMoved()){
							int movementModified = pieceSelected.getMovementModified();
							paintColorInStar(movementModified, Color.blue, tileSelected);
						}
					}
				}
				
			}					
		}
		
		if(selectedType.isTypeAttack()){
			if(tileSelected!=null){
				Piece pieceSelected = tileSelected.getPiece();
				if(pieceSelected!=null){
					if(matchModel.sameTeamPiece(pieceSelected)){
						if(!tileSelected.getPiece().getAttacked()){
							int range = tileSelected.getPiece().getRange();
							paintColorInStar(range, Color.red, tileSelected);
						}
					}
				}
			}
		}
		
		view.getMatchPanel().getVisualBoard().updateCursor(coordinatesToInt(getCursorPosition()));
		
		
		if(selectedType.isTypeSkill()){
			if(tileSelected!=null){
				Piece pieceSelected = tileSelected.getPiece();
				if(pieceSelected!=null){
					if(matchModel.sameTeamPiece(pieceSelected)){
						if(!pieceSelected.getAttacked()){
							if(pieceSelected.getSkill().size()> selectedType.getSkillSelected()){
								Skill skillSelected = pieceSelected.getSkill().get(selectedType.getSkillSelected());
								int rangeSkill = skillSelected.getRange();
								if(skillSelected.getSkillCharges()>0){
									paintColorInStar(rangeSkill, Color.yellow, tileSelected);
									view.getMatchPanel().getVisualBoard().updateCursor(coordinatesToInt(getCursorPosition()));
									if(skillSelected.checkValidTarget(tileSelected, getCursorPosition(), matchModel)){
										for(Tile targetTiles : skillSelected.getAreaOfEffect().getAreaOfEffect(tileSelected, getCursorPosition(), matchModel)){
											view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(targetTiles), Color.orange);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		view.getMatchPanel().getVisualBoard().repaint();
		view.getMatchPanel().getVisualBoard().revalidate();
	}
	
	private ArrayList<Tile> getAreaDeployable() {
		return matchModel.getAreaDeployable();
	}

	/**
	 * Pone todos los colores del Background del VisualBoard.
	 */
	public void fillPieces(){
		for(int i=0; i<matchModel.getPieces().size() ; i++){ //Para cada jugador de pieces
			for(Piece piece: matchModel.getPieces().get(i)){ //Para cada Pieza de cada Jugador
				if(piece.getPosition()!=null){ // No hay que pintar las piezas que no pusimos todavia.
					view.getMatchPanel().getVisualBoard().updatePiece(piece);
				}
			}
		}
		view.getMatchPanel().getVisualBoard().repaint();
		view.getMatchPanel().getVisualBoard().revalidate();
	}
	
	/**
	 * @see fillBackgroundBoard
	 * @see fillPieces
	 */
	public void fillBoard(){
		fillPieces();
		fillBackgroundBoard();
	}
	
	/**
	 * Llena el VisualBoard con todas las piezas y los colores del Background y imprime quien gano en caso de que alguien gane
	 */
	public void fillAndUpdate(){
		fillBoard();		
		updateSelectedTileDescription();
		printPosition();
		int whoWon = matchModel.whoWon();
		if(matchModel.getPhaseMatch().isTypeEnd()){
			matchEnd(whoWon);
		}
	}
	
	
	
	
	
	private void matchEnd(int whoWon) {
		view.setVisible(false);
		view.dispose();
		new IntroController("Player " + whoWon + " Won");
	}	

	/**
	 * Pinta el fondo de todos los casilleros tablero, que esten a una distancia de la startingTile menor o igual que dimension, 
	 * del color que recibe 
	 * @param dimension
	 * @param color
	 * @param startingTile
	 */
	private void paintColorInStar(int dimension, Color color, Tile startingTile){
		for(int i=-dimension; i<=dimension; i++){ 
			//i va a recorrer de izquierda a derecha todo el ancho del rombo de movimiento
			for(int j=0; Math.abs(i)+Math.abs(j)<=dimension; j++){ 
				//Si el movimiento es 3, cuando i es 3, j es 0. Si i es 2 j es 0 o 1
				//Tengo entonces toda la piramide superior del rombo de movimiento
				if(startingTile.getPositionX()+i>=0 && startingTile.getPositionX()+i<matchModel.getHeight()){
					
					if(startingTile.getPositionY()+j>=0 && startingTile.getPositionY()+j<matchModel.getWidth()){
						//No tiene que irse afuera del tablero
						Tile targetTile = matchModel.getTile(startingTile.getPositionX()+i, startingTile.getPositionY()+j);
						//targetTile seria entonces la tile donde estan ahora mis i y j. 
						//(Teniendo en cuenta la position inicial).
						view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(targetTile), color);
						
					}
					//Lo mismo pero para la otra punta de la piramide. Cambio +j por -j
					if(startingTile.getPositionY()-j>=0 && startingTile.getPositionY()-j<matchModel.getWidth()){
						Tile targetTile = matchModel.getTile(startingTile.getPositionX()+i, startingTile.getPositionY()-j);
						view.getMatchPanel().getVisualBoard().updateBackground(coordinatesToInt(targetTile), color);
						
					}
				}
			}
		}
	}
}
