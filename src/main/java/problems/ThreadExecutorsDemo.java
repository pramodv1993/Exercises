package problems;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pramodvadiraj on 21/04/17.
 */
public class ThreadExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new test11());
        executorService.execute(new test11());
        executorService.execute(new test11());
        executorService.execute(new test11());
        executorService.execute(new test11());
        executorService.shutdown();

    }
}
class test11 implements Runnable
{

    static int count = 0;
    private int id;
    public test11()
    {
        id = ++count;
    }
    @Override
    public void run() {
        System.out.println("Thread :"+ id +" started");
        for(int i = 0 ; i< 10 ; i++) System.out.println("Thread :" + id + "   " +i);
        System.out.println("Thread :" + id + " ended");

    }
}

class t11
{
    public void disp()
    {
        GenericInterface<Integer> a = ()-> System.out.println("asd");
        Type[] interfaces = (a.getClass().getGenericInterfaces());
        for (Type genericInterface : interfaces) {
            if (genericInterface instanceof ParameterizedType) {
                Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    System.out.println("Generic type: " + genericType);
                }
            }
        }


    }

    public static void main(String[] args) {
        new t11().disp();
    }
}
     interface GenericInterface<T>
        {
        void display();
        }

