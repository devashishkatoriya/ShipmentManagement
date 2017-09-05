package dev.shipmentmanagement;

/*
 * Created by Devashish Katoriya on 05-09-2017.
 */

public class DBSchema
{
    public static final class Table
    {
        public static final String TNAME = "User_Details";
        public static final class Cols
        {
            public static final String Person_NAME = "Name_of_Person";
            public static final String Phone_NO = "Phone_No";
            public static final String Username = "Username";
            public static final String Password = "Password";
            public static final String Address = "Address";
            public static final String Email = "Email";
        }
    }

    public static final class Table2
    {
        public static final String TNAME = "Shipment_Table";
        public static final class Cols
        {
            public static final String Shipment_No = "Shipment_No";
            public static final String Date = "Date";
            public static final String Shipped_By = "Shipped_By";
            public static final String Shipped_To = "Shipped_To";
            public static final String Remarks = "Remarks";
        }
    }


}
