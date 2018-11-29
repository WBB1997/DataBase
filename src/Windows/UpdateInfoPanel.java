package Windows;

import Charactor.Student;
import Util.InfoManager;
import Util.XmlUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class UpdateInfoPanel extends JDialog {

    UpdateInfoPanel(List<String> columnNames, Object o , Frame parent) {
        super(parent, true);
        AbstructPanel userInterface = new AbstructPanel(columnNames); // 用对象属性初始化面板
        Student student = (Student)o; // 这里将传进来的对象转化成需要的实体类，更改表，此处需要更改

        userInterface.setFieldValues(student.getList()); // 将每个输入框输入对象的值
        JTextField[] textField = userInterface.getFields(); // 获取所有输入框

        this.setLayout(new BorderLayout());
        this.add(userInterface, BorderLayout.CENTER);
        JButton submit = userInterface.getDoTask1();
        JButton cancel = userInterface.getDoTask2();
        submit.setText("提交");
        cancel.setText("取消");
        submit.addActionListener(e -> {

            Student tmp = new Student(); // 定义一个对象用来保存需要更新的数据，更改表，此处需要更改

            InfoManager infoManager = (InfoManager) XmlUtil.getBean();
            List<String> list = new ArrayList<>();
            for (JTextField aTextField : textField)
                list.add(aTextField.getText());
            tmp.setList(list);
            // 更新数据，更改表，此处需要更改
            JOptionPane.showMessageDialog(null, infoManager.update(student, tmp), "信息", JOptionPane.WARNING_MESSAGE);
        });
        cancel.addActionListener(e -> this.dispose());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(270, 28 * (textField.length  * 2 + 1));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
