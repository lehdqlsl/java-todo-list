public class TodoItem {
    private String title;
    private Status status;

    public TodoItem(String title) {
        this.title = title;
        this.status = Status.YET;
    }

    public String getTitle() {
        return title;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
