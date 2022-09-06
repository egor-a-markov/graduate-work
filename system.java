package prngl ;

import javax.naming.PartialResultException;

public class system {
    public static void main(String[] args) {
        PRNG g = new PRNG();
        g.setStart();
        System.out.println();
        g.getSequence();
    }
}
