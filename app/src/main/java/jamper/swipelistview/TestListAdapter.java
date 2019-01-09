package jamper.swipelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class TestListAdapter extends ArrayAdapter<String> {

    ArrayList<String> mainList;
    Context mContext;


    public TestListAdapter(Context context, int resId, ArrayList<String> mainList) {
        super(context, resId, mainList);
        this.mContext = context;
        this.mainList = mainList;
    }


    public class ViewHolder {
        TextView fullNameText;
    }


    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder holder = null;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item_layout, null);
            holder = new ViewHolder();

            holder.fullNameText =  v.findViewById(R.id.text);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }


        try {
            //Set the various data her

            if (mainList != null) {

                holder.fullNameText.setText( mainList.get(position));
            }

        } catch (Exception e) {

        }

        return v;
    }


    @Override
    public int getCount() {
        return super.getCount();
       // return 10;
    }


}