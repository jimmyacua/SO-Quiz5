public class Oso extends Thread {
    public Monitor monitor;
    public int capac;
    public int cantDep;

    public Oso(int c, int cd, Monitor m){
        monitor = m;
        capac = c;
        cantDep = cd;
    }

    public void comer() throws InterruptedException{
        if(capac == cantDep){
            monitor.setCome(true);
            monitor.comer();
            cantDep = 0;
            monitor.setCome(false);
        }
    }

    public void run(){
        try {
            comer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
