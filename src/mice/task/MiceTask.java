package mice.task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class MiceTask {

    private short tubes;
    private boolean isPoisonous = false;


    public MiceTask(short tubes, boolean isPoisonous) {
        this.tubes = tubes;
        this.isPoisonous = isPoisonous;
    }

    public short getTubes() {
        return tubes;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    private ArrayList<MiceTask> tasks = new ArrayList<MiceTask>();

    public MiceTask() {

    }

    public void generatePoisonousTubes() {
        LinkedList<Integer> unluckyNums = new LinkedList<>();

        unluckyNums.add((int) (Math.random() * 1000 + 1));
        System.out.println('\n' + "Our unlucky numbers: " + '\t' + unluckyNums);

        for (int i = 1; i <= 1000; i++) {
            if (unluckyNums.contains(i)) {
                tasks.add(i - 1, new MiceTask((short) i, true));
                System.out.println(i + " In binary: " + String.format("%10s", Integer.toBinaryString(tasks.get(i - 1).getTubes())).replace(' ', '0') + " " + tasks.get(i - 1).isPoisonous());
            } else {
                tasks.add(i - 1, new MiceTask((short) i, false));
            }
        }
    }

    public void shot(Mice mouse, MiceTask vaccine) {
        if (vaccine.isPoisonous()) {
            mouse.setAlive(false);
        }
    }

    public void research(MiceTask tube, int i) {


        switch (i) {

            case 0: {
                shot(mice.task.Mice.mice.get(9), tube);
                break;
            }

            case 1: {
                shot(mice.task.Mice.mice.get(8), tube);
                break;
            }
            case 2: {
                shot(mice.task.Mice.mice.get(7), tube);
                break;
            }
            case 3: {
                shot(mice.task.Mice.mice.get(6), tube);
                break;
            }
            case 4:{
                shot(mice.task.Mice.mice.get(5),tube);
                break;
                    }
            case 5:{
                shot(mice.task.Mice.mice.get(4),tube);
                break;
                    }
            case 6:{
                shot(mice.task.Mice.mice.get(3),tube);
                break;
                    }
            case 7:{
                shot(mice.task.Mice.mice.get(2),tube);
                break;
                    }
            case 8:{
                shot(mice.task.Mice.mice.get(1),tube);
                break;
                    }
            case 9:{
                shot(mice.task.Mice.mice.get(0),tube);
                break;
                    }

        }

    }


    public static void main(String[] args) {
        MiceTask task = new MiceTask();
        Mice mouse = new Mice();
        task.generatePoisonousTubes();
        mouse.inicializeMice();
        System.out.println("""

                 
                """);
        for (int i = 0; i < mouse.mice.size(); i++) {
            System.out.println(i + "th " + mouse.mice.get(i).toString());
            //System.out.println(mouse.mice.get(i).isAlive()+ " "+mouse.mice.get(i).getNumber());
        }

        for (MiceTask tube : task.tasks) {
            String tempNumb = String.format("%10s", Integer.toBinaryString(tube.getTubes())).replace(' ', '0');
            char[] tubeChar = tempNumb.toCharArray();
            //System.out.println(tubeChar);
            for (int i = 0; i < tubeChar.length; i++) {
                if (tubeChar[i] == 49) {
                    //System.out.println("I found '1' at element " + i);
                    task.research(tube, i);
                }
            }



        }
        System.out.println("""

                 
                """);
        for (int i = 0; i < mouse.mice.size(); i++) {
            System.out.println(i + "th " + mouse.mice.get(i).toString());
            //System.out.println(mouse.mice.get(i).isAlive()+ " "+mouse.mice.get(i).getNumber());
        }
        System.out.println("""

                 
                """);
        LinkedList<Integer> list = new LinkedList<>();
        String finalStr="";
        for (Mice m :
                mouse.mice) {


            if (!m.isAlive()) {
                String tempStr = String.format("%10s", Integer.toBinaryString(m.getNumber())).replace(' ', '0');
                System.out.println(tempStr);
                list.add(tempStr.indexOf('1'));

            }

            //System.out.println(mouse.mice.get(i).isAlive()+ " "+mouse.mice.get(i).getNumber());
        }
        for(int i=0; i<10; i++) {

            if(list.contains(i)){
                finalStr+="1";
                System.out.print("^");

            }
            else {
                finalStr+="0";
                System.out.print(" ");
            }
            //System.out.println(finalStr);
        }
        System.out.println('\n');
        System.out.println(finalStr);


    }

    @Override
    public String toString() {
        return "MiceTask{" +
                "tubes=" + tubes +
                ", isPoisonous=" + isPoisonous +
                ", tasks=" + tasks +
                '}';
    }
}
