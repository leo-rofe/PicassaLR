package parenExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import factory.ParenFactory;

import model.EvalExpression;
import model.RGBColor;

public class RandomEx extends ParenEx {

	public RandomEx(ArrayList<EvalExpression> operands) {
		super(operands);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> varMap) {
		return random();
	}

	// random color
	public static RGBColor random() {
		Random ran = new Random();
		return new RGBColor(ran.nextDouble(), ran.nextDouble(),
				ran.nextDouble());
	}

	public static class Factory extends ParenFactory {

		public boolean isCommand(String command) {

			return command.equals("random");
		}

		public EvalExpression createExpression(
				ArrayList<EvalExpression> operands) {
			return new RandomEx(operands);
		}

	}
}
