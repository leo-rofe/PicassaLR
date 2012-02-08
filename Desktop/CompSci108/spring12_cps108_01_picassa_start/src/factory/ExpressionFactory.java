package factory;

import model.EvalExpression;
import model.Parser;

public abstract class ExpressionFactory {

	public abstract boolean isThisKindOfExp(String parseableString);

	public abstract EvalExpression parseExpression(Parser exParser);

}
