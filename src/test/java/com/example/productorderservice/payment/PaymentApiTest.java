package com.example.productorderservice.payment;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.order.OrderService;
import com.example.productorderservice.order.OrderSteps;
import com.example.productorderservice.product.ProductService;
import com.example.productorderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.example.productorderservice.payment.PaymentSteps.주문결제요청;
import static com.example.productorderservice.payment.PaymentSteps.주문결제요청_생성;

class PaymentApiTest extends ApiTest {

    @Test
    public void 상품주문() throws Exception {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        final var request = PaymentSteps.주문결제요청_생성();

        final var response = 주문결제요청(request);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
