import java.util.function.Predicate;

public class StringAssertion {

    private AssertionImpl assertionImpl;
    public StringAssertion(AssertionImpl assertionImpl) {
        this.assertionImpl = assertionImpl;
    }

    public StringAssertion toBeEqual(String v) {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.CONDITION, "toBeEqual", (Predicate<Object>)  j ->((String) j).equals(v)));
        return new StringAssertion(assertionImpl);
    }


    public StringAssertion and() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.AND));
        return this;
    }

    public StringAssertion not() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.NOT));
        return this;
    }

    public StringAssertion or() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.OR));
        return this;
    }
    public StringAssertion then() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.THEN));
        return this;
    }

    public boolean test() {
        return assertionImpl.test();
    }
}
