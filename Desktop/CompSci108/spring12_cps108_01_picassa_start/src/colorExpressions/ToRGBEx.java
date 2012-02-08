package colorExpressions;

import java.util.ArrayList;
import java.util.HashMap;

import parenExpression.ParenEx;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ToRGBEx extends ParenEx {

	public ToRGBEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return ycrcb2rgb(getOperands().get(0).evaluate(varMap));
	}

	/**
	 * Convert color from YUV to RGB color space.
	 */
	public static RGBColor ycrcb2rgb(RGBColor c) {
		return new RGBColor(c.getRed() + c.getBlue() * 1.4022, c.getRed()
				+ c.getGreen() * -0.3456 + c.getBlue() * -0.7145, c.getRed()
				+ c.getGreen() * 1.7710);
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("ycrcbtorgb");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new ToRGBEx(operands);
		}

	}
}
