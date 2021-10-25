public class Job {
    private String title;

    public Job(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                '}';
    }
}
