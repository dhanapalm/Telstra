package au.telstra.telstraassignment.model;

import java.util.ArrayList;

/**
 * Created by Dhanapal on 24/02/15.
 */
public class Feeds
{
    private String title;

    private ArrayList<FeedRow> rows;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public ArrayList<FeedRow> getRows ()
    {
        return rows;
    }

    public void setRows (ArrayList<FeedRow> rows)
    {
        this.rows = rows;
    }
}
