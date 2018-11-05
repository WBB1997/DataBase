package Windows;

import Charactor.Student;
import Util.StudentManager;
import Util.StudentTableModel;
import Util.XmlUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private JTable table;
    private JFrame mainJFrame;
    private JButton search;

    public MainFrame() {
        mainJFrame = this;
        search = new JButton("查找");
        JButton flash = new JButton("刷新");
        JTextField input = new JTextField(60);
        StudentTableModel stm = new StudentTableModel();
        table = new JTable(stm);
        JComboBox<String> menu = new JComboBox<>(stm.getColumnNames().toArray(new String[]{}));
        JPanel innerPanelNouth = new JPanel();
        innerPanelNouth.setLayout(new FlowLayout(FlowLayout.CENTER));
        innerPanelNouth.add(menu);
        innerPanelNouth.add(input);
        innerPanelNouth.add(search);
        innerPanelNouth.add(flash);
        JPanel innerPanelSouth = new JPanel();
        innerPanelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton first = new JButton("首页");
        JButton last = new JButton("尾页");
        JButton prev = new JButton("上一页");
        JButton next = new JButton("下一页");
        JButton add = new JButton("添加");
        first.addActionListener(e -> {
            ((StudentTableModel) table.getModel()).firstPage();
            table.updateUI();
        });
        last.addActionListener(e -> {
            ((StudentTableModel) table.getModel()).lastPage();
            table.updateUI();
        });
        next.addActionListener(e -> {
            ((StudentTableModel) table.getModel()).nextPage();
            table.updateUI();
        });
        prev.addActionListener(e -> {
            ((StudentTableModel) table.getModel()).prevPage();
            table.updateUI();
        });
        add.addActionListener(e -> {
            AddStudentPanel panel =  new AddStudentPanel(((StudentTableModel) table.getModel()).getColumnNames(), mainJFrame);
            panel.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    ((StudentTableModel)table.getModel()).setPage(0);
                    search.doClick();
                    super.windowClosing(e);
                }
            });
        });
        innerPanelSouth.add(first);
        innerPanelSouth.add(prev);
        innerPanelSouth.add(next);
        innerPanelSouth.add(last);
        innerPanelSouth.add(add);
        JScrollPane sp = new JScrollPane(table);
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            System.out.println("选择了" + row + "行");
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //右击弹出菜单
                if (SwingUtilities.isRightMouseButton(e)) {
                    JPopupMenu popMenu;
                    JTable table = (JTable) e.getComponent();
                    //获取鼠标右键选中的行
                    int row = table.rowAtPoint(e.getPoint());
                    if (row == -1)
                        return;
                    //获取已选中的行
                    int[] rows = table.getSelectedRows();
                    boolean inSelected = false;
                    //判断当前右键所在行是否已选中
                    for (int r : rows)
                        if (row == r) {
                            inSelected = true;
                            break;
                        }
                    //当前鼠标右键点击所在行不被选中则高亮显示选中行
                    if (!inSelected)
                        table.setRowSelectionInterval(row, row);
                    //生成右键菜单
                    popMenu = createPopupMenu(row);
                    popMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        search.addActionListener(e -> {
            String flag = (String) menu.getSelectedItem();
            StudentManager studentManager = (StudentManager) XmlUtil.getBean();
            String keyword = input.getText();
            if (keyword.length() > 0) {
                List<Student> res = studentManager.get(flag, input.getText());
                StudentTableModel model = new StudentTableModel(res);
                model.setPage(((StudentTableModel) table.getModel()).getPage());
                table.setModel(model);
            } else {
                StudentTableModel model = new StudentTableModel();
                model.setPage(((StudentTableModel) table.getModel()).getPage());
                table.setModel(model);
            }
        });
        flash.addActionListener(e -> {
            table.setModel(new StudentTableModel());
            input.setText("");
        });
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowGainedFocus(WindowEvent e) {
//                System.out.println("State");
//                int rowHeight = table.getRowHeight();
//                int Height = mainJFrame.getHeight();
//                int pageSize = Height / rowHeight;
//                StudentTableModel.setPageSize(pageSize);
//                search.doClick();
//                super.windowGainedFocus(e);
//            }
//        });
        this.add(sp, BorderLayout.CENTER);
        this.add(innerPanelNouth, BorderLayout.NORTH);
        this.add(innerPanelSouth, BorderLayout.SOUTH);
    }

    private JPopupMenu createPopupMenu(int row) {

        Student student = new Student();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < student.getAttrCounts(); i++)
            list.add(table.getValueAt(row,i).toString());
        student.setList(list);
        StudentManager studentManager = (StudentManager) XmlUtil.getBean();

        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem delMenuItem = new JMenuItem("删除");
        JMenuItem updMenuItem = new JMenuItem("更新");

        delMenuItem.addActionListener(e -> {
            int select;
            select = JOptionPane.showConfirmDialog(null, "确定删除吗?", "警告", JOptionPane.YES_NO_OPTION);
            if (select == 0) {
                JOptionPane.showMessageDialog(null, studentManager.delete(student), "信息", JOptionPane.WARNING_MESSAGE);
                search.doClick();
            }
        });
        updMenuItem.addActionListener(e -> {
            UpdateStudentPanel panel =  new UpdateStudentPanel(((StudentTableModel) table.getModel()).getColumnNames(), student, mainJFrame);
            panel.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    search.doClick();
                    super.windowClosing(e);
                }
            });
        });
        jPopupMenu.add(delMenuItem);
        jPopupMenu.add(updMenuItem);
        return jPopupMenu;
    }
}
