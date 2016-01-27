package com.duanlei.myplan;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.duanlei.myplan.adapter.ViewPagerFragmentAdapter;
import com.melnykov.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    public static FloatingActionButton mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        //添加按钮
        mAddButton = (FloatingActionButton)findViewById(R.id.fab);

        //初始化抽屉菜单
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        //初始化ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null){
            setupViewPager(viewPager);
        }

        //选项卡
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (viewPager != null)
            tabLayout.setupWithViewPager(viewPager);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置抽屉布局
     * @param navigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {

                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }

    /**
     * 设置 viewPager 内容
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerFragmentAdapter adapter =
                new ViewPagerFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlanListFragment(), "旅游计划");
        adapter.addFragment(new PlanListFragment(), "减肥计划");
        adapter.addFragment(new PlanListFragment(), "学习计划");
        viewPager.setAdapter(adapter);
    }





}
