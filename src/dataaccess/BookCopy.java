package dataaccess;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class BookCopy{

    private int id;
    private boolean available;

    public BookCopy(int id, boolean available) {
        this.id = id;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}