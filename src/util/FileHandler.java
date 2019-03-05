package util;

import java.io.*;

/**
 * Created by Mekuanent Getachew on 2019-03-05.
 */
public class FileHandler {

    public static final String STORAGE_DIR = "./storage/";

    public static final String LIBRARY_MEMBER_FNAME = "LibraryMembers.ser";
    public static final String BOOKS_FNAME = "Books.ser";
    public static final String CHECKOUT_REC_FNAME = "CheckoutRecord.ser";
    public static final String DATA_CLASS_FNAME = "DataClass.ser";
    public static final String USER_FNAME = "User.ser";

    public boolean writeObject(String fileName, Object object){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try{
            fileOutputStream = new FileOutputStream(STORAGE_DIR + fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public  <E> E readObject(String fileName, E defaultObject){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(STORAGE_DIR+ fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            objectInputStream.close();

            if(obj == null)
                return defaultObject;

            return (E)obj;
        }catch (FileNotFoundException ex){
            System.out.println("File Not Found, proceeding with default data.\nResource files will be " +
                    "regenerated on next restart");
            return defaultObject;
        }
        catch (Exception e){
            e.printStackTrace();
            return defaultObject;
        }

    }

}
