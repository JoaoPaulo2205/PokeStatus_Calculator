package pokestats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Screen extends JFrame {

    JTextField valueAttack, valueDefense, valueHP;

    public Screen() {

        setSize(330, 670);
        setTitle("Pokemon IV Calc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("C:/Users/user/IdeaProjects/PokeStatsCalculator/src/pokestats/images/pokeball.png");
        setIconImage(icon.getImage());

        setLayout(null);

        JButton calculate = new JButton();

        calculate.setText("Calculate IV");
        calculate.setBounds(80, 525, 150, 50);
        calculate.setFont(new Font("Arial", Font.BOLD, 14));
        calculate.setBackground(new Color(240, 240, 240));
        calculate.setForeground(new Color(0, 0, 0));

        add(calculate);
        calculate.addActionListener(this::calcularIV);

        valueAttack = new JTextField();
        valueAttack.setBounds(235, 375, 30, 30);
        valueAttack.setFont(new Font("Arial", Font.BOLD, 15));
        valueAttack.setHorizontalAlignment(JTextField.CENTER);

        add(valueAttack);

        valueDefense = new JTextField();
        valueDefense.setBounds(235, 415, 30, 30);
        valueDefense.setFont(new Font("Arial", Font.BOLD, 15));
        valueDefense.setHorizontalAlignment(JTextField.CENTER);

        add(valueDefense);

        valueHP = new JTextField();
        valueHP.setBounds(235, 455, 30, 30);
        valueHP.setFont(new Font("Arial", Font.BOLD, 15));
        valueHP.setHorizontalAlignment(JTextField.CENTER);

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


        JLabel imageLabel = new JLabel();

        ImageIcon pokemon_image = new ImageIcon("C:/Users/user/IdeaProjects/PokeStatsCalculator/src/pokestats/images/gengar.png");
        imageLabel.setIcon(pokemon_image);



        imageLabel.setBounds(80, 40, 200, 200);
        add(imageLabel);

        setVisible(true);
    }

    public void calcularIV(ActionEvent ActionEvent){

        Double attack = Double.parseDouble(valueAttack.getText());
        Double defense = Double.parseDouble(valueDefense.getText());
        Double hp = Double.parseDouble(valueHP.getText());

        double result = (((attack + defense + hp) / 45) * 100);

        String classifiedAs = " ";
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
            classifiedAs = " 100%% perfect!";
        }
        
        String resultIV = String.format("Your Pokemon IV is: %.0f%% %s", result, classifiedAs);
        JOptionPane.showMessageDialog(null, resultIV, "IV", JOptionPane.INFORMATION_MESSAGE);
    }
    


}

