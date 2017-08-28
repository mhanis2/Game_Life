package sk.game.life;

import javax.swing.JFrame;

public class CellGrid extends JFrame {

	private static final long serialVersionUID = 1928547002998310383L;

	public CellGrid() {
		add(new CellGridJPanel());
		pack();
	}
}
