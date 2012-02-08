package parenExpression;


import java.util.ArrayList;
import java.util.HashMap;




import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class ArcTanEx extends ParenEx {

	public ArcTanEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return atan(getOperands().get(0).evaluate(varMap));
	}

	   //arctan, evaluate each component of color as if it were a radian value
    public static RGBColor atan (RGBColor exp){
    	return new RGBColor(Math.atan(Math.toRadians(exp.getRed())), Math.atan(Math.toRadians(exp.getGreen())), Math.atan(Math.toRadians(exp.getBlue())));
    }
    
	public static class Factory extends ParenFactory {

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new ArcTanEx(operands);
		}

		public boolean isCommand(String command) {
			
			return command.equals("atan");
		}
		
	}
}
