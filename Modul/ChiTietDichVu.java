package Modul;

import DanhSach.DanhSachDichVu;
import Modul.Error.InvalidNumberException;
import Modul.Error.InvalidStringException;
import Modul.Error.NotExsitException;
import Modul.SupportModul.Check;
import Modul.SupportModul.DateTime;

import java.math.BigDecimal;

public class ChiTietDichVu implements ConsoleIO, MyCompare<ChiTietDichVu> {
    private DichVu dv = new DichVu();
    private BigDecimal soLuong = new BigDecimal("0");
    private BigDecimal giaTien = new BigDecimal("0");

    public ChiTietDichVu() {
    }

    public String getMaDV(){
        return dv.maDV;
    }

    public String getTenDV(){
        return dv.tenDV;
    }

    public DateTime getNgayTao(){
        return dv.ngayTao;
    }

    public String getDonVi(){
        return dv.donVi;
    }

    public ChiTietDichVu(DanhSachDichVu ds,String maDV) throws NotExsitException {
        DichVu dv = ds.layDuLieuDV(maDV);
    }

    public DichVu getDanhSachDV(DanhSachDichVu ds,String maDV) throws NotExsitException {
        return ds.layDuLieuDV(maDV);
    }

    public void setMaDV(DanhSachDichVu ds, String maDV) throws NotExsitException {
        dv = getDanhSachDV(ds,maDV);
    }

    private void setMaDV(String nextLine) {
    }

    public BigDecimal getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(String soLuong) throws InvalidNumberException {
        if (Check.containsCharacter(soLuong)) throw new InvalidNumberException("Vui lòng nhập số nguyên dương!");
        BigDecimal bg = new BigDecimal(soLuong);
        Check.checkGiaTien(bg);
        this.soLuong = bg;
    }

    public BigDecimal getGiaTien() {
        return this.giaTien;
    }

    public void updateGiaTien() {
        // getDonGia
        giaTien = soLuong.multiply(dv.donGia);
    }

    public void nhapThongTin(DanhSachDichVu ds) {
        int step =1;
        do{
            try {
                if (step == 1){
                    System.out.print("> Nhập mã dịch vụ: ");
                    setMaDV(ds,sc.nextLine());
                }
                if (step == 2){
                    System.out.print("> Nhập số lượng: ");
                    setSoLuong(sc.nextLine());
                }
                step++;
            } catch (NotExsitException e){
                System.out.println(e.toString());
            } catch (InvalidNumberException e) {
                System.out.println(e.toString());
            }
        } while (step <3);
        updateGiaTien();
    }

    @Override
    public void nhapThongTin() {
        int step =1;
        do{
            try {
                if (step == 1){
                    System.out.print("> Nhập mã dịch vụ: ");
                    setMaDV(sc.nextLine());
                }
                if (step == 2){
                    System.out.print("> Nhập số lượng: ");
                    setSoLuong(sc.nextLine());
                }
                step++;
            } catch (InvalidNumberException e) {
                System.out.println(e.toString());
            }
        } while (step <3);
        updateGiaTien();
    }

    public void xuatThongTin() {
        //Kiem tra dich vu co ton tai hay k
        //donGia = getDonGia();
        System.out.println(" - Mã dịch vụ: " + dv.maDV);
        System.out.println(" - Số lượng: " + soLuong);
        System.out.println(" - Đơn giá: " + dv.donGia);
        System.out.println(" - Giá tiền: " + giaTien);
        System.out.println(" - Ngày giờ: " + dv.ngayTao);
    }

    public void suaThongTin(){
        System.out.print("> Nhập số lượng: ");
        try {
            setSoLuong(sc.nextLine());
        } catch (InvalidNumberException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString() {
        String format = String.format("|%15s|%25s|%10s|%15s|%15s|%20s|\n", dv.maDV, dv.tenDV, soLuong, dv.donGia, giaTien, dv.ngayTao);
        return format;
    }

    public String getUuDaiStr(){
        String format = String.format("|%15s|%25s|%10s|%15s|%20s|\n", dv.maDV, dv.tenDV, soLuong, dv.donVi, dv.ngayTao);
        return format;
    }

    @Override
    public int compareTo(ChiTietDichVu o2, int type) {
        if (type == 1){
            if (this.dv.maDV.compareToIgnoreCase(o2.dv.maDV) >1)
                return 1;
            return -1;
        }
        if (type == 2){
            if (this.dv.tenDV.compareToIgnoreCase(o2.dv.tenDV)>1)
                return 1;
            return -1;
        }
        if (type == 3){
            if (this.dv.donGia.compareTo(o2.dv.donGia)>1)
                return 1;
            return -1;
        }
        if (type == 4){
            if (this.dv.ngayTao.compareDateTime(o2.dv.ngayTao)>0)
                return 1;
            return -1;
        }
        if (type == 5){
            if (this.soLuong.compareTo(o2.soLuong)>0)
                return 1;
            return -1;
        }
        if (type == 6){
            if (this.giaTien.compareTo(o2.giaTien)>0)
                return 1;
            return -1;
        }
        return 0;
    }
}
