package com.startdis.api.client;

import com.startdis.api.factory.DemoClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "startdistem-service-web",  fallbackFactory = DemoClientFactory.class)
//@FeignClient(value = "startdistem-service-web", configuration = FeignHeaderRequestInterceptor.class), fallbackFactory = ProductServiceFactory.class)
public interface DemoClientApi {

    @GetMapping("/api/v1/goods/findByGoodsId")
    String findById(@RequestParam("goodsId") int goodsId);
}
