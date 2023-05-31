package com.example.productorderservice.order;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.example.productorderservice.order.OrderSteps.상품주문요청;
import static com.example.productorderservice.order.OrderSteps.상품주문요청_생성;
import static org.assertj.core.api.Assertions.assertThat;

class OrderApiTest extends ApiTest {

    @Test
    public void 상품주문() throws Exception {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final var request = 상품주문요청_생성();

        final var response = 상품주문요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
