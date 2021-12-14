package DanhSach;

import Modul.*;
import Modul.Error.InvalidNumberException;
import Modul.Error.NotExsitException;
import Modul.SupportModul.DocGhiFile;

import java.util.InputMismatchException;

public class DanhSachPhong implements ChucNangDS, ConsoleIO {
    private MyArray<Phong> dsp = new MyArray<Phong>();

    public DanhSachPhong(){
    }

    public MyArray<Phong> getDspArr() {
        return dsp;
    }

    public void setDspArr(MyArray<Phong> dsp) {
        this.dsp = dsp;
    }

    @Override
    public void timKiem() {

    }

    public void hienThiPhongTrong(){
        System.out.println();
        System.out.println(Text.center("DANH SÁCH PHÒNG TRỐNG",90,' '));
        if (dsp.getLength()>0){
            System.out.println(DanhSachPhong.title());
            boolean isHasRoom = false;
            for (int i=0;i<dsp.getLength();i++){
                if (!dsp.getAt(i).getTinhTrang()){
                    System.out.println(dsp.getAt(i).toString());
                    isHasRoom = true;
                }
            }
            if (!isHasRoom){
                System.out.println(Text.center("<!> Khồng còn phòng trống !",90,' '));
            }
        }
        else {
            System.out.println("<!> Khách sạn chưa có phòng nào! Vui lòng liện hệ quản lý");
        }

    }

    public Phong layDuLieuPhong(String maPhong) throws NotExsitException {
        for (int i=0;i<dsp.getLength();i++){
            Phong kh = dsp.getAt(i);
            if (maPhong.equalsIgnoreCase(kh.getMaPhong())){
                return kh;
            }
        }
        throw new NotExsitException("mã phòng "+maPhong);
    }

    @Override
    public void them() {
        while (true){
            System.out.println();
            System.out.println(Text.center("THÊM PHÒNG",40,'-'));
            System.out.println("|"+Text.leftAt(10,Text.setLength("1. Thêm phòng thường",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("2. Thêm phòng vip",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("3. Trở về danh sách",27),' ')+"|");
            System.out.println(Text.center("",40,'-'));
            System.out.print("> Nhập lựa chọn: ");
            int choice = 0;
            try{
                choice = sc.nextInt();
                if (choice <1 || choice>3) throw new InvalidNumberException("Lựa chọn phải từ 1-3");
            }catch (InputMismatchException e){
                System.out.println("<!> Vui lòng nhập số");
            } catch (InvalidNumberException e){
                System.out.println(e);
            } finally {
                sc.nextLine();
            }
            if (choice == 1){
                Phong pt = new Phong();
                pt.nhapThongTin();
                dsp.push(pt);
            }
            if (choice == 2 ){
                Phong pv = new PhongVip();
                pv.nhapThongTin();
                dsp.push(pv);
            }
            if (choice == 3){
                break;
            }
        }
    }

    public void themPhong(Phong phong){
        dsp.push(phong);
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
        switch (choice){
            case 1: them();
                break;
            case 2: timKiem();
                break;
            case 3: sua();
                break;
            case 4: xoa();
                break;
            case 5: sapXep();
                break;
            case 6: xuatThongTin();
                break;
        }
    }

    @Override
    public void sapXepTangDan(int type) {

    }

    @Override
    public void sapXepGiamDan(int type) {

    }

    @Override
    public void writeToFile() {
        String name = "./Data/Phong.txt";
        DocGhiFile<Phong> ghi = new DocGhiFile<Phong>(dsp);
        ghi.ghiFileVaoThuMuc(name);
    }

    @Override
    public void readFromFile() {
        String name = "./Data/Phong.txt";
        DocGhiFile<Phong> doc = new DocGhiFile<Phong>();
        dsp = doc.docFileTuThuMuc(name);
    }

    @Override
    public void nhapThongTin() {
        readFromFile();
        while (true){
            System.out.println();
            System.out.println(Text.center("DANH SÁCH PHÒNG",40,'-'));
            System.out.println("|"+Text.leftAt(10,Text.setLength("1. Thêm phòng",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("2. Tìm phòng",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("3. Sửa phòng",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("4. Xóa phòng",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("5. Sắp xếp danh sách",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("6. Xem danh sách",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("7. Lưu và thoát",27),' ')+"|");
            System.out.println(Text.center("",40,'-'));
            System.out.print("> Nhập lựa chọn: ");
            int value =0;
            try{
                value = sc.nextInt();
                if (value <1 || value>7) throw new InvalidNumberException("Vui lòng chọn số từ 1-7");
            } catch (InputMismatchException e){
                System.out.println("<!> Lỗi: Vui lòng nhập số !");
            } catch (InvalidNumberException e) {
                System.out.println(e.toString());
            }
            finally {
                sc.nextLine();
            }
            if (value == 7) {
                writeToFile();
                break;
            }
            xuLy(value);
        }
    }

    @Override
    public void xuatThongTin() {
        System.out.println(DanhSachPhong.title());
        for (int i=0;i<dsp.getLength();i++){
            System.out.println(dsp.getAt(i));
        }
    }

    public static String title(){
        String header = Text.center("",97,'-');
        String format = String.format("|%15s|%15s|%15s|%15s|%15s|%15s|","Mã Phòng","Loại Phòng","Mã Lầu","Số Giường","Số người","Tình trạng");
        String footer = Text.center("",97,'-');
        return header+"\n"+format+"\n"+footer;
    }

    public MyArray<Phong> modulTimKiem(String str){
        str = str.toLowerCase();
        //Tạo mảng tạm để lưu dữ liệu
        MyArray<Phong> result = new MyArray<Phong>();
        for(int i=0;i<dsp.getLength();i++){
            Phong pg = dsp.getAt(i);
            if (pg.getMaPhong().toLowerCase().contains(str) || Integer.toString(pg.getMaLau()).contains(str) ||
                    Integer.toString(pg.getSoGiuong()).contains(str) || Integer.toString(pg.getSoNguoiToiDa()).contains(str)
                    || pg.getTypeStr().contains(str)) {
                result.push(pg);
            }
        }
        if (result.getLength() == 0 ) return null;
        return result;
    }
}
