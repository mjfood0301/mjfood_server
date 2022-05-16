package mj.mjfood.controller;

import lombok.RequiredArgsConstructor;
import mj.mjfood.config.BaseResponse;
import mj.mjfood.dto.GetStoreRes;
import mj.mjfood.entity.Store;
import mj.mjfood.service.StoreService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/stores")
@RequiredArgsConstructor
@RestController
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/{storeId}")
    public BaseResponse<GetStoreRes> getStore(@PathVariable Long storeId) {
        Store store = storeService.findOne(storeId);
        return new BaseResponse<>(new GetStoreRes(store));
    }
}
