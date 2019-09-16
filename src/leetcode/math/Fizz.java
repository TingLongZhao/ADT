package leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class Fizz {
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int num1 = i%3;
            int num2 = i%5;
            String s = "";
            if(num1 ==0 && num2!=0){
                s = "Fizz";
            }else if(num1 !=0 && num2==0){
                s = "Buzz";
            }else if(num1==0 && num2==0){
                s = "FizzBuzz";
            }else{
                s = ""+i;
            }
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
