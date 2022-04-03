package es.ulpgc.eite.cleancode.catalog.master;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class MasterListPresenter implements MasterListContract.Presenter {

    public static String TAG = MasterListPresenter.class.getSimpleName();

    private WeakReference<MasterListContract.View> view;
    private MasterListState state;
    private MasterListContract.Model model;
    private CatalogMediator mediator;

    public MasterListPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getMasterListState();
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart()");

        view.get().displayMasterListData(state);
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume()");

        view.get().displayMasterListData(state);
    }

    @Override
    public void onBackPressed() {
    }

    private void passDataToProductListScreen(CategoryItem state) {
        mediator.setCategory(state);}

    @Override
    public void injectView(WeakReference<MasterListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(MasterListContract.Model model) {
        this.model = model;
    }

    @Override
    public void fetchProductListData() {
        Log.e(TAG, "fetchProductListData()");

        // call the model
        state.category = model.fetchProductListData();
        view.get().displayMasterListData(state);
    }

    @Override
    public void selectProductListData(CategoryItem item) {

        passDataToProductListScreen(item);

        view.get().navigateToProductListScreen();
    }
}