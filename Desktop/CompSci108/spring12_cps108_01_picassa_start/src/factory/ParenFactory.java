package factory;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import model.EvalExpression;
import model.Parser;

public abstract class ParenFactory extends ExpressionFactory {
	// expression begins with a left paren followed by the command name,
	// which is a sequence of alphabetic characters
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
			.compile("\\(([a-z+-/^%*!]+)");

	public boolean isThisKindOfExp(String parseableString) {
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(parseableString.toLowerCase());
		if (expMatcher.lookingAt() == false)
			return false;
		String commandName = expMatcher.group(1);
		return isCommand(commandName);
	}

	public EvalExpression parseExpression(Parser exParser) {
		ArrayList<EvalExpression> operands = new ArrayList<EvalExpression>();
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(exParser
				.getMyInput().toLowerCase());
		expMatcher.find(exParser.getMyCurrent());
		int value = expMatcher.end();
		exParser.updatePosition(value);
		exParser.skipWhiteSpace();
		while (exParser.currentCharacter() != ')') {
			EvalExpression element = exParser.makeExpression();
			operands.add(element);
		}
		exParser.updatePosition(exParser.getMyCurrent() + 1);
		return createExpression(operands);
	}

	public abstract boolean isCommand(String command);

	public abstract EvalExpression createExpression(
			ArrayList<EvalExpression> operands);
}
