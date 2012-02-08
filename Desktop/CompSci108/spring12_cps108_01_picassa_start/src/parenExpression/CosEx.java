package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class CosEx extends ParenEx {

	public CosEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return cos(getOperands().get(0).evaluate(varMap));
	}

	// cosine, evaluate each component of color as if it were a radian value
	public static RGBColor cos(RGBColor exp) {
		return new RGBColor(Math.cos(Math.toRadians(exp.getRed())),
				Math.cos(Math.toRadians(exp.getGreen())), Math.cos(Math
						.toRadians(exp.getBlue())));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("cos");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new CosEx(operands);
		}

	}
}
