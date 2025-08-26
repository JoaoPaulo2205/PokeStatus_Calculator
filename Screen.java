package pokestats;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public Screen() {

        setSize(330, 670);
        setTitle("Pokemon IV Calc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);

        setLayout(null);

        JButton calculate = new JButton();

        calculate.setText("Calculate IV");
        calculate.setBounds(80, 525, 150, 50);
        calculate.setFont(new Font("Comic Sans", Font.BOLD, 14));
        calculate.setBackground(new Color(240, 240, 240));
        calculate.setForeground(new Color(0, 0, 0));


        add(calculate);
        
        //ImageIcon pokemon = new ImageIcon("C:/Users/Ana Julia/IdeaProjects/PokeStatsCalculator/images/charizard.png");

        




        setVisible(true);
    }

}
