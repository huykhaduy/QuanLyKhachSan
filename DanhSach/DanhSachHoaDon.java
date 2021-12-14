package DanhSach;

import Modul.ConsoleIO;
import Modul.HoaDon;

public class DanhSachHoaDon implements ChucNangDS, ConsoleIO {
    private MyArray<HoaDon> dshd = new MyArray<HoaDon>();

    public MyArray<HoaDon> getDshdArr() {
        return dshd;
    }

    public void setDshdArr(MyArray<HoaDon> dshd) {
        this.dshd = dshd;
    }

    @Override
    public void timKiem() {

    }

    @Override
    public void them() {

    }

    @Override
    public void xoa() {

    }

    @Override
    public void sua() {

    }

    @Override
    public void sapXep() {

    }

    @Override
    public void xuLy(int choice) {

    }

    @Override
    public void sapXepTangDan(int type) {

    }

    @Override
    public void sapXepGiamDan(int type) {

    }

    @Override
    public void writeToFile() {

    }

    @Override
    public void readFromFile() {

    }

    @Override
    public void nhapThongTin() {

    }

    @Override
    public void xuatThongTin() {

    }
}
