package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class LogEx extends ParenEx {

	public LogEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return log(getOperands().get(0).evaluate(varMap));
	}

	// log (base e)
	public static RGBColor log(RGBColor exp) {
		return new RGBColor(Math.log(exp.getRed()), Math.log(exp.getGreen()),
				Math.log(exp.getBlue()));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("log");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new LogEx(operands);
		}

	}
}
