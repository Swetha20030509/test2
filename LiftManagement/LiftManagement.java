package LiftManagement;

import java.util.ArrayList;
import java.util.Scanner;


public class LiftManagement {
    ArrayList<Lift> allLift=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LiftManagement liftManagement=new LiftManagement();
        liftManagement.leftAllocated();
        while(true) {
            System.out.println("1.leftDetail");
            System.out.println("2.user acces left");
            System.out.println("3.Under maintain lift");
            System.out.println("4.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    liftManagement.displayLeftPosition();
                    break;
                case 2:
                    System.out.println("Enter the current floor");
                    int currentFloor = sc.nextInt();
                    System.out.println("Enter the desination floor");
                    int desinationFloor = sc.nextInt();


                    liftManagement.nearestPostionFind(currentFloor, desinationFloor);
                    break;
                case 3:
                    System.out.println("Enter id");
                    int id =sc.nextInt();
                    liftManagement.allLift.get(id-1).setAvailable(false);
                    liftManagement.allLift.get(id-1).setFloorNumber(-1);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    private void displayLeftPosition() {
        System.out.println("Display the left detail");
        System.out.println("LeftNumber    "+"FloorNUmber");
        for (int i=0;i<allLift.size();i++)
        {
            System.out.println("L"+allLift.get(i).getLeftId()+"        "+allLift.get(i).getFloorNumber());
        }
    }
    public int restrickLeft(int id, int currentFloor, int desinationFloor)
    {
        if(id==0||id==1)
        {
            if(currentFloor>=0&&currentFloor<=5&&desinationFloor>=0&&desinationFloor<=5)
                return id;
            else
                return -1;
        }
        else if(id==2||id==3)
        {
            if((currentFloor==0||(currentFloor>=6&&currentFloor<=10))&&(desinationFloor==0||(desinationFloor>=6&&desinationFloor<=10)))
                return id;
            else
                return -1;
        }

            return id;

    }
    public int leaseNumberOfStep(int i,int currentFloor, int destintioFloor)
    {

           if(i==0||i==1)
           {
                   return Math.abs(allLift.get(i).getFloorNumber()-currentFloor)+((Math.abs(currentFloor-destintioFloor)));
           }
           else if(i==3||i==2)
           {
               return Math.abs(allLift.get(i).getFloorNumber()-currentFloor)+((Math.abs(currentFloor-destintioFloor))-5);


           }
          return Math.abs(allLift.get(i).getFloorNumber()-currentFloor)+((Math.abs(currentFloor-destintioFloor)));


    }
    public void nearestPostionFind(int currentFloor, int desinationFloor)
    {
         int id=-1;
         int minmum=Integer.MAX_VALUE;
        for(int i=0;i<allLift.size();i++) {
            if (allLift.get(i).isAvailable()&&restrickLeft(i, currentFloor, desinationFloor) != -1) {
                if(minmum>leaseNumberOfStep(i,currentFloor,desinationFloor))
                {
                    minmum=leaseNumberOfStep(i,currentFloor,desinationFloor);
                    id = i;
                }
            }
        }

        int capacity1=0;
        int count=0;
        if(id!=-1) {
            for (int i = 0; i < minmum; i++) {
                count++;
                if (allLift.get(id).getCapacity() != capacity1) {
                    if (i % 2 == 0) {
                        capacity1 += 3;
                    } else {
                        capacity1 += 2;
                    }
                    if (capacity1 > allLift.get(id).getCapacity() && i % 2 == 0) {
                        capacity1 = capacity1 - 3;
                        break;
                    } else if (capacity1 > allLift.get(id).getCapacity() && i % 2 == 0) {
                        capacity1 -= 2;
                        break;
                    }
                }
            }
        }
        System.out.println(id);

              /* int distance=-1;
                int id=-1;
                for (int i=0;i<allLift.size();i++)
                {
                    if(i==0)
                    {
                        distance=Math.abs(currentFloor-allLift.get(i).getFloorNumber());
                        id=i;
                        if(restrickLeft(id,currentFloor,desinationFloor)==-1) {
                            distance = Integer.MAX_VALUE;
                            id=-1;
                        }
                    }
                    else if(distance==Math.abs(currentFloor-allLift.get(i).getFloorNumber()))
                    {

                       if(allLift.get(id).getFloorNumber()<allLift.get(i).getFloorNumber()) {
                           id = i;
                       }
                        if(restrickLeft(id,currentFloor,desinationFloor)==-1) {
                            distance = Integer.MAX_VALUE;
                            id=-1;
                        }

                    }
                    else if(distance>Math.abs(currentFloor-allLift.get(i).getFloorNumber())) {
                        distance = Math.abs(currentFloor - allLift.get(i).getFloorNumber());
                        id=i;
                        if(restrickLeft(id,currentFloor,desinationFloor)==-1) {
                            distance = Integer.MAX_VALUE;
                            id=-1;
                        }
                    }

                }
                if(distance!=-1)
                {
                    allLift.get(id).setFloorNumber(desinationFloor);
                    System.out.println("L"+(id+1)+"Allocated");
                }*/
        if(id!=-1) {
            allLift.get(id).setFloorNumber(desinationFloor);
            System.out.println("L" + (id + 1) + "Allocated");
            System.out.println("L"+id+"number person in cab"+capacity1);
        }
        else {
            System.out.println("No left available");
        }
    }

    private  void leftAllocated() {

        for(int i=0;i<5;i++)
        {
            if(i%2==0)
            allLift.add(new Lift(i+1,1,4));
            else
                allLift.add(new Lift(i+1,1,5));
        }
    }
}
