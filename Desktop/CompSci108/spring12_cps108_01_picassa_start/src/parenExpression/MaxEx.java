package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class MaxEx extends ParenEx {

	public MaxEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		RGBColor max = new RGBColor(getOperands().get(0).evaluate(varMap));
		int size = getOperands().size();
		for (int i =1; i< size;i++){
			if (max.compareTo(getOperands().get(i).evaluate(varMap))<0)
			{
				max = getOperands().get(i).evaluate(varMap);
			}
		}
		return max;
}
	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {
			return (command.equals("max"));
		}

		@Override
		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new MaxEx(operands);
		}
		
	}
}

