import dataaccess.Address;
import dataaccess.Admin;
import dataaccess.LibraryMember;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Storage;

import java.util.ArrayList;


import static org.junit.Assert.*;
/**
 * Created by Mekuanent Kassaye on 2019-03-06.
 */
public class AdminRoleTest {

    Admin admin = new Admin();
    private int libraryMemberId = 80002;

    @Before
    public void setUp() throws Exception {
        Storage.init();
    }

    @After
    public void tearDown() throws Exception {
        Storage.persistData();
    }

    @Test
    public void AddLibraryMemberTest() {
        int currentId = Storage.getNextLibraryMemberId();
        admin.addLibraryMembers(new LibraryMember(
                "Mekuanent", "Getachew", "+1 (641) 123-4567",
                new Address("1000 N. 4th St.", "Fairfield", "Iowa", "52557")
        ));

        ArrayList<LibraryMember> members = new ArrayList<>(Storage.libraryMembers.values());
        if(members.size() > 0){
            LibraryMember member = members.get(members.size() - 1);
            System.out.println(member.getId());
            assertEquals(currentId+1, member.getId());
        }else{
            fail();
        }

    }

    @Test
    public void EditLibraryMemberTest() {

    }

}
