package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.controller;

import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.factory.DisposalGuidelineFactory;
import com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.model.DisposalGuideline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DisposalGuidelineControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    DisposalGuidelineController controller;
    @Autowired private TestRestTemplate restTemplate;

    private DisposalGuideline disposalGuideline;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.disposalGuideline = DisposalGuidelineFactory.build("test-category","test-guidelinename");
        this.baseUrl = "http://localhost:" + this.port + "/api/guideline/";
    }

    @Test
    @Order(2)
    void getAllDisposalGuidelines() {
        String url = this.baseUrl + "all";
        System.out.println(url);
        ResponseEntity<DisposalGuideline[]> response =
                this.restTemplate.getForEntity(url, DisposalGuideline[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody().length == 0)
        );

    }

    @Test
    @Order(3)
    void getDisposalGuidelineById() {
        String url = this.baseUrl + "read" + this.disposalGuideline.getDisposalId();
        System.out.println(url);
        ResponseEntity<DisposalGuideline> response = this.restTemplate.getForEntity(url, DisposalGuideline.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(1)
    void createDisposalGuideline() {
        String url = this.baseUrl + "save";
        System.out.println(url);
        ResponseEntity<DisposalGuideline> response = this.restTemplate
                .postForEntity(url,this.disposalGuideline,DisposalGuideline.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(4)
    void updateGuideline() {
    }

    @Test
    @Order(5)
    void deleteDisposalGuideline() {
        String url = this.baseUrl + "delete" + this.disposalGuideline.getDisposalId();
        this.restTemplate.delete(url);
    }
}