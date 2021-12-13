package Modul;

import Modul.SupportModul.DateTime;

import java.io.Serializable;


public abstract class Phieu implements Serializable {
    protected KhachHang maKH;
    protected Phong maPhong;
    protected NhanVien maNV;
    protected DateTime ngayTaoPhieu = new DateTime();
 
    public Phieu() {
        ngayTaoPhieu.setCurrentTime();
    }

    public Phieu(KhachHang maKH, Phong maPhong, NhanVien maNV) {
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.maNV = maNV;
        ngayTaoPhieu.setCurrentTime();
    }

    public abstract void nhapThongTin();
    
    public abstract void xuatThongTin();


}
