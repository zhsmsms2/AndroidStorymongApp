package com.myapplication;

import java.time.LocalDateTime;

public class Member {
    private int mb_id;
    private String mb_email;
    private String mb_password;
    private String mb_phone;
    private String mb_type;
    private String mb_gender;
    private String mb_name;
    private String mb_birthdt;
    private String mb_status;
    private String mb_marketing;
    private String mb_auth;
    private int mb_dream;
    private int mb_point;
    private String author_reg;
    private String reg_dt;
    private String mod_dt;
    private String mb_pic;
    private String old_mb_pic_file;
    private String default_pic;

    public Member(int mb_id, String mb_email, String mb_password, String mb_phone, String mb_type, String mb_gender, String mb_name, String mb_birthdt, String mb_status, String mb_marketing, String mb_auth, int mb_dream, int mb_point, String author_reg, String reg_dt, String mod_dt, String mb_pic, String old_mb_pic_file, String default_pic) {
        this.mb_id = mb_id;
        this.mb_email = mb_email;
        this.mb_password = mb_password;
        this.mb_phone = mb_phone;
        this.mb_type = mb_type;
        this.mb_gender = mb_gender;
        this.mb_name = mb_name;
        this.mb_birthdt = mb_birthdt;
        this.mb_status = mb_status;
        this.mb_marketing = mb_marketing;
        this.mb_auth = mb_auth;
        this.mb_dream = mb_dream;
        this.mb_point = mb_point;
        this.author_reg = author_reg;
        this.reg_dt = reg_dt;
        this.mod_dt = mod_dt;
        this.mb_pic = mb_pic;
        this.old_mb_pic_file = old_mb_pic_file;
        this.default_pic = default_pic;
    }

    public int getMb_id() {
        return mb_id;
    }

    public void setMb_id(int mb_id) {
        this.mb_id = mb_id;
    }

    public String getMb_email() {
        return mb_email;
    }

    public void setMb_email(String mb_email) {
        this.mb_email = mb_email;
    }

    public String getMb_password() {
        return mb_password;
    }

    public void setMb_password(String mb_password) {
        this.mb_password = mb_password;
    }

    public String getMb_phone() {
        return mb_phone;
    }

    public void setMb_phone(String mb_phone) {
        this.mb_phone = mb_phone;
    }

    public String getMb_type() {
        return mb_type;
    }

    public void setMb_type(String mb_type) {
        this.mb_type = mb_type;
    }

    public String getMb_gender() {
        return mb_gender;
    }

    public void setMb_gender(String mb_gender) {
        this.mb_gender = mb_gender;
    }

    public String getMb_name() {
        return mb_name;
    }

    public void setMb_name(String mb_name) {
        this.mb_name = mb_name;
    }

    public String getMb_birthdt() {
        return mb_birthdt;
    }

    public void setMb_birthdt(String mb_birthdt) {
        this.mb_birthdt = mb_birthdt;
    }

    public String getMb_status() {
        return mb_status;
    }

    public void setMb_status(String mb_status) {
        this.mb_status = mb_status;
    }

    public String getMb_marketing() {
        return mb_marketing;
    }

    public void setMb_marketing(String mb_marketing) {
        this.mb_marketing = mb_marketing;
    }

    public String getMb_auth() {
        return mb_auth;
    }

    public void setMb_auth(String mb_auth) {
        this.mb_auth = mb_auth;
    }

    public int getMb_dream() {
        return mb_dream;
    }

    public void setMb_dream(int mb_dream) {
        this.mb_dream = mb_dream;
    }

    public int getMb_point() {
        return mb_point;
    }

    public void setMb_point(int mb_point) {
        this.mb_point = mb_point;
    }

    public String getAuthor_reg() {
        return author_reg;
    }

    public void setAuthor_reg(String author_reg) {
        this.author_reg = author_reg;
    }

    public String getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(String reg_dt) {
        this.reg_dt = reg_dt;
    }

    public String getMod_dt() {
        return mod_dt;
    }

    public void setMod_dt(String mod_dt) {
        this.mod_dt = mod_dt;
    }

    public String getMb_pic() {
        return mb_pic;
    }

    public void setMb_pic(String mb_pic) {
        this.mb_pic = mb_pic;
    }

    public String getOld_mb_pic_file() {
        return old_mb_pic_file;
    }

    public void setOld_mb_pic_file(String old_mb_pic_file) {
        this.old_mb_pic_file = old_mb_pic_file;
    }

    public String getDefault_pic() {
        return default_pic;
    }

    public void setDefault_pic(String default_pic) {
        this.default_pic = default_pic;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mb_id=" + mb_id +
                ", mb_email='" + mb_email + '\'' +
                ", mb_password='" + mb_password + '\'' +
                ", mb_phone='" + mb_phone + '\'' +
                ", mb_type='" + mb_type + '\'' +
                ", mb_gender='" + mb_gender + '\'' +
                ", mb_name='" + mb_name + '\'' +
                ", mb_birthdt='" + mb_birthdt + '\'' +
                ", mb_status='" + mb_status + '\'' +
                ", mb_marketing='" + mb_marketing + '\'' +
                ", mb_auth='" + mb_auth + '\'' +
                ", mb_dream=" + mb_dream +
                ", mb_point=" + mb_point +
                ", author_reg='" + author_reg + '\'' +
                ", reg_dt='" + reg_dt + '\'' +
                ", mod_dt='" + mod_dt + '\'' +
                ", mb_pic='" + mb_pic + '\'' +
                ", old_mb_pic_file='" + old_mb_pic_file + '\'' +
                ", default_pic='" + default_pic + '\'' +
                '}';
    }
}
