package fill;

import rasterize.Raster;
public class SeedFiller implements Filler{

    private Raster raster;
    private int x, y;

    int backgroundColor, fillColor;

    public SeedFiller(Raster raster, int x, int y, int backgroundColor, int fillColor){
        this. raster = raster;
        this.x = x;
        this.y = y;
        this.backgroundColor = backgroundColor;
        this.fillColor = fillColor;
    }
    public void fill() {
        seedFill(x,y);
    }

    private void seedFill(int x, int y){
        // 1. mačíst barvu na pozici x, y
        int pixelColor = raster.getPixel(x,y);

        //2. podmínka jestli pixelColor == backgroundColor
        //pokud se nerovnají, nepokračuju

        if (pixelColor == backgroundColor){
            //3. obarvím pixel
            raster.setPixel(x,y, 0x147856);
            seedFill(x+1, y);
            seedFill(x-1, y);
            seedFill(x, y+1);
            seedFill(x, y-1);
            //4. zavolám metodu seedFill pro 4 sousedy
        }
        else{
            return;
        }


    }
}
