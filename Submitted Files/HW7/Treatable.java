//I worked on the homework assignment alone, using only course materials.
/**
 * Defines methods for an entity to be treatable.
 *
 * @author Alex Zhang
 * @version 1.0
 */
public interface Treatable {

    /**
     * Determines if the entity needs treatment.
     *
     * @return True if the entity needs treatment, false otherwise.
     */
    boolean needsTreatment();

    /**
     * Treats the entity.
     */
    void treat();
}
