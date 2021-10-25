import java.util.function.Function;
import java.util.function.Supplier;

public class JobAssertion {

    private AssertionImpl assertionImpl;
    public JobAssertion(AssertionImpl assertionImpl) {
        this.assertionImpl = assertionImpl;
    }

    public StringAssertion title() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.SUPPLIER, "get title", (Function<Object, Object>)  j ->((Job) j).getTitle()));
        return new StringAssertion(assertionImpl);
    }


    public JobAssertion and() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.AND));
        return this;
    }

    public JobAssertion not() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.NOT));
        return this;
    }

    public JobAssertion or() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.OR));
        return this;
    }
    public JobAssertion then() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.THEN));
        return this;
    }
}
