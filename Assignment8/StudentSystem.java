import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StudentSystem extends JFrame{
    private JButton addButton = new JButton("ADD");
    private JLabel ID = new JLabel("ID number: ");
    private JTextField IDText = new JTextField(5);
    private JLabel name = new JLabel("Name: ");
    private JTextField nameText = new JTextField(10);
    private JLabel gender = new JLabel("gender: ");
    private JComboBox genderChoice = new JComboBox(new String[] {"male","female"});
    private JComboBox ageChoice = new JComboBox(new String[]{"18","19","20","21","22","23","24"});

    public StudentSystem(){
        super("student system");
        Container con = getContentPane();

        addToContainer(con);

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addToContainer(Container con){
        FlowLayout gl = new FlowLayout();
        con.setLayout(gl);

        addToPanel(con, ID, IDText);
        addToPanel(con, name, nameText);
        addToPanel(con, gender, genderChoice);
        addToPanel(con, ageChoice,addButton);
        addButton.setSize(5,5);

        DefaultTableModel m = setTable(con);
        addButton.addActionListener((ActionEvent ae)-> parseStudent(m));

    }


    public void addToPanel(Container con, Component a, Component b){
        JPanel jp = new JPanel();
        jp.add(a);
        jp.add(b);
        con.add(jp);
    }

    public void parseStudent(DefaultTableModel m){
        String IDString = IDText.getText();
        String nameString = nameText.getText();
        String genderString = genderChoice.getSelectedItem().toString();
        String ageString = ageChoice.getSelectedItem().toString();
        m.addRow(new String[]{IDString, nameString,genderString,ageString});
    }

    public DefaultTableModel setTable(Container con){
        DefaultTableModel m = new DefaultTableModel(0,4);
        JTable table = new JTable(m);
        m.addRow(new String[]{"ID","Name","Gender","Age"});

        JPanel t = new JPanel(new BorderLayout());

        t.add(table,BorderLayout.CENTER);

        con.add(t);
        return m;
    }
    public static void main(String[] args) {
        new StudentSystem();
    }
}
