package com.start.mavenbook.Controller;

import com.start.mavenbook.DTO.ItemDTO;
import com.start.mavenbook.Entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {
    @GetMapping(value = "/main")
    public String thymeleaf() {
        return "index";
    }

    @GetMapping(value = "/item")
    public String ItemTable(Model model) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemDetail("상품 상세 설명");
        itemDTO.setItemName("테스트 상품 1");
        itemDTO.setPrice(10000);
        itemDTO.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDTO", itemDTO);
        return "shop/shopDTO";
    }

    @GetMapping(value = "/itemList")
    public String shopList(Model model) {

        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (int i = 1; i<=10; i++) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemDetail("삼품 상세 설명" + i);
            itemDTO.setItemName("테스트 상품" + i);
            itemDTO.setPrice(10000 * i);
            itemDTO.setRegTime(LocalDateTime.now());
            itemDTOList.add(itemDTO);
        }

        model.addAttribute("itemDtoList", itemDTOList);

        return "shop/list/shopDTOList";
    }

    @GetMapping(value = "/link")
    public String thymeleafLink(String param1, String param2, Model model) {
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "shop/link";
    }

    @GetMapping(value = "/layout")
    public String layoutContext() {
        return "shop/layoutMain";
    }
}
