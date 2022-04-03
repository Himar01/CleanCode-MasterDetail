package es.ulpgc.eite.cleancode.catalog.master;

import android.view.MenuItem;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;

public interface MasterListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayMasterListData(MasterListViewModel viewModel);

        void navigateToProductListScreen();
    }

    interface Presenter {
        void injectView(WeakReference<MasterListContract.View> view);

        void injectModel(MasterListContract.Model model);

        void fetchProductListData();

        void selectProductListData(CategoryItem item);

        void onResume();

        void onStart();

        void onBackPressed();
    }

    interface Model {
        List<CategoryItem> fetchProductListData();
    }

}