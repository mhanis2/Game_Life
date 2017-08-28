package sk.game.life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CellGridJPanel extends JPanel {

	private static final long serialVersionUID = 1928547002998310383L;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	private static final int SIDE_LENGTH = 10;

	private List<Rectangle2D> squares;
	private Rectangle2D cell;

	public CellGridJPanel() {
		squares = new ArrayList<>();
		cell = null;
		addMouseListener(new MouseHandler());
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	@Override
	public void paintComponent(Graphics g) {
		for (Rectangle2D rec : squares) {
			if (rec == cell) {
				double w = cell.getWidth();
				double h = cell.getHeight();
				g.fillRect((int) w - 10, (int) h - 10, 10, 10);
				setBackground(Color.RED);
			}
		}

		for (int i = 0; i < 300; i += 10) {
			for (int y = 0; y < 300; y += 10) {
				cell = new Rectangle2D.Double(i, y, DEFAULT_WIDTH, SIDE_LENGTH);
				squares.add(cell);
				g.drawRect(i, y, 10, 10);
			}
		}
	}

	public Rectangle2D find(Point2D point) {
		for (Rectangle2D rect : squares) {
			if (rect.contains(point)) {
				return rect;
			}
		}

		return null;
	}

	private class MouseHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent event) {
			
			Point p = event.getPoint();
			cell = find(p);


		}

		@Override
		public void mouseClicked(MouseEvent event) {
		}
	}
}
