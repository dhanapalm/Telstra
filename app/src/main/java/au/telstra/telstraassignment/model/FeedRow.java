package au.telstra.telstraassignment.model;

/**
 * Created by Dhanapal on 24/02/15.
 */
public class FeedRow {
    private String title;

    private String description;

    private String imageHref;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getImageHref ()
    {
        return imageHref;
    }

    public void setImageHref (String imageHref)
    {
        this.imageHref = imageHref;
    }

}
