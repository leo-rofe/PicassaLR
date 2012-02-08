package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class FloorEx extends ParenEx {

	public FloorEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return floor(getOperands().get(0).evaluate(varMap));
	}

	// round down
	public static RGBColor floor(RGBColor exp) {
		return new RGBColor(Math.floor(exp.getRed()),
				Math.floor(exp.getGreen()), Math.floor(exp.getBlue()));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("floor");
		}

		@Override
		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new FloorEx(operands);
		}

	}
}
