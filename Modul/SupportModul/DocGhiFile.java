package Modul.SupportModul;

import DanhSach.MyArray;
import java.io.*;


public class DocGhiFile<U extends Serializable> {
    private MyArray<U> list;

    public DocGhiFile() {
    }

    public DocGhiFile(MyArray<U> value){
        list = value;
    }

    public void ghiFileVaoThuMuc(String name){
        try{
            FileOutputStream filein = new FileOutputStream(name);
            System.out.println("Here");
            ObjectOutputStream fileobj = new ObjectOutputStream(filein);
            System.out.println("Here");
            fileobj.writeObject(list);
            fileobj.close();
        } catch (IOException e) {
            System.out.println("<!> Lỗi ghi vào file "+name);
            if (e instanceof NotSerializableException ){
                System.out.println("<!> Not seriable "+name);
            }
            if (e instanceof InvalidClassException){
                System.out.println("<!> Invalid class "+name);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public MyArray<U> docFileTuThuMuc(String name){
        MyArray<U> result = new MyArray<>();
        try{
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream fileobj = new ObjectInputStream(fis);
            result = (MyArray<U>) fileobj.readObject();
            fileobj.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi đọc dữ liệu từ file "+name);
            return null;
        }
        return result;
    }

}
