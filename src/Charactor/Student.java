package Charactor;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String Sno;
    private String Sname;
    private String Ssex;
    private String Sage;
    private String Sdept;
    private String Cno;
    private String Grade;

    private List<String> InfoList = new ArrayList<>();

    public String getCno() {
        return Cno;
    }

    public String getGrade() {
        return Grade;
    }

    public String getSage() {
        return Sage;
    }

    public String getSdept() {
        return Sdept;
    }

    public String getSname() {
        return Sname;
    }

    public String getSno() {
        return Sno;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public void setSage(String sage) {
        Sage = sage;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public void setList(List<String> list){
        InfoList = list;
        for(int i = 0; i < InfoList.size(); i++){
            switch (i){
                case 0: Sno = InfoList.get(i);
                case 1: Sname = InfoList.get(i);
                case 2: Ssex = InfoList.get(i);
                case 3: Sage = InfoList.get(i);
                case 4: Sdept = InfoList.get(i);
                case 5: Cno = InfoList.get(i);
                case 6: Grade = InfoList.get(i);
            }
        }
    }

    public List<String> getList(){
        return InfoList;
    }

    public int getAttrCounts(){
        return 7;
    }

    @Override
    public String toString() {
        return Sno + "," + Sname + "," + Ssex + "," + Sage + "," + Sdept + "," + Cno + "," + Grade;
    }
}
