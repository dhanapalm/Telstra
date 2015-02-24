package au.telstra.telstraassignment.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

import au.telstra.telstraassignment.R;
import au.telstra.telstraassignment.network.RequestManager;

/**
 * Created by Dhanapal on 24/02/15.
 *
 * Adapter class for Listview
 *
 */
public class FeedListAdapter extends BaseAdapter {

    /**
     * ViewHolder For the Adapter
     */
    class ViewHolder {
        ImageView imgFeed;
        TextView txtTitle;
        TextView txtDescription;
        boolean isImageSet;
    }

    private static final String TAG = "FeedListAdapter";

    Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<FeedRow> feedList;

    public FeedListAdapter(Context mContext, ArrayList<FeedRow> feedList) {

        this.mContext = mContext;
        this.feedList = feedList;

        mInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return feedList.size();
    }

    @Override
    public FeedRow getItem(int position) {
        return feedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, "position : " + position);
        final ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.feed_list_item, null);

            holder = new ViewHolder();
            holder.imgFeed = (ImageView) convertView.findViewById(R.id.feed_image);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.feed_title);
            holder.txtDescription = (TextView) convertView.findViewById(R.id.feed_description);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FeedRow feedRow = feedList.get(position);
        String title = feedRow.getTitle();
        String description = feedRow.getDescription();
        String imageHref = feedRow.getImageHref();

        if(title != null) {
            holder.txtTitle.setText(title);
        } else {
            holder.txtTitle.setText(mContext.getString(R.string.title));
        }

        if(description != null) {
            holder.txtDescription.setText(description);
        } else {
            holder.txtDescription.setText(mContext.getString(R.string.description));
        }

        if (imageHref != null) {
            RequestManager.getInstance().getImageLoader().get(imageHref, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer imageContainer, boolean b) {
                    holder.imgFeed.setImageBitmap(imageContainer.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    holder.imgFeed.setImageResource(R.drawable.img_not_available);
                }
            });
        } else {
            holder.imgFeed.setImageResource(R.drawable.img_not_available);
        }


        return convertView;

    }

}