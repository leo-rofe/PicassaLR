package model;


import java.awt.Dimension;
import java.util.HashMap;





/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 */
public class Model
{
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;
    public static final int NUM_FRAMES = 50;

    private double myCurrentTime = 0;


    /**
     * Advance to the next frame in the animation.
     */
    public void reset ()
    {
        myCurrentTime = -1;
    }


    /**
     * Advance to the next frame in the animation.
     */
    public void nextFrame ()
    {
        myCurrentTime += 1.0 / NUM_FRAMES*2;
    }


    /**
     * Evaluate an expression for each point in the image.
     */
    public Pixmap evaluate (String input, Dimension size)
    {
        
    	Pixmap result = new Pixmap(size);
        // create expression to evaluate just once
        EvalExpression toEval = new Parser(input).makeExpression();
        // evaluate at each pixel
        HashMap<String, RGBColor> letMap = new HashMap<String, RGBColor>();
        letMap.put("t", new RGBColor(myCurrentTime));
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            double evalY = imageToDomainScale(imageY, size.height);
            letMap.put("y", new RGBColor(evalY));
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                double evalX = imageToDomainScale(imageX, size.width);
                letMap.put("x", new RGBColor(evalX));
                result.setColor(imageX, imageY,
                                toEval.evaluate(letMap).toJavaColor());
            }
        }
        return result;
    }


    /**
     * Convert from image space to domain space.
     */
    protected double imageToDomainScale (int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double)value / bounds) * range + DOMAIN_MIN;
    }
}
