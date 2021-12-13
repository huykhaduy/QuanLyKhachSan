package Modul;

import Modul.Error.InvalidNumberException;
import Modul.SupportModul.Check;

import java.math.BigDecimal;
import java.util.Scanner;

public class BangGia {
    static Scanner sc = new Scanner(System.in);
    //Gia Phong Thuong
    private static BigDecimal giaPhongThuongNgay = new BigDecimal("0");
    private static BigDecimal giaPhongThuongGio = new BigDecimal("0");
    private static BigDecimal giaPhongThuongPhut = new BigDecimal("0");
    //Gia Phong Vip
    private static BigDecimal giaPhongVipNgay = new BigDecimal("0");
    private static BigDecimal giaPhongVipGio = new BigDecimal("0");
    private static BigDecimal giaPhongVipPhut= new BigDecimal("0");

    public static BigDecimal getGiaPhongThuongNgay() {
        return giaPhongThuongNgay;
    }

    public static void setGiaPhongThuongNgay(BigDecimal giaPhongThuongNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongNgay);
        BangGia.giaPhongThuongNgay = giaPhongThuongNgay;
    }

    public static BigDecimal getGiaPhongThuongGio() {
        return giaPhongThuongGio;
    }

    public static void setGiaPhongThuongGio(BigDecimal giaPhongThuongGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongGio);
        BangGia.giaPhongThuongGio = giaPhongThuongGio;
    }

    public static BigDecimal getGiaPhongThuongPhut() {
        return giaPhongThuongPhut;
    }

    public static void setGiaPhongThuongPhut(BigDecimal giaPhongThuongPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongPhut);
        BangGia.giaPhongThuongPhut = giaPhongThuongPhut;
    }

    public static BigDecimal getGiaPhongVipNgay() {
        return giaPhongVipNgay;
    }

    public static void setGiaPhongVipNgay(BigDecimal giaPhongVipNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipNgay);
        BangGia.giaPhongVipNgay = giaPhongVipNgay;
    }

    public static BigDecimal getGiaPhongVipGio() {
        return giaPhongVipGio;
    }

    public static void setGiaPhongVipGio(BigDecimal giaPhongVipGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipGio);
        BangGia.giaPhongVipGio = giaPhongVipGio;
    }

    public static BigDecimal getGiaPhongVipPhut() {
        return giaPhongVipPhut;
    }

    public static void setGiaPhongVipPhut(BigDecimal giaPhongVipPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipPhut);
        BangGia.giaPhongVipPhut = giaPhongVipPhut;
    }
    public static void thayDoiGiaTienThuong(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG THƯỜNG",40,'-'));
        int step = 1;
        do{
            try{
                if (step == 1){
                    System.out.print("> Nhập giá theo ngày: ");
                    setGiaPhongThuongNgay(new BigDecimal(sc.nextLine()));
                }
                if (step == 2){
                    System.out.print("> Nhập giá theo giờ: ");
                    setGiaPhongThuongGio(new BigDecimal(sc.nextLine()));
                }
                if (step == 3){
                    System.out.print("> Nhập giá theo phút: ");
                    setGiaPhongThuongPhut(new BigDecimal(sc.nextLine()));
                }
                step++;
            } catch (NumberFormatException ex){
                System.out.println("<!> Vui lòng nhập số");
            } catch (InvalidNumberException e) {
                System.out.println(e.toString());
            }
        } while (step<4);
    }

    public static void thayDoiGiaTienVip(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG VIP",40,'-'));
        int step = 1;
        do{
            try{
                if (step == 1){
                    System.out.print("> Nhập giá theo ngày: ");
                    setGiaPhongVipNgay(new BigDecimal(sc.nextLine()));
                }
                if (step == 2){
                    System.out.print("> Nhập giá theo giờ: ");
                    setGiaPhongVipGio(new BigDecimal(sc.nextLine()));
                }
                if (step == 3){
                    System.out.print("> Nhập giá theo phút: ");
                    setGiaPhongVipPhut(new BigDecimal(sc.nextLine()));
                }
                step++;
            } catch (NumberFormatException ex){
                System.out.println("<!> Vui lòng nhập số");
            } catch (InvalidNumberException e) {
                System.out.println(e.toString());
            }
        } while (step<4);
    }

    public static void hienThiGiaTienThuong(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG THƯỜNG",40,'-'));
        System.out.println("Giá phòng theo ngày: "+giaPhongThuongNgay);
        System.out.println("Giá phòng theo giờ: "+giaPhongThuongGio);
        System.out.println("Giá phòng theo ngày: "+giaPhongThuongPhut);
    }
    public static void hienThiGiaTienVip(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG VIP",40,'-'));
        System.out.println("Giá phòng theo ngày: "+giaPhongVipNgay);
        System.out.println("Giá phòng theo giờ: "+giaPhongVipGio);
        System.out.println("Giá phòng theo ngày: "+giaPhongVipPhut);
    }
}
