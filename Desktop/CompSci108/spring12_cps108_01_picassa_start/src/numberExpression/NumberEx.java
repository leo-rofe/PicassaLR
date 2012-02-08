package numberExpression;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import factory.ExpressionFactory;
import model.EvalExpression;
import model.Parser;
import model.RGBColor;

public class NumberEx extends EvalExpression {
	private RGBColor myValue;
	
	public NumberEx (RGBColor value){
		myValue = value;
	}
	
	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return myValue;
	}

	public static class Factory extends ExpressionFactory {
		// double is made up of an optional negative sign, followed by a sequence
		// of one or more digits, optionally followed by a period, then possibly
		// another sequence of digits
		private static final Pattern DOUBLE_REGEX = Pattern
				.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");

		// checks to see if it is a Number expression
		public boolean isThisKindOfExp(String parseableString) {
			Matcher doubleMatcher = DOUBLE_REGEX.matcher(parseableString);
			return doubleMatcher.lookingAt();
		}

		// parses number expression
		public EvalExpression parseExpression(Parser exParser) {
			Matcher doubleMatcher = DOUBLE_REGEX.matcher(exParser.getMyInput());
			doubleMatcher.find(exParser.getMyCurrent());
			String numberMatch = exParser.getMyInput().substring(
					doubleMatcher.start(), doubleMatcher.end());
			int val = doubleMatcher.end();
			exParser.updatePosition(val);
			// this represents the color gray of the given intensity
			double value = Double.parseDouble(numberMatch);
			RGBColor gray = new RGBColor(value);
			return new NumberEx(gray);
		}

	}
}
