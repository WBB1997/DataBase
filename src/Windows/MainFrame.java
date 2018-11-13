package Windows;

import Charactor.Student;
import Util.InfoManager;
import Util.InfoModel;
import Adapter.PageControl;
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
    private JTextField index;
    private boolean flag = false;

    public MainFrame() {
        mainJFrame = this;
        search = new JButton("查找");
        JButton flash = new JButton("刷新");
        JTextField input = new JTextField(60);
        index = new JTextField("1",5);
        InfoModel tm = new InfoModel(((InfoManager) XmlUtil.getBean()).get(), ((InfoManager) XmlUtil.getBean()).getColumnNames());
        table = new JTable(tm);
        JComboBox<String> menu = new JComboBox<>(tm.getColumnNames().toArray(new String[]{}));
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
            PageControl.setFirstPage();
            dosomething();
        });
        last.addActionListener(e -> {
            PageControl.setLastPage();
            dosomething();
        });
        next.addActionListener(e -> {
            PageControl.setNextPage();
            dosomething();
        });
        prev.addActionListener(e -> {
            PageControl.setPrevPage();
            dosomething();
        });
        add.addActionListener(e -> {
            AddStudentPanel panel = new AddStudentPanel(((InfoModel) table.getModel()).getColumnNames(), mainJFrame);
            panel.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    PageControl.setFirstPage();
                    table.setModel(new InfoModel(((InfoManager) XmlUtil.getBean()).get(), ((InfoManager) XmlUtil.getBean()).getColumnNames()));
                    super.windowClosing(e);
                }
            });
        });
        innerPanelSouth.add(first);
        innerPanelSouth.add(prev);
        innerPanelSouth.add(index);
        innerPanelSouth.add(next);
        innerPanelSouth.add(last);
        innerPanelSouth.add(add);
        JScrollPane sp = new JScrollPane(table);
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            String args = (String) menu.getSelectedItem();
            InfoManager infoManager = (InfoManager) XmlUtil.getBean();
            String keyword = input.getText();
            if (keyword.length() > 0) {
                if(!flag)
                    PageControl.setFirstPage();
                table.setModel(new InfoModel(infoManager.get(args, input.getText()), ((InfoManager) XmlUtil.getBean()).getColumnNames()));
                flag = true;
            } else {
                table.setModel(new InfoModel(((InfoManager) XmlUtil.getBean()).get(), ((InfoManager) XmlUtil.getBean()).getColumnNames()));
                flag = false;
            }
            index.setText(Integer.toString(PageControl.getPage() + 1));
            index.updateUI();
        });
        flash.addActionListener(e -> {
            PageControl.setFirstPage();
            table.setModel(new InfoModel(((InfoManager) XmlUtil.getBean()).get(), ((InfoManager) XmlUtil.getBean()).getColumnNames()));
            input.setText("");
            flag = false;
        });
        this.add(sp, BorderLayout.CENTER);
        this.add(innerPanelNouth, BorderLayout.NORTH);
        this.add(innerPanelSouth, BorderLayout.SOUTH);
    }

    private JPopupMenu createPopupMenu(int row) {

        Student student = new Student();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < student.getAttrCounts(); i++)
            list.add(table.getValueAt(row, i).toString());
        student.setList(list);
        InfoManager infoManager = (InfoManager) XmlUtil.getBean();

        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem delMenuItem = new JMenuItem("删除");
        JMenuItem updMenuItem = new JMenuItem("更新");

        delMenuItem.addActionListener(e -> {
            int select;
            select = JOptionPane.showConfirmDialog(null, "确定删除吗?", "警告", JOptionPane.YES_NO_OPTION);
            if (select == 0) {
                JOptionPane.showMessageDialog(null, infoManager.delete(student), "信息", JOptionPane.WARNING_MESSAGE);
                search.doClick();
            }
        });
        updMenuItem.addActionListener(e -> {
            UpdateStudentPanel panel = new UpdateStudentPanel(((InfoModel) table.getModel()).getColumnNames(), student, mainJFrame);
            panel.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
//                    table.setModel(new InfoModel(((InfoManager) XmlUtil.getBean()).get(), ((InfoManager) XmlUtil.getBean()).getColumnNames()));
                    search.doClick();
                    super.windowClosing(e);
                }
            });
        });
        jPopupMenu.add(delMenuItem);
        jPopupMenu.add(updMenuItem);
        return jPopupMenu;
    }

    private void dosomething(){
        if(!flag) {
            InfoManager infoManager = (InfoManager) XmlUtil.getBean();
            table.setModel(new InfoModel(infoManager.get(), infoManager.getColumnNames()));
            index.setText(Integer.toString(PageControl.getPage() + 1));
            index.updateUI();
        }else
            search.doClick();
    }
}
