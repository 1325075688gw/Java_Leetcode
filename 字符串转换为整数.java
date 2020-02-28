package com.biggw.LeetCode;

public class 字符串转换为整数 {
    public static void main(String[] args) {
        字符串转换为整数 obj = new 字符串转换为整数();
        solution solution = obj.new solution();
        int i = solution.myAtoi("-2147483648");
        System.out.println(i);
    }

    class solution {
        public int myAtoi(String str) {
            str = str.trim();
            if (str == null || str.length() == 0) return 0;
            int positiveFlag = 1;
            int res = 0;
            int start = 0;

            char firstChar = str.charAt(0);
            if (firstChar == '-') {
                positiveFlag = -1;
                start++;
            } else if (firstChar == '+') {
                positiveFlag = 1;
                start++;
            }

            for (int i = start; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i)))
                    return res * positiveFlag;
                int pop = str.charAt(i) - '0';      //将字符串当前位的字符转换位数字
                if (positiveFlag == 1 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)))
                    return Integer.MAX_VALUE;
                if (positiveFlag == -1 && (-res < Integer.MIN_VALUE / 10 || (-res == Integer.MIN_VALUE / 10 && pop > 8)))
                    return Integer.MIN_VALUE;
                res = res * 10 + pop;
            }
            return res * positiveFlag;
        }
    }

//    class Solution {
//        public int myAtoi(String str) {
//            str = str.trim();     //清除空格
//            if(str == null || str.length() == 0){
//                return 0;
//            }
//            char firstChar = str.charAt(0);
//            int sign = 1;         //控制最后输出正负整数的标志位。默认为正
//            int start = 0;        //遍历字符串的起始位
//            int res = 0;          //最后输出的结果
//
//            if(firstChar == '+'){    //判断字符串首字符
//                sign = 1;
//                start++;
//            }else if(firstChar == '-'){
//                sign = -1;
//                start++;
//            }
//
//            for(int i = start;i < str.length(); i++){    //若字符串首字符不包含符号，则从首位开始遍历，默认为正数
//                if(!Character.isDigit(str.charAt(i))){   //判断字符串当前位是否不是数字
//                    return res * sign;
//                }
//                int pop = str.charAt(i) - '0';      //将字符串当前位的字符转换位数字
//
//                if(sign  == 1 && (res > Integer.MAX_VALUE /10 ||(res == Integer.MAX_VALUE / 10 && pop > 7))){   //判断字符串转换过程中是否发生越界，思路来自上一题 int的范围-2147483648～2147483647
//                    return Integer.MAX_VALUE;
//                }
//                if(sign == -1 && (-res < Integer.MIN_VALUE /10 || (-res == Integer.MIN_VALUE /10 && -pop < -8))){
//                    return Integer.MIN_VALUE;
//                }
//                res = res * 10 + pop;
//            }
//            return res * sign;
//        }
//    }

}
