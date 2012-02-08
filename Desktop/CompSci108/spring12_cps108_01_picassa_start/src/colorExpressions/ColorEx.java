package colorExpressions;

import java.util.ArrayList;
import java.util.HashMap;

import parenExpression.ParenEx;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ColorEx extends ParenEx {

	public ColorEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return new RGBColor(getOperands().get(0).evaluate(varMap).getRed(),
				getOperands().get(1).evaluate(varMap).getGreen(), getOperands()
						.get(2).evaluate(varMap).getBlue());
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("color");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new ColorEx(operands);
		}

	}

}
