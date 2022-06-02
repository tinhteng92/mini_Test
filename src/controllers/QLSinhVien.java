package controllers;

import Validate.ValidateStudent;
import io.ReaderAndWriter;
import models.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLSinhVien {
    Scanner scanner = new Scanner(System.in);
    List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
    ValidateStudent validateStudent = new ValidateStudent();
    ReaderAndWriter readerAndWriterStudent = new ReaderAndWriter();



    public QLSinhVien() {
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
            case 6:
                sinhVienList = readerAndWriterStudent.read();
                System.out.println("Đọc thành công");
                break;
            case 7:
                readerAndWriterStudent.write(sinhVienList);
                System.out.println("Viết thành công");
                break;
            case 8:
                System.exit(0);
        }
    }

    public void hienThiDS(){
        if(sinhVienList.size() == 0){
            System.out.println("Chưa có danh sách nào!");
        }
        for (int i = 0; i < sinhVienList.size(); i++) {
            if((i+1) % 5 == 0){
                System.out.println(sinhVienList.get(i));
                scanner.nextLine();
            }else {
                System.out.println(sinhVienList.get(i));
            }
        }
    }
    public SinhVien taoSinhVien(){
        int msv = validateStudent.validateID(sinhVienList);
        String hoTen= validateStudent.validateString("họ tên sinh viên: ");
        int tuoi = validateStudent.validateTuoi();
        String gioiTinh = validateStudent.validateGioiTinh();
        String diaChi = validateStudent.validateString("địa chỉ của sinh viên:");
        float diemTB = validateStudent.validateDiemTB();
        return new SinhVien(msv, hoTen,tuoi, gioiTinh, diaChi, diemTB);
    }
    public void themSV() {
        sinhVienList.add(taoSinhVien());
    }

    public void capNhat() {
        System.out.println("Nhập mã sinh viên cần sửa:");
        int msv = Integer.parseInt(scanner.nextLine());
        int index = validateStudent.getIndexMSV(msv, sinhVienList);
        if(index != -1){
            sinhVienList.set(index, taoSinhVien());
        }else {
            System.out.println("Mã sinh viên không tồn tại!");
        }
    }

    public void xoaSV(){
        System.out.println("Nhập mã số sinh viên của sv muốn xóa: ");
        int msv = Integer.parseInt(scanner.nextLine());
        int index = validateStudent.getIndexMSV(msv, sinhVienList);
        if(index != -1){
            sinhVienList.remove(index);
        }else {
            System.out.println("Sinh viên này ko tồn tại!");
        }
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
