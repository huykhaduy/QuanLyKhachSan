package Modul;

import Modul.SupportModul.DateTime;
import Modul.SupportModul.DiaChi;

import java.io.Serializable;

public abstract class NhanVien extends ConNguoi implements MyCompare<NhanVien>, Serializable{
    private static int id = 0;
    private int maNV;
    private String maNVStr;
    private DateTime ngayThamGia = new DateTime();

    public NhanVien() {
        super();
        maNV = ++id;
        maNVStr = getMaNVStr();
        ngayThamGia.setCurrentTime();
    }

    public NhanVien(String name, String soDienThoai, String cmnd, DiaChi diaChi, DateTime ngaySinh) {
        super(name, soDienThoai, cmnd, diaChi, ngaySinh);
        maNV = ++id;
        maNVStr = getMaNVStr();
        ngayThamGia.setCurrentTime();
    }

    public int getMaNV() {
        return maNV;
    }

    public String getMaNVStr() {
        //VD : NV0004
        String result = "NV";
        if (maNV<1000){
            if (maNV>=100){
                result+="0";
            }
            else if (maNV >= 10){
                result += "00";
            }
            else {
                result += "000";
            }
        }
        return result+maNV;
    }

    public void setMaNV(int maNV) {
        if (maNV>0)
            this.maNV = maNV;
    }

    public DateTime getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(DateTime ngayThamGia) {
        if (ngayThamGia.compareDateTime(DateTime.getTimeNow())<=0)
            this.ngayThamGia = ngayThamGia;
    }

    public void nhapThongTin(){
        super.nhapThongTin();
    }

    public void xuatThongTin(){
        System.out.println(Text.center("THÔNG TIN NHÂN VIÊN",40,'-'));
        System.out.println(" - Mã nhân viên: "+getMaNVStr());
        System.out.println(" - Chức vụ: "+ getChucVuStr());
        super.xuatThongTin();
        System.out.println(" - Ngày tham gia: "+ngayThamGia.toStringNgay());
    }

//    public void suaThongTin(){
//        //Sửa thuộc tính chung cho nhân viên
//        int step = 1;
//        String temp;
//        do {
//            try{
//                if (step == 1){
//                    System.out.print("> Nhập họ tên NV: ");
//                    temp = sc.nextLine();
//                    if (temp.equals("")){
//                        step++;
//                        continue;
//                    }
//                    setName(temp);
//                }
//
//                if (step == 2){
//                    System.out.print("> Nhập CCCD/CMND: ");
//                    temp = sc.nextLine();
//                    if (temp.equals("")){
//                        step++;
//                        continue;
//                    }
//                    setCmnd(temp);
//                }
//
//                if (step == 3){
//                    System.out.print("> Nhập số điện thoại: ");
//                    temp = sc.nextLine();
//                    if (temp.equals("")){
//                        step++;
//                        continue;
//                    }
//                    setSoDienThoai(temp);
//                }
//
//                if (step == 4){
//                    DateTime dt = new DateTime();
//                    dt.nhapNgaySinh();
//                    if (dt.compareDateTime(DateTime.getTimeNow())>=0){
//                        step++;
//                        continue;
//                    }
//                    setNgaySinh(dt);
//                }
//
//                if (step ==5){
//                    DiaChi dc = new DiaChi();
//                    dc.NhapDiaChi();
//                    if (dc.toString().equals("")){
//                        step++;
//                        continue;
//                    }
//                    setDiaChi(dc);
//                }
//
//                step++;
//            } catch (Exception e) {
//                System.out.println(e.toString());
//            }
//
//        } while (step<6);
//    }

    public abstract void lamViec();
    public abstract int getChucVu();
    public String getChucVuStr(){
        String[] chucVu = {"Lễ tân","Quản lý","Admin"};
        int index = (int) Math.log10(getChucVu());
        return chucVu[index];
    }

    public abstract void suaThuocTinhCuaChucVu();

    @Override
    public String toString(){
        String format = String.format("|%10s|%20s|%15s|%15s|%15s|%15s|%15s|%30s|",maNVStr,name,getChucVuStr(),ngaySinh.toStringNgay(),cmnd,soDienThoai,ngayThamGia.toStringNgay(),diaChi);
        return format;
    }

    public int compareTo(NhanVien o2, int type) {
        //So sánh mã nhân viên
        if (type == 0){
            if (this.getMaNV() > o2.getMaNV())
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
            if (this.ngaySinh.compareDateTime(o2.ngayThamGia)>0)
                return 1;
            return -1;
        }
        //So sánh số ngày tạo tài khoản
       if (type == 5){
            if (this.ngayThamGia.compareDateTime(o2.ngayThamGia)>0)
                return 1;
            return -1;
       }
       if (type == 6){
           if (this.getChucVu() > o2.getChucVu()){
               return 1;
           }
           return -1;
       }
        return 0;
    }
}
