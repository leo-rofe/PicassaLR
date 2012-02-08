package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class IfEx extends ParenEx {

	public IfEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		RGBColor zero = new RGBColor();
		RGBColor first = new RGBColor(getOperands().get(0).evaluate(varMap));
		RGBColor second = new RGBColor(getOperands().get(1).evaluate(varMap));
		RGBColor third = new RGBColor(getOperands().get(2).evaluate(varMap));
		if (first.compareTo(zero)>0) return second;
		return third;
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {
			return command.equals("if");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new IfEx(operands);
		}
		
	}
}
