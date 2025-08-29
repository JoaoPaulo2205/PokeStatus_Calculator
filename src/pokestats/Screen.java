package pokestats;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Screen extends JFrame {

    JTextField valueAttack, valueDefense, valueHP;
    JProgressBar ivBar;

    public Screen() {

        setSize(330, 670);
        setTitle("Pokemon IV Calc. V1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon icon;
        icon = new ImageIcon(getClass().getResource("./images/pokeball.png"));
        setIconImage(icon.getImage());

        setLayout(null);

        ivBar = new JProgressBar(0, 100);

        ivBar.setStringPainted(true);
        ivBar.setBounds(50, 255, 215, 15);
        ivBar.setFont(new Font("Arial", Font.BOLD, 14));
        ivBar.setBackground(new Color(255, 255, 255));
        ivBar.setForeground(new Color(76, 21, 143));
        add(ivBar);

        JButton calculate = new JButton();

        calculate.setText("Calculate IV");
        calculate.setBounds(80, 525, 150, 50);
        calculate.setFont(new Font("Arial", Font.BOLD, 14));
        calculate.setBackground(new Color(240, 240, 240));
        calculate.setForeground(new Color(0, 0, 0));

        add(calculate);
        calculate.addActionListener(this::calculateIV);

        JLabel limits = new JLabel();
        limits.setBounds(235, 350, 30, 30);
        limits.setText("0-15");
        limits.setFont(new Font("Arial", Font.BOLD, 15));
        limits.setForeground(new Color(85, 85, 85));
        limits.setBackground(new Color(255, 255, 255));

        add(limits);

        NumberDocumentFilter filter = new NumberDocumentFilter(0, 15);

        valueAttack = new JTextField();
        valueAttack.setBounds(235, 375, 30, 30);
        valueAttack.setFont(new Font("Arial", Font.BOLD, 15));
        valueAttack.setHorizontalAlignment(JTextField.CENTER);
        ((AbstractDocument) valueAttack.getDocument()).setDocumentFilter(filter);

        add(valueAttack);

        valueDefense = new JTextField();
        valueDefense.setBounds(235, 415, 30, 30);
        valueDefense.setFont(new Font("Arial", Font.BOLD, 15));
        valueDefense.setHorizontalAlignment(JTextField.CENTER);
        ((AbstractDocument) valueDefense.getDocument()).setDocumentFilter(filter);

        add(valueDefense);

        valueHP = new JTextField("");
        valueHP.setBounds(235, 455, 30, 30);
        valueHP.setFont(new Font("Arial", Font.BOLD, 15));
        valueHP.setHorizontalAlignment(JTextField.CENTER);
        ((AbstractDocument) valueHP.getDocument()).setDocumentFilter(filter);

        add(valueHP);

        JLabel attack = new JLabel("Insert your Attack level");
        attack.setBounds(50, 380, 170, 20);
        attack.setFont(new Font("Arial", Font.PLAIN, 15));

        add(attack);

        JLabel defense = new JLabel("Insert your Defense level");
        defense.setBounds(50, 420, 170, 20);
        defense.setFont(new Font("Arial", Font.PLAIN, 15));

        add(defense);

        JLabel hp = new JLabel("Insert your HP level");
        hp.setBounds(50, 460, 170, 20);
        hp.setFont(new Font("Arial", Font.PLAIN, 15));

        add(hp);

        JLabel newIV = new JLabel("Pokemon IV");
        newIV.setBounds(120, 238, 170, 20);
        newIV.setFont(new Font("Arial", Font.BOLD, 15));

        add(newIV);

        JLabel imageLabel = new JLabel();

        ImageIcon pokemon_image = new ImageIcon(getClass().getResource("./images/gengar.png"));
        imageLabel.setIcon(pokemon_image);

        imageLabel.setBounds(80, 35, 200, 200);
        add(imageLabel);

        setVisible(true);
    }

    public void calculateIV(ActionEvent ActionEvent){

        Double attack = Double.parseDouble(valueAttack.getText());
        Double defense = Double.parseDouble(valueDefense.getText());
        Double hp = Double.parseDouble(valueHP.getText());

        double result = (((attack + defense + hp) / 45) * 100);

        String classifiedAs = "-";
        if(result < 0 || result > 100) {
            classifiedAs = "Inválid!";
        }else if (result >= 0 && result <= 33.33){
            classifiedAs = "1 Star.";
        }else if(result > 33.3 && result < 66.66){
            classifiedAs = "2 Stars.";
        }else if(result > 66.66 && result <= 80){
            classifiedAs = "3 Stars.";
        }else if(result > 80 && result <= 90) {
            classifiedAs = "Good Pokemon.";
        }else if(result > 90 && result < 100) {
            classifiedAs = "Very Good Pokemon.";
        }else if(result == 100) {
            classifiedAs = "Perfect!";
        }

        String resultIV = String.format("Your Pokemon IV is: %d%% %s", (int) result, classifiedAs);
        JOptionPane.showMessageDialog(null, resultIV, "IV", JOptionPane.INFORMATION_MESSAGE);
        updateIV((int) result);
    }

    public void updateIV(int newIV){
        ivBar.setValue(newIV);
    }




}
