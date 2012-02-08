package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class NegEx extends ParenEx {

	public NegEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return negate(getOperands().get(0).evaluate(varMap));
	}

	/**
	 * Negates (i.e. inverts) a given color
	 */
	public static RGBColor negate(RGBColor exp) {
		return new RGBColor(exp.getRed() * -1, exp.getGreen() * -1,
				exp.getBlue() * -1);
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return (command.equals("neg") || command.equals("!"));
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {

			return new NegEx(operands);
		}

	}
}
