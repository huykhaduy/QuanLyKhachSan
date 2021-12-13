package Modul;

import DanhSach.DanhSachDichVu;
import Modul.Error.InvalidNumberException;
import Modul.Error.InvalidStringException;
import Modul.Error.NotExsitException;
import Modul.SupportModul.Check;

import java.math.BigDecimal;

public class ChiTietDichVu extends DichVu{
    private BigDecimal soLuong = new BigDecimal("0");
    private BigDecimal giaTien = new BigDecimal("0");

    public ChiTietDichVu() {
        super();
    }

    public ChiTietDichVu(DanhSachDichVu ds,String maDV,BigDecimal soLuong,BigDecimal giaTien) throws NotExsitException {
        super();
        DichVu dv = ds.layDuLieuDV(maDV);
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.donGia = dv.donGia;
        this.tenDV = dv.tenDV;
        this.donVi = dv.donVi;
    }

    public DichVu getDanhSachDV(DanhSachDichVu ds,String maDV) throws NotExsitException {
        return ds.layDuLieuDV(maDV);
    }

    public void setMaDV(DanhSachDichVu ds, String maDV) throws NotExsitException {
        DichVu dv = getDanhSachDV(ds,maDV);
        this.maDV = dv.maDV;
        this.donGia = dv.donGia;
        this.tenDV = dv.tenDV;
        this.donVi = dv.donVi;
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
        giaTien = soLuong.multiply(donGia);
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

    public void xuatThongTin() {
        //Kiem tra dich vu co ton tai hay k
        //donGia = getDonGia();
        System.out.println(" - Mã dịch vụ: " + maDV);
        System.out.println(" - Số lượng: " + soLuong);
        System.out.println(" - Đơn giá: " + donGia);
        System.out.println(" - Giá tiền: " + giaTien);
        System.out.println(" - Ngày giờ: " + ngayTao);
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
        String format = String.format("|%15s|%25s|%10s|%15s|%15s|%20s|\n", maDV, tenDV, soLuong, donGia, giaTien, ngayTao);
        return format;
    }

    public String getUuDaiStr(){
        String format = String.format("|%15s|%25s|%10s|%15s|%20s|\n", maDV, tenDV, soLuong, donVi, ngayTao);
        return format;
    }

}
