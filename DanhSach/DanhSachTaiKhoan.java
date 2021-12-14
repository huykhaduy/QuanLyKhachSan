package DanhSach;

import java.util.ArrayList;
import java.util.Scanner;

import Modul.Phong;
import Modul.SupportModul.DocGhiFile;
import Modul.TaiKhoan;

public class DanhSachTaiKhoan implements ChucNangDS{
		public MyArray<TaiKhoan> dstk = new MyArray<>();
		
		public DanhSachTaiKhoan() {
			dstk = new MyArray<>();
//			TaiKhoan tkmd = new TaiKhoan("duy","123","admin");
//			dstk.add(tkmd);
//			TaiKhoan tkmd1 = new TaiKhoan("DUY","1234","letan");
//			dstk.add(tkmd1);
		}	
		public DanhSachTaiKhoan(MyArray<TaiKhoan> dstk) {
			this.dstk = dstk;
		}

	public TaiKhoan layDuLieuTk(String username){
		for (int i=0;i<dstk.getLength();i++){
			TaiKhoan tk = dstk.getAt(i);
			if (tk.getTenDangNhap().equalsIgnoreCase(username))
				return tk;
		}
		return null;
	}

	public void themTaiKhoan(String username,String password){
		dstk.push(new TaiKhoan(username,password));
	}

	public void themTaiKhoan(String username,String password, String maNV){
		dstk.push(new TaiKhoan(username,password,maNV));
	}

//		public static void themTaiKhoan() {
//			Scanner sc = new Scanner(System.in);
//			System.out.print("Tên đăng nhập ");
//			String tenDangNhap = sc.nextLine();
//			System.out.print("Mật khẩu: ");
//			String matKhau = sc.nextLine();
//			System.out.println("chọn vai trò (1)admin (2)quản lý (3)lễ tân ");
//			String chon = sc.nextLine();
//			String vaiTro = null;
//			switch (chon){
//			case "1":
//				vaiTro = "admin";
//				break;
//			case "2":
//				vaiTro = "quanly";
//				break;
//			case "3":
//				vaiTro = "letan";
//				break;
//			}
//			TaiKhoan tk = new TaiKhoan(tenDangNhap,matKhau,vaiTro);
//			dstk.add(tk);
//		}
		public void suaTaiKhoan(){
			
		}
		public void xoaTaiKhoan() {
			
		}



//		public void showDSTk() {
//			System.out.format("%-30s%-30s\n","-----------------------------Danh Sách tài khoản","-----------------------------");
//			System.out.format("%s%-19s%s%-30s%s%-30s%s\n","|","ID","|","Tên ĐN","|","Mật Khẩu","|");
//			for(TaiKhoan tk : dstk) {
//				tk.show();
//			}
//		}
//		//kiểm tra tài khoản
//		public boolean checkLogin(String ten, String mk, int d) {
//			for(int i=0; i<dstk.size(); i++) {
//				if(ten.equals(dstk.get(i).getTenDangNhap()) && mk.equals(dstk.get(i).getMatKhau())) {
//					d = i;
//					return true;
//				}
//			}
//			return false;
//		}
//		// tìm tài khoản theo mã nhân viên
//		public int timTheoMaNV(String maNV) {
//			int d=-1;
////			for(int i=0; i< dsNV.size() ;i++) {
////				if(maNV == dsNV.get(i).getMaNV() ) {
////					d = i;
////				}
////			}
//			return d;
//		}
//		public int timTheoTen(String ten) {
//			int d=-1;
////			for(int i=0; i< dsNV.size() ;i++) {
////				if(ten == dsNV.get(i).getTen() ) {
////					d = i;
////				}
////			}
//			return d;
//		}
//		public void logIn() {
//			boolean login = false;
//			int tkLogin = -1;
//			do {
//				Scanner sc = new Scanner(System.in);
//				System.out.format("%-20s%-50s\n","","|---------------Đăng nhập---------------|");
//				System.out.format("%-20s","");
//				System.out.print("Tên đăng nhập :");
//				String ttk = sc.nextLine();
//				System.out.format("%-20s","");
//				System.out.print("Mật khẩu      :");
//				String mk = sc.nextLine();
//				if(this.checkLogin(ttk, mk, tkLogin)) {
//					login = true;
//				}else {
//					System.out.println("Tài khoản không tồn tại!");
//					System.out.print("Chọn : (1)Đăng nhập lại 		(2)Thoát ");
//					int chon =  sc.nextInt();
//					if(chon==2) {
//						break;
//					}
//				}
//			}while(login==false);
//			do {
//				dstk.get(tkLogin).menu(login);;
//			}while(login);
//		}
		@Override
		public void timKiem() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void them() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void xoa() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void sua() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void sapXep() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void xuLy(int choice) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void sapXepTangDan(int type) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void sapXepGiamDan(int type) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void writeToFile() {
			String name = "./Data/TaiKhoan.txt";
			DocGhiFile<TaiKhoan> ghi = new DocGhiFile<TaiKhoan>(dstk);
			ghi.ghiFileVaoThuMuc(name);
		}
		@Override
		public void readFromFile() {
			String name = "./Data/TaiKhoan.txt";
			DocGhiFile<TaiKhoan> doc = new DocGhiFile<TaiKhoan>();
			dstk = doc.docFileTuThuMuc(name);
			
		}

}

