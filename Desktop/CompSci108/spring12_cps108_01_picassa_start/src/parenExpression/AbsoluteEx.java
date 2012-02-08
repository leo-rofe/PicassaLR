package parenExpression;


import java.util.ArrayList;
import java.util.HashMap;




import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class AbsoluteEx extends ParenEx {

	public AbsoluteEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		
		return absolute(getOperands().get(0).evaluate(varMap));
	}
   //	 absolute value
    
    public static RGBColor absolute (RGBColor exp)
    {
        return new RGBColor(Math.abs(exp.getRed()), 
                            Math.abs(exp.getGreen()),
                            Math.abs(exp.getBlue()));
    }
    
	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {
			return command.equals("abs");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new AbsoluteEx(operands);
		}
}
}