import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AssertionStep {

    public enum StepType {
        SUPPLIER, CONDITION, AND, NOT, THEN, OR
    }

    StepType type;
    String name;
    Predicate<Object> predicate;
    Function<Object, Object> supplier;
    public AssertionStep(StepType type) {
        this.type = type;
    }

    public AssertionStep(StepType type, String name, Function<Object, Object> supplier) {
        this.type = type;
        this.name = name;
        this.supplier = supplier;
    }

    public AssertionStep(StepType type, String name, Predicate<Object> predicate) {
        this.type = type;
        this.name = name;
        this.predicate = predicate;
    }
}
