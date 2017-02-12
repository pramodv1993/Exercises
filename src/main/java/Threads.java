/**
 * Created by pramodvadiraj on 13/02/17.
 */

//depicting usages of Threads, synchronized
class RunnableObject implements Runnable {

    public  void run() {
        disp();
    }
    public synchronized void disp()
    {
        for(int i = 0 ; i < 10 ; i++)
        {
            System.out.println("Thread Name " +Thread.currentThread().getName() + " : "+ i);

        }
    }
}
public class Threads
{
    public static void main(String[] args) {
        new Thread(new RunnableObject(),"FirstThread").start();
        new Thread(new RunnableObject(),"SecondThread").start();
        System.out.println(Thread.currentThread().getName() + " Thread Exit");

    }
}

