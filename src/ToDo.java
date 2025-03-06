import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ToDo extends SimpleTask{
    public static int command;
    public static Scanner s = new Scanner(System.in);
    public static int showMenu() {

        System.out.println("Choose from the List : ");
        System.out.println("1. Add Task ");
        System.out.println("2. List all Tasks ");
        System.out.println("3. Updata Task ");
        System.out.println("4. Delete Task ");
        System.out.println("5. Show Report ");
        System.out.println("6. Exit ");
        System.out.print(" Command> ");
        command = s.nextInt();
        return command;
    }
    public static void addInput() {
        String inputTitle, inputDesc, inputDate,inputType,inputDeadline,inputStart;
        int inputIndex;
        while (true) {
            System.out.print("Enter task title: ");
            inputTitle = s.nextLine();
            System.out.println("Enter task description: ");
            inputDesc = s.nextLine();
            System.out.println("Enter task date (e.g., YYYY-MM-DD): ");
            inputDate = s.nextLine();
            if (!inputTitle.isEmpty() && !inputDesc.isEmpty()) {
                break;
            } else {
                System.out.println("Please enter both Task title and description.");
            }
            System.out.println("Do you want add deadline or recurring on task ?");
            inputType=s.nextLine();
            if(inputType.toLowerCase().equals("deadline")){
                DeadLine T1=new DeadLine();
                T1.add(inputTitle,inputDesc,inputDate);
                T1.print();
                System.out.println("Select the Task that you would to add deadline to it : ");
                inputIndex=s.nextInt();
                System.out.println("add deadline date : ");
                inputDeadline=s.nextLine();
                T1.setDeadline(inputIndex,inputDeadline);
            } else if (inputType.toLowerCase().equals("recurring")) {
                RecurringTask T2=new RecurringTask();
                T2.add(inputTitle,inputDesc,inputDate);
                T2.print();
                System.out.println("Select the Task that you would to add Start and End date  to it : ");
                inputIndex=s.nextInt();
                System.out.println("add start date : ");
                inputStart=s.nextLine();
                System.out.println("add deadline date : ");
                inputDeadline=s.nextLine();
                T2.repeat(inputIndex,inputStart,inputDeadline);
            }
        }


        System.out.println("Task added successfully!");
    }

    public static void userOption(int c){
        command=c;
        switch (c) {
            case (1):
                addInput();
                break;
            case(2):

        }
    }
    public static void main(String[] args) {
        showMenu();
        userOption(command);
    }

    }



//        SimpleTask c2 = new RecurringTask();
//        SimpleTask c3 = new DeadLine();
//        int x = 0;
//        ArrayList<String> arr = new ArrayList<>();
//        int countSimple = 0 ;
//        int countRecurring = 0 ;
//        int countDeadline = 0 ;
//        SimpleTask c = new SimpleTask();
//        while(x<3) {
//            arr.add(c.toString());
//            arr.add(c2.toString());
//            arr.add(c3.toString());
//           x++;
//        }
////            arr.add(c);
////        for (SimpleTask i : arr)
////        {
////            System.out.println(i.getClass());
//////        }
//            //class RecurringTask - class DeadLine
//        for (int i = 0; i <arr.size() ; i++) {
//            if (arr.get(i).equals("SimpleTask"))
//            {
//                countSimple++;
//            } else if (arr.get(i).equals("RecurringTask"))
//            {
//                countRecurring++;
//            } else if (arr.get(i).equals("DeadLine"))
//            {
//                countDeadline++;
//            }
//        }
//        System.out.println("Simple:\t"+ countSimple);
//        System.out.println("Recurring:\t"+ countRecurring);
//        System.out.println("DeadLine:\t"+ countDeadline);
//    }

