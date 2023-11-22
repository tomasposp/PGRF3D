import fill.SeedFiller;
import model.Line;
import model.Point;
import model.Polygon;
import rasterize.LineRasterizer;
import rasterize.LineRasterizerTrivial;
import rasterize.PolygonRasterizer;
import rasterize.RasterBufferedImage;
import renderer.WiredRenderer;
import solid.Cube;
import solid.Solid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author PGRF FIM UHK
 * @version 2023.b
 */

public class App3D {

	private JPanel panel;
	private RasterBufferedImage raster;
	private int x,y;
	private Line line;
	private LineRasterizer lineRasterizer;
	private WiredRenderer wiredRenderer;

	private Solid cube;
	public App3D(int width, int height) {
		JFrame frame = new JFrame();

		frame.setLayout(new BorderLayout());

		frame.setTitle("UHK FIM PGRF : " + this.getClass().getName());
		frame.setResizable(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		raster = new RasterBufferedImage(width, height);
		lineRasterizer = new LineRasterizerTrivial(raster);
		wiredRenderer = new WiredRenderer();


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

		initScene();
	}

	public void initScene(){
		cube = new Cube();
	}
	public void drawScene(){
	wiredRenderer.render(cube);
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
		line = new Line(1,1,200,200,0xff0000);
		panel.repaint();
		drawScene();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new App3D(800, 600).start());
	}

}
