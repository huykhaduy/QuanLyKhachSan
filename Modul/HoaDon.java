package Modul;

import Modul.SupportModul.DateTime;

import java.math.BigDecimal;

public class HoaDon extends Phieu implements ConsoleIO{
    private static int id=0;
    private int maHoaDon;
    private PhieuThue phieuThue;
    private PhieuThu phieuThu;
    private boolean thanhToan = false;
    private DateTime thoiGianThanhToan;
    private BigDecimal tongTien = new BigDecimal("0");
    private BigDecimal soTienKhachDua = new BigDecimal("0");
    private BigDecimal getSoTienPhaiTra = new BigDecimal("0");

    public HoaDon() {
        super();
        maHoaDon = ++id;
        phieuThu = new PhieuThu();
        phieuThue = new PhieuThue();
        thoiGianThanhToan = new DateTime();
    }

    public HoaDon(KhachHang maKH, Phong maPhong, NhanVien maNV) {
        super(maKH, maPhong, maNV);
        maHoaDon = ++id;
        phieuThu = new PhieuThu(maKH,maPhong);
        phieuThue = new PhieuThue(maKH,maPhong);
        thoiGianThanhToan = new DateTime();
    }

    //    public HoaDon(){
//        super();
//        maHoaDon = ++id;
//        phieuThu = new PhieuThu();
//        phieuThue = new PhieuThue();
//        thoiGianThanhToan = new DateTime();
//    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public PhieuThue getPhieuThue() {
        return phieuThue;
    }

    public void setPhieuThue(PhieuThue phieuThue) {
        this.phieuThue = phieuThue;
    }

    public PhieuThu getPhieuThu() {
        return phieuThu;
    }

    public void setPhieuThu(PhieuThu phieuThu) {
        this.phieuThu = phieuThu;
    }

    public boolean isThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(boolean thanhToan) {
        this.thanhToan = thanhToan;
    }

    public DateTime getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(DateTime thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public BigDecimal getSoTienKhachDua() {
        return soTienKhachDua;
    }

    public void setSoTienKhachDua(BigDecimal soTienKhachDua) {
        this.soTienKhachDua = soTienKhachDua;
    }

    public BigDecimal getGetSoTienPhaiTra() {
        return getSoTienPhaiTra;
    }

    public void setGetSoTienPhaiTra(BigDecimal getSoTienPhaiTra) {
        this.getSoTienPhaiTra = getSoTienPhaiTra;
    }

    // Variable of abtract


    public Phong getMaPhong() {
        return maPhong;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("----------NHẬP THÔNG TIN THUÊ----------");
        System.out.print("> Nhập mã KH: ");
        //Check if khach hang ton tai do
//        super.setMaKH(sc.nextInt());
        System.out.print("> Nhập mã phòng: ");
        //Check if phòng tồn tại và trống
//        super.setMaPhong(sc.nextInt());
        sc.nextLine();
//        phieuThue = new PhieuThue(maKH,maPhong);
//        phieuThu = new PhieuThu(maKH,maPhong);
        phieuThue.nhapThongTin();
//        phieuThu.nhapThongTin();
    }

    @Override
    public void xuatThongTin() {
        System.out.println("\n-------------------------HÓA ĐƠN----------------------");
        System.out.println(" - Mã hóa đơn: "+maHoaDon+"\t Ngày lập hóa đơn: "+ngayTaoPhieu);
        phieuThue.xuatThongTin();
        phieuThu.xuatThongTin();
    }

}
