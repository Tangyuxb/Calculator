package com.tangyu.app.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.Stack;


public class Calculator extends Activity implements OnClickListener {

    //文本框
    private TextView screen;
    //定义Button
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnDoc, btnAdd, btnSub, btnMul, btnDiv, btnResult, btnDel, btnClear;
    //后缀表达式栈
    private Stack<String> postfixStack = new Stack<>();
    //运算符栈
    private Stack<Character> opStack = new Stack<>();
    //运用运算符ASCII码-40做索引的运算符优先级
    private int[] operatePriority = new int[]{0, 3, 2, 1, -1, 1, 0, 2};
    //判断是否已经计算
    boolean isCalculate;
    //是否输入小数点
    boolean point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //工作文本
        screen = (TextView) findViewById(R.id.screen);
        screen.setText("");
        initial();
    }

    private void initial() {
        //设置事件监听
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDoc = (Button) findViewById(R.id.btnDoc);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnClear = (Button) findViewById(R.id.btnClear);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnDoc.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("0");
            }
            break;
            case R.id.btn1: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("1");
            }
            break;
            case R.id.btn2: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("2");
            }
            break;
            case R.id.btn3: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("3");
            }
            break;
            case R.id.btn4: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("4");
            }
            break;
            case R.id.btn5: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("5");
            }
            break;
            case R.id.btn6: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("6");
            }
            break;
            case R.id.btn7: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("7");
            }
            break;
            case R.id.btn8: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("8");
            }
            break;
            case R.id.btn9: {
                if (isCalculate == true) {
                    screen.setText("");
                    isCalculate = false;
                }
                screen.append("9");
            }
            break;
            case R.id.btnDoc: {
                if (screen.getText().toString() == null || screen.getText().toString().length() == 0) {
                    screen.setText("0.");
                    point = true;
                } else {
                    char temp = screen.getText().toString().charAt(screen.getText().toString().length() - 1);
                    if (temp != '+' && temp != '-' && temp != '×' && temp != '÷' && temp != '.' && temp != '(') {
                        if (point == false) {
                            screen.append(".");
                            point = true;
                        } else {
                            screen.setText(screen.getText());
                        }
                    } else
                        screen.setText(screen.getText());
                }
            }
            break;
            case R.id.btnAdd: {
                if (screen.getText().toString().equals("") || screen.getText().toString().length() == 0)
                    screen.setText(screen.getText());
                else {
                    char temp = screen.getText().toString().charAt(screen.getText().toString().length()-1);
                    if (temp != '+' && temp != '-' && temp != '×' && temp != '÷' && temp != '.' && temp != '(') {
                        if (isCalculate == false) {
                            screen.append("+");
                            point = false;
                        } else {
                            screen.append("+");
                            isCalculate = false;
                            point = false;
                        }
                    } else
                        screen.setText(screen.getText());
                }
            }
            break;
            case R.id.btnSub: {
                if (screen.getText().toString().equals("") || screen.getText().toString().length() == 0)
                    screen.setText(screen.getText());
                else {
                    char temp = screen.getText().toString().charAt(screen.getText().toString().length()-1);
                    if (temp != '+' && temp != '-' && temp != '×' && temp != '÷' && temp != '.' && temp != '(') {
                        if (isCalculate == false) {
                            screen.append("-");
                            point = false;
                        } else {
                            screen.append("-");
                            isCalculate = false;
                            point = false;
                        }
                    } else
                        screen.setText(screen.getText());
                }
            }
            break;
            case R.id.btnMul: {
                if (screen.getText().toString().equals("") || screen.getText().toString().length() == 0)
                    screen.setText(screen.getText());
                else {
                    char temp = screen.getText().toString().charAt(screen.getText().toString().length()-1);
                    if (temp != '+' && temp != '-' && temp != '×' && temp != '÷' && temp != '.' && temp != '(') {
                        if (isCalculate == false) {
                            screen.append("×");
                            point = false;
                        } else {
                            screen.append("×");
                            isCalculate = false;
                            point = false;
                        }
                    } else
                        screen.setText(screen.getText());
                }
            }
            break;
            case R.id.btnDiv: {
                if (screen.getText().toString().equals("") || screen.getText().toString().length() == 0)
                    screen.setText(screen.getText());
                else {
                    char temp = screen.getText().toString().charAt(screen.getText().toString().length()-1);
                    if (temp != '+' && temp != '-' && temp != '×' && temp != '÷' && temp != '.' && temp != '(') {
                        if (isCalculate == false) {
                            screen.append("÷");
                            point = false;
                        } else {
                            screen.append("÷");
                            isCalculate = false;
                            point = false;
                        }
                    } else
                        screen.setText(screen.getText());
                }
            }
            break;
            case R.id.btnDel: {
                if (screen.getText().toString().length() != 0 || screen.getText().toString() != null) {
                    if (isCalculate == false) {
                        //获取当前长度
                        int length = screen.getText().toString().length();
                        if (length > 0)
                            //清除1位
                            screen.setText(screen.getText().toString().substring(0, length - 1));
                        else
                            screen.setText("");
                    } else {
                        //全部清除，同时将iscalculat标志回置
                        screen.setText("");
                        isCalculate = false;
                        point = false;
                    }
                } else {
                    screen.setText("");
                }
            }
            break;
            case R.id.btnClear: {
                screen.setText("");
                /*screen.setText("");
                screen.setHint("0.0");*/
                isCalculate = false;
//                sign = false;
                point = false;
            }
            break;
            case R.id.btnResult: {
                if (screen.getText().toString() == null || screen.getText().toString().length() == 0) {
                    screen.setText("");
                } else {
                    char temp = screen.getText().toString().charAt(screen.getText().toString().length() - 1);
                    if (temp != '+' && temp != '-' && temp != '×' && temp != '÷' && temp != '.' ) {
                        String expression;
                        String ans;
                        expression = screen.getText().toString();
                        double result = Calculator.conversion(expression);
                        ans = String.valueOf(result);
                        screen.setText(screen.getText() + "=" + ans);
                        isCalculate = true;
                    } else {
                        //最后一个字符不为数字
                        screen.setText(screen.getText().toString().substring(0, screen.getText().toString().length() - 2));
                        String expression;
                        String ans;
                        expression = screen.getText().toString();
                        double result = Calculator.conversion(expression);
                        ans = String.valueOf(result);
                        screen.setText(screen.getText() + "=" + ans);
                        isCalculate = true;
                    }
                }
                break;
            }
        }
    }

    public static double conversion(String expression) {
        double result = 0;
        Calculator cal = new Calculator();
        try {
            result = cal.calculate(expression);
        } catch (Exception e) {
            e.printStackTrace();
            // 运算错误返回NaN
            return 0.0 / 0.0;
        }
        // return new String().valueOf(result);
        return result;
    }

    //按照给定的表达式计算
    public double calculate(String expression) {
        Stack<String> resultStack = new Stack<String>();
        prepare(expression);
        Collections.reverse(postfixStack);//将后缀式栈反转
        String firstValue, secondValue, currentValue;//参与计算的第一个值，第二个值和算术运算符
        while (!postfixStack.isEmpty()) {
            currentValue = postfixStack.pop();
            if (!isOperator(currentValue.charAt(0))) {//如果不是运算符则存入操作数栈中
                resultStack.push(currentValue);
            } else {//如果是运算符则从操作数栈中取两个值和该数值一起参与运算
                secondValue = resultStack.pop();
                firstValue = resultStack.pop();
                String tempResult = calculate(firstValue, secondValue, currentValue.charAt(0));
                resultStack.push(tempResult);
            }
        }
        return Double.valueOf(resultStack.pop());
    }

    //将表达式转换成为后缀式
    private void prepare(String expression) {
        opStack.push(',');//运算符放入栈底元素逗号，此符号优先级最低
        char[] arr = expression.toCharArray();
        int currentIndex = 0;//当前字符的位置
        int count = 0;//上次算术运算符到本次算术运算符的字符的长度便于或者之间的数值
        char currentOp, peekOp;//当前操作符和栈顶操作符
        for (int i = 0; i < arr.length; i++) {
            currentOp = arr[i];
            if (isOperator(currentOp)) {//如果当前字符是运算符
                if (count > 0) {
                    postfixStack.push(new String(arr, currentIndex, count));//取两个运算符之间的数字
                }
                peekOp = opStack.peek();
                if (currentOp == ')') {//遇到反括号则将运算符栈中的元素移除到后缀式栈中直到遇到左括号
                    while (opStack.peek() != '(') {
                        postfixStack.push(String.valueOf(opStack.pop()));
                    }
                    opStack.pop();
                } else {
                    while (currentOp != '(' && peekOp != ',' && compare(currentOp, peekOp)) {
                        postfixStack.push(String.valueOf(opStack.pop()));
                        peekOp = opStack.peek();
                    }
                    opStack.push(currentOp);
                }
                count = 0;
                currentIndex = i + 1;
            } else {
                count++;
            }
        }
        if (count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {//最后一个字符不是括号或者其他运算符的则加入后缀式栈中
            postfixStack.push(new String(arr, currentIndex, count));
        }

        while (opStack.peek() != ',') {
            postfixStack.push(String.valueOf(opStack.pop()));//将操作符栈中的剩余的元素添加到后缀式栈中
        }
    }

    //判断是否为算术符号
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷' || c == '(' || c == ')';
    }

    //利用ASCII码-40做下标去算术符号优先级
    public boolean compare(char cur, char peek) {// 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
        boolean result = false;
        if (operatePriority[(peek) - 40] >= operatePriority[(cur) - 40]) {
            result = true;
        }
        return result;
    }

    //按照给定的算术运算符做计算
    private String calculate(String firstValue, String secondValue, char currentOp) {
        String result = "";
        switch (currentOp) {
            case '+':
                result = String.valueOf(ArithHelper.add(firstValue, secondValue));
                break;
            case '-':
                result = String.valueOf(ArithHelper.sub(firstValue, secondValue));
                break;
            case '×':
                result = String.valueOf(ArithHelper.mul(firstValue, secondValue));
                break;
            case '÷':
                result = String.valueOf(ArithHelper.div(firstValue, secondValue));
                break;
        }
        return result;
    }

}




