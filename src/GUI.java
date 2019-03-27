import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JComboBox fishComboBox;
    private JButton start;

    public GUI() {
        super("Powerfisher");

        setLayout(new FlowLayout());

        start = new JButton("Start");

        fishComboBox = new JComboBox<>(FishData.values());


        add(fishComboBox);
        add(start);

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Powerfisher.fishData = (FishData) fishComboBox.getSelectedItem();
                dispose();
            }
        });

    }


}
