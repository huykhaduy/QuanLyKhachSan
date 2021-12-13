
package Modul;

import DanhSach.DanhSachUuDai;

public class PhongVip extends Phong {
    private DanhSachUuDai uuDaiVip;

    public PhongVip(){
        super();
        loaiPhong = 1;
    }
    public PhongVip(String maphong, int malau, int sogiuong, int songuoitoida, boolean tinhtrang){
        super(maphong,malau,sogiuong,songuoitoida,tinhtrang);
        loaiPhong = 1;
    }

    public DanhSachUuDai getUuDaiVip() {
        return uuDaiVip;
    }

    public void setUuDaiVipClone(DanhSachUuDai uuDaiVip) {
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