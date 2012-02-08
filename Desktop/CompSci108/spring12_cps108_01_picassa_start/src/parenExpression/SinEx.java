package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class SinEx extends ParenEx {

	public SinEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return sine(getOperands().get(0).evaluate(varMap));
	}

	// sine, evaluate each component of color as if it were a radian value
	public static RGBColor sine(RGBColor exp) {
		return new RGBColor(Math.sin(Math.toRadians(exp.getRed())),
				Math.sin(Math.toRadians(exp.getGreen())), Math.sin(Math
						.toRadians(exp.getBlue())));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("sin");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new SinEx(operands);
		}

	}
}
