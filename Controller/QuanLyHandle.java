package Controller;

import DanhSach.DanhSachDichVu;
import DanhSach.DanhSachPhong;
import DanhSach.DanhSachTienNghi;
import DanhSach.DanhSachUuDai;
import Modul.BangGia;
import Modul.Text;

import java.util.Scanner;

public class QuanLyHandle {
    static Scanner sc = new Scanner(System.in);
    public static void quanLyPhong(){
        DanhSachPhong dsp = Program.getDSP();
        dsp.nhapThongTin();
    }

    public static void quanLyGiaThue(){
        BangGia bangGia = Program.getBangGia();
        while (true){
            System.out.println();
            System.out.println(Text.center("BẢNG GIÁ",60,'-'));
            System.out.println("|"+Text.leftAt(15,Text.setLength("1. Thay đổi giá phòng thường",42),' ')+"|");
            System.out.println("|"+Text.leftAt(15,Text.setLength("2. Thay đổi giá phòng vip",42),' ')+"|");
            System.out.println("|"+Text.leftAt(15,Text.setLength("3. Xem giá phòng thường",42),' ')+"|");
            System.out.println("|"+Text.leftAt(15,Text.setLength("4. Xem giá phòng vip",42),' ')+"|");
            System.out.println("|"+Text.leftAt(15,Text.setLength("5. Trở về danh sách",42),' ')+"|");
            System.out.println(Text.center("",60,'-'));
            System.out.print("> Nhập lựa chọn: ");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    bangGia.thayDoiGiaTienThuong();
                    break;
                case "2":
                    bangGia.thayDoiGiaTienVip();
                    break;
                case "3":
                    bangGia.hienThiGiaTienThuong();
                    break;
                case "4":
                    bangGia.hienThiGiaTienVip();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("<!> Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }

    public static void quanLyTienNghi(){
        DanhSachTienNghi dstn = Program.getDstnThuong();
        DanhSachTienNghi dstnvip = Program.getDstnVip();
        while (true) {
            System.out.println();
            System.out.println(Text.center("DANH SÁCH TIỆN NGHI", 60, '-'));
            System.out.println("|" + Text.leftAt(15, Text.setLength("1. Danh sách tiện nghi thường", 42), ' ') + "|");
            System.out.println("|" + Text.leftAt(15, Text.setLength("2. Danh sách tiện nghi vip", 42), ' ') + "|");
            System.out.println("|" + Text.leftAt(15, Text.setLength("3. Trở về danh sách", 42), ' ') + "|");
            System.out.println(Text.center("", 60, '-'));
            System.out.print("> Nhập lựa chọn: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    dstn.nhapThongTin();
                    break;
                case "2":
                    dstnvip.nhapThongTin();
                    break;
                case "3":
                    dstn.writeToFile("./Data/TienNghiThuong.txt");
                    dstnvip.writeToFile("./Data/TienNghiVip.txt");
                    return;
                default:
                    System.out.println("<!> Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }

    public static void quanLyDichVu(){
        DanhSachDichVu ds = Program.getDSDV();
        ds.nhapThongTin();
    }

    public static void quanLyUuDai(){
        DanhSachUuDai uudaiVip = Program.getDsudVip();
        uudaiVip.nhapThongTin();
    }

    public static void quanLyHoaDon(){

    }
}
