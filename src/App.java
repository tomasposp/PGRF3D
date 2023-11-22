import fill.SeedFiller;
import model.Line;
import model.Point;
import rasterize.*;
import model.Polygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author PGRF FIM UHK
 * @version 2023.b
 */

public class App {

	private JPanel panel;
	private RasterBufferedImage raster;
	private int x,y;
	private Line line;
	private LineRasterizer lineRasterizer;
	private Polygon polygon;
	private PolygonRasterizer PolygonRasterizer;
	public App(int width, int height) {
		JFrame frame = new JFrame();

		frame.setLayout(new BorderLayout());

		frame.setTitle("UHK FIM PGRF : " + this.getClass().getName());
		frame.setResizable(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		raster = new RasterBufferedImage(width, height);
		//rasterizers
		lineRasterizer = new LineRasterizerTrivial(raster);
		PolygonRasterizer = new PolygonRasterizer(lineRasterizer);


		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				present(g);
			}
		};
		panel.setPreferredSize(new Dimension(width, height));

		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
/*
		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				clear(0xaaaaaa);
				// TODO: init draw
				line = new Line(100,100,e.getX(),e.getY(),0xff0000);
				lineRasterizer.rasterize(line);

				panel.repaint();
			}
		});*/

		polygon = new Polygon();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				raster.clear();

				if(e.getButton()== MouseEvent.BUTTON1){
					Point point = new Point(e.getX(), e.getY());
					polygon.addPoint(point);
				}
				PolygonRasterizer.rasterize(polygon);

				if(e.getButton()== MouseEvent.BUTTON3){
					SeedFiller seedFiller = new SeedFiller(raster, e.getX(), e.getY(), new Color(raster.getColor()).getRGB(), 0xff0000);
					seedFiller.fill();
				}


				panel.repaint();
			}
		});
	}

	public void clear(int color) {
		raster.setClearColor(color);
		raster.clear();

	}

	public void present(Graphics graphics) {
		raster.repaint(graphics);
	}

	public void start() {
		clear(0x000000);
		// TODO: init draw
		line = new Line(1,1,200,200,0xff0000);
		//lineRasterizer.rasterize(line);

		panel.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new App(800, 600).start());
	}

}
