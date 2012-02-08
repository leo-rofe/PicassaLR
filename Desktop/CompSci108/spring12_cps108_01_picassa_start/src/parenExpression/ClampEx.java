package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ClampEx extends ParenEx {

	public ClampEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return clamp(getOperands().get(0).evaluate(varMap));
	}

	// clamp results to [-1, 1]
	public static RGBColor clamp(RGBColor exp) {
		exp.clamp();
		return exp;
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("clamp");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new ClampEx(operands);
		}

	}
}
