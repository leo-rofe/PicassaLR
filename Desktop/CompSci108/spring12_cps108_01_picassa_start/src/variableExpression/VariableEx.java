package variableExpression;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import factory.ExpressionFactory;
import model.EvalExpression;
import model.Parser;
import model.ParserException;
import model.RGBColor;
import model.ParserException.Type;

public class VariableEx extends EvalExpression {
	private String myCommand;
	
	public VariableEx(String command) {
		myCommand = command;
	}
	public String getMyCommand(){
		return myCommand;
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		if (varMap.containsKey(myCommand))
			return varMap.get(myCommand);
		else{
			throw new ParserException("Unknown Command " + myCommand,
					Type.UNKNOWN_COMMAND);
		}
	}

	public static class Factory extends ExpressionFactory {
		protected static final Pattern VAR_REGEX = Pattern.compile("[a-zA-Z]+");
		
		public boolean isThisKindOfExp(String parseableString)  {
	        Matcher varMatcher =
	            VAR_REGEX.matcher(parseableString);
	        return varMatcher.lookingAt();
	    }

		public EvalExpression parseExpression(Parser exParser) {
			Matcher varMatcher = VAR_REGEX.matcher(exParser.getMyInput());
		    varMatcher.find(exParser.getMyCurrent());
		    String variableMatch = exParser.getMyInput().substring(varMatcher.start(), varMatcher.end());
		    int value = varMatcher.end();
		    exParser.updatePosition(value);
		    return new VariableEx(variableMatch);
		
	}

	}
}
