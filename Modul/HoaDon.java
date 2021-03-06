package Modul;

import Controller.Program;
import DanhSach.DanhSachHoaDon;
import DanhSach.DanhSachPhong;
import Modul.Error.NotExsitException;
import Modul.SupportModul.DateTime;

import java.io.Serializable;
import java.math.BigDecimal;

public class HoaDon extends Phieu implements ConsoleIO, Serializable,MyCompare<HoaDon> {
//    private static int id=0;
    private int maHoaDon;
    private String maHoaDonStr;
    private PhieuThue phieuThue;
    private PhieuThu phieuThu;
    private boolean thanhToan = false;
    private DateTime thoiGianThanhToan;

    public HoaDon() {
        super();
        maHoaDon = Program.getDSHD().getLargestId()+1;
        setMaHoaDonStr();
        phieuThu = new PhieuThu();
        phieuThue = new PhieuThue();
    }

    public HoaDon(KhachHang maKH, Phong maPhong, NhanVien maNV) {
        super(maKH, maPhong, maNV);
        maHoaDon = Program.getDSHD().getLargestId()+1;
        setMaHoaDonStr();
        phieuThu = new PhieuThu(maKH,maPhong);
        phieuThue = new PhieuThue(maKH,maPhong);
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHoaDonStr(){
        return maHoaDonStr;
    }

    public void setMaHoaDonStr(){
        this.maHoaDonStr = "HD" + maHoaDon;
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

    // Variable of abtract


    public Phong getMaPhong() {
        return maPhong;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("> X??c nh???n thanh to??n h??a ????n "+maHoaDonStr+" (y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")){
            PhieuThue pthue = getPhieuThue();
            pthue.traPhongNow();
            PhieuThu pthu = getPhieuThu();
            pthu.kiemTraUuDaiCuaPhongVip();
            thoiGianThanhToan = new DateTime();
            thoiGianThanhToan.setCurrentTime();
            thanhToan = true;
        }
    }

    @Override
    public void xuatThongTin() {
        System.out.println(Text.center("TH??NG TIN H??A ????N",60,'-'));
        System.out.println(" - M?? h??a ????n: "+maHoaDonStr+"\t\tNg??y t???o: "+ngayTaoPhieu.toString());
        System.out.println(" - M?? ph??ng: "+maPhong.getMaPhong()+"\t\tM?? KH: "+maKH.getMaKHStr());
        System.out.println(" - M?? NV: "+ maNV.getMaNVStr()+"\t\tT??n NV: "+maNV.getName());
        System.out.println(" - Tr???ng th??i: "+getTrangThaiStr());
        System.out.println(" - Th???i gian thanh to??n: "+(thoiGianThanhToan!=null?thoiGianThanhToan.toString():""));
        System.out.println(" - T???ng ti???n: "+tinhTien());
        phieuThue.xuatThongTin();
        phieuThu.xuatThongTin();
    }

    @Override
    public BigDecimal tinhTien() {
        if (phieuThue.tinhTien() == null) return new BigDecimal("0");
        return phieuThu.getTongTien().add(phieuThue.tinhTien());
    }

    public String getTrangThaiStr(){
        return thanhToan?"???? thanh to??n":"Ch??a thanh to??n";
    }

    public String toString(){
        String format = String.format("|%15s|%15s|%15s|%15s|%15s|%20s|%25s|%25s|",maHoaDonStr,maPhong.getMaPhong(),maKH.getMaKHStr(),maNV.getMaNVStr(),tinhTien().toString(),getTrangThaiStr(),thoiGianThanhToan!=null?thoiGianThanhToan.toString():"Tr???ng",ngayTaoPhieu.toString());
        return format;
    }

    @Override
    public int compareTo(HoaDon o2, int type) {
        if (type == 1){
            if (maHoaDonStr.compareToIgnoreCase(o2.maHoaDonStr)>0)
                return 1;
            return -1;
        }
        if (type == 2){
            if (maKH.getMaKHStr().compareToIgnoreCase(o2.getMaKH().getMaKHStr())>0)
                return 1;
            return -1;
        }
        if (type == 3){
            if (maPhong.getMaPhong().compareToIgnoreCase(o2.getMaPhong().getMaPhong())>0)
                return 1;
            return -1;
        }
        if (type == 4){
            if (getTrangThaiStr().compareToIgnoreCase(o2.getTrangThaiStr())>0)
                return 1;
            return -1;
        }
        return 0;
    }
}
