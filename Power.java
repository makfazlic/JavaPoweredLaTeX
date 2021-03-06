
/**
 * An Integer Power
 *
 * @author Mak Fazlic & Roberto Ferrari - Latex project.
 * @version v1.0
 */
public class Power extends Node
{
    // instance variables
    private final Node child;
    private final Node exponent;

    /**
     * Constructor for objects of class Power.
     * @param child expression Node.
     * @param exponent expression Node.
     */
    public Power(final Node child, final Node exponent) {
        super();
        this.child = child;
        this.exponent = exponent;
    }
 
    @Override
    // Returns Latex of Power
    public String toLatex() {
        return "{" + child.toLatex() + "^{" + exponent.toLatex() + "}}";
    }
}
