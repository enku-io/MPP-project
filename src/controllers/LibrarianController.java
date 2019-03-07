package controllers;

import dataaccess.view.BookView;
import dataaccess.view.MemberCheckoutRecordView;
import dataaccess.view.OverdueView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.DataConversion;
import util.Storage;

import javax.xml.crypto.Data;
import java.io.IOException;

public class LibrarianController {
    @FXML
    private TableView tableView;
    @FXML
    private Button checkoutButton;
    @FXML
    TableColumn isbnColumn;
    @FXML
    TableColumn titleColumn;
    @FXML
    TableColumn authorColumn;
    @FXML
    TableColumn isAvailableColumn;
    @FXML
    TableColumn copiesColumn;
    @FXML
    Button logoutButton;

    @FXML
    TextField memberIdField;
    @FXML
    Button searchMemberButton;
    @FXML
    Label errorFieldForMember;

    @FXML
    TableView memberCheckoutRecordTableView;
    @FXML
    TableColumn bookCopyID;
    @FXML
    TableColumn libraryMemberID;
    @FXML
    TableColumn ISBNColumn;
    @FXML
    TableColumn BookTitleColumn;
    @FXML
    TableColumn FullNameColumn;
    @FXML
    TableColumn CheckoutDateColumn;
    @FXML
    TableColumn DueDateColumn;
    @FXML
    Button printButton;

    @FXML
    TableView overDueTable;
    @FXML
    TextField overDueText;
    @FXML
    Button overDueSeachButton;
    @FXML
    TableColumn oIDColumn;
    @FXML
    TableColumn oMemberIDColumn;
    @FXML
    TableColumn oMemberFullNameColumn;
    @FXML
    TableColumn oDueDateColumn;
    @FXML
    TableColumn oCheckoutDateColumn;
    @FXML
    Label BookTitleLabel;

    ObservableList<MemberCheckoutRecordView> memberCheckoutRecordViews;



    @FXML
    public void initialize(){
        isbnColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("author"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isAvailable"));
        copiesColumn.setCellValueFactory(new PropertyValueFactory<BookView,Number>("copies"));
        tableView.setItems(DataConversion.getBookListView(Storage.session));

        bookCopyID.setCellValueFactory(new PropertyValueFactory<MemberCheckoutRecordView,String>("bookCopyId"));
        libraryMemberID.setCellValueFactory(new PropertyValueFactory<MemberCheckoutRecordView,String>("libraryMemberId"));
        ISBNColumn.setCellValueFactory(new PropertyValueFactory<MemberCheckoutRecordView,String>("isbn"));
        BookTitleColumn.setCellValueFactory(new PropertyValueFactory<MemberCheckoutRecordView,String>("bookTitle"));
        FullNameColumn.setCellValueFactory(new PropertyValueFactory<MemberCheckoutRecordView,String>("fullName"));
        CheckoutDateColumn.setCellValueFactory(new PropertyValueFactory<MemberCheckoutRecordView,String>("checkoutDate"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<MemberCheckoutRecordView,String>("dueDate"));

        oIDColumn.setCellValueFactory(new PropertyValueFactory<OverdueView.BookCopyView,String>("id"));
        oMemberIDColumn.setCellValueFactory(new PropertyValueFactory<OverdueView.BookCopyView,String>("memberId"));
        oMemberFullNameColumn.setCellValueFactory(new PropertyValueFactory<OverdueView.BookCopyView,String>("memberFullName"));
        oDueDateColumn.setCellValueFactory(new PropertyValueFactory<OverdueView.BookCopyView,String>("due"));
        oCheckoutDateColumn.setCellValueFactory(new PropertyValueFactory<OverdueView.BookCopyView,String>("checkoutDate"));


    }

    @FXML
    private void checkoutEvent(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/checkout_books.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Checkout Book");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleLogout(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/login.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Book");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void viewMemberCheckoutRecord(ActionEvent event){
        try{
            if(!memberIdField.getText().isEmpty()){
                memberCheckoutRecordViews =  Storage.session.getPersonRole().getRecordByMemberId(Integer.parseInt(memberIdField.getText()));
                memberCheckoutRecordTableView.setItems(memberCheckoutRecordViews);
            }else{
                errorFieldForMember.setText("Please Enter Member ID");
            }
        }catch(NumberFormatException ex){
            errorFieldForMember.setText("Only Numbers Allowed");
        }

    }
    @FXML
    private void viewOverDUeCheckoutRecord(ActionEvent event){
        try{
            if(!overDueText.getText().isEmpty()){
                OverdueView overdueView = Storage.session.getPersonRole().getOverdueRecord(Integer.parseInt(overDueText.getText()));
                BookTitleLabel.setText("Title: " + overdueView.getTitle() + " ISBN : " + overdueView.getIsbn());
                overDueTable.setItems(overdueView.getBookCopyViews());
            }
        }catch(NumberFormatException ex){

        }

    }
    @FXML
    private void printMethod(ActionEvent event){
        if(memberCheckoutRecordViews != null){
            Storage.session.getPersonRole().printCheckoutRecords(memberCheckoutRecordViews);
        }else{
            errorFieldForMember.setText("Please Enter Member ID");
        }
    }

}
