import java.util.*;
import java.util.Calendar;
import java.sql.*;
class Staff
{
    String sname, desg, sex;
    int salary;
    void new_staff()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        sname = sc.nextLine();
        System.out.print("Desigination: ");
        desg = sc.nextLine();
        System.out.print("Sex: ");
        sex = sc.nextLine();
        System.out.print("Salary: ");
        salary = sc.nextInt();
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement insert = conn.prepareStatement("INSERT INTO staff (sname,desg,sex,salary) VALUES (?,?,?,?)"))
        {
            insert.setString(1,sname);
            insert.setString(2,desg);
            insert.setString(3,sex);
            insert.setInt(4,salary);
            insert.executeUpdate();
            System.out.println("Staff added successfully!");
        }
        catch (SQLException e)
        {
            System.out.println(" Error adding staff: " + e.getMessage());
        }
    }
    void staff_info()
    {
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM staff"))
        {
            if (!rs.isBeforeFirst())
            {
                System.out.println(" Table is empty.");
                return;
            }
            while (rs.next())
            {
                System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname")+"\t"+rs.getString("desg")+"\t"+rs.getString("sex")+"\t"+rs.getInt("salary"));
            }

        } catch (SQLException e) {
            System.out.println(" Error viewing table: " + e.getMessage());
        }
    } 
} 
class Doctor 
{ 
    String dname, specialist, appoint, doc_qual; 
    int droom; 
    void new_doctor() 
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Name: "); 
        dname = sc.nextLine(); 
        System.out.print("Specialization: "); 
        specialist = sc.nextLine(); 
        System.out.print("Timing: "); 
        appoint = sc.nextLine(); 
        System.out.print("Qualification: "); 
        doc_qual = sc.nextLine(); 
        System.out.print("Room no.: "); 
        droom = sc.nextInt(); 
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement insert = conn.prepareStatement("INSERT INTO doctor (dname,specialist,appoint,doc_qual,droom) VALUES (?,?,?,?,?)"))
        {
            insert.setString(1,dname);
            insert.setString(2,specialist);
            insert.setString(3,appoint);
            insert.setString(4,doc_qual);
            insert.setInt(5,droom);
            insert.executeUpdate();
            System.out.println("Doctor added successfully!");
        }
        catch (SQLException e)
        {
            System.out.println(" Error adding doctor: " + e.getMessage());
        }
    } 
    void doctor_info() 
    { 
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM doctor"))
        {
            if (!rs.isBeforeFirst())
            {
                System.out.println(" Table is empty.");
                return;
            }
            while (rs.next())
            {
                System.out.println(rs.getInt("did")+"\t"+rs.getString("dname")+"\t"+rs.getString("specialist")+"\t\t"+rs.getString("appoint")+"\t"+rs.getString("doc_qual")+"\t\t"+rs.getInt("droom"));
            }
        }
        catch (SQLException e)
        {
            System.out.println(" Error viewing table: " + e.getMessage());
        } 
    } 
} 
class Patient 
{ 
    String pname, disease, sex, admit_status; 
    int age; 
    void new_patient() 
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Name: "); 
        pname = sc.nextLine(); 
        System.out.print("Disease: "); 
        disease = sc.nextLine(); 
        System.out.print("Sex: "); 
        sex = sc.nextLine(); 
        System.out.print("Admit status: "); 
        admit_status = sc.nextLine(); 
        System.out.print("Age: "); 
        age = sc.nextInt();
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement insert = conn.prepareStatement("INSERT INTO patient (pname,disease,sex,admit_status,age) VALUES (?,?,?,?,?)"))
        {
            insert.setString(1,pname);
            insert.setString(2,disease);
            insert.setString(3,sex);
            insert.setString(4,admit_status);
            insert.setInt(5,age);
            insert.executeUpdate();
            System.out.println("Patient added successfully!");
        }
        catch (SQLException e)
        {
            System.out.println(" Error adding patient: " + e.getMessage());
        }
    } 
    void patient_info() 
    { 
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM patient"))
        {
            if (!rs.isBeforeFirst())
            {
                System.out.println(" Table is empty.");
                return;
            }
            while (rs.next())
            {
                System.out.println(rs.getInt("pid")+"\t"+rs.getString("pname")+"\t"+rs.getString("disease")+"\t"+rs.getString("sex")+"\t"+rs.getString("admit_status")+"\t"+rs.getInt("age"));
            }

        } catch (SQLException e) {
            System.out.println(" Error viewing table: " + e.getMessage());
        }
    } 
} 
class Medicine
{ 
    String medname, medcomp, expdate; 
    int medcost, count; 
    void new_medi() 
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Name: "); 
        medname = sc.nextLine(); 
        System.out.print("Company: "); 
        medcomp = sc.nextLine(); 
        System.out.print("Expiry date:"); 
        expdate = sc.nextLine(); 
        System.out.print("Cost: "); 
        medcost = sc.nextInt(); 
        System.out.print("No. of unitS: "); 
        count = sc.nextInt();
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement insert = conn.prepareStatement("INSERT INTO medicine (medname,medcomp,expdate,medcost,count) VALUES (?,?,?,?,?)"))
        {
            insert.setString(1,medname);
            insert.setString(2,medcomp);
            insert.setString(3,expdate);
            insert.setInt(4,medcost);
            insert.setInt(5,count);
            insert.executeUpdate();
            System.out.println("Medicine added successfully!");
        }
        catch (SQLException e)
        {
            System.out.println(" Error adding medicine: " + e.getMessage());
        }
    } 
    void find_medi() 
    { 
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM medicine"))
        {
            if (!rs.isBeforeFirst())
            {
                System.out.println(" Table is empty.");
                return;
            }
            while (rs.next())
            {
                System.out.println(rs.getInt("medid")+"\t"+rs.getString("medname")+"\t"+rs.getString("medcomp")+"\t"+rs.getString("expdate")+"\t"+rs.getInt("medcost")+"\t"+rs.getInt("count"));
            }

        } catch (SQLException e) {
            System.out.println(" Error viewing table: " + e.getMessage());
        }
    } 
} 
class Diagnostic
{ 
    String facility; 
    int cost; 
    void new_feci() 
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Facility: "); 
        facility = sc.nextLine(); 
        System.out.print("Cost: "); 
        cost = sc.nextInt();
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement insert = conn.prepareStatement("INSERT INTO diagnostic (facility,cost) VALUES (?,?)"))
        {
            insert.setString(1,facility);
            insert.setInt(2,cost);
            insert.executeUpdate();
            System.out.println("Staff added successfully!");
        }
        catch (SQLException e)
        {
            System.out.println(" Error adding staff: " + e.getMessage());
        }
    } 
    void feci_list() 
    { 
        String DB_URL = "jdbc:sqlite:Hospital.db";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM diagnostic"))
        {
            if (!rs.isBeforeFirst())
            {
                System.out.println(" Table is empty.");
                return;
            }
            while (rs.next())
            {
                System.out.println(rs.getInt("fid")+"\t"+rs.getString("facility")+"\t"+rs.getInt("cost"));
            }

        } catch (SQLException e) {
            System.out.println(" Error viewing table: " + e.getMessage());
        }
    } 
}
public class HospitalManagement 
{ 
    public static void main(String args[]) 
    { 
        String months[] = { 
            "Jan", 
            "Feb", 
            "Mar", 
            "Apr", 
            "May", 
            "Jun", 
            "Jul", 
            "Aug", 
            "Sep", 
            "Oct", 
            "Nov", 
            "Dec" 
        }; 
        Calendar calendar = Calendar.getInstance(); 
        System.out.println("\n--------------------------------------------------------------------------------"); 
        System.out.println("            *** Welcome to Hospital Management System Project in Java ***"); 
        System.out.println("--------------------------------------------------------------------------------"); 
        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR)); 
        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND)); 
        Scanner sc = new Scanner(System.in); 
        int choice, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1;
        while (status == 1) 
        { 
            System.out.println("\n                                    MAIN MENU"); 
            System.out.println("-----------------------------------------------------------------------------------"); 
            System.out.println("1.Doctors  2. Patients  3.Medicines  4.Diagnostic  5. Staff "); 
            System.out.println("-----------------------------------------------------------------------------------"); 
            choice = sc.nextInt(); 
            switch (choice) 
            { 
                case 1: 
                    { 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        System.out.println("                      **DOCTOR SECTION**"); 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        s1 = 1; 
                        while (s1 == 1) 
                        {
                            Doctor obj1=new Doctor();
                            System.out.println("1.Add new entry\n2.Existing doctors list"); 
                            c1 = sc.nextInt(); 
                            switch (c1) 
                            { 
                                case 1: 
                                    { 
                                        obj1.new_doctor();
                                        break;
                                    } 
                                case 2: 
                                    { 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        System.out.println("Id \t Name\t\t Specialist \t Timing \t Qualification \t Room No."); 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        obj1.doctor_info();
                                        break; 
                                    } 
                            } 
                            System.out.println("\nTo return back press 1 and for main menu press 0"); 
                            s1 = sc.nextInt(); 
                        } 
                        break; 
                    } 
                case 2: 
                    { 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        System.out.println("                     **PATIENT SECTION**"); 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        s2 = 1; 
                        while (s2 == 1) 
                        { 
                            Patient obj2=new Patient();
                            System.out.println("1.Add new entry\n2.Existing patients list"); 
                            c1 = sc.nextInt(); 
                            switch (c1) 
                            { 
                                case 1: 
                                    { 
                                        obj2.new_patient();
                                        break; 
                                    } 
                                case 2: 
                                    { 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        System.out.println("Id \t Name \t Disease \t Gender \t Admit status \t Age"); 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        obj2.patient_info();
                                        break; 
                                    } 
                            } 
                            System.out.println("\nTo return back press 1 and for main menu press 0"); 
                            s2 = sc.nextInt(); 
                        } 
                        break; 
                    } 
                case 3: 
                    { 
                        s3 = 1; 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        System.out.println("                     **MEDICINE SECTION**"); 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        while (s3 == 1) 
                        { 
                            Medicine obj3=new Medicine();
                            System.out.println("1.Add new entry\n2.Existing medicines list"); 
                            c1 = sc.nextInt(); 
                            switch (c1) 
                            { 
                                case 1: 
                                    { 
                                        obj3.new_medi();
                                        break; 
                                    } 
                                case 2: 
                                    { 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        System.out.println("Id \t Name \t Company \t Expiry date \t Cost \t Count"); 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        obj3.find_medi();
                                        break; 
                                    } 
                            } 
                            System.out.println("\nTo return back press 1 and for main menu press 0"); 
                            s3 = sc.nextInt(); 
                        } 
                        break; 
                    } 
                case 4:
                    s4 = 1; 
                    System.out.println("--------------------------------------------------------------------------------"); 
                    System.out.println("                    **DIAGNOSTIC SECTION**"); 
                    System.out.println("--------------------------------------------------------------------------------"); 
                    while (s4 == 1) 
                    { 
                        Diagnostic obj4=new Diagnostic();
                        System.out.println("1.Add new entry \n2.Existing diagnostic list"); 
                        c1 = sc.nextInt(); 
                        switch (c1) 
                        { 
                            case 1:
                                obj4.new_feci(); 
                                break;
                            case 2: 
                                System.out.println("--------------------------------------------------------------------------------"); 
                                System.out.println("Id \t Diagnostic \t Cost"); 
                                System.out.println("--------------------------------------------------------------------------------"); 
                                obj4.feci_list();
                                break;  
                        } 
                        System.out.println("\nTo return back press 1 and for main menu press 0"); 
                        s4 = sc.nextInt(); 
                        } 
                    break; 
                case 5: 
                    { 
                        s5 = 1; 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        System.out.println("                       **STAFF SECTION**"); 
                        System.out.println("--------------------------------------------------------------------------------"); 
                        while (s5 == 1) 
                        { 
                            Staff obj5=new Staff();
                            System.out.println("1.Add new entry \n2.Existing staff list"); 
                            c1 = sc.nextInt(); 
                            switch (c1) 
                            { 
                                case 1: 
                                    { 
                                        obj5.new_staff();
                                        break; 
                                    } 
                                case 2: 
                                    { 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        System.out.println("id \t Name \t Gender \t Salary"); 
                                        System.out.println("--------------------------------------------------------------------------------"); 
                                        obj5.staff_info();
                                        break; 
                                    } 
                            } 
                            System.out.println("\nTo return back press 1 and for main menu press 0"); 
                            s5= sc.nextInt(); 
                        } 
                        break; 
                    } 
                default: 
                    { 
                        System.out.println(" You have enter wrong choice!!!"); 
                    } 
            } 
            System.out.println("\nTo return back to main menu Press 1"); 
            status = sc.nextInt(); 
        } 
    }
}