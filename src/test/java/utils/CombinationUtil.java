package utils;

public class CombinationUtil {

    public static int  getNoOfPossibleCombination(String numbers){

        char[] actualInput = numbers.toCharArray();

        int combination =1;
        for(char no: actualInput){
            if(no=='0' || no == '1'){
            combination =combination*1;
            }
            else if(no == '7' || no == '9') {
                combination= combination*4;
            }
            else {
                combination= combination*3;

            }

        }
        return combination;

    }
}
