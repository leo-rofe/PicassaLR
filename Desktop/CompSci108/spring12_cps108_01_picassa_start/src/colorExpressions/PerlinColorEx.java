package colorExpressions;

import java.util.ArrayList;
import java.util.HashMap;

import parenExpression.ParenEx;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinColorEx extends ParenEx {

	public PerlinColorEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return PerlinNoise.colorNoise(getOperands().get(0).evaluate(varMap),
				getOperands().get(1).evaluate(varMap));
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("perlincolor");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new PerlinColorEx(operands);
		}

	}
}
