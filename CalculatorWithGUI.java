
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Double.parseDouble;

class CalculatorWithGUI extends Frame implements ActionListener {

  JTextField textInput;
  JPanel panel;

  String[] btnString = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "÷", "^", "√", "%", "⌫"};

  int n = 20; //number of buttons
  JButton[] btn = new JButton[n];
  double num1 = 0;
  double num2 = 0;
  String result = " ";
  char charSymbol;

  public CalculatorWithGUI() {

    Font f = new Font("MONOSPACED", Font.BOLD, 18);

    textInput = new JTextField(10);
    textInput.setFont(f);

    panel = new JPanel();

    add(textInput, "North");
    add(panel, "Center");

    panel.setLayout(new GridLayout(5, 4));

    for (int i = 0; i < n; i++) {

      btn[i] = new JButton(btnString[i]);
      btn[i].setFont(f);
      btn[i].addActionListener(this);
      panel.add(btn[i]);
    }

    addWindowListener(new WindowAdapter() {

      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

  public void actionPerformed(ActionEvent ae) {

    String str = ae.getActionCommand();

    switch (str) {
      case "+" -> {
        charSymbol = '+';
        num1 = parseDouble(textInput.getText());
        textInput.setText("");
      }
      case "-" -> {
        charSymbol = '-';
        num1 = parseDouble(textInput.getText());
        textInput.setText("");
      }
      case "*" -> {
        charSymbol = '*';
        num1 = parseDouble(textInput.getText());
        textInput.setText("");
      }
      case "÷" -> {
        charSymbol = '÷';
        num1 = parseDouble(textInput.getText());
        textInput.setText("");
      }
      case "^"-> {
        charSymbol = '^';
        num1 = parseDouble(textInput.getText());
        textInput.setText("");
      }
      case "√"-> {
        charSymbol = '√';
        textInput.setText("");
      }
      case "%" -> {
        charSymbol = '%';
        num1 = parseDouble(textInput.getText());
        textInput.setText("");
      }
      case "⌫" -> {
        String theText = textInput.getText();
        if (theText.length() == 0) {
          result = "";
        } else {
          result = theText.substring(0, theText.length()-1);
        }
        textInput.setText(result + "");
        result = " ";
      }
      case "=" -> {
        num2 = parseDouble(textInput.getText());
        switch (charSymbol) {
          case '+' -> result = String.valueOf(num1 + num2);
          case '-' -> result = String.valueOf(num1 - num2);
          case '*' -> result = String.valueOf(num1 * num2);
          case '÷' -> result = String.valueOf(num1 / num2);
          case '^' -> result = Double.toString(Math.pow(num1, num2));
          case '√' -> result = Double.toString(Math.sqrt(num2));
          case '%' -> {
            if(num2 == 0){
              result ="DIVISOR IS 0";
            }
            else {
              result = String.valueOf(Math.floorMod((long) num1, (long) num2));
            }
          }
        }
        textInput.setText(result + "");
        result = " ";
      }
      case "C" -> {
        textInput.setText("");
        num1 = 0;
      }
      default -> textInput.setText(textInput.getText() + str);
    }
  }

  public static void main(String[] args) {

    CalculatorWithGUI m = new CalculatorWithGUI();
    m.setTitle("Calculator using Java (AWT)");
    m.setSize(250, 300);
    m.setBackground(Color.CYAN);
    m.setForeground(Color.DARK_GRAY);
    m.setVisible(true);
  }
}