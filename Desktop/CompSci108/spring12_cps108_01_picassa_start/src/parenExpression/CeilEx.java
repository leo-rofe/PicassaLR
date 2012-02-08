package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class CeilEx extends ParenEx {

	public CeilEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return ceil(getOperands().get(0).evaluate(varMap));
	}

	// round up
	public static RGBColor ceil(RGBColor exp) {
		return new RGBColor(Math.ceil(exp.getRed()), Math.ceil(exp.getGreen()),
				Math.ceil(exp.getBlue()));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("ceil");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new CeilEx(operands);
		}

	}
}
