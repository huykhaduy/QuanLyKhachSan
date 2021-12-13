package DanhSach;

import Modul.ConsoleIO;
import Modul.Error.InvalidNumberException;
import Modul.Text;

import java.util.InputMismatchException;

public class DanhSachPhong implements ChucNangDS, ConsoleIO {

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

    }
}
