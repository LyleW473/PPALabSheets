public class EventPost extends Post
{
    private String description;

    public EventPost(String author)
    {
        super(author);
    }

    public void addDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
