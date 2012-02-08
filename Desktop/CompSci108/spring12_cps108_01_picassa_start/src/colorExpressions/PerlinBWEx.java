package colorExpressions;

import java.util.ArrayList;
import java.util.HashMap;

import parenExpression.ParenEx;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinBWEx extends ParenEx {

	public PerlinBWEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return PerlinNoise.greyNoise(getOperands().get(0).evaluate(varMap),
				getOperands().get(1).evaluate(varMap));
	}

	public static class Factory extends ParenFactory {

		@Override
		public boolean isCommand(String command) {

			return command.equals("perlinbw");
		}

		@Override
		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new PerlinBWEx(operands);
		}

	}
}
