public class AssertionSupplierTesting {

    public static PersonAssertion expect(Person p) {
        AssertionImpl assertion = new AssertionImpl(p);
        return new PersonAssertion(assertion);
    }
    public static void main(String[] args) {
        Person p = new Person("Joe", "CEO");
        var assertion = expect(p).job().title().toBeEqual("CEO").and().not().toBeEqual("butcher");
        assertion.test();
    }
}
