
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class math_part extends JFrame implements ActionListener {

    // Variables //
    JFrame frame;
    JTextField textField;
    ImageIcon icon;
    JPanel panel;
    JPanel panel2;
    JButton functionButton;
    JButton add, subtract, multiply, divide, equal, clear, decimal, backspace; // 8 buttons for operators
    JButton zero, one, two, three, four, five, six, seven, eight, nine; // 10 buttons for numbers
    char operator;
    double num1=0; 
    double num2=0; 
    double result;


    math_part() { 
        // JFrame // 
        frame = new JFrame("Caclulator");
        
        frame.setLayout(null);
        
        frame.setSize(510, 739);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setResizable(false);
        
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);  

        

        

        // Image Icon cac.png // 

        icon = new ImageIcon("cac.png");
        
        frame.setIconImage(icon.getImage());
        
        // text Field // 

        textField = new JTextField();
        
        textField.setBounds(50, 50, 400, 100);
        
        textField.setFont(new Font("Arial", Font.BOLD, 45));
        
        textField.setBackground(Color.WHITE);
        
        textField.setEditable(false);
        
        frame.add(textField);
        
        // Text Field or Text Box // 

        panel = new JPanel();
        
        panel.setBounds(0, 0, 500, 200);
        
        panel.setBackground(Color.DARK_GRAY);
        
        frame.add(panel);

        // Buttons // 

        // Operator Buttons //
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equal = new JButton("=");
        clear = new JButton("C");
        decimal = new JButton(".");
        backspace = new JButton("Back");

        // Number Buttons //
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");


        // varibles into function // 
        functionButton = add;
        functionButton = subtract;
        functionButton = multiply;
        functionButton = divide;
        functionButton = equal;
        functionButton = clear;
        functionButton = decimal;
        functionButton = backspace;


        // adding buttons to the panel //
        for (JButton button : new JButton[] {add, subtract, multiply, divide, equal, clear, decimal, backspace
                                            , zero, one, two, three, four, five, six, seven, eight, nine}) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 25));
            button.setBackground(Color.white);
            button.setFocusable(false);
        }

        // Panel 2 (Adding buttons to the panel) //
        panel2 = new JPanel();
        panel2.setBounds(0, 200, 500, 500);
        panel2.setLayout(new GridLayout(5, 5));
        panel2.setBackground(Color.LIGHT_GRAY);

        // Panel buttons// 
        panel2.add(clear);
        panel2.add(backspace);
        panel2.add(divide);
        panel2.add(multiply);
        panel2.add(seven);
        panel2.add(eight);
        panel2.add(nine);
        panel2.add(subtract);
        panel2.add(four);
        panel2.add(five);
        panel2.add(six);
        panel2.add(add);
        panel2.add(one);
        panel2.add(two);
        panel2.add(three);
        panel2.add(equal);
        panel2.add(zero);
        panel2.add(decimal);
        
        frame.add(panel2); // adds all of the buttons in a 5x5 grid layout
        
        frame.setVisible(true); // make the frame visible with all other components

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            for (JButton button : new JButton[] {zero, one, two, three, four, five, six, seven, eight, nine}) {
                if (e.getSource() == button) {
                    textField.setText(textField.getText().concat(button.getText())); // 
                } // Gets text from the user when they use the buttons // 
        }
    
        if (e.getSource() == decimal) { 
            textField.setText(textField.getText().concat(".")); // decimal point added to the text field //
            
        } else if (e.getSource() == clear) {
            textField.setText(""); // clear the text//
        }
        else if (e.getSource() == backspace) { 
            String string = textField.getText(); // backspace, removes last character of text field 
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        else if (e.getSource() == add) { 
            num1 = Double.parseDouble(textField.getText()); // Plus operator //
            operator = '+'; 
            textField.setText("");
        }   
        else if (e.getSource() == subtract) { 
            num1 = Double.parseDouble(textField.getText()); // Minus operator //
            operator = '-';
            textField.setText("");
            

        }
        else if (e.getSource() == multiply) { 
            num1 = Double.parseDouble(textField.getText()); // Multiply operator //
            operator = '*';
            textField.setText("");
            

        }
        else if (e.getSource() == divide) { 
            num1 = Double.parseDouble(textField.getText()); // Divide operator //
            operator = '/';
            textField.setText("");  
        }
        else if (e.getSource() == equal) { 
            num2 = Double.parseDouble(textField.getText()); // Equal operator //
            
            switch(operator) {
                case '+': 
                result = num1 + num2;
                break;
            
                case '-':
                result = num1 - num2;
                    if (num2 == 0) { 
                        result = num1;
                     } else {
                            result = num1 - num2;
                        }
                    break;
                                        // Switch statement for the operators and possible cases //
                case '*':
                result = num1 * num2;
                break;

                case '/':
                result = num1 / num2;
                if (num2 == 0) {
                    textField.setText("Undefined"); // Undefined message when dividing by zero //
                    return;
                } else {
                    result = num1 / num2;
                }
                break;


            }
            textField.setText(String.valueOf(result));
            
                
                
            }
            
    }
}

   





    

    