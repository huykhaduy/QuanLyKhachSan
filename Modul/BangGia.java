package Modul;

import Modul.Error.InvalidNumberException;
import Modul.SupportModul.Check;

import java.math.BigDecimal;
import java.util.Scanner;

public class BangGia{
    static Scanner sc = new Scanner(System.in);
    //Gia Phong Thuong
    private BigDecimal giaPhongThuongNgay = new BigDecimal("0");
    private BigDecimal giaPhongThuongGio = new BigDecimal("0");
    private BigDecimal giaPhongThuongPhut = new BigDecimal("0");
    //Gia Phong Vip
    private BigDecimal giaPhongVipNgay = new BigDecimal("0");
    private BigDecimal giaPhongVipGio = new BigDecimal("0");
    private BigDecimal giaPhongVipPhut= new BigDecimal("0");

    public BigDecimal getGiaPhongThuongNgay() {
        return giaPhongThuongNgay;
    }

    public void setGiaPhongThuongNgay(BigDecimal giaPhongThuongNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongNgay);
        this.giaPhongThuongNgay = giaPhongThuongNgay;
    }

    public BigDecimal getGiaPhongThuongGio() {
        return giaPhongThuongGio;
    }

    public void setGiaPhongThuongGio(BigDecimal giaPhongThuongGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongGio);
        this.giaPhongThuongGio = giaPhongThuongGio;
    }

    public BigDecimal getGiaPhongThuongPhut() {
        return giaPhongThuongPhut;
    }

    public void setGiaPhongThuongPhut(BigDecimal giaPhongThuongPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongPhut);
        this.giaPhongThuongPhut = giaPhongThuongPhut;
    }

    public BigDecimal getGiaPhongVipNgay() {
        return giaPhongVipNgay;
    }

    public void setGiaPhongVipNgay(BigDecimal giaPhongVipNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipNgay);
        this.giaPhongVipNgay = giaPhongVipNgay;
    }

    public BigDecimal getGiaPhongVipGio() {
        return giaPhongVipGio;
    }

    public void setGiaPhongVipGio(BigDecimal giaPhongVipGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipGio);
        this.giaPhongVipGio = giaPhongVipGio;
    }

    public BigDecimal getGiaPhongVipPhut() {
        return giaPhongVipPhut;
    }

    public void setGiaPhongVipPhut(BigDecimal giaPhongVipPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipPhut);
        this.giaPhongVipPhut = giaPhongVipPhut;
    }
    public void thayDoiGiaTienThuong(){
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

    public void thayDoiGiaTienVip(){
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

    public void hienThiGiaTienThuong(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG THƯỜNG",40,'-'));
        System.out.println("Giá phòng theo ngày: "+giaPhongThuongNgay);
        System.out.println("Giá phòng theo giờ: "+giaPhongThuongGio);
        System.out.println("Giá phòng theo ngày: "+giaPhongThuongPhut);
    }
    public void hienThiGiaTienVip(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG VIP",40,'-'));
        System.out.println("Giá phòng theo ngày: "+giaPhongVipNgay);
        System.out.println("Giá phòng theo giờ: "+giaPhongVipGio);
        System.out.println("Giá phòng theo ngày: "+giaPhongVipPhut);
    }
}
