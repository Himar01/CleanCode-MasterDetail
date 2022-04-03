package es.ulpgc.eite.cleancode.catalog.master;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;

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
        presenter.fetchProductListData();
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
                        this, viewModel.category, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        CategoryItem category = (CategoryItem) view.getTag();
                        presenter.selectProductListData(category);
                    }
                })
        );
    }

    @Override
    public void navigateToProductListScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(MasterListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}