package Modul;

import java.math.BigDecimal;

import Modul.SupportModul.DateTime;

public class PhieuThue extends Phieu implements ConsoleIO {
    private static int id = 0;
    private int maPhieuThue;
    private DateTime startDate = new DateTime();
    private DateTime endDate = new DateTime();
    private BigDecimal giaTien = new BigDecimal("0");

    public PhieuThue() {
        super();
        maPhieuThue = ++id;
    }

    public PhieuThue(KhachHang maKH, Phong maPhong) {
        super();
        maPhieuThue = ++id;
        this.maKH = maKH;
        this.maPhong = maPhong;
    }

    public DateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getGiaTien() {
        //Calculate gia tien by giaphong multiple endDate - startDate
        return this.giaTien;
    }

    public void updateGiaTien(BigDecimal giaTien) {
        //Tinh toan gia tien !
        this.giaTien = giaTien;
    }

    public void traPhong() {
        //set trang thai phong ve trong
        endDate.nhapNgayGio("NHẬP NGÀY GIỜ TRẢ PHÒNG");
        while (endDate.compareDateTime(startDate) < 0) {
            // endDate.setCurrentTime();
            System.out.println("Ngày trả phòng nhỏ hơn ngày đặt phòng! Vui lòng nhập lại");
            endDate.nhapNgayGio("NHẬP NGÀY GIỜ TRẢ PHÒNG");
        }
            
        int[] counter = endDate.getDayTimeFrom(startDate);
        System.out.println(" -> Thue " + counter[0] + " ngay " + counter[1] + " gio " + counter[2]);
        
    }

    @Override
    public void nhapThongTin() {
//        System.out.print("> Nhập mã phòng: ");
//        setMaPhong(sc.nextInt());
        startDate.nhapNgayGio("NHẬP NGÀY GIỜ ĐẶT PHÒNG");
        while (startDate.compareDateTime(DateTime.getTimeNow()) > 0) {
//            startDate.setCurrentTime();
            System.out.println(" <!> Ngày đặt phòng không thể lón hơn thời gian hiện tại! Vui lòng nhập lại");
//            System.out.println(" -> Tự động lấy ngày đặt là hiện tại: " + startDate);
            startDate.nhapNgayGio("NHẬP NGÀY GIỜ ĐẶT PHÒNG");
        }  
    }

    @Override
    public void xuatThongTin(){
        System.out.println("\n-------------------------PHIẾU THUÊ--------------------------");
        System.out.println(" - Mã phiếu thuê: " + maPhieuThue+"\t Ngày lập phiếu thuê: "+ngayTaoPhieu);
        System.out.println("Mã KH: "+ maKH+"\t Mã phòng: "+maPhong);
        System.out.println("Ngày thuê: "+startDate);
        System.out.println("Ngày trả: "+endDate);
        System.out.println(" =>Tổng tiền: " + giaTien);
    }

//    @Override
//    public void xuatThongTin() {
////        System.out.print("\033[44m");
//        System.out.println("-----------------------------------------------------------------------------------------------------------");
//        System.out.printf("|%-15s|%-15s|%-15s|%-20s|%-20s|%-15s|","MaKH","Ma Phieu Thue","Ma Phong","Ngay thue","Ngay ket thuc","Gia tien");
////        System.out.print("\033[0m");
//        System.out.println();
////        System.out.print("\033[44m");
//        System.out.println("-----------------------------------------------------------------------------------------------------------");
////        System.out.print("\033[0m\n");
//        System.out.printf("|%15s|%15s|%15s|%20s|%20s|%15s|\n",maKH,maPhieuThue,maPhong,startDate,endDate,giaTien);
//    }
    
    
    
}
