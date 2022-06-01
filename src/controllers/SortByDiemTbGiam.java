package controllers;

import models.SinhVien;

import java.util.Comparator;

public class SortByDiemTbGiam implements Comparator<SinhVien> {


    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        if(o1.getDiemTB() < o2.getDiemTB()){
            return 1;
        }else {
            return -1;
        }
    }
}