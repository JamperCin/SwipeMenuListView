package jamper.swipelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.animation.BounceInterpolator;
import android.widget.ListView;

import com.jamper.swipemenulistview.swipe.Margins;
import com.jamper.swipemenulistview.swipe.SwipeMenu;
import com.jamper.swipemenulistview.swipe.SwipeMenuCreator;
import com.jamper.swipemenulistview.swipe.SwipeMenuItem;
import com.jamper.swipemenulistview.swipe.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> list;
    private TestListAdapter mAdapter;
    private SwipeMenuListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        displayListView();
    }




    /**
     * Display the Approval list in the ListView
     **/
    private void displayListView() {
        try {
            list = new ArrayList<>();
            list.add("hello i will be");
            list.add("Can we i will be");
            list.add("how may i help i will be");
            list.add("hello i will be");
            list.add("Tomorrow is my birthday");
            list.add("hello i will be");
            list.add("hello i will be");
            list.add("hello i will be");


            mAdapter = new TestListAdapter(this, R.layout.item_layout, list);
            listView.setAdapter(mAdapter);
            listView.setItemsCanFocus(true);
            mAdapter.notifyDataSetChanged();

            createHorizontalSwipeMenu();

        } catch (Exception e) {

        }
    }



    public int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.getResources().getDisplayMetrics());
    }


    /**
     * Create the Horizontal menu on each row of the listView
     **/
    private void createHorizontalSwipeMenu() {
        try {
            SwipeMenuCreator creator = new SwipeMenuCreator() {
                @Override
                public void create(SwipeMenu menu) {
                    SwipeMenuItem approve = new SwipeMenuItem(MainActivity.this);
                    approve.setWidth(dp2px(80));
                    approve.setTitle("Approve");
                    approve.setBackground(R.drawable.round_green);
                    approve.setIcon(R.drawable.price);
                    approve.setTitleColor(android.R.color.white);
                    approve.setTitleSize(14);
                    approve.setIconTintColor(R.color.white);
                    approve.setLayoutBackgroundColor(R.color.ash);
                    approve.setMargins(new Margins(5,5,5,5));
                    menu.addMenuItem(approve);


                    SwipeMenuItem cancel = new SwipeMenuItem(MainActivity.this);
                    cancel.setWidth(dp2px(80));
                    cancel.setTitle("Cancel");
                    cancel.setIcon(R.drawable.search); //tODO use png file
                    cancel.setTitleSize(14);
                    cancel.setTitleColor(android.R.color.black);
                    cancel.setBackground(R.drawable.round_red);
                    cancel.setIconTintColor(R.color.white);
                    cancel.setLayoutBackgroundColor(R.color.ash);
                    cancel.setMargins(new Margins(5,5,5,5));
                    menu.addMenuItem(cancel);

                }
            };

            listView.setMenuCreator(creator);
            listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {

                    switch (index) {
                        case 0:


                            break;

                        case 1:

                            break;

                    }

                    return false;
                }
            });

            listView.setCloseInterpolator(new BounceInterpolator());
        } catch (Exception e) {
           // LOG("Error " + e.getMessage());
        }

    }



}
