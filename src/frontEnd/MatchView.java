package frontEnd;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MatchView extends JPanel{
	
	
	private JLabel cursorDescription;
	private JLabel playerTurn;
	private JLabel nextDeploy;
	private VisualBoard visualBoard;
	private JLabel skillsDescription;
	private JLabel controls;
	private String instructions;

	
	public MatchView(int width, int height){
		setLayout(null);
		setSize(1280, 800);
		Dimension size = getSize();
		
		
		cursorDescription = new JLabel("");
		cursorDescription.setBounds(size.width/2 - 500, 80, 200, 400);
		
		skillsDescription = new JLabel("");
		skillsDescription.setBounds(size.width/2 + 300, 40, 200, 500);
		
		playerTurn = new JLabel("");
		playerTurn.setBounds(size.width/2 - 150, 1, 700, 90);
		
		nextDeploy = new JLabel("");
		nextDeploy.setBounds(size.width/2 + 150, 1, 700, 90);
		
		visualBoard = new VisualBoard(width, height);
		visualBoard.setBounds(size.width/2 - 300, 91, 600, 600);
				
		
		
		instructions=addInstructions();
		controls = new JLabel(instructions);
		controls.setBounds(size.width/2 - 500, 400, 200, 400);

				
		this.add(cursorDescription);
		this.add(playerTurn);
		this.add(nextDeploy);
		this.add(controls);
		this.add(visualBoard);
		this.add(skillsDescription);
		
		}
	
	private String addInstructions() {
		instructions=new String();
		instructions="<html>";
		instructions+="CONTROLS";
		instructions+="<br>";
		instructions+="D: Deploy Unit";
		instructions+="<br>";
		instructions+="A: Select Unit and enter Attack Mode";
		instructions+="<br>";
		instructions+="M: Select Unit and enter Move Mode";
		instructions+="<br>";
		instructions+="SPACE: Confirm Action";
		instructions+="<br>";
		instructions+="ENTER: Pass Turn";
		instructions+="<br>";
		instructions+="UP ARROW: Cursor UP";
		instructions+="<br>";
		instructions+="DOWN ARROW: Cursor DOWN";
		instructions+="<br>";
		instructions+="LEFT ARROW: Cursor LEFT";
		instructions+="<br>";
		instructions+="RIGHT ARROW: Cursor RIGHT";
		instructions+="<br>";
		instructions+="1: Skill 1";
		instructions+="<br>";
		instructions+="2: Skill 2";
		instructions+="<br>";
		instructions+="3: Skill 3";
		instructions+="</html>";
		return instructions;
		
	}

	public void printCursorDescription(String text){
		cursorDescription.setText(text);
	}
	
	public void printNextDeploy(String text){
		nextDeploy.setText(text);
	}
	
	public void printPlayerTurn(String text){
		playerTurn.setText(text);
	}
	
	public void printSelectedTileDescription(String text){
		skillsDescription.setText(text);
	}
	
	public VisualBoard getVisualBoard(){
		return this.visualBoard;
	}
	
	
}
