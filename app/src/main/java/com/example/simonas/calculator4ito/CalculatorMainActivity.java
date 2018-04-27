package com.example.simonas.calculator4ito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class CalculatorMainActivity extends AppCompatActivity {
    private static Stack<Double> operandStack = new Stack<Double>();
    private static Stack<String> operatorStack = new Stack<String>();
    private static final String OPERATORS = "+-/*√()";
    private static final String NONBRACES = "+-/*√";
    //                                       +  -  /  *  √   (   )
    private static final int[] PRECEDENCE = {1, 1, 2, 2, 3, -1, -1,};
    static ArrayList<String> input = new ArrayList<String>();
    private String inputOnDisplay;

    double doubleToSqrt;

    TextView displayResult;
    EditText displayInput;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot,
            btnParenthesesOpen,btnParenthesesClose, btnEqual, btnSqrt, btnMultiple, btnMinus, btnPlus, btnDivide,
            btnClear, btnBack;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        displayInput = (EditText) findViewById(R.id.display_input);
        displayResult = (TextView) findViewById(R.id.display_result);

        btn0 = (Button) findViewById(R.id.btn_zero);
        btn1 = (Button) findViewById(R.id.btn_one);
        btn2 = (Button) findViewById(R.id.btn_two);
        btn3 = (Button) findViewById(R.id.btn_three);
        btn4 = (Button) findViewById(R.id.btn_four);
        btn5 = (Button) findViewById(R.id.btn_five);
        btn6 = (Button) findViewById(R.id.btn_six);
        btn7 = (Button) findViewById(R.id.btn_seven);
        btn8 = (Button) findViewById(R.id.btn_eight);
        btn9 = (Button) findViewById(R.id.btn_nine);
        btnDot = (Button) findViewById(R.id.btn_dot);

        btnClear = (Button) findViewById(R.id.btn_clear);
        btnBack = (Button) findViewById(R.id.btn_back);

        btnParenthesesOpen = (Button) findViewById(R.id.btn_parentheses_open);
        btnParenthesesClose = (Button) findViewById(R.id.btn_parentheses_close);
        btnEqual = (Button) findViewById(R.id.btn_equal);

        btnSqrt = (Button) findViewById(R.id.btn_sqrt);
        btnMultiple = (Button) findViewById(R.id.btn_multiple);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnDivide = (Button) findViewById(R.id.btn_divide);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn0.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn1.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn2.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn3.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn4.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn5.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn6.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn7.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn8.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btn9.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btnDot.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btnPlus.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btnMinus.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btnMultiple.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btnDivide.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnParenthesesOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btnParenthesesOpen.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnParenthesesClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.setText(displayInput.getText().toString() + btnParenthesesClose.getText().toString());
                displayInput.setSelection(displayInput.getText().length());
            }
        });
        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputOnDisplay = displayInput.getText().toString();
                if     (displayInput.getText().toString().contains("+")|| displayInput.getText().toString().contains("-") || displayInput.getText().toString().contains("*")||
                        displayInput.getText().toString().contains("/")|| displayInput.getText().toString().contains("(")|| displayInput.getText().toString().contains(")"))
                        /*(displayInput.getText().toString().matches("^[+()/*-]+$"))*/
                {
                    Toast.makeText(CalculatorMainActivity.this, "Can only calculate SQRT of a single double :(", Toast.LENGTH_LONG).show();
                } else if (inputOnDisplay.isEmpty()) {
                    Toast.makeText(CalculatorMainActivity.this, "There is nothing to calculate", Toast.LENGTH_LONG).show();
                } else {
                    doubleToSqrt=Double.parseDouble(displayInput.getText().toString()) ;
                    displayResult.setText(Double.toString(Math.sqrt(doubleToSqrt)));
                    displayInput.getText().clear();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInput.getText().clear();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = displayInput.getText().length();
                if (length > 0) {
                    displayInput.getText().delete(length - 1, length);
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parenthesesCounter = 0;
                inputOnDisplay = displayInput.getText().toString();
                if (inputOnDisplay.isEmpty()) {
                    Toast.makeText(CalculatorMainActivity.this, "There is nothing to calculate", Toast.LENGTH_LONG).show();
                } else {
                    for (char ch : inputOnDisplay.toCharArray())
                        if (ch == '(') parenthesesCounter++;
                        else if (ch == ')') parenthesesCounter--;

                    if (parenthesesCounter == 0) {

                        ArrayList doMath = new ArrayList();
                        doMath = inputCleaner(inputOnDisplay);
                        try {
                            System.out.println(infixCalculator(doMath));
                        } catch (Exception e) {
                        }
                        displayResult.setText(infixCalculator(doMath));
                        doMath.clear();
                    } else if (parenthesesCounter != 0) {
                        Toast.makeText(CalculatorMainActivity.this, "The number of parentheses don't match up!", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
    }

    public ArrayList inputCleaner(String postfix) {
        StringBuilder sb = new StringBuilder();
        String noSpaces = postfix.replace(" ", "");
        for (int i = 0; i < noSpaces.length(); i++) {
            char c = noSpaces.charAt(i);
            boolean isNum = (c >= '0' && c <= '9');

            if (isNum) {
                sb.append(c);
                if (i == noSpaces.length() - 1) {
                    input.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else if (c == '.') {
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == '.') {
                        //throw new Exception("You can't have two decimals in a number.");

                    } else if (j == sb.length() - 1) {
                        sb.append(c);
                        j = (sb.length() + 1);
                    }
                }
                if (sb.length() == 0) {
                    sb.append(c);
                }
                if (i == noSpaces.length() - 1) {
                    // throw new SyntaxErrorException("You can't end your equation with a decimal!");
                }
            } else if (OPERATORS.indexOf(c) != -1) {
                if (sb.length() != 0) {
                    input.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                sb.append(c);
                input.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                // throw new SyntaxErrorException("Make sure your input only contains numbers, operators, or parantheses");
            }
        }

        int numLP = 0;
        int numRP = 0;

        for (int f = 0; f < input.size(); f++) {
            switch (input.get(f)) {
                case "(":
                    numLP++;
                    break;
                case ")":
                    numRP++;
                    break;
                default: //do nothing
                    break;
            }

        }
        if (numLP != numRP) {
            //throw new SyntaxErrorException("The number of parentheses don't match up!");
        }

        int doop = 0;
        for (int f = 0; f < input.size(); f++) {
            String parenthesisCheck = input.get(f);
            switch (parenthesisCheck) {
                case "(":
                    doop++;
                    break;
                case ")":
                    doop--;
                    break;
                default: //do nothing
                    break;
            }
            if (doop < 0) {
                //throw new SyntaxErrorException("The order of your parentheses, brackets, or braces is off. Make sure you open a set of parenthesis before you close them.");
            }
        }
        if (NONBRACES.indexOf(input.get(input.size() - 1)) != -1) {
            //throw new SyntaxErrorException("The input can't end in an operator");
        }
        return input;
    }

    private static void processOperator(String op) {
        if (operatorStack.empty() || op.equals("(")) {
            operatorStack.push(op);
        } else {
            //peek the operator stack and let topOp be the top operator.
            String topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                topOp = op;
                operatorStack.push(op);
            } else {
                System.out.println(operatorStack);
                System.out.println(operandStack);
                System.out.println("--------------");
                //Pop all stacked operators with equal or higher precedence than op.
                while (operandStack.size() >= 2 && !operatorStack.isEmpty()) {
                    double r = operandStack.pop();
                    double l = operandStack.pop();
                    String work = getNextNonBracerOperator();
                    System.out.println("L:" + l + " R:" + r + " W:" + work);

                    doOperandWork(work, l, r);

                    if (op.equals("(")) {
                        //matching '(' popped - exit loop.
                        operandStack.push(l);
                        operandStack.push(r);
                        break;
                    }

                    if (!operatorStack.empty()) {
                        //reset topOp
                        topOp = operatorStack.peek();
                    }
                }
                //assert: Operator stack is empty or current operator precedence > top of stack operator precedence.
                if (!op.equals(")")) {
                    operatorStack.push(op);
                }
            }
        }
    }

    public String infixCalculator(ArrayList<String> expressions) {
        for (String expression : expressions) {
            if (OPERATORS.indexOf(expression) == -1) {
                operandStack.push(Double.parseDouble(expression));
            } else {
                processOperator(expression);
            }
        }
        while (operandStack.size() >= 2 && !operatorStack.isEmpty()) {
            System.out.println("--------------");
            System.out.println(operandStack);
            System.out.println(operatorStack);

            double r = operandStack.pop();
            double l = operandStack.pop();
            String work = getNextNonBracerOperator();
            System.out.println("L:" + l + " R:" + r + " W:" + work);

            doOperandWork(work, l, r);
        }
        if (operandStack.isEmpty())
            return null;
        return String.valueOf(operandStack.pop());
    }

    private static String getNextNonBracerOperator() {
        String work = "\0"; // \0 is null,
        while (!operatorStack.isEmpty() && NONBRACES.indexOf(work) == -1)
            work = operatorStack.pop();
        return work;
    }

    private static void doOperandWork(String work, double l, double r) {
        switch (work) {
            case "+":
                operandStack.push(l + r);
                break;
            case "-":
                operandStack.push(l - r);
                break;
            case "*":
                operandStack.push(l * r);
                break;
            case "/":
                operandStack.push(l / r);
                break;
            //case "√": operandStack.push(l*1*(Math.sqrt(r))); //Wasn't able to solve it with stack yet.
            // break;
            default:

        }
    }

    private static int precedence(String op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }
}