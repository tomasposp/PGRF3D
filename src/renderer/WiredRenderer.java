package renderer;

import rasterize.LineRasterizer;
import solid.Solid;
import transforms.Point3D;

import java.awt.*;
import java.util.ArrayList;

public class WiredRenderer{
    private LineRasterizer lineRasterrizer;


    public void render (Solid solid){
    for (int i = 0; i < solid.getIb().size(); i+=2){
        int indexA = solid.getIb().get(i);
        int indexB = solid.getIb().get(i +1);

        Point3D a = solid.getVb().get(indexA);
        Point3D b = solid.getVb().get(indexB);

        lineRasterrizer.rasterize(
                (int)Math.round(a.getX()), (int)Math.round(a.getY()),
                (int)Math.round(b.getX()), (int)Math.round(b.getY()),
                Color.YELLOW
        );
        }
    }
    public void renderScene(ArrayList<Solid> scene){
        for (Solid solid : scene)
            render(solid);
    }
}
