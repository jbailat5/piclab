import java.awt.Color;
public class Steganography {

    public static void clearLow(Pixel P){
        P.setGreen((P.getGreen()/4)*4);
        P.setRed((P.getRed()/4)*4);
        P.setBlue((P.getBlue()/4)*4);

    }

    public static Picture testClearLow(Picture p){
       Picture copy = new Picture(p);
       Pixel[][] pixels = copy.getPixels2D();
		for (int i = 0; i < copy.getHeight(); i++) {
			for (int j = 0; j < copy.getWidth(); j++) {
				clearLow(copy.getPixel(j, i));
			}
		}

		return copy;
	}


    public static void setLow(Pixel p, Color c){
        int red = p.getRed() / 4 * 4;
        int green = p.getGreen() / 4 * 4;
        int blue = p.getBlue() / 4 * 4;

        p.setRed(red + (c.getRed()/64));
        p.setGreen(green + (c.getGreen()/64));
        p.setBlue(blue + (c.getBlue()/64));

    }

    public static void main(String[] args){

        Picture beach = new Picture("beach.jpg");
        beach.explore();
        Picture copy = testClearLow(beach);
        copy.explore();

        Picture beach2 = new Picture ("beach.jpg")
        beach2.explore();
        Picture copy2 = testClearLow(beach2, Color.PINK);
        copy2.explore();

    }
}
