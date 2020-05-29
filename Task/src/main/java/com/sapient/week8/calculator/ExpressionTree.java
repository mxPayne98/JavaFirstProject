package com.sapient.week8.calculator;

import java.util.Stack;

public class ExpressionTree {

    public static Node constructTree(String expression) {
        Stack<Node> st = new Stack<>();
        Node root = new Node();
        st.push(root);
        Node node = root;
        for (String c : expression.split(" ")) {
            switch (c) {
                case "(":
                    node.left = new Node();
                    st.push(node);
                    node = node.left;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    node.val = c;
                    node.right = new Node();
                    st.push(node);
                    node = node.right;
                    break;
                case ")":
                    node = st.pop();
                    break;
                default:
                    node.val = c;
                    node = st.pop();
                    break;
            }
        }
        return root;

    }
}
