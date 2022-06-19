package mice.task;

import java.util.LinkedList;

public class Mice {
    private boolean isAlive;
    private short number;


    public Mice(boolean isAlive, short number) {
        this.isAlive = isAlive;
        this.number = number;
    }

    public Mice() {

    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public short getNumber() {
        return number;
    }

    public static LinkedList<Mice> mice = new LinkedList<>();

    public LinkedList<Mice> getMice() {
        return mice;
    }

    @Override
    public String toString() {
        return "Mice{" +
                "isAlive=" + isAlive +
                ", number=" + String.format("%10s",Integer.toBinaryString(number)).replace(' ', '0') +
                '}';
    }

    public  void inicializeMice() {
        short start = 0b0000000001;
        for (int i = 0; i < 10; i++) {
            mice.add(i, new Mice(true, (short) (start << i)));

        }
    }
}
