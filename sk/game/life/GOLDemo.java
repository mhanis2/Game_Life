package sk.game.life;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GOLDemo {
	public static void main(String[] args) {
		JFrame frame = new CellGrid();
		frame.setTitle("GOL");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(new CellGridJPanel());
		frame.setVisible(true);
	}
}
