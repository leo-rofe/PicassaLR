package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class WrapEx extends ParenEx {

	public WrapEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return wrap(getOperands().get(0).evaluate(varMap));
	}

	// wrap results around [-1, 1] (i.e., 1.5 -> -0.5)
	public static RGBColor wrap(RGBColor exp) {
		exp.wrap();
		return exp;
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("wrap");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new WrapEx(operands);
		}

	}
}
