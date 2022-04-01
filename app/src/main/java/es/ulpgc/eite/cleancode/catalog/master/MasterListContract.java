package es.ulpgc.eite.cleancode.catalog.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.master.MasterListContract;
import es.ulpgc.eite.cleancode.catalog.master.MasterListViewModel;
import es.ulpgc.eite.cleancode.catalog.products.ProductListContract;

public interface MasterListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayMasterListData(MasterListViewModel viewModel);
    }

    interface Presenter {

        void injectView(WeakReference<MasterListContract.View> view);
        void injectModel(MasterListContract.Model model);
        //void injectRouter(Router router);

        void fetchProductListData();
        void selectProductListData(ProductItem item);

        void onResume();

        void onStart();

        void onBackPressed();
    }

    interface Model {
        List<CategoryItem> fetchProductListData();
    }

}