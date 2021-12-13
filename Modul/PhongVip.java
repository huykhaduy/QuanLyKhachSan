
package Modul;

import DanhSach.DanhSachDichVu;
import DanhSach.DanhSachUuDaiVip;
import DanhSach.MyArray;

public class PhongVip extends Phong {
    private DanhSachUuDaiVip uuDaiVip;

    public PhongVip(){
        super();
        loaiPhong = 1;
    }
    public PhongVip(String maphong, int malau, int sogiuong, int songuoitoida, boolean tinhtrang){
        super(maphong,malau,sogiuong,songuoitoida,tinhtrang);
        loaiPhong = 1;
    }

    public DanhSachUuDaiVip getUuDaiVip() {
        return uuDaiVip;
    }

    public void setUuDaiVipClone(DanhSachUuDaiVip uuDaiVip) {
        try {
            this.uuDaiVip = uuDaiVip.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Copy giá trị thất bại!");
        }
    }

    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        uuDaiVip.xuatThongTin();
    }


}