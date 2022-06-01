package io;


import models.SinhVien;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderAndWriter {
    public void write(List<SinhVien> sinhVienList){
        File file = new File("data/students.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (SinhVien s: sinhVienList) {
                bufferedWriter.write(s.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<SinhVien> reader(){
        List<SinhVien> sinhVienList1 = new ArrayList<>();
        File file = new File("data/students.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = bufferedReader.readLine();
            while (str != null){
                String[] arr = str.split(",");
                String MSV = arr[0];
                String hoTen = arr[1];
                int tuoi = Integer.parseInt(arr[2]);
                String gioiTinh = arr[3];
                String diaChi = arr[4];
                Float diemTB = Float.parseFloat(arr[5]);

                sinhVienList1.add(new SinhVien(MSV, hoTen, tuoi, gioiTinh, diaChi, diemTB));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            System.err.println("File chua ton tai");
        }
        return sinhVienList1;
    }
}