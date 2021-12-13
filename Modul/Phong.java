package Modul;

import Modul.Error.InvalidNumberException;
import Modul.Error.InvalidStringException;
import Modul.SupportModul.Check;

import java.io.Serializable;
import java.util.InputMismatchException;

public class Phong implements ConsoleIO, Serializable {
    protected String maPhong;
    protected int maLau;
    protected int soGiuong;
    protected int soNguoiToiDa;
    protected boolean tinhTrang;
    protected int loaiPhong;
    public Phong(){
    }

    public Phong(String maPhong,int maLau,int soGiuong,int soNguoiToiDa, boolean tinhTrang){
        this.maPhong=maPhong;
        this.soGiuong=soGiuong;
        this.soNguoiToiDa=soNguoiToiDa;
        this.maLau= maLau;
        this.tinhTrang=tinhTrang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public int getMaLau() {
        return maLau;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public int getLoaiPhong() {
        return loaiPhong;
    }

    public void setMaPhong(String maPhong) throws InvalidStringException {
        if (Check.containsSpace(maPhong)){
            throw new InvalidStringException("Mã phòng không tồn tại khoảng trắng");
        }
        if (maPhong.length()<3){
            throw new InvalidStringException("Mã phòng phải có từ 3 kí tự trở lên");
        }
        this.maPhong = maPhong;
    }

    public void setMaLau(int maLau) throws InvalidNumberException {
        if (maLau<0) throw new InvalidNumberException("Mã lầu không được âm");
        this.maLau = maLau;
    }

    public void setSoGiuong(int soGiuong) throws InvalidNumberException {
        if (soGiuong<=0) throw new InvalidNumberException("Sô giường không được âm hoặc bằng 0");
        this.soGiuong = soGiuong;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) throws InvalidNumberException {
        if (soNguoiToiDa<=0) throw new InvalidNumberException("Sô người không được âm hoặc bằng 0");
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setLoaiPhong(int loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    @Override
    public void nhapThongTin(){
//        System.out.println("-----Nhập thông tin phòng -----");
//        System.out.print("- Mã phòng: "); maPhong=sc.nextLine();
//        System.out.print("- Mã lầu: ");maLau=sc.nextInt();
//        System.out.print("- Số giường: "); soGiuong=sc.nextInt();
//        System.out.print("- Số người tối đa: "); soNguoiToiDa=sc.nextInt();
//        System.out.print("- Tình trạng [trống/full]: "); String tt=sc.nextLine();tt=sc.nextLine();
//        tinhTrang = !("trong".equals(tt)||"Trong".equals(tt)||"Trống".equals(tt)||"trống".equals(tt));
//        System.out.print("- Giá tiền: "); giaTien=sc.nextBigDecimal();
//        System.out.println("--------------------------------");
        System.out.println(Text.center("NHẬP THÔNG TIN PHÒNG",40,'-'));
        int step = 1;
        do{
            try{
                if (step == 1){
                    System.out.print("> Nhập mã phòng: ");
                    setMaPhong(sc.nextLine());
                }
                if (step == 2){
                    System.out.print("> Nhập mã lầu: ");
                    setMaLau(sc.nextInt());
                }
                if (step == 3){
                    System.out.print("> Nhập số giường: ");
                    setSoGiuong(sc.nextInt());
                }
                if (step == 4){
                    System.out.print("> Nhập số người tối đa: ");
                    setSoNguoiToiDa(sc.nextInt());
                }
                step++;
            }
            catch (InputMismatchException e){
                System.out.println("Vui lòng nhập số nguyên dương!");
                sc.nextLine();
            }
            catch (InvalidNumberException e){
                System.out.println(e.toString());
                sc.nextLine();
            } catch (InvalidStringException e) {
                System.out.println(e.toString());
            }
        } while (step<5);


    }
    @Override
    public void xuatThongTin(){
        System.out.printf("|%-10s|%-10s|%-10s|%-15s|%-10s|%-10s|%-20s|\n",maPhong,maLau,soGiuong,soNguoiToiDa, tinhTrang ?"Đầy":"Trống",
                loaiPhong==1?"VIP":"Thường",loaiPhong == 1?BangGia.getGiaPhongThuongGio():BangGia.getGiaPhongVipGio());
    }

    public void suaThongTin(){
        System.out.println(Text.center("THAY ĐỔI THÔNG TIN PHÒNG",40,'-'));
        int step = 1;
        do{
            try{
                if (step == 1){
                    System.out.print("> Nhập mã lầu: ");
                    setMaLau(sc.nextInt());
                }
                if (step == 2){
                    System.out.print("> Nhập số giường: ");
                    setSoGiuong(sc.nextInt());
                }
                if (step == 3){
                    System.out.print("> Nhập số người tối đa: ");
                    setSoNguoiToiDa(sc.nextInt());
                }
                step++;
            }
            catch (InputMismatchException e){
                System.out.println("Vui lòng nhập số nguyên dương!");
                sc.nextLine();
            }
            catch (InvalidNumberException e){
                System.out.println(e.toString());
                sc.nextLine();
            }
        } while (step<4);
    }

    public void thayDoiTinhTrang(){
        System.out.println(Text.center("THAY ĐỔI THÔNG TIN PHÒNG",40,'-'));
        System.out.println(" 1. Trống");
        System.out.println(" 2. Đang sử dụng");
        System.out.print("> Lựa chọn của bạn: ");
        try{
            int choice = sc.nextInt();
            if (choice<1 || choice >2) throw new InvalidNumberException("Lựa chọn không hợp lệ!");
            if (choice == 1) setTinhTrang(false);
            else setTinhTrang(true);
        } catch (InvalidNumberException e) {
            System.out.println(e.toString());
        } catch (InputMismatchException e){
            System.out.println("<!> Vui lòng nhập số nguyên dương");
        } finally {
            sc.nextLine();
        }
    }
}