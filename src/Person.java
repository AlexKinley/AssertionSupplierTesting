public class Person {
    private String name;
    private Job job;
    public Person(String name, String jobTitle) {
        this.name = name;
        this.job =  new Job(jobTitle);
    }

    public String getName() {
        return this.name;
    }
    public Job getJob() {
        return this.job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job=" + job +
                '}';
    }
}
