# SwipeMenuListView
Use this light weight android library to create a customised listView to show menus when swiped left with animations used as a menu dialog in android.

[![](https://jitpack.io/v/JamperCin/SwipeMenuListView.svg)](https://jitpack.io/#JamperCin/SwipeMenuListView)

![alt text](https://github.com/JamperCin/FloatingMenuDialog/blob/master/sample.png)

**Step 1: Add this to your root build.gradle(Project level) at the end of repositories:**

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  **Step 2: Add the dependency to your dependencies in the build.gradle (Module:App level)**

	dependencies {
	        implementation 'com.github.JamperCin:SwipeMenuListView:1.0.1'
	}
  
 

**Step 3: Create your list and populate your adapter to show as its done in normal listView **
```
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

```

**To create the swiped menus do the following**
```
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
                    menu.addMenuItem(cancel);

                }
            };

```

** When done with the menus creation, set them to the listView like below, and listen to menuOnClicks with their index in the order they were added, STARTING from index 0. You can set the close interpolation if you want an animation when swioed or closed**
```
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
```
