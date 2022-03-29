package es.ulpgc.eite.cleancode.catalog.master;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
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
        // Log.e(TAG, "onStart()");

        // initialize the state
        state = new MasterListState();

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        //PreviousToMasterListState savedState = getStateFromPreviousScreen();
        /*if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
/*        NextToMasterListState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }*/

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

/*    private NextToMasterListState getStateFromNextScreen() {
        return mediator.getCategory();
    }*/

    private void passDataToProductListScreen(ProductItem state) {
        mediator.setProduct(state);
    }

/*    private void passStateToPreviousScreen(MasterListToPreviousState state) {
        mediator.setPreviousMasterListScreenState(state);
    }*/

/*    private PreviousToMasterListState getStateFromPreviousScreen() {
        return mediator.getPreviousMasterListScreenState();
    }*/

    @Override
    public void injectView(WeakReference<MasterListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(MasterListContract.Model model) {
        this.model = model;
    }

}