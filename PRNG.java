package prngl;

import java.util.Date;

public class PRNG {
    int cell1;
    int cell2;
    int cell3;
    int cell4;
    int bitDepth = 2;
    private static final int degreeOfPolinom = 4;
    private static int getSeed() {
        Date d2 = new Date();
        long temp = d2.getTime() % 1000;
        String temp1 = Long.toBinaryString(temp);
        String[] stat = new String[4];
        for (int i = 0; i < stat.length; i++) {
            char c = temp1.charAt(i);
            stat[i] = Character.toString(c);
        }
        String str = String.join("", stat);
        int start = Integer.parseInt(str);
        return start;
    }

    public void setStart() {
        int t = getSeed();
        this.cell1 = t % 10;
        t = t / 10;
        this.cell2 = t % 10;
        t = t / 10;
        this.cell3 = t % 10;
        t = t / 10;
        this.cell4 = t % 10;
    }

    public int[][] getSequence() {
        int countOfStates = (int) Math.pow(bitDepth, degreeOfPolinom);
        int[][] sequence = new int[degreeOfPolinom][countOfStates - 1];
        int[] temp = new int[]{cell1,cell2,cell3,cell4};
        int[] temp2=new int[]{cell1,cell2,cell3,cell4};
        for (int i = 0; i < degreeOfPolinom; i++)  {
            for (int j = 0; j < countOfStates-1 ; j++){
                int z =0;
                temp[0]=temp2[3];
                temp[1]=(temp2[0]+temp2[3])%bitDepth;
                temp[2]=temp2[1];
                temp[3]=temp2[2];
                for (int a = 0; a < temp.length; a++) temp2[a] = temp[a];
                sequence[i][j] = temp[i];
                z++;
            }
        }
        for (int j = 0; j < countOfStates-1; j++) {
            for (int i = 0; i < degreeOfPolinom; i++){
                System.out.print(sequence[i][j]+ " ");
            }System.out.println(" ");
        }
        return sequence;
    }
}

