package DanhSach;

import Modul.*;
import Modul.Error.InvalidNumberException;
import Modul.Error.NotExsitException;

import java.util.InputMismatchException;

public class DanhSachNhanVien implements ChucNangDS,Modul.ConsoleIO{
    private MyArray<NhanVien> dsnv = new MyArray<NhanVien>();

    public DanhSachNhanVien() {
    }

    public MyArray<NhanVien> getListDanhSach(){
        return dsnv;
    }

    @Override
    public void timKiem() {
        System.out.print("> Nhập thông tin khách hàng cần tìm: ");
        MyArray<NhanVien> result = modulTimKiem(sc.nextLine().toLowerCase());
        if (result != null){
//            System.out.println(DanhSachKhachHang.title());
            for (int i=0;i< result.getLength();i++){
                System.out.println(result.getAt(i));
            }
        }
        else {
            System.out.println("<!> Không tìm thấy kết quả nào!");
        }
    }

    @Override
    public void them() {
        while (true){
            System.out.println();
            System.out.println(Text.center("THÊM NHÂN VIÊN",40,'-'));
            System.out.println("|"+Text.leftAt(10,Text.setLength("1. Thêm Lễ Tân",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("2. Thêm Quản Lý",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("3. Thêm Admin",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("4. Trở về danh sách",27),' ')+"|");
            System.out.println(Text.center("",40,'-'));
            System.out.print("> Nhập lựa chọn: ");
            int choice = 0;
            try{
                choice = sc.nextInt();
                if (choice <1 || choice>4) throw new InvalidNumberException("Lựa chọn phải từ 1-4");
            }catch (InputMismatchException e){
                System.out.println("<!> Vui lòng nhập số");
            } catch (InvalidNumberException e){
                System.out.println(e);
            } finally {
                sc.nextLine();
            }
            if (choice == 1){
                NhanVien lt = new LeTan();
                lt.nhapThongTin();
                dsnv.push(lt);
            }
            if (choice == 2 ){
                NhanVien qly = new QuanLy();
                qly.nhapThongTin();
                dsnv.push(qly);
            }
            if (choice == 3){
                NhanVien admin = new Admin();
                admin.nhapThongTin();
                dsnv.push(admin);
            }
            if (choice == 4){
                break;
            }
        }
    }

    @Override
    public void xoa() {
        System.out.print("> Nhập mã nhân viên muốn xóa: ");
        NhanVien nv;
        try{
            nv = layDuLieuNV(sc.nextLine().toLowerCase());
        } catch (NotExsitException e) {
            System.out.println(e);
            return;
        }
        System.out.print("> Bạn muốn xóa NV: "+nv.getName() +" (y/n)? ");
        char isDel = 'n';
        try{
            isDel = sc.nextLine().charAt(0);
        } catch (InputMismatchException e){
            System.out.println("<!> Lựa chọn nvông hợp lệ!");
        }
        if (isDel == 'y'|| isDel =='Y'){
            dsnv.removeAt(dsnv.indexOf(nv));
            System.out.println("<!> Xóa thành công nhân viên!");
        }
    }

    @Override
    public void sua() {
        System.out.print("> Nhập mã NV muốn sửa: ");
        NhanVien nv;
        try{
            nv = layDuLieuNV(sc.nextLine().toLowerCase());
        } catch (NotExsitException e){
            System.out.println(e);
            return;
        }
        String[] chucvu = {" (chức vụ: lễ tân)"," (chức vụ: quản lý)"," (chức vụ: admin)"};
        String[] thaydoi = {" 2. Thay đổi số phòng đã đặt"," 2. Thay đổi điểm tín dụng"," 2. Thay đổi quyền thao tác"};
        int index = (int) Math.round(Math.log10(nv.getChucVu()));
        System.out.println(" Bạn đang sửa thông tin của: "+nv.getName() +chucvu[index]);
        //Xuất thông tin
        System.out.println(" 1. Thay đổi thông tin cơ bản");
        System.out.println(thaydoi[index]);
        int choice = 0;
        System.out.print(" > Nhập lựa chọn: ");
        try{
            choice = sc.nextInt();
            if (choice <1 || choice >2){
                throw new NotExsitException("lựa chọn");
            }
        } catch (InputMismatchException | NotExsitException e){
            System.out.println("<!> Lựa chọn không hợp lệ");
        } finally {
            sc.nextLine();
        }

        if (choice == 1) nv.suaThongTin();
        if (choice == 2) nv.suaThuocTinhCuaChucVu();
    }

    @Override
    public void sapXep() {

    }


    public NhanVien layDuLieuNV(String maNVStr) throws NotExsitException {
        for (int i=0;i<dsnv.getLength();i++){
            NhanVien nv = dsnv.getAt(i);
            if (maNVStr.equalsIgnoreCase(nv.getMaNVStr())){
                return nv;
            }
        }
        throw new NotExsitException("nhân viên "+maNVStr);
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
            case 5: xuatThongTin();
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

    }

    @Override
    public void readFromFile() {

    }

    @Override
    public void nhapThongTin() {
        while (true){
            System.out.println();
            System.out.println(Text.center("DANH SÁCH NHÂN VIÊN",40,'-'));
            System.out.println("|"+Text.leftAt(10,Text.setLength("1. Thêm nhân viên",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("2. Tìm nhân viên",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("3. Sửa nhân viên",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("4. Xóa nhân viên",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("5. Xem danh sách",27),' ')+"|");
            System.out.println("|"+Text.leftAt(10,Text.setLength("6. Thoát",27),' ')+"|");
            System.out.println(Text.center("",40,'-'));
            System.out.print("> Nhập lựa chọn: ");
            int value =0;
            try{
                value = sc.nextInt();
                if (value <1 || value>6) throw new InvalidNumberException("Vui lòng chọn số từ 1-6");
            } catch (InputMismatchException e){
                System.out.println("<!> Lỗi: Vui lòng nhập số !");
            } catch (InvalidNumberException e) {
                System.out.println(e);
            }
            finally {
                sc.nextLine();
            }
            if (value == 6) break;
            xuLy(value);
        }
    }

    @Override
    public void xuatThongTin() {
        System.out.println(DanhSachKhachHang.title());
        for (int i=0;i< dsnv.getLength();i++){
            System.out.println(dsnv.getAt(i).toString());
        }
    }

    public MyArray<NhanVien> getDanhSachType(int chucVuCode) throws NotExsitException {
        MyArray<NhanVien> dslt = new MyArray<NhanVien>();
        for (int i=0;i<dsnv.getLength();i++){
            if (dsnv.getAt(i).getChucVu() == chucVuCode){
                dslt.push(dsnv.getAt(i));
            }
        }
        if (dslt.getLength() == 0)
            throw new NotExsitException("danh sách");
        return dslt;
    }

    public MyArray<NhanVien> modulTimKiem(String str){
        MyArray<NhanVien> result = new MyArray<NhanVien>();
        for(int i=0;i<dsnv.getLength();i++){
            NhanVien nv = dsnv.getAt(i);
            if (nv.getMaNVStr().toLowerCase().contains(str) || nv.getNgayThamGia().toStringNgay().toLowerCase().contains(str) ||
                    nv.getNgaySinh().toStringNgay().toLowerCase().contains(str) || nv.getName().toLowerCase().contains(str)
                    || nv.getSoDienThoai().toLowerCase().contains(str) || nv.getCmnd().toLowerCase().contains(str) ||
                    nv.getDiaChi().toString().toLowerCase().contains(str)) {
                result.push(nv);
            }
        }
        if (result.getLength() == 0 ) return null;
        return result;
    }

    public static String title(){
        String header = Text.center("",128,'-');
        String format = String.format("|%10s|%20s|%15s|%15s|%15s|%15s|%30s|","MaNV","Tên NV","Ngày sinh","CCCD/CMND","SDT","Ngày tạo","Địa chỉ");
        String footer = Text.center("",128,'-');
        return header+"\n"+format+"\n"+footer;
    }
}
