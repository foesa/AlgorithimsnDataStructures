// -------------------------------------------------------------------------
/**
 *  Utility class containing validation/evaluation/conversion operations
 *  for prefix and postfix arithmetic expressions.
 *
 *  @author  
 *  @version 1/12/15 13:03:48
 */

public class Arith 
{


  //~ Validation methods ..........................................................


  /**
   * Validation method for prefix notation.
   *
   * @param prefixLiterals : an array containing the string literals hopefully in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return true if the parameter is indeed in prefix notation, and false otherwise.
   **/
  public static boolean validatePrefixOrder(String prefixLiterals[])
  {
    int counter =1;
    for(int count =0;count<prefixLiterals.length;count++) {
    	String literal = prefixLiterals[count];
    	if (literal.equals("*")|| literal.equals("/")||literal.equals("+")||literal.equals("-")){
    		counter++;
    	}
    	else {
    		counter--;
    	}
    	if(counter <=0) {
    		return false;
    	}
    }
    return true;
  }


  /**
   * Validation method for postfix notation.
   *
   * @param postfixLiterals : an array containing the string literals hopefully in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return true if the parameter is indeed in postfix notation, and false otherwise.
   **/
  public static boolean validatePostfixOrder(String postfixLiterals[])
  {
	  
  }


  //~ Evaluation  methods ..........................................................


  /**
   * Evaluation method for prefix notation.
   *
   * @param prefixLiterals : an array containing the string literals in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the integer result of evaluating the expression
   **/
  public static int evaluatePrefixOrder(String prefixLiterals[])
  {
    //TODO
  }


  /**
   * Evaluation method for postfix notation.
   *
   * @param postfixLiterals : an array containing the string literals in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the integer result of evaluating the expression
   **/
  public static int evaluatePostfixOrder(String postfixLiterals[])
  {
  }


  //~ Conversion  methods ..........................................................


  /**
   * Converts prefix to postfix.
   *
   * @param prefixLiterals : an array containing the string literals in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in postfix order.
   **/
  public static String[] convertPrefixToPostfix(String prefixLiterals[])
  {
    //TODO
  }


  /**
   * Converts postfix to prefix.
   *
   * @param prefixLiterals : an array containing the string literals in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in prefix order.
   **/
  public static String[] convertPostfixToPrefix(String postfixLiterals[])
  {
    //TODO
  }

  /**
   * Converts prefix to infix.
   *
   * @param infixLiterals : an array containing the string literals in prefix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in infix order.
   **/
  public static String[] convertPrefixToInfix(String prefixLiterals[])
  {
    //TODO
  }

  /**
   * Converts postfix to infix.
   *
   * @param infixLiterals : an array containing the string literals in postfix order.
   * The method assumes that each of these literals can be one of:
   * - "+", "-", "*", or "/"
   * - or a valid string representation of an integer.
   *
   * @return the expression in infix order.
   **/
  public static String[] convertPostfixToInfix(String postfixLiterals[])
  {
    //TODO
  }



}
