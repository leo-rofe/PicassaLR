package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ProductEx extends ParenEx {

	public ProductEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		RGBColor product = new RGBColor(getOperands().get(0).evaluate(varMap));
		for (int i =1; i< getOperands().size();i++){
			 product = MultiplyEx.multiply(product, getOperands().get(i).evaluate(varMap));
		 }
		return product;
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {
			return command.equals("product");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new SumEx(operands);
		}
		
	}
}
