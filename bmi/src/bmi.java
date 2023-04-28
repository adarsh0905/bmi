import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class bmi extends JFrame{
    JFrame frame = new JFrame();
    bmi(){
        JPanel jp = new JPanel();
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setTitle("BMI Calculator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Weight");
        JTextField t1 = new JTextField();
        t1.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel l2 = new JLabel("Height");
        JTextField t2 = new JTextField();
        t2.setHorizontalAlignment(SwingConstants.RIGHT);
        JButton btn = new JButton("Compute");
        JLabel l3 = new JLabel("BMI Value");

        String w_Units[] = {"Kg"};
        String h_Units[] = {"cm"};

        JComboBox jcb1 = new JComboBox(w_Units);
        jcb1.setBounds(350,100,70,40);
        add(jcb1);
        jcb1.setBackground(Color.CYAN);
        JComboBox jcb2 = new JComboBox(h_Units);
        jcb2.setBounds(350,150,70,40);
        add(jcb2);
        jcb2.setBackground(Color.CYAN);

        l1.setBounds(30,100,70,40);
        add(l1);
        t1.setBounds(130,100,200,40);
        add(t1);
        l2.setBounds(30,150,70,40);
        add(l2);
        t2.setBounds(130,150,200,40);
        add(t2);
        btn.setBounds(200,240,100,40);
        add(btn);
        l3.setBounds(220,340,60,40);
        add(l3);

        btn.setBackground(Color.pink);
        l1.setBackground(Color.GREEN);
        l1.setOpaque(true);
        l2.setBackground(Color.GREEN);
        l2.setOpaque(true);
        l3.setBackground(Color.GREEN);
        l3.setOpaque(true);
        t1.setBackground(Color.LIGHT_GRAY);
        t2.setBackground(Color.LIGHT_GRAY);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    float weight = Float.parseFloat(t1.getText());
                    float height = Float.parseFloat(t2.getText());
                    float h = (float) (height * 0.01);
                    float result = weight / (h * h);


                    if(result <= 18.5){
                        JOptionPane.showMessageDialog(frame,"UnderWeight");
                    } else if (result > 25){
                        JOptionPane.showMessageDialog(frame,"OverWeight");
                    } else if (result > 18.5 || result < 24.9){
                        JOptionPane.showMessageDialog(frame,"Normal Weight");
                    }
                    l3.setText(String.valueOf(result));
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                    l3.setText("Invalid Arguments");
                }

            }
        });
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                bmi b = new bmi();
            }
        });
    }
}