package model;


import java.util.HashMap;




public abstract class EvalExpression {
	
	public abstract RGBColor evaluate (HashMap<String, RGBColor> varMap);
		
}
