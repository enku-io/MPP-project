package dataaccess;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class CheckoutRecordEntry implements Serializable {

    private BookCopy bookCopy;
    private Date checkoutDate, dueDate;


    public CheckoutRecordEntry(BookCopy bookCopy, Date checkoutDate, Date dueDate){
        this.bookCopy = bookCopy;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    /**
     * @return the bookCopy
     */
    public BookCopy getBookCopy() {
        return bookCopy;
    }

    /**
     * @param bookCopy the bookCopy to set
     */
    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    /**
     * @return the checkoutDate
     */
    public Date getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * @param checkoutDate the checkoutDate to set
     */
    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    

}