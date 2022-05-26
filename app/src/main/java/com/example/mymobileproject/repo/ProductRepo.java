package com.example.mymobileproject.repo;

import com.example.mymobileproject.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    List<Product> productList = new ArrayList<>();
    List<Product> fullProductList = new ArrayList<>();

    public ProductRepo() {

        productList.add(new Product(1, "canon_eos_r_body2", "2790р 8370р 19530р", 2790, 1));
        productList.add(new Product(2, "fujifilm_gfx_50s_body2", "3290р 9870р 23030р", 3290,2));
        productList.add(new Product(3, "canon_eos_r5_body2", "4690р 14070р 32830р", 4690,3));
        productList.add(new Product(4, "canon_eos_r6_body2", "3990р 11970р 27930р", 3990,4));

        productList.add(new Product(5, "canon5dmarkivbody2", "3490р 10470р 24430р", 3490,5));
        productList.add(new Product(6, "canon5dmarkiiibody2", "2390р 7170р 16730р", 2390,6));

        productList.add(new Product(7, "panasoniceva1ef2", "6990р 20970р 48930р", 6990,7));
        productList.add(new Product(8, "canonxa152", "2490р 7470р 17430р", 2490,8));

        productList.add(new Product(9, "goprohero10blackedition2", "2190р 6570р 15330р", 2190,9));

        productList.add(new Product(10, "canonef1124f40lusm2", "2990р 8970р 20930р", 2990,10));
        productList.add(new Product(11, "sonysel1018f40oss2", "990р 2970р 6930р", 990,11));

        productList.add(new Product(12, "sirui24f28anamorphicmft2", "1590р 4770р 11130р", 1590,12));

        productList.add(new Product(13, "cfexpresstypeb256gbsonyg2", "1290р 3870р 9030р", 1290,13));

        productList.add(new Product(14, "vmount6a90wh2", "490р 1470р 3430р", 490,14));

        productList.add(new Product(15, "canon430exii2", "490р 1470р 3430р", 490,15));

        productList.add(new Product(16, "arritruebluet22", "1390р 4170р 9730р", 1390,16));


        fullProductList.addAll(productList);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Product> getProductByType(int id){

        List<Product> filterProducts = new ArrayList<>();

        for (Product s: productList) {
            if(s.getType() == id) {
                filterProducts.add(s);
            }
        }

        return filterProducts;
    }


}
