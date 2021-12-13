package Modul;

import java.math.BigDecimal;
import java.util.LinkedList;

public class PhieuThu extends Phieu implements ConsoleIO{
    private static int id = 0;
    private int maPhieuThu;
    private LinkedList<ChiTietDichVu> dsdv = new LinkedList<ChiTietDichVu>();
    private BigDecimal tongTien = new BigDecimal("0");

    public PhieuThu() {
        super();
        maPhieuThu = ++id;
    }

    public PhieuThu(int maKH,int maPhong) {
        super();
        maPhieuThu = ++id;
        this.maKH = maKH;
        this.maPhong = maPhong;
    }
    
    public void themDichVu() {
        dsdv.add(new ChiTietDichVu());
        dsdv.getLast().nhapThongTin();
        updateTongTien();
    }
    
    public void xoaDichVu() {
        dsdv.removeLast();
        updateTongTien();
    }
    
    public void updateTongTien() {
        BigDecimal sum = new BigDecimal("0");
        for (ChiTietDichVu ct : dsdv) {
            sum.add(ct.getGiaTien());
        }
    }

    public int getMaPhieuThu() {
        return this.maPhieuThu;
    }

    public void setMaPhieuThu(int maPhieuThu) {
        this.maPhieuThu = maPhieuThu;
    }


    public BigDecimal getTongTien() {
        return this.tongTien;
    }


    @Override
    public void nhapThongTin() {
        System.out.print("> Nhập mã KH: ");
        this.maKH = sc.nextInt();
        sc.nextLine();
    }
    
    @Override
    public void xuatThongTin() {
        System.out.println("\n-------------------------PHIẾU THU--------------------------");
        System.out.println(" - Tên khách hàng: " + maPhieuThu+"\t Ngày lập phiếu thu: "+ngayTaoPhieu);
        System.out.println(" - Mã phiếu thu: " + maPhieuThu+"\t Ngày lập phiếu thu: "+ngayTaoPhieu);
        System.out.println("--------------DANH SÁCH CÁC DỊCH VỤ ĐÃ DÙNG--------------");
        System.out.print(title());
        dsdv.forEach(item -> {
            System.out.println(item);
        });
        System.out.println(" => Tổng tiền: " + tongTien);
    }

    public static String title(){
        String header = Text.center("",128,'-')+"\n";
        String format = String.format("|%-15s|%-15s|%-25s|%-10s|%-15s|%-15s|%-20s|\n","Mã DV","Tên DV","Số Lượng","Đơn Giá","Giá Tiền","Ngày tạo");
        String footer = Text.center("",128,'-')+"\n";
        String returnStr = header + format + footer;
        return returnStr;
    }



}
