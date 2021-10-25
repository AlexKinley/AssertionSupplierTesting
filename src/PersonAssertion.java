import java.util.function.Function;
import java.util.function.Supplier;

public class PersonAssertion {
    // a person can be considered to have a
    // Job
    // Name

    private AssertionImpl assertionImpl;
    public PersonAssertion(AssertionImpl assertionImpl) {
        this.assertionImpl = assertionImpl;
    }

    public JobAssertion job() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.SUPPLIER, "get job",(Function<Object, Object>) p ->((Person) p).getJob()));
        return new JobAssertion(assertionImpl);
    }

    public PersonAssertion and() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.AND));
        return this;
    }

    public PersonAssertion not() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.NOT));
        return this;
    }

    public PersonAssertion or() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.OR));
        return this;
    }
    public PersonAssertion then() {
        assertionImpl.steps.add(new AssertionStep(AssertionStep.StepType.THEN));
        return this;
    }

}

/**
 * env.expect(person).job().title().toBeEqual("CEO")
 * env.expect(person) returns PersonAssertion
 * PersonAssertion#job returns JobAssertion
 * JobAssertion#title return StringAssertion
 * StringAssertion#toBeEqual returns GenericAssertion<StringAssertion>?
 */