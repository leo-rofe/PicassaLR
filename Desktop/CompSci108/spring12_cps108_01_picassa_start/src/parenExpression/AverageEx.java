package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class AverageEx extends ParenEx{
	public AverageEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		RGBColor sum = new RGBColor(getOperands().get(0).evaluate(varMap));
		int size = getOperands().size();
		for (int i =1; i< size;i++){
			 sum = PlusEx.add(sum, getOperands().get(i).evaluate(varMap));
		 }
		return divide(sum, size);
	}
	public RGBColor divide (RGBColor temp, int size){
		return new RGBColor(temp.getRed() / size, temp.getGreen()
				/ size, temp.getBlue() / size);
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {
			return command.equals("average");
		}

		@Override
		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new SumEx(operands);
		}
		
	}
}
