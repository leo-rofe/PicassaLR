package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class MinEx extends ParenEx {

	public MinEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		RGBColor min = new RGBColor(getOperands().get(0).evaluate(varMap));
		int size = getOperands().size();
		for (int i =1; i< size;i++){
			if (min.compareTo(getOperands().get(i).evaluate(varMap))>0)
			{
				min = getOperands().get(i).evaluate(varMap);
			}
		}
		return min;
}
	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {
			return (command.equals("min"));
		}

		@Override
		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new MinEx(operands);
		}
		
	}
}
