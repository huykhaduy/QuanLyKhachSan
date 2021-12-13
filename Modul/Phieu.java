package Modul;

import Modul.SupportModul.DateTime;

import java.io.Serializable;


public abstract class Phieu implements Serializable {
    protected int maKH;
    protected int maPhong;
    protected int maNV;
    protected DateTime ngayTaoPhieu = new DateTime();
 
    public Phieu() {
        ngayTaoPhieu.setCurrentTime();
    }


    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong){
        if (maPhong>0)
            this.maPhong = maPhong;
    }

    public DateTime getNgayTaoPhieu() {
        return ngayTaoPhieu;
    }

    public void setNgayTaoPhieu(DateTime ngayTaoPhieu) {
        this.ngayTaoPhieu = ngayTaoPhieu;
    }

    public void setMaKH(int maKH){
        if (maKH>0)
            this.maKH = maKH;
    }

    public int getMaKH(){
        return maKH;
    }

    public void setMaNV(int maNV){
        if (maNV>0)
            this.maNV = maNV;
    }

    public int getMaNV(){
        return maNV;
    }

//    public KhachHang getThongTinKH(int maKH){
//
//    }

    public abstract void nhapThongTin();
    
    public abstract void xuatThongTin();


}
