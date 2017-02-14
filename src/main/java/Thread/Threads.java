package Thread;

/**
 * Created by pramodvadiraj on 13/02/17.
 */

//depicting usages of Thread.Threads, synchronized,join
//join-executes the current thread , before going to the next thread
//synchornized- only 1 thread can access the monitor at a time, can be block or method- either cases it uses the current object that was specified to
    //obtain the lock and then accesses the shared resource
//
class RunnableObject implements Runnable {

    public  void run() {
        try {
            disp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void disp() throws InterruptedException {
        for(int i = 0 ; i < 10 ; i++)
        {
            System.out.println("Thread Name " +Thread.currentThread().getName() + " : "+ i);
            //Thread.sleep(1000L);

        }
    }
}
public class Threads
{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(new RunnableObject(),"FirstThread");
        t1.start();
        t1.join();//the below thread does not run until t1 ends
        new Thread(new RunnableObject(),"SecondThread").start();
        System.out.println(Thread.currentThread().getName() + " Thread Exit");

    }
}



