import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gui_calculator implements ActionListener {
    JFrame frame;
    JTextField text;
    JPanel panel;
    JButton[] numbutton = new JButton[10];
    JButton[] opebutton = new JButton[8];
    JButton addbutton, subbutton, mulbutton, divbutton;
    JButton clrbutton, delbutton, equbutton, dotbutton;
    double num1, num2, result;
    char operator;

    gui_calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(420, 550);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(25, 25, 370, 70);
        text.setBackground(Color.lightGray);
        text.setEditable(false);

        panel = new JPanel();
        panel.setBounds(25, 110, 370, 400);
        panel.setLayout(new GridLayout(5, 5, 5, 5));
        panel.setBackground(Color.yellow);

        clrbutton = new JButton("CLR");
        delbutton = new JButton("DEL");
        addbutton = new JButton("+");
        subbutton = new JButton("-");
        mulbutton = new JButton("*");
        divbutton = new JButton("/");
        equbutton = new JButton("=");
        dotbutton = new JButton(".");


        opebutton[0] = clrbutton;
        opebutton[1] = delbutton;
        opebutton[2] = addbutton;
        opebutton[3] = subbutton;
        opebutton[4] = mulbutton;
        opebutton[5] = divbutton;
        opebutton[6] = equbutton;
        opebutton[7] = dotbutton;

        for (int i = 0; i < 8; i++) {
            opebutton[i].addActionListener(this);
        }
        for (int i = 0; i < 10; i++) {
            numbutton[i] = new JButton(String.valueOf(i));
            numbutton[i].addActionListener(this);
        }

        panel.add(opebutton[0]);
        panel.add(opebutton[1]);
        panel.add(opebutton[2]);
        panel.add(opebutton[3]);
        panel.add(opebutton[4]);
        panel.add(opebutton[5]);
        panel.add(opebutton[6]);
        panel.add(opebutton[7]);
        panel.add(numbutton[0]);
        panel.add(numbutton[1]);
        panel.add(numbutton[2]);
        panel.add(numbutton[3]);
        panel.add(numbutton[4]);
        panel.add(numbutton[5]);
        panel.add(numbutton[6]);
        panel.add(numbutton[7]);
        panel.add(numbutton[8]);
        panel.add(numbutton[9]);

        frame.add(panel);
        frame.add(text);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        gui_calculator cal = new gui_calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<=9;i++)
        {
            if(e.getSource() == numbutton[i])
            {
                text.setText(text.getText().concat(String.valueOf(i)));
            }

        }
        if(e.getSource() == dotbutton)
        {
            text.setText(text.getText().concat(String.valueOf(".")));
        }
        if(e.getSource()==addbutton)
        {
            num1=Double.parseDouble(text.getText());
            operator='+';
            text.setText("");
        }
        if(e.getSource()==subbutton)
        {
            num1=Double.parseDouble(text.getText());
            operator='-';
            text.setText("");
        }
        if(e.getSource()==mulbutton)
        {
            num1=Double.parseDouble(text.getText());
            operator='*';
            text.setText("");
        }
        if(e.getSource()==delbutton)
        {
            text.setText("");
        }
        String currentText =text.getText();

        if(e.getSource()==clrbutton)
        {
            if (currentText.length() > 0) {
                text.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
        if(e.getSource()==divbutton)
        {
            num1=Double.parseDouble(text.getText());
            operator='/';
            text.setText("");
        }
        if(e.getSource()==equbutton) {
            num2 = Double.parseDouble(text.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
        }
    }
}
