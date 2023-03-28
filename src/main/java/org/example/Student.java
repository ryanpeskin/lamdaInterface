package org.example;

public class Student extends Person{

    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }

    public void savedStudent(Student student) {
        SaveHandler saveHandler = new SaveHandler() {
            @Override
            public void saveObject(Object object) {
                System.out.println("Object Saved!");
            }
        };
        saveHandler.saveObject(this);
    }

    public void multiThreadSave(String directoryLocation){
        Thread t1;
        Thread t2;
        Runnable runnable1 = new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i<1000; i++){
                    System.out.println("Im runnable 1" + directoryLocation);
                }
            }
        };

        Runnable runnable2 = new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i<1000; i++){
                    System.out.println("Im runnable 2" + directoryLocation);
                }
            }
        };

        t1 = new Thread(runnable1);
        t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
