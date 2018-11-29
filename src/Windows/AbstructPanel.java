package Windows;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class AbstructPanel extends JPanel {
    private JTextField[] fields;
    private JButton doTask1, doTask2;
    private int size;

    AbstructPanel(List<String> arrayString) {
        size = arrayString.size();
        JLabel[] labels = new JLabel[size];
        fields = new JTextField[size];
        for (int i = 0; i < size; i++)
            labels[i] = new JLabel(arrayString.get(i), JLabel.RIGHT);
        for (int i = 0; i < size; i++)
            fields[i] = new JTextField(40);
        JPanel innerPanelCenter = new JPanel();
        innerPanelCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < size; i++) {
            innerPanelCenter.add(labels[i]);
            innerPanelCenter.add(fields[i]);
        }
        doTask1 = new JButton("doTask1");
        doTask2 = new JButton("doTask2");
        JPanel innerPanelSouth = new JPanel();
        innerPanelSouth.add(doTask1);
        innerPanelSouth.add(doTask2);
        setLayout(new BorderLayout());
        add(innerPanelCenter, BorderLayout.CENTER);
        add(innerPanelSouth, BorderLayout.SOUTH);
    }

    JButton getDoTask1() {
        return doTask1;
    }

    JButton getDoTask2() {
        return doTask2;
    }

    JTextField[] getFields() {
        return fields;
    }

    void clearFields() {
        for (int i = 0; i < size; i++)
            fields[i].setText("");
    }

    void setFieldValues(List<String> strings) throws IllegalArgumentException {
        if (strings.size() != size)
            throw new IllegalArgumentException("数据个数不匹配");
        for (int i = 0; i < size; i++)
            fields[i].setText(strings.get(i));
    }

    List<String> getFieldValues() {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < size; i++)
            values.add(fields[i].getText());
        return values;
    }
}
