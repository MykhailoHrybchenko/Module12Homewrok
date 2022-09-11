public class ClockCounter implements Runnable, TaskOne {

    private Thread t = new Thread(this);

    ClockCounter() {
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(1000);
                synchronized (MessagePrinter.class) {
                    MessagePrinter.sendMessage(Integer.toString(++MessagePrinter.count));
                    MessagePrinter.class.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
