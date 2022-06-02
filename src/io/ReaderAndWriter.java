package io;


import models.SinhVien;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderAndWriter {
    File file = new File("C:\\CodeGym\\Hoc-lieu-Java\\DemoCode\\Modul-2\\Mini_Test\\src\\data\\students.csv");
    public void write(List<SinhVien> sinhVienList){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("MSV, Họ tên, Tuổi, Giới Tính, Địa chỉ, Điểm TB");
            bufferedWriter.newLine();
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

    public List<SinhVien> read(){
        List<SinhVien> sinhVienList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null){
                String[] arr = str.split(",");
                int MSV = Integer.parseInt(arr[0]);
                String hoTen = arr[1];
                int tuoi = Integer.parseInt(arr[2]);
                String gioiTinh = arr[3];
                String diaChi = arr[4];
                Float diemTB = Float.parseFloat(arr[5]);

                sinhVienList.add(new SinhVien(MSV, hoTen, tuoi, gioiTinh, diaChi, diemTB));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("File chua ton tai");
        }
        return sinhVienList;
    }
}