package com.yoo_devit.taalem_student.Beans;

public class Course {
    private String  Cname,Sdesc,Nbchapter,Cfee;
    private  int id;


    public Course(int id, String cname, String cchapter, String csshortdesc, String cfee) {
    }

    public Course( String cname, String nbchapter, String sdesc, String cfee) {
        Cname = cname;
        Nbchapter = nbchapter;
        Sdesc = sdesc;
        Cfee = cfee;
    }

    public Course(String cname, String nbchapter, String sdesc) {
        Cname = cname;
        Nbchapter = nbchapter;
        Sdesc = sdesc;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getNbchapter() {
        return Nbchapter;
    }

    public void setNbchapter(String nbchapter) {
        Nbchapter = nbchapter;
    }

    public String getSdesc() {
        return Sdesc;
    }

    public void setSdesc(String sdesc) {
        Sdesc = sdesc;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCfee() {
        return Cfee;
    }

    public void setCfee(String cfee) {
        Cfee = cfee;
    }
}
