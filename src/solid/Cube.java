package solid;

import model.Point;
import transforms.Point3D;

public class Cube extends Solid {
    public Cube(){
        vb.add(new Point3D(200,400,1));
        vb.add(new Point3D(400,400,1));
        vb.add(new Point3D(400,200,1));
        vb.add(new Point3D(200,200,1));

        addIndicies(0,1,
                    1,2,
                    0,3,
                    3,1,
                    3,2);
    }
}
