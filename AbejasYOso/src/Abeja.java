public class Abeja extends Thread {
    public Monitor monitor;
    public int capac;
    public int cantDep;
    public int porcion;

    public Abeja(int c, int cd, Monitor m, int p) {
        monitor = m;
        capac = c;
        cantDep = cd;
        porcion = p;
    }

    public void depositar() throws InterruptedException {
        monitor.abejaPare();
        if (capac > cantDep) {
            monitor.deposite();
            cantDep += porcion;
            if (capac == cantDep) { //despertar oso
                monitor.setCome(true);
                monitor.comer();
                cantDep = 0;
                monitor.setCome(false);
            }
        }
    }

    public void run(){
        try {
            depositar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
