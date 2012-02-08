package parenExpression;


import java.util.ArrayList;

import model.EvalExpression;





public abstract class ParenEx extends EvalExpression {
	private ArrayList<EvalExpression> myOperands;
	
	public ParenEx (ArrayList<EvalExpression> operands){
		myOperands = operands;
		
	}

	protected ArrayList<EvalExpression> getOperands(){
		return myOperands;
	}
		
	
}
