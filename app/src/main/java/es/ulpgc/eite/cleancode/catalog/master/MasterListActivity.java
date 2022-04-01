package es.ulpgc.eite.cleancode.catalog.master;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;

public class MasterListActivity
        extends AppCompatActivity implements MasterListContract.View {

    public static String TAG = MasterListActivity.class.getSimpleName();

    private MasterListContract.Presenter presenter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.app_name));
        }

        // do the setup
        MasterListScreen.configure(this);
        listView = findViewById(R.id.master_list);
        if (savedInstanceState == null) {
            presenter.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    public void displayMasterListData(MasterListViewModel viewModel) {
        Log.e(TAG, "displayProductListData()");

        // deal with the data
        listView.setAdapter(new MasterListAdapter(
                        this, viewModel.products, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        CategoryItem item = (CategoryItem) view.getTag();
                        presenter.selectProductListData(item);
                    }
                })
        );
    }
    @Override
    public void injectPresenter(MasterListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}