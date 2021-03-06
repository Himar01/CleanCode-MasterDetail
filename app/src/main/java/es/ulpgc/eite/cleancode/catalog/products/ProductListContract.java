package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

interface ProductListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayProductListData(ProductListViewModel viewModel);

    void navigateToProductDetailScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void fetchProductListData();

    void selectProductListData(ProductItem item);

    void onResume();
  }

  interface Model {
    List<ProductItem> fetchProductListData();

    void createProductListData(int category);

    boolean listEmpty();
  }
}