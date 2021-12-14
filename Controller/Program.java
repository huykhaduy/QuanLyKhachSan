package Controller;

import DanhSach.*;
import Modul.BangGia;
import Modul.TaiKhoan;

public class Program {
    private static DanhSachKhachHang dskh;
    private static DanhSachNhanVien dsnv;
    private static DanhSachPhong dsphong;
    private static DanhSachDichVu dsdv;
    private static DanhSachTienNghi dstnThuong;
    private static DanhSachTienNghi dstnVip;
    private static DanhSachHoaDon dshd;
    private static DanhSachUuDai dsudThuong;
    private static DanhSachUuDai dsudVip;
    private static DanhSachTaiKhoan dstk;
    private static BangGia bangGia;
    private static TaiKhoan tkLogin;

    public static void run(){
        Program.init();
        Program.readFiles();
//        dstk.themTaiKhoan("1","1","NV0001");
//        dstk.themTaiKhoan("2","2","NV0002");
//        dstk.themTaiKhoan("3","3","NV0003");
//        dstk.writeToFile();
        Program.getBangGia();
        while (true){
            MenuHandle.loginMenu();
            MenuHandle.showWorkMenu();
        }
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
        dstk = new DanhSachTaiKhoan();
        bangGia = new BangGia();
    }

    public static void readFiles(){
//        dskh.readFromFile();
        dsnv.readFromFile();
        dskh.readFromFile();
        dsphong.readFromFile();
        dstk.readFromFile();
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

    public static DanhSachTaiKhoan getDSTK(){
        return dstk;
    }

    public static BangGia getBangGia(){
        return bangGia;
    }

    public static TaiKhoan getTaikhoan(){
        return tkLogin;
    }

    public static void setTaiKhoan(TaiKhoan tk){
        tkLogin = tk;
    }

}
