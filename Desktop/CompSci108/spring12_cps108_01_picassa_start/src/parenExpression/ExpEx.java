package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ExpEx extends ParenEx {

	public ExpEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return exp(getOperands().get(0).evaluate(varMap), getOperands().get(1)
				.evaluate(varMap));
	}

	/**
	 * Combine two colors by taking the power of their components.
	 */
	public static RGBColor exp(RGBColor left, RGBColor right) {
		return new RGBColor(Math.pow(left.getRed(), right.getRed()), Math.pow(
				left.getGreen(), right.getGreen()), Math.pow(left.getBlue(),
				right.getBlue()));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return (command.equals("exp") || command.equals("^"));
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {

			return new ExpEx(operands);
		}

	}
}
