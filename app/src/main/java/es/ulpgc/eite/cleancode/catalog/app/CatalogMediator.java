package es.ulpgc.eite.cleancode.catalog.app;

import es.ulpgc.eite.cleancode.catalog.master.MasterListState;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailState;
import es.ulpgc.eite.cleancode.catalog.products.ProductListState;

public class CatalogMediator {
  private MasterListState masterListState = new MasterListState();
  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();

  private ProductItem product;
  private CategoryItem category;

  private static CatalogMediator INSTANCE;

  private CatalogMediator() {

  }



  public static CatalogMediator getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }

  public MasterListState getMasterListState() {
    return masterListState;
  }

  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }
  public CategoryItem getCategory(){
    CategoryItem item = category;
    return item;
    // TODO:  [Tutoria] ¿No es lo mismo 'return category;'?
    // TODO: [Tutoria]¿Al hacer product = null, por que no se cambia item = null?, ¿No estan linkeados?

  }
  public void setProduct(ProductItem item) {
    product = item;
  }
  public void setCategory(CategoryItem item){ category = item;}
}
