package es.ulpgc.eite.cleancode.catalog.master;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.master.MasterListContract;

public class MasterListModel implements MasterListContract.Model {

    public static String TAG = es.ulpgc.eite.cleancode.catalog.products.ProductListModel.class.getSimpleName();

    private final List<CategoryItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public MasterListModel() {
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }

    @Override
    public List<CategoryItem> fetchProductListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }

    private void addProduct(CategoryItem item) {
        itemList.add(item);
    }

    private CategoryItem createProduct(int position) {
        String content = "Category " + position;

        return new CategoryItem(
                position, content
        );
    }




}