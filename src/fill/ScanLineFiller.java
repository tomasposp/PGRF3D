package fill;

import model.Edge;
import model.Line;
import model.Point;
import model.Polygon;
import rasterize.LineRasterizer;
import rasterize.PolygonRasterizer;

import java.util.ArrayList;
import java.util.List;

public class ScanLineFiller implements Filler{
    private LineRasterizer lineRasterizer;
    private PolygonRasterizer polygonRasterizer;
    private Polygon polygon;

    public ScanLineFiller(LineRasterizer lineRasterizer, PolygonRasterizer polygonRasterizer, Polygon polygon) {
        this.lineRasterizer = lineRasterizer;
        this.polygonRasterizer = polygonRasterizer;
        this.polygon = polygon;
    }

    @Override
    public void fill() {
        // TODO: najít yMin a yMax v points

        // vytvořím seznam hran
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < polygon.getSize() - 1; i++) {
            Point p1 = polygon.getPoint(i);
            int indexP2 = i + 1;
            if(indexP2 == polygon.getSize())
                indexP2 = 0;
            Point p2 = polygon.getPoint(indexP2);

            Edge edge = new Edge(p1.x, p1.y, p2.x, p2.y);
            if(edge.isHorizontal())
                continue;

            edge.orientate();

            edges.add(edge);
        }

        // iterace yMin do yMax
        // {
            // pro každou hranu
            // {
                // 1. existuje průsečík?
                // 2. Pokud existuje, spočítám ho
                // 3. uložím do sezamu průsečíků
            // }

            // seřadit průsečíky
            // obarvím line mezi sudým a lichým
            // obarvím hranici polygonu
        // }

    }
}
