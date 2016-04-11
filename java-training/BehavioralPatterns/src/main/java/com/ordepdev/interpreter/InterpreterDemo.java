package com.ordepdev.interpreter;

public class InterpreterDemo {

    static Expression buildInterpreterTree() {
        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        Expression terminal3 = new TerminalExpression("Bears");

        Expression alternation1 = new AndExpression(terminal1, terminal2);
        Expression alternation2 = new OrExpression(alternation1, terminal3);

        return alternation2;
    }

    public static void main(String[] args) {
        //String context = "Lions"; // => true
        //String context = "Tigers"; // => false
        //String context = "Lions Tigers"; // => true
        //String context = "Lions Bears"; // => true
        String context = "Lions Bears Tigers"; // => true

        Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    }
}
