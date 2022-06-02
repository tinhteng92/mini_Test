package Validate;

import models.SinhVien;

import java.util.List;
import java.util.Scanner;

public class ValidateStudent {
    Scanner scanner = new Scanner(System.in);
    public int validateID(List<SinhVien> sinhVienList){
        while (true){
            try {
                System.out.println("Nhập mã sinh viên:");
                int msv = Integer.parseInt(scanner.nextLine());
                if (getIndexMSV(msv, sinhVienList) != -1) {
                    throw new Exception();
                }
                return msv;
            }catch (Exception e){
                System.out.println("Nhập sai mã số sinh viên!");
            }
        }
    }

    public int getIndexMSV(int msv, List<SinhVien> sinhVienList){
        for (int i = 0; i < sinhVienList.size(); i++) {
            if(sinhVienList.get(i).getMSV() == msv){
                return i;
            }
        }
        return -1;
    }

    public String validateString(String name){
        while (true){
            System.out.println("Nhập " + name);
            String str = scanner.nextLine();
            if(str.equals("")){
                System.out.println("Không được để trống");
                continue;
            }
            return str;
        }
    }

    public String validateGioiTinh(){

        while (true){
            try {
                System.out.println("Nhập giới tính:");
                System.out.println("1. Nam");
                System.out.println("0. Nữ");
                System.out.println("Nhập 1 để chọn giới tính Nam, nhập 0 để chọn giới tính Nữ.");
                int choice = Integer.parseInt(scanner.nextLine());
                String gioiTinh;
                if(choice == 1){
                    return gioiTinh = "Nam";
                }else if (choice == 0) {
                    return gioiTinh = "Nữ";
                }
            }catch (Exception e){
                System.out.println("Chỉ chọn 0 hoặc 1!");
            }
        }
    }

    public int validateTuoi(){
        while (true){
            try {
                System.out.println("Nhập tuổi: ");
                int tuoi = Integer.parseInt(scanner.nextLine());
                return tuoi;
            }catch (Exception e){
                System.out.println("Nhập vào số!");
            }
        }
    }

    public float validateDiemTB(){
        while (true){
            try {
                System.out.println("Nhập điểm trung bình: ");
                float diemTB = Integer.parseInt(scanner.nextLine());
                if (diemTB < 0 || diemTB > 10){
                    System.out.println("Nhập điểm lớn hơn 0 và nhỏ hơn 10");
                }else {
                    return diemTB;
                }
            }catch (Exception e){
                System.out.println("Nhập vào số!");
            }
        }
    }

}
