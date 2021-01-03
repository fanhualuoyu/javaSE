package example;

import inherit.Demo01ThreadTicketImpl;

public class Demo01ThreadTicket {
    public static void main(String[] args) {
        Demo01ThreadTicketImpl ticket = new Demo01ThreadTicketImpl();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        t1.start();
        t2.start();
        t3.start();
    }
}
