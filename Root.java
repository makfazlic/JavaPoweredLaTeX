/**
 * An Integer Root values.
 *
 * @author Mak Fazlic & Roberto Ferrari - Latex project.
 * @version v1.0
 */
public class Root extends Node
{
    // instance variables
    private final Node power;
    private final Node base;

    /**
     * Constructor for objects of class Power.
     * @param power expression Node.
     * @param base expression Node.
     */
    public Root(final Node power, final Node base) {
        super();
        this.power = power;
        this.base = base;       
    }
    
    @Override
    // Returns Latex of Roots
    public String toLatex() {
        return "{\\sqrt[" + power.toLatex() + "]{" + base.toLatex() + "}}";
    }
}