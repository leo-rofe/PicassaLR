package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class SumEx extends ParenEx {

	public SumEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		RGBColor sum = new RGBColor(getOperands().get(0).evaluate(varMap));
		for (int i =1; i< getOperands().size();i++){
			 sum = PlusEx.add(sum, getOperands().get(i).evaluate(varMap));
		 }
		return sum;
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {
			return command.equals("sum");
		}

		@Override
		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new SumEx(operands);
		}
		
	}
}
