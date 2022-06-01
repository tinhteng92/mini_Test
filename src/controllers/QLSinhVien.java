package controllers;

import io.ReaderAndWriter;
import models.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLSinhVien {
    Scanner scanner = new Scanner(System.in);
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();
    List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
    String[] gioiTinh = new String[2];


    public QLSinhVien() {
        gioiTinh[0] = "Nũ";
        gioiTinh[1] = "Nam";
    }



    public void menu(){
        System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
        System.out.println("Chọn chức năng theo số(để tiếp tục");
        System.out.println("1. Xem danh sách sinh viên");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                hienThiDS();
                break;
            case 2:
                themSV();
                break;
            case 3:
                capNhat();
                break;
            case 4:
                xoaSV();
                break;
            case 5:
                sapXep();
                break;
//            case 6:
//                doc();
//            case 7:
//                ghi();
            case 8:
                System.exit(0);
        }
    }

    public void hienThiDS(){
        System.out.println("Danh sách sinh viên: ");
        for(SinhVien sinhVien: sinhVienList){
            System.out.println(sinhVien);
        }
    }
    public SinhVien taoSinhVien(){
        boolean checkTuoi = false;
        boolean checkDiemTB = false;
        System.out.println("Nhập mã sinh viên:");
        String MSV = scanner.nextLine();
        System.out.println("Nhập tên sinh viên:");
        String hoTen = scanner.nextLine();
        int tuoi = -1;
        while (!checkTuoi) {
            try {
                System.out.println("Nhập tuổi:");
                tuoi = Integer.parseInt(scanner.nextLine());
                checkTuoi = true;
            } catch (Exception e) {
                System.err.println("Hãy nhập số!");
            }
        }
        System.out.println("Chọn giới tính của sinh viên:");
        for (int i = 0; i < gioiTinh.length; i++) {
            System.out.println("      " + i +". " + gioiTinh[i]);
        }
        System.out.println("Nếu là Nữ chọn 0, nếu là Nam chọn 1");
        int choice1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập địa chỉ:");
        String diaChi = scanner.nextLine();
        float diemTB = -1;
        while (!checkDiemTB) {
            try {
                System.out.println("Nhập điểm trung bình:");
                diemTB = Float.parseFloat(scanner.nextLine());
                checkDiemTB = true;
            } catch (Exception e) {
                System.err.println("Hãy nhập số!");
            }
        }
        return new SinhVien(MSV, hoTen, tuoi, gioiTinh[choice1], diaChi, diemTB);
    }
    public void themSV() {
        sinhVienList.add(taoSinhVien());
    }

    public void capNhat() {
        System.out.println("Nhập mã sinh viên cần sửa:");
        String msv = scanner.nextLine();
        for (int i = 0; i < sinhVienList.size(); i++) {
            if(sinhVienList.get(i).getMSV().equals(msv)) {
                sinhVienList.remove(i);
                themSV();
                break;
            } else if (i == sinhVienList.size() - 1){
                System.out.println("Không tìm được sinh viên với mã sinh viên trên.");
                capNhat();
                break;
            } else if (msv.equals("")) {
                break;
            }
        }
    }

    public SinhVien xoaSV(){
        System.out.println("Nhập mã số sinh viên của sv muốn xóa: ");
        String msv = scanner.nextLine();
        SinhVien sinhVien = null;
        for (SinhVien sv: sinhVienList) {
            if (sv.getMSV().equals(msv)) {
                sinhVien = sv;
            }
        }
        if(sinhVien != null){
            sinhVienList.remove(sinhVien);
            System.out.println("Xóa sinh viên có mã số" + msv + "thành công");
        }
        return sinhVien;
    }

    public void sapXep(){
        System.out.println("---- Sắp xếp sinh viên theo điểm trung bình ---");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần");
        System.out.println("3. Thoát");
        System.out.println("Chọn chức năng: ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2){
            case 1:
                sinhVienList.sort(new SortByDiemTbTang());
                hienThiDS();
                sapXep();
                break;
            case 2:
                sinhVienList.sort(new SortByDiemTbGiam());
                hienThiDS();
                break;
            case 3:
                menu();
                break;

        }


    }
}
