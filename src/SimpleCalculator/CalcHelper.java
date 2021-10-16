package SimpleCalculator;

import javafx.scene.control.TextArea;

public class CalcHelper {

        public static String convertFloatToString ( float v){
            String i = String.valueOf(v);
            if (i.substring(Math.max(i.length() - 2, 0)).equals(".0")) { //Check if whole number
                return i.substring(0, i.length() - 2); // return whole number
            }
            return i;
        }

    public static void writeHistory( TextArea history,
                              float firstCalcReadOut,
                              String operator,
                              float secondCalcReadOut,
                              String newCalcReadOut) {

        String firstReadOut = CalcHelper.convertFloatToString(firstCalcReadOut);
        String secondReadOut = CalcHelper.convertFloatToString(secondCalcReadOut);

        history.appendText(firstReadOut + " " + operator + " "
                + secondReadOut + " = " + newCalcReadOut + "\n");
    }
    }
