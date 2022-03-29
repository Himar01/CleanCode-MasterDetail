package es.ulpgc.eite.cleancode.catalog.master;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.catalog.R;

public class MasterListActivity
        extends AppCompatActivity implements MasterListContract.View {

    public static String TAG = MasterListActivity.class.getSimpleName();

    private MasterListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getSupportActionBar().setTitle(R.string.app_name);


        // do the setup
        MasterListScreen.configure(this);

        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
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
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(MasterListViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
//      ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, MasterListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(MasterListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}