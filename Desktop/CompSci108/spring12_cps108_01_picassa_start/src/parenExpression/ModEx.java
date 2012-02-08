package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ModEx extends ParenEx {

	public ModEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return mod(getOperands().get(0).evaluate(varMap), getOperands().get(1)
				.evaluate(varMap));
	}

	/**
	 * Combine two colors by moding their components.
	 */
	public static RGBColor mod(RGBColor left, RGBColor right) {
		return new RGBColor(left.getRed() % right.getRed(), left.getGreen()
				% right.getGreen(), left.getBlue() % right.getBlue());
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return (command.equals("mod") || command.equals("%"));
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {

			return new ModEx(operands);
		}

	}
}
