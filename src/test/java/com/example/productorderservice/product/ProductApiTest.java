package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
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


    @Test
    public void 상품조회() throws Exception {
        //상품 등록
        상품등록요청(상품등록요청_생성());

        //등록한 상품의 번호
        final Long productId = 1L;

        final var response = RestAssured.given().log().all()
                .when()
                .get("/products/{productId}", productId)
                .then().log().all()
                .extract();

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }
}
