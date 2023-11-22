package rasterize;

import static java.lang.Math.abs;

public class LineRasterizerTrivial extends LineRasterizer{
    public LineRasterizerTrivial(Raster raster) {
        super(raster);
    }

    @Override
    protected void drawLine(int x1, int y1, int x2, int y2) {
        float k = (float)(y2-y1)/(x2-x1);
        float q = y1-(k*x1);
        if(abs((float)y2-y1) < abs((float) x2-x1))
        {
            if(x2<x1){
                int tmp = x1;
                x1 = x2;
                x2 =tmp;
            }
            for(int x = x1; x<=x2;x++) {
                int y = Math.round((k*x)+q);
                raster.setPixel(x,y,0xffff00);
            }
        }
        else{
            if(y2<y1){
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            for (int y = y1; y <= y2; y++) {
                int x = Math.round((y-q)/k);

                if(x2 == x1){
                    raster.setPixel(x2,y,0xffff00);
                }
                else{
                    raster.setPixel(x,y,0xffff00);
                }
            }
        }
    }
}
