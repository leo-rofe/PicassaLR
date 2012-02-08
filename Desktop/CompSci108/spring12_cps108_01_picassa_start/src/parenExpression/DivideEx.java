package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class DivideEx extends ParenEx {

	public DivideEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return divide(getOperands().get(0).evaluate(varMap),
				getOperands().get(1).evaluate(varMap));
	}

	/**
	 * Combine two colors by dividing their components.
	 */
	public static RGBColor divide(RGBColor left, RGBColor right) {
		return new RGBColor(left.getRed() / right.getRed(), left.getGreen()
				/ right.getGreen(), left.getBlue() / right.getBlue());
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return (command.equals("div")|| command.equals("/"));
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {

			return new DivideEx(operands);
		}

	}
}