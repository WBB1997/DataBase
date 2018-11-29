package Windows;

import Charactor.Student;
import Util.InfoManager;
import Util.XmlUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class AddInfoPanel extends JDialog {

    AddInfoPanel(List<String> columnNames, Frame parent) {
        super(parent, true);
        AbstructPanel userInterface = new AbstructPanel(columnNames);
        JTextField[] textField = userInterface.getFields();

        this.setLayout(new BorderLayout());
        this.add(userInterface, BorderLayout.CENTER);
        JButton submit = userInterface.getDoTask1();
        JButton cancel = userInterface.getDoTask2();
        submit.setText("提交");
        cancel.setText("取消");
        submit.addActionListener(e -> {
            Student tmp = new Student();// 更改表，此处需要更改
            InfoManager infoManager = (InfoManager) XmlUtil.getBean();
            List<String> list = new ArrayList<>();
            for (JTextField aTextField : textField)
                list.add(aTextField.getText());
            tmp.setList(list);
            //更改表，此处需要更改
            JOptionPane.showMessageDialog(null, infoManager.add(tmp), "信息", JOptionPane.WARNING_MESSAGE);
        });
        cancel.addActionListener(e -> this.dispose());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(270, 28 * (textField.length  * 2 + 1));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
