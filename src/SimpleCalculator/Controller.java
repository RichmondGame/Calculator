package SimpleCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField = new TextField();
    @FXML
    public TextArea history = new TextArea();
    public float firstCalcReadOut;
    public float secondCalcReadOut;
    private int operator;
    boolean isOperatingAgain = false;

    private enum operatorEnum {divide,multiply,subtract,add}

    public void one (ActionEvent e) { handleButtonNumber("1"); }

    public void two (ActionEvent e) {
        handleButtonNumber("2");
    }

    public void three (ActionEvent e) {
        handleButtonNumber("3");
    }

    public void four (ActionEvent e) {
        handleButtonNumber("4");
    }

    public void five (ActionEvent e) {
        handleButtonNumber("5");
    }

    public void six (ActionEvent e) {
        handleButtonNumber("6");
    }

    public void seven (ActionEvent e) {
        handleButtonNumber("7");
    }

    public void eight (ActionEvent e) {
        handleButtonNumber("8");
    }

    public void nine (ActionEvent e) {
        handleButtonNumber("9");
    }

    public void zero (ActionEvent e) { handleButtonNumber("0"); }

    public void decimal (ActionEvent e) {
        if (textField.getText().equals("0")) {
            textField.setText("0.");
        }
        if (textField.getText().contains(".")) {
            return;
        } else {
            handleButtonNumber(".");
        }
    }

    public void backSpace (ActionEvent e) {
        System.out.println(textField.getLength());

        if (textField.getLength() == 1) {
            textField.setText("0");
        }
        if (!textField.getText().equals("0")) {
            textField.setText(textField.getText().substring(0, textField.getLength()-1));
        }
    }

    public void clear (ActionEvent e) {
        textField.setText("0");
        firstCalcReadOut = 0;
        isOperatingAgain = false;
    }

    public void divide (ActionEvent e) {
        operator = operatorEnum.divide.ordinal();
        handleOperatorButton();
    }

    public void multiply (ActionEvent e) {
        operator = operatorEnum.multiply.ordinal();
        handleOperatorButton();
    }

    public void subtract (ActionEvent e) {
        operator = operatorEnum.subtract.ordinal();
        handleOperatorButton();
    }

    public void add (ActionEvent e) {
        operator = operatorEnum.add.ordinal();
        handleOperatorButton();
    }

    private void handleOperatorButton() {
        firstCalcReadOut = Float.parseFloat(textField.getText());
        textField.setText("0");
        isOperatingAgain = false;
    }

    public void equals (ActionEvent e) {
        String newCalcReadOut;
        if (!isOperatingAgain) {
            secondCalcReadOut = Float.parseFloat(textField.getText());
        } else {
            firstCalcReadOut = Float.parseFloat(textField.getText());
        }
        switch (operator) {
            case 0:
                newCalcReadOut = CalcHelper.convertFloatToString(firstCalcReadOut / secondCalcReadOut);
                textField.setText(newCalcReadOut);
                CalcHelper.writeHistory(history, firstCalcReadOut, "/", secondCalcReadOut, newCalcReadOut);
                break;
            case 1:
                newCalcReadOut = CalcHelper.convertFloatToString(firstCalcReadOut * secondCalcReadOut);
                textField.setText(newCalcReadOut);
                CalcHelper.writeHistory(history, firstCalcReadOut, "X", secondCalcReadOut, newCalcReadOut);
                break;
            case 2:
                newCalcReadOut = CalcHelper.convertFloatToString(firstCalcReadOut - secondCalcReadOut);
                textField.setText(newCalcReadOut);
                CalcHelper.writeHistory(history, firstCalcReadOut, "-", secondCalcReadOut, newCalcReadOut);
                break;
            case 3:
                newCalcReadOut = CalcHelper.convertFloatToString(firstCalcReadOut + secondCalcReadOut);
                textField.setText(newCalcReadOut);
                CalcHelper.writeHistory(history, firstCalcReadOut, "+", secondCalcReadOut, newCalcReadOut);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        isOperatingAgain = true;
    }

    private void handleButtonNumber(String i) {
        if (textField.getText().equals("0")) {
            textField.setText(i);
            return;
        }
        textField.setText(textField.getText() + i);
    }

}
