package colorExpressions;

import java.util.ArrayList;
import java.util.HashMap;

import parenExpression.ParenEx;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ToLumEx extends ParenEx {

	public ToLumEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return rgb2ycrcb(getOperands().get(0).evaluate(varMap));
	}

	/**
	 * Convert color from RGB to YUV color space.
	 */
	public static RGBColor rgb2ycrcb(RGBColor c) {
		return new RGBColor(c.getRed() * 0.2989 + c.getGreen() * 0.5866
				+ c.getBlue() * 0.1145, c.getRed() * -0.1687 + c.getGreen()
				* -0.3312 + c.getBlue() * 0.5, c.getRed() * 0.5000
				+ c.getGreen() * -0.4183 + c.getBlue() * -0.0816);
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("rgbtoycrcb");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new ToLumEx(operands);
		}

	}
}
