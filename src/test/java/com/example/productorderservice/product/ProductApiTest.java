package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.example.productorderservice.product.ProductSteps.상품등록요청;
import static com.example.productorderservice.product.ProductSteps.상품등록요청_생성;

class ProductApiTest extends ApiTest {

    @Test
    public void 상품등록() throws Exception {

        final var request = 상품등록요청_생성();

        final var response = 상품등록요청(request);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
