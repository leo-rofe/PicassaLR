package variableExpression;

import java.util.ArrayList;
import java.util.HashMap;

import parenExpression.ParenEx;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class LetEx extends ParenEx {

	public LetEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		HashMap<String, RGBColor> mapCopy = new HashMap<String, RGBColor>(varMap);
		RGBColor myColor = new RGBColor(getOperands().get(1).evaluate(varMap));
		mapCopy.put(((VariableEx) getOperands().get(0)).getMyCommand(), myColor);
		
		return getOperands().get(2).evaluate(mapCopy);
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("let");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new LetEx(operands);
		}

	}

}
