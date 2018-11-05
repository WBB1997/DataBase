package Windows;

import Charactor.Student;
import Util.StudentManager;
import Util.XmlUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class AddStudentPanel extends JDialog {

    AddStudentPanel(List<String> columnNames, Frame parent) {
        super(parent, true);
        StudentUI userInterface = new StudentUI(columnNames);
        JTextField textField[] = userInterface.getFields();

        this.setLayout(new BorderLayout());
        this.add(userInterface, BorderLayout.CENTER);
        JButton submit = userInterface.getDoTask1();
        JButton cancel = userInterface.getDoTask2();
        submit.setText("提交");
        cancel.setText("取消");
        submit.addActionListener(e -> {
            Student tmp = new Student();
            StudentManager studentManager = (StudentManager) XmlUtil.getBean();
            List<String> list = new ArrayList<>();
            for (JTextField aTextField : textField)
                list.add(aTextField.getText());
            tmp.setList(list);
            JOptionPane.showMessageDialog(null, studentManager.add(tmp), "信息", JOptionPane.WARNING_MESSAGE);
        });
        cancel.addActionListener(e -> this.dispose());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(270, 28 * (textField.length  * 2 + 1));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}