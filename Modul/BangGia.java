package Modul;

import DanhSach.MyArray;
import Modul.Error.InvalidNumberException;
import Modul.SupportModul.Check;
import Modul.SupportModul.DocGhiFile;

import java.math.BigDecimal;
import java.util.Scanner;

public class BangGia{
    static Scanner sc = new Scanner(System.in);
    private boolean isSet = false;
    private boolean isSetVip = false;
    //Gia Phong Thuong
    private MyArray<BigDecimal> giaPhongThuong = new MyArray<BigDecimal>();
    //Gia Phong Vip
    private MyArray<BigDecimal> giaPhongVip = new MyArray<BigDecimal>();

    public BangGia(){
        giaPhongThuong.push(new BigDecimal("0"));
        giaPhongThuong.push(new BigDecimal("0"));
        giaPhongThuong.push(new BigDecimal("0"));
        giaPhongVip.push(new BigDecimal("0"));
        giaPhongVip.push(new BigDecimal("0"));
        giaPhongVip.push(new BigDecimal("0"));
    }

    public BigDecimal getGiaPhongThuongNgay() {
        return giaPhongThuong.getAt(0);
    }

    public void setGiaPhongThuongNgay(BigDecimal giaPhongThuongNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongNgay);
        this.giaPhongThuong.setAt(giaPhongThuongNgay,0);

    }

    public BigDecimal getGiaPhongThuongGio() {
        return giaPhongThuong.getAt(1);
    }

    public void setGiaPhongThuongGio(BigDecimal giaPhongThuongGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongGio);
        this.giaPhongThuong.setAt(giaPhongThuongGio,1);
    }

    public BigDecimal getGiaPhongThuongPhut() {
        return giaPhongThuong.getAt(2);
    }

    public void setGiaPhongThuongPhut(BigDecimal giaPhongThuongPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongThuongPhut);
        this.giaPhongThuong.setAt(giaPhongThuongPhut,2);
    }

    public BigDecimal getGiaPhongVipNgay() {
        return giaPhongVip.getAt(0);
    }

    public void setGiaPhongVipNgay(BigDecimal giaPhongVipNgay) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipNgay);
        this.giaPhongVip.setAt(giaPhongVipNgay,0);
    }

    public BigDecimal getGiaPhongVipGio() {
        return giaPhongVip.getAt(1);
    }

    public void setGiaPhongVipGio(BigDecimal giaPhongVipGio) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipGio);
        this.giaPhongVip.setAt(giaPhongVipGio,1);
    }

    public BigDecimal getGiaPhongVipPhut() {
        return giaPhongVip.getAt(2);
    }

    public void setGiaPhongVipPhut(BigDecimal giaPhongVipPhut) throws InvalidNumberException {
        Check.checkGiaTien(giaPhongVipPhut);
        this.giaPhongVip.setAt(giaPhongVipPhut,2);

    }
    public void thayDoiGiaTienThuong(){
        System.out.println(Text.center("B???NG GI?? PH??NG TH?????NG",40,'-'));
        int step = 1;
        do{
            try{
                if (step == 1){
                    System.out.print("> Nh???p gi?? theo ng??y: ");
                    setGiaPhongThuongNgay(new BigDecimal(sc.nextLine()));
                }
                if (step == 2){
                    System.out.print("> Nh???p gi?? theo gi???: ");
                    setGiaPhongThuongGio(new BigDecimal(sc.nextLine()));
                }
                if (step == 3){
                    System.out.print("> Nh???p gi?? theo ph??t: ");
                    setGiaPhongThuongPhut(new BigDecimal(sc.nextLine()));
                }
                step++;
            } catch (NumberFormatException ex){
                System.out.println("<!> Vui l??ng nh???p s???");
            } catch (InvalidNumberException e) {
                System.out.println(e.toString());
            }
        } while (step<4);
        isSet = true;
        writeToFile();
    }

    public void thayDoiGiaTienVip(){
        System.out.println(Text.center("B???NG GI?? PH??NG VIP",40,'-'));
        int step = 1;
        do{
            try{
                if (step == 1){
                    System.out.print("> Nh???p gi?? theo ng??y: ");
                    setGiaPhongVipNgay(new BigDecimal(sc.nextLine()));
                }
                if (step == 2){
                    System.out.print("> Nh???p gi?? theo gi???: ");
                    setGiaPhongVipGio(new BigDecimal(sc.nextLine()));
                }
                if (step == 3){
                    System.out.print("> Nh???p gi?? theo ph??t: ");
                    setGiaPhongVipPhut(new BigDecimal(sc.nextLine()));
                }
                step++;
            } catch (NumberFormatException ex){
                System.out.println("<!> Vui l??ng nh???p s???");
            } catch (InvalidNumberException e) {
                System.out.println(e.toString());
            }
        } while (step<4);
        isSetVip = true;
        writeToFile();
    }

    public void hienThiGiaTienThuong(){
        System.out.println(Text.center("B???NG GI?? PH??NG TH?????NG",40,'-'));
        System.out.println("Gi?? ph??ng theo ng??y: "+giaPhongThuong.getAt(0).toString());
        System.out.println("Gi?? ph??ng theo gi???: "+giaPhongThuong.getAt(1).toString());
        System.out.println("Gi?? ph??ng theo ng??y: "+giaPhongThuong.getAt(2).toString());

    }
    public void hienThiGiaTienVip(){
        System.out.println(Text.center("B???NG GI?? PH??NG VIP",40,'-'));
        System.out.println("Gi?? ph??ng theo ng??y: "+giaPhongVip.getAt(0).toString());
        System.out.println("Gi?? ph??ng theo gi???: "+giaPhongVip.getAt(1).toString());
        System.out.println("Gi?? ph??ng theo ng??y: "+giaPhongVip.getAt(2).toString());
    }

    public void writeToFile(){
        String name1 = "./Data/GiaPhongThuong.txt";
        String name2 = "./Data/GiaPhongVip.txt";
        DocGhiFile<BigDecimal> ghiThuong = new DocGhiFile<BigDecimal>(giaPhongThuong);
        ghiThuong.ghiFileVaoThuMuc(name1);
        DocGhiFile<BigDecimal> ghiVip = new DocGhiFile<BigDecimal>(giaPhongVip);
        ghiVip.ghiFileVaoThuMuc(name2);
    }

    public void readFromFile(){
        String name1 = "./Data/GiaPhongThuong.txt";
        String name2 = "./Data/GiaPhongVip.txt";
        DocGhiFile<BigDecimal> ghiThuong = new DocGhiFile<BigDecimal>();
        MyArray<BigDecimal> test = ghiThuong.docFileTuThuMuc(name1);
        if (test.getLength()>0){
            giaPhongThuong = test;
        }
        DocGhiFile<BigDecimal> ghiVip = new DocGhiFile<BigDecimal>();
        test = ghiVip.docFileTuThuMuc(name2);
        if (test.getLength()>0){
            giaPhongVip = test;
        }
    }
}
