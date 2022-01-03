package firas.karbich.com.wakalni.Asapters;

import firas.karbich.com.wakalni.Models.ProductModel;

public interface OnProductListener {

    void onProductClick(int position);

    void onAddCartClick(ProductModel product);

}
