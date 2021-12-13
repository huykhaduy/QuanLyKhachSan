package Controller;

import DanhSach.*;
import Modul.BangGia;

public class Program {
    static DanhSachKhachHang dskh;
    static DanhSachNhanVien dsnv;
    static DanhSachPhong dsphong;
    static DanhSachDichVu dsdv;
    static DanhSachTienNghi dstnThuong;
    static DanhSachTienNghi dstnVip;
    static DanhSachHoaDon dshd;
    static DanhSachUuDai dsudThuong;
    static DanhSachUuDai dsudVip;
    static BangGia bangGia;
    //Static TaiKhoan tk;

    public static void run(){
        Program.init();


    }

    public static void init(){
        dskh = new DanhSachKhachHang();
        dsnv = new DanhSachNhanVien();
        dsphong = new DanhSachPhong();
        dsdv = new DanhSachDichVu();
        dstnThuong = new DanhSachTienNghi();
        dstnVip = new DanhSachTienNghi();
        dshd = new DanhSachHoaDon();
        dsudVip = new DanhSachUuDai();
        dsudThuong = new DanhSachUuDai();
        bangGia = new BangGia();
    }

    public static DanhSachKhachHang getDSKH(){
        return dskh;
    }

    public static DanhSachNhanVien getDSNV(){
        return dsnv;
    }

    public static DanhSachPhong getDSP(){
        return dsphong;
    }

    public static DanhSachDichVu getDSDV(){
        return dsdv;
    }

    public static DanhSachTienNghi getDstnThuong(){
        return dstnThuong;
    }

    public static DanhSachTienNghi getDstnVip(){
        return dstnVip;
    }

    public static DanhSachHoaDon getDSHD(){
        return dshd;
    }

    public static DanhSachUuDai getDsudThuong(){
        return dsudThuong;
    }

    public static DanhSachUuDai getDsudVip(){
        return dsudVip;
    }

    public static BangGia getBangGia(){
        return bangGia;
    }


}
