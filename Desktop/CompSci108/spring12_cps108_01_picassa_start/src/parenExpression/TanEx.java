package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class TanEx extends ParenEx {

	public TanEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return tan(getOperands().get(0).evaluate(varMap));
	}

	// tan, evaluate each component of color as if it were a radian value
	public static RGBColor tan(RGBColor exp) {
		return new RGBColor(Math.tan(Math.toRadians(exp.getRed())),
				Math.tan(Math.toRadians(exp.getGreen())), Math.tan(Math
						.toRadians(exp.getBlue())));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("tan");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new TanEx(operands);
		}

	}
}
