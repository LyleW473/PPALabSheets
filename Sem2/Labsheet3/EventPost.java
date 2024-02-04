public class EventPost extends Post
{
    private String description; // A description of the event that has occured, mentioned in the event post.

    /**
     * Constructor for objects of class PhotoPost.
     * 
     * @param author    The username of the author of this post.
     */
    public EventPost(String author)
    {
        super(author);
    }

    /**
     * Add a description to this event post.
     * 
     * @param description The description to be added.
     */
    public void addDescription(String description)
    {
        this.description = description;
    }

    /**
     * Return the description of the event post.
     * 
     * @return The description of the event post.
     */
    public String getDescription()
    {
        return description;
    }
}
