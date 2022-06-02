package models;

import java.text.SimpleDateFormat;

public class SinhVien {
    private int MSV;
    private String hoTen;
    private int tuoi;
    private String gioiTinh;
    private String diaChi;
    private float diemTB;

    public SinhVien() {
    }


    public SinhVien(int MSV, String hoTen, int tuoi, String gioiTinh, String diaChi, float diemTB) {
        this.MSV = MSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diemTB = diemTB;
    }

    public int getMSV() {
        return MSV;
    }

    public void setMSV(int MSV) {
        this.MSV = MSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "MSV='" + MSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", diemTB=" + diemTB +
                '}';
    }
    public String write(){
        return MSV + "," + hoTen + "," + tuoi + "," + gioiTinh + "," + diaChi + "," + diemTB;
    }
}
