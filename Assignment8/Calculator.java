import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {
    private JLabel firstLabel, secondLabel, operationalLabel, resultLabel;
    private JTextField firstField, secondField;
    private JComboBox options;
    private JButton resultsButton;

    public Calculator(){
        super("basic calculator");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        create();
        Container con = getContentPane();

        add(con);

        setSize(400,300);
        setVisible(true);
    }

    public void create(){

        firstLabel = new JLabel("First number is: ");
        secondLabel = new JLabel("Second number is: ");
        operationalLabel =  new JLabel("Operation: ");
        resultLabel = new JLabel("Result: ");

        firstField = new JTextField(10);
        secondField = new JTextField(10);

        options = new JComboBox(new String[]{"+","-","x","/"});
        resultsButton = new JButton("Compute");


    }

    public void add(Container con){
        FlowLayout fl = new FlowLayout();

        con.setLayout(fl);
        addText(con, firstLabel, firstField);
        addText(con, operationalLabel, options);
        addText(con, secondLabel, secondField);
        addText(con, resultsButton, resultLabel);
        resultsButton.addActionListener((ActionEvent ae)-> showResult());

    }

    public void addText(Container c, Component a, Component b){
        JPanel panel = new JPanel();
        panel.add(a);
        panel.add(b);
        c.add(panel);

    }

    public void showResult(){
        int a;
        try{
            a = Integer.parseInt(firstField.getText());
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(this, "should enter integer");
            throw e;
        }
        int b = Integer.parseInt(secondField.getText());
        String operation = options.getSelectedItem().toString();
        int res = calculate(a,b,operation);
        resultLabel.setText("Result: "+ "" + res);


    }

    public int calculate(int a, int b, String op){
        if(op.equals("+")){
            return a+b;
        }
        if(op.equals("-")){
            return a-b;
        }
        if(op.equals("x")){
            return a*b;
        }
        return a/b;

    }


    public static void main(String[] args) {
        new Calculator();



    }


}
