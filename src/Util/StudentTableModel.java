package Util;

import Charactor.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;
 
public class StudentTableModel extends AbstractTableModel {

    private List<String> columnNames;

    private List<Student> studentList;

    private int page = 0;
    private static int pageSize = 20;
    private static int firstPage = 0;
    private static int endPage = 999;
    private static int midPage = 250;
    private List<Student> pageElements;

    public StudentTableModel() {
        StudentManager studentManager = (StudentManager) XmlUtil.getBean();
        studentList = studentManager.getstudentList();
        columnNames = studentManager.getcolumnNames();
        updatePageElements();
    }

    public StudentTableModel(List<Student> list) {
        StudentManager studentManager = (StudentManager) XmlUtil.getBean();
        studentList = list;
        columnNames = studentManager.getcolumnNames();
        updatePageElements();
    }

    public int getRowCount() {
        updatePageElements();
        return pageElements.size();
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        updatePageElements();
        Student student = pageElements.get(rowIndex);
        List<String> list = student.getList();
        return list.get(columnIndex);
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void nextPage() {
        page = (page + 1) * pageSize >= studentList.size() ? page : page + 1;
    }

    public void prevPage() {
        page = page > 0 ? page - 1 : page;
    }

    public void firstPage() {
        page = 0;
    }

    public void lastPage() {
        page = studentList.size() % pageSize == 0 ? (studentList.size() < pageSize ? 0 : studentList.size() / pageSize - 1)  : studentList.size() / pageSize;
    }


    public void setPage(int page) {
        this.page = page * pageSize >= studentList.size() ? (page - 1 >= 0 ? page - 1 : 0) : page;
    }

    public int getPage() {
        return page;
    }

    public int getAllPage(){
        return studentList.size() % pageSize == 0 ? (studentList.size() < pageSize ? 0 : studentList.size() / pageSize - 1)  : studentList.size() / pageSize;
    }

    public int PageState(){
        if((page + 1) * pageSize > studentList.size())
            return StudentTableModel.endPage;
        if(page == 0)
            return StudentTableModel.firstPage;
        else
            return StudentTableModel.midPage;
    }

    private void updatePageElements() {
        if (studentList.size() < pageSize)
            pageElements = studentList;
        else {
            int start = page * pageSize;
            int end = start + pageSize;
            if (end > studentList.size())
                end = studentList.size();
            pageElements = studentList.subList(start, end);
        }
    }

    public static void setPageSize(int pageSize) {
        StudentTableModel.pageSize = pageSize;
    }
}