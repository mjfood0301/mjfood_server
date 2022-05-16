package mj.mjfood.service;

import lombok.RequiredArgsConstructor;
import mj.mjfood.dto.CreateMenuDto;
import mj.mjfood.entity.Menu;
import mj.mjfood.entity.Store;
import mj.mjfood.repository.FoodRepository;
import mj.mjfood.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final FoodRepository foodRepository;

    @Transactional
    public Long createService(String name, String image, BigDecimal locationX, BigDecimal locationY, List<CreateMenuDto> createMenuDto) {
        //메뉴 생성
        List<Menu> menus = createMenuDto.stream()
                .map(m-> Menu.createMenu(foodRepository.findOne(m.getFoodId()), m.getName()))
                .collect(toList());

        Store store = Store.createStore(name, image, locationX, locationY, menus);

        storeRepository.save(store);

        return store.getId();
    }

    public Store findOne(Long storeId) {
        return storeRepository.findOne(storeId);
    }
}
