public class FiveSecThread implements Runnable, TaskOne{

    private final int period;
    private String mes;
    private Thread t = new Thread(this);

    FiveSecThread(int period, String mes){
        this.period = period;
        this.mes = mes;
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true)
                synchronized (MessagePrinter.class) {
                    MessagePrinter.class.wait();
                    if (MessagePrinter.count % period == 0)
                        MessagePrinter.sendMessage(mes);
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
