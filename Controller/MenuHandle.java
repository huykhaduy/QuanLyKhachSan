package Controller;

import Modul.NhanVien;
import Modul.Text;

import java.util.Scanner;

public class MenuHandle {
    static Scanner sc = new Scanner(System.in);
    public static void loginMenu(){
        String username;
        String password;
        while (true){
            System.out.println();
            System.out.println(Text.center("ĐĂNG NHẬP TÀI KHOẢN",40,'-'));
            System.out.print(" > Nhập tên tài khoản: ");
            username = sc.nextLine();
            System.out.print(" > Nhập mật khẩu: ");
            password = sc.nextLine();
            if (!LoginHandle.login(username,password)){
                System.out.println("<!> Đăng nhập thất bại "+username);
            }
            else {
                System.out.println("<!> Đăng nhập thành công "+username);
                break;
            }
        }
    }

    public static void showWorkMenu(){
        NhanVien nv = Program.getTaikhoan().getNhanVien();
        nv.lamViec();
    }

    public static void leTanMenu(){
        while (true){
            System.out.println();
            System.out.format("%-30s%-80s\n","","----------------------------MENU LỄ TÂN---------------------------");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","|PHÍM","|","CHỨC NĂNG","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 1","| Đặt phòng","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 2","| Tìm phòng","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 3","| Yêu cầu dịch vụ","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 4","| Thanh toán hóa đơn","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 5","| Thêm khách hàng","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 6","| Sửa khách hàng","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 6","| Tìm khách hàng","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 0","| Đăng xuất","","|");
            System.out.format("%-30s%-80s\n","","------------------------------------------------------------------");
            System.out.format("%-30s%s","","Nhập lựa chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice){
                case "0": LoginHandle.logOut();
                    return;
                case "1": LeTanHandle.datPhong();
                    break;
                case "2": LeTanHandle.hienThiPhongTrong();
                    break;
                default:
                    System.out.format("%-30s%s","","<!> Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }

    public static void quanLyMenu(){
        while (true){
            System.out.println();
            System.out.format("%-30s%-80s\n","","------------------------------MENU QUẢN LÝ------------------------");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","|PHÍM","|","CHỨC NĂNG","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 1","| Quản lý phòng","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 2","| Quản lý giá thuê phòng","","|");
            //Quản lý phòng gồm: quản lý thêm xóa sửa, giá phòng, tiện ích của phòng
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 3","| Quản lý dịch vụ","","|");
            //Quản lý dịch vụ gồm: quản lý thêm xóa sửa, dịch vụ
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 4","| Quản lý ưu đãi","","|");
            //Quản lý dịch vụ gồm: quản lý thêm xóa sửa, ưu đãi
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 5","| Thống kê doanh thu","","|");
            //System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 5","| Xem hóa đơn","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 0","| Đăng xuất","","|");
            System.out.format("%-30s%-80s\n","","------------------------------------------------------------------");
            System.out.format("%-30s%s","","Nhập lựa chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice){
                case "0": LoginHandle.logOut();
                    return;

                case "1":
                    QuanLyHandle.quanLyPhong();
                    break;

                default:
                    System.out.format("%-30s%s","","<!> Lựa chọn không hợp lệ!");
                    break;
            }
        }

    }

    public static void adminMenu(){
        while (true){
            System.out.println();
            System.out.format("%-30s%-80s\n","","-----------------------------MENU ADMIN--------------------------");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","|PHÍM","|","CHỨC NĂNG","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 1","| Quản lý tài khoản","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 2","| Quản lý thông tin nhân viên","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 3","| Quản lý thông tin khách hàng","","|");
            System.out.format("%-30s%-5s%-30s%-30s%s\n","","| 0","| Đăng xuất","","|");
            System.out.format("%-30s%-80s\n","","------------------------------------------------------------------");
            System.out.format("%-30s%s","","Nhập lựa chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice){
                case "0": LoginHandle.logOut();
                    return;
//                case "1": FunctionHandle.datPhong();
//                    break;

                default:
                    System.out.format("%-30s%s","","<!> Lựa chọn không hợp lệ!");
                    break;
            }
        }
    }
}
