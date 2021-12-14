package Modul;

import Modul.Error.InvalidNumberException;
import Modul.SupportModul.Check;

import java.math.BigDecimal;
import java.util.Scanner;

public class BangGia{
    static Scanner sc = new Scanner(System.in);
    private boolean isSet = false;
    private boolean isSetVip = false;
    //Gia Phong Thuong
    private BigDecimal[] giaPhongThuong = new BigDecimal[3];
    //Gia Phong Vip
    private BigDecimal[] giaPhongVip = new BigDecimal[3];

    public BangGia(){
        giaPhongVip[0] = new BigDecimal("0");
        giaPhongVip[1] = new BigDecimal("0");
        giaPhongVip[2] = new BigDecimal("0");
        giaPhongThuong[0] = new BigDecimal("0");
        giaPhongThuong[1] = new BigDecimal("0");
        giaPhongThuong[2] = new BigDecimal("0");
    }

    public BigDecimal getGiaPhongThuongNgay() {
        return giaPhongThuong[0];
    }

    public void setGiaPhongThuongNgay(BigDecimal giaPhongThuongNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongNgay);
        this.giaPhongThuong[0] = giaPhongThuongNgay;
    }

    public BigDecimal getGiaPhongThuongGio() {
        return giaPhongThuong[1];
    }

    public void setGiaPhongThuongGio(BigDecimal giaPhongThuongGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongGio);
        this.giaPhongThuong[1] = giaPhongThuongGio;
    }

    public BigDecimal getGiaPhongThuongPhut() {
        return giaPhongThuong[2];
    }

    public void setGiaPhongThuongPhut(BigDecimal giaPhongThuongPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongPhut);
        this.giaPhongThuong[2] = giaPhongThuongPhut;
    }

    public BigDecimal getGiaPhongVipNgay() {
        return giaPhongVip[0];
    }

    public void setGiaPhongVipNgay(BigDecimal giaPhongVipNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipNgay);
        this.giaPhongVip[0] = giaPhongVipNgay;
    }

    public BigDecimal getGiaPhongVipGio() {
        return giaPhongVip[1];
    }

    public void setGiaPhongVipGio(BigDecimal giaPhongVipGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipGio);
        this.giaPhongVip[1] = giaPhongVipGio;
    }

    public BigDecimal getGiaPhongVipPhut() {
        return giaPhongVip[2];
    }

    public void setGiaPhongVipPhut(BigDecimal giaPhongVipPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipPhut);
        this.giaPhongVip[2] = giaPhongVipPhut;
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
        isSet = true;
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
        isSetVip = true;
    }

    public void hienThiGiaTienThuong(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG THƯỜNG",40,'-'));
        System.out.println("Giá phòng theo ngày: "+giaPhongThuong[0]);
        System.out.println("Giá phòng theo giờ: "+giaPhongThuong[1]);
        System.out.println("Giá phòng theo ngày: "+giaPhongThuong[2]);

    }
    public void hienThiGiaTienVip(){
        System.out.println(Text.center("BẢNG GIÁ PHÒNG VIP",40,'-'));
        System.out.println("Giá phòng theo ngày: "+giaPhongVip[1]);
        System.out.println("Giá phòng theo giờ: "+giaPhongVip[2]);
        System.out.println("Giá phòng theo ngày: "+giaPhongVip[3]);
    }
}
