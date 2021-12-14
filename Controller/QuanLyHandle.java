package Controller;

import DanhSach.DanhSachPhong;

public class QuanLyHandle {
    public static void quanLyPhong(){
        DanhSachPhong dsp = Program.getDSP();
        dsp.nhapThongTin();
    }
}
