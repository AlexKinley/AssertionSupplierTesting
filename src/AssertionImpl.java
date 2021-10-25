import java.util.ArrayList;
import java.util.List;

public class AssertionImpl {

   public List<AssertionStep> steps = new ArrayList<>();

   Object startingObject;
   public AssertionImpl(Object startingObject) {
        this.startingObject = startingObject;
   }
    public boolean test() {
       Object currentObj = startingObject;
        for (final AssertionStep step: steps) {
            switch (step.type) {
                case AND -> System.out.println("AND STEP");
                case OR -> System.out.println("OR STEP");
                case THEN -> System.out.println("THEN STEP");
                case NOT -> System.out.println("NOT STEP");
                case SUPPLIER -> {
                    System.out.println("SUPPLIER STEP: " + step.name);
                    currentObj = step.supplier.apply(currentObj);
                    System.out.println(currentObj);
                }
                case CONDITION -> {
                    System.out.println("CONDITION STEP: " + step.name);
                    System.out.println("RESULT = " + step.predicate.test(currentObj));
                }
            }
        }
        return false;
    }

    public void and() {
        this.steps.add(new AssertionStep(AssertionStep.StepType.AND));
    }

    public void not() {
        this.steps.add(new AssertionStep(AssertionStep.StepType.NOT));
    }

    public void or() {
        this.steps.add(new AssertionStep(AssertionStep.StepType.OR));
    }
    public void then() {
        this.steps.add(new AssertionStep(AssertionStep.StepType.THEN));
    }
}
