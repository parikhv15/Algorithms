package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrajp on 4/11/2016.
 */
public class ExpressionAddOperator {

    public static void main(String a[]) {
        ExpressionAddOperator op = new ExpressionAddOperator();

        System.out.println(op.addOperators("232", 8));
    }

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();

        addOperatorsUtil(num, 0, "", target, 0, 0, list);

        return list;
    }

    public void addOperatorsUtil(String num, int pos, String ops, int target, long value, long pre, List<String> list) {
        if (num.length() == pos && target == value) {
            list.add(ops);
        }

        if (num.length() == pos)
            return;

        for (int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && pos != i)
                break;

            String numString = num.substring(pos, i+1);
            long numValue = Long.parseLong(numString);

            if (ops.length() == 0) {
                addOperatorsUtil(num, i+1, numString, target, numValue, numValue, list);
            } else {
                addOperatorsUtil(num, i+1, ops + "+" + numString, target, value + numValue, numValue, list);
                addOperatorsUtil(num, i+1, ops + "-" + numString, target, value - numValue, -numValue, list);
                addOperatorsUtil(num, i+1, ops + "*" + numString, target, value - pre + pre * numValue, numValue * pre, list);
            }
        }
    }


}
