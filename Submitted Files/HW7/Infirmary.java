/**
 * Defines infirmaries.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public class Infirmary {
    private static int numberOfInfirmaries = 0;
    private String infirmaryName;

    /**
     * Creates an infirmary and increments number of infirmaries.
     *
     * @param infirmaryName Name of the infirmary
     */
    public Infirmary(String infirmaryName) {
        this.infirmaryName = infirmaryName;
        numberOfInfirmaries++;
    }

    /**
     * Gets number of infirmaries.
     *
     * @return number of infirmaries.
     */
    public static int getNumberOfInfirmaries() {
        return numberOfInfirmaries;
    }

    /**
     * Prints the troop as a string. If a barbarian, make it scream as well.
     *
     * @param o Troop to be inspected
     */
    public void inspectTroop(Troop o) {
        System.out.println(o);
        if (o instanceof Barbarian) {
            ((Barbarian) o).scream();
        }
    }

    /**
     * Treats a troop if needed.
     *
     * @param o Troop to be treated.
     */
    public void doTreatment(Treatable o) {
        if (o.needsTreatment()) {
            o.treat();
        } else {
            System.out.printf("You are fine. You will not receive treatment at %s infirmary", this.infirmaryName);
        }
    }

    /**
     * Represents the infirmary as a string.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return String.format("%s infirmary", this.infirmaryName);
    }


    /**
     * Compares the infirmary to another.
     *
     * @param o Object to compare to.
     * @return True if equals, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Infirmary)) {
            return false;
        }
        Infirmary infirmary = (Infirmary) o;
        return this.infirmaryName.equals(infirmary.infirmaryName);
    }
}
