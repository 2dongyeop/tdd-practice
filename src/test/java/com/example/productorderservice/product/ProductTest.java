package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void update() {
        final Product product = getNoneDiscountProduct();

        product.update("상품수정", 2000, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품수정");
    }
    
    @Test
    public void none_discounted_product() throws Exception {
        final Product product = getNoneDiscountProduct();

        final int discountedPrice = product.getDiscountPrice();

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    public void fix_1000_discounted_product() throws Exception {
        final Product product = getFix1000DiscountProduct();


        final int discountedPrice = product.getDiscountPrice();

        assertThat(discountedPrice).isEqualTo(1000);
    }

    private static Product getFix1000DiscountProduct() {
        return new Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT);
    }

    private static Product getNoneDiscountProduct() {
        return new Product("상품명", 1000, DiscountPolicy.NONE);
    }
}