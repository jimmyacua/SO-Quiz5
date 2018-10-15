public class Monitor {
    private boolean come;
    private int capac;
    private int cantDep;
    private int porcion;

    public Monitor(int c, int p){
        capac = c;
        porcion = p;
        cantDep = 0;
        come = false;
    }


    public void setCome(boolean comer){
        come = comer;
    }

    synchronized void abejaPare() throws InterruptedException {
        while(come) //si el oso está comiendo
            wait();
        notifyAll();
    }

    synchronized void deposite() throws InterruptedException{
        if(!come) {
            cantDep += porcion;
            if(cantDep >= capac){
                System.out.println("Llenando tarro");
                come = true;
                comer();
                cantDep = 0;
            } else {
                System.out.println("Llenando tarro");
            }
            notifyAll();
        } else{
            wait();
        }
    }

    synchronized void comer() throws InterruptedException{
        while (come) {
            cantDep = 0;
            System.out.println("Oso comiendo...");
            try {
                Thread.sleep((int)(Math.random() * 5000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            come = false;
        }
        notifyAll();
    }

}
