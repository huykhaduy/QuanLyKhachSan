package Controller;

import DanhSach.*;
import Modul.*;
import Modul.Error.NotExsitException;

import java.util.Scanner;

public class LeTanHandle {
    static Scanner sc = new Scanner(System.in);
    public static void datPhong(){
        DanhSachPhong dsp = Program.getDSP();
        BangGia gia = Program.getBangGia();
        DanhSachHoaDon dshd = Program.getDSHD();
        DanhSachKhachHang dskh = Program.getDSKH();
        DanhSachUuDai dsuudai = Program.getDsudThuong();
        DanhSachUuDai dsuudaiVip = Program.getDsudVip();
        TaiKhoan tk = Program.getTaikhoan();
        System.out.print("> Nhập mã khách hàng: ");
        KhachHang kh;
        try {
            kh = dskh.layDuLieuKh(sc.nextLine());
        } catch (NotExsitException e) {
            System.out.println(e.toString());
            System.out.print(" Bạn có muốn tạo khách hàng (y/n)? ");
            if (sc.nextLine().equalsIgnoreCase("y")){
                themKhachHang();
                int index = dskh.getDskhArr().getLength()-1;
                kh = dskh.getDskhArr().getAt(index);
            }
            else return;
        }
        Phong ph;
        while (true){
            try {
                System.out.println();
                System.out.print("> Nhập mã phòng: ");
                ph =  dsp.layDuLieuPhong(sc.nextLine());
                break;
            } catch (NotExsitException e) {
                System.out.println(e.toString());
                System.out.print(" Bạn có muốn xem phòng trống (y/n)? ");
                if (sc.nextLine().equalsIgnoreCase("y")){
                    dsp.hienThiPhongTrong();
                }
            }
        }
        HoaDon newHD = new HoaDon(kh,ph,tk.getNhanVien());
        newHD.getPhieuThue().nhapThongTin();
        ph.setTinhTrang(true);
        if (ph.getLoaiPhong()==1){
            PhongVip v = (PhongVip) ph;
            v.setUuDaiVipClone(dsuudaiVip);
        }
        ph.setDstn();
        dshd.getDshdArr().push(newHD);
    }

    public static void themKhachHang(){
        DanhSachKhachHang dskh = Program.getDSKH();
        dskh.them();
    }

    public static void hienThiPhongTrong(){
        DanhSachPhong dsp = Program.getDSP();
        dsp.hienThiPhongTrong();
    }

    public static void yeuCauDichVu(){
        System.out.println("> Nhập mã phòng yêu cầu: ");
        DanhSachPhong dsp = Program.getDSP();
        Phong ph;
        try{
            ph = dsp.layDuLieuPhong(sc.nextLine());
        } catch (NotExsitException e){
            System.out.println(e.toString());
            System.out.println("<!> Mã phòng không tồn tại");
            return;
        }
        if (!ph.getTinhTrang()){
            System.out.println("<!> Phòng trống, không thể yêu cầu dịch vụ!");
            return;
        }
        DanhSachHoaDon dshd = Program.getDSHD();

    }
}
