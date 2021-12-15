package Modul;

import Controller.Program;
import Modul.Error.InvalidNumberException;
import Modul.SupportModul.DateTime;
import Modul.SupportModul.DiaChi;

import java.io.Serializable;

public class KhachHang extends ConNguoi implements ConsoleIO, MyCompare<KhachHang>, Serializable{
    private static int id= Program.getDSKH().getLargestId();
    private int maKH;
    private String maKHStr;
    private DateTime ngayThamGia = new DateTime();

    public KhachHang(){
        super();
        maKH = ++id;
        maKHStr = getMaKHStr();
        ngayThamGia.setCurrentTime();
    }

    public KhachHang(String name, String soDienThoai, String cmnd, DiaChi diaChi, DateTime ngaySinh) {
        super(name, soDienThoai, cmnd, diaChi, ngaySinh);
        maKH = ++id;
        maKHStr = getMaKHStr();
        ngayThamGia.setCurrentTime();
    }

    public int getMaKH() {
        return maKH;
    }

    public String getMaKHStr() {
        //VD : KH0004
        String result = "KH";
        if (maKH<1000){
            if (maKH>=100){
                result+="0";
            }
            else if (maKH >= 10){
                result += "00";
            }
            else {
                result += "000";
            }
        }
        return result+maKH;
    }

//    Prevent change maKH
//    public void setMaKH(int maKH) {
//        if (maKH>0)
//            this.maKH = maKH;
//    }

    public DateTime getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(DateTime ngayThamGia) {
        if (ngayThamGia.compareDateTime(DateTime.getTimeNow())>=0)
            this.ngayThamGia = ngayThamGia;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
    }

    @Override
    public void xuatThongTin(){
        System.out.println(Text.center("THÔNG TIN KHÁCH HÀNG",80,'-'));
        System.out.println(" - Mã khách hàng: "+maKHStr);
        System.out.println(" - Ngày tham gia: "+ngayThamGia.toStringNgay());
        super.xuatThongTin();
    }

    @Override
    public String toString(){
        String format = String.format("|%10s|%20s|%15s|%15s|%15s|%15s|%30s|",maKHStr,name,ngaySinh.toStringNgay(),cmnd,soDienThoai,ngayThamGia.toStringNgay(),diaChi);
        return format;
    }

    @Override
    public int compareTo(KhachHang o2, int type) {
        //So sánh mã khách hàng
        if (type == 0){
            if (this.maKH > o2.maKH)
                return 1;
            return -1;
        }
        //So sánh tên
        if (type == 1){
            if (this.name.compareToIgnoreCase(o2.name)>0)
                return 1;
            return -1;
        }
        //So sánh cmnd
        if (type == 2){
            if (this.cmnd.compareToIgnoreCase(o2.cmnd)>0)
                return 1;
            return -1;
        }

        //So sánh số điện thoại
        if (type == 3 ){
            if (this.soDienThoai.compareToIgnoreCase(o2.soDienThoai)>0)
                return 1;
            return -1;
        }
        //So sánh số ngay sinh
        if (type == 4){
            if (this.ngaySinh.compareDateTime(o2.ngaySinh)>0)
                return 1;
            return -1;
        }
        //So sánh số ngày tạo tài khoản
        if (type == 5){
            if (this.ngayThamGia.compareDateTime(o2.ngayThamGia)>0)
                return 1;
            return -1;
        }
        return 0;
    }
}
