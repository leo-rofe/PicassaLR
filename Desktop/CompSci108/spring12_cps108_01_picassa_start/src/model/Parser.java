package model;


import java.util.ArrayList;

import numberExpression.NumberEx;

import colorExpressions.ColorEx;
import colorExpressions.PerlinBWEx;
import colorExpressions.PerlinColorEx;
import colorExpressions.ToLumEx;
import colorExpressions.ToRGBEx;

import parenExpression.AbsoluteEx;
import parenExpression.ArcTanEx;
import parenExpression.AverageEx;
import parenExpression.CeilEx;
import parenExpression.ClampEx;
import parenExpression.CosEx;
import parenExpression.DivideEx;
import parenExpression.ExpEx;
import parenExpression.FloorEx;
import parenExpression.IfEx;
import parenExpression.LogEx;
import parenExpression.MaxEx;
import parenExpression.MinEx;
import parenExpression.ModEx;
import parenExpression.MultiplyEx;
import parenExpression.NegEx;
import parenExpression.PlusEx;
import parenExpression.ProductEx;
import parenExpression.RandomEx;
import parenExpression.SinEx;
import parenExpression.SubtractEx;
import parenExpression.SumEx;
import parenExpression.TanEx;
import parenExpression.WrapEx;
import variableExpression.LetEx;
import variableExpression.VariableEx;

import factory.ExpressionFactory;




/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser {

	private int myCurrentPosition;
	private String myInput;

	public Parser(String input) {
		myInput = input;
	}

	/**
	 * Converts given string into expression tree.
	 * 
	 * @param input
	 *            expression given in the language to be parsed
	 * @return expression tree representing the given formula
	 */
	public EvalExpression makeExpression() {
		ArrayList<ExpressionFactory> factories = new ArrayList<ExpressionFactory>();
		factories.add(new NumberEx.Factory());
		factories.add(new VariableEx.Factory());
		factories.add(new ColorEx.Factory());
		factories.add(new DivideEx.Factory());
		factories.add(new ExpEx.Factory());
		factories.add(new ModEx.Factory());
		factories.add(new MultiplyEx.Factory());
		factories.add(new NegEx.Factory());
		factories.add(new PlusEx.Factory());
		factories.add(new SubtractEx.Factory());
		factories.add(new AbsoluteEx.Factory());
		factories.add(new RandomEx.Factory());
		factories.add(new SinEx.Factory());
		factories.add(new LogEx.Factory());
		factories.add(new FloorEx.Factory());
		factories.add(new CeilEx.Factory());
		factories.add(new CosEx.Factory());
		factories.add(new TanEx.Factory());
		factories.add(new ArcTanEx.Factory());
		factories.add(new ToLumEx.Factory());
		factories.add(new ClampEx.Factory());
		factories.add(new WrapEx.Factory());
		factories.add(new ToRGBEx.Factory());
		factories.add(new PerlinColorEx.Factory());
		factories.add(new PerlinBWEx.Factory());
		factories.add(new LetEx.Factory());
		factories.add(new SumEx.Factory());
		factories.add(new ProductEx.Factory());
		factories.add(new AverageEx.Factory());
		factories.add(new MinEx.Factory());
		factories.add(new MaxEx.Factory());
		factories.add(new IfEx.Factory());
		EvalExpression result = null;
		for (ExpressionFactory typeOfEx : factories) {
			if (typeOfEx.isThisKindOfExp(myInput.substring(myCurrentPosition))) {
				result = typeOfEx.parseExpression(this);
				break;
			}
		}
		skipWhiteSpace();
//		if (notAtEndOfString())
//       {
//            throw new ParserException("Unexpected characters at end of the string: " +
//                                      myInput.substring(myCurrentPosition),
//	                                      ParserException.Type.EXTRA_CHARACTERS);
//       	}
		return result;
	}

	public String getMyInput() {
		return myInput;
	}

	public int getMyCurrent() {
		return myCurrentPosition;
	}

	public void updatePosition(int val) {
		myCurrentPosition = val;
	}

	public void skipWhiteSpace() {
		while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
			myCurrentPosition++;
		}
	}

	public char currentCharacter() {
		return myInput.charAt(myCurrentPosition);
	}

	public boolean notAtEndOfString() {
		return myCurrentPosition < myInput.length();
	}
}
