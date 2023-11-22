package solid;

import transforms.Point3D;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Solid {
    protected ArrayList<Point3D> vb = new ArrayList<>();
    protected ArrayList<Integer> ib = new ArrayList<>();

    protected  void addIndicies(Integer... indicies){
        ib.addAll(Arrays.asList(indicies));
    }

    public ArrayList<Point3D> getVb() {
        return vb;
    }

    public ArrayList<Integer> getIb() {
        return ib;
    }
}
