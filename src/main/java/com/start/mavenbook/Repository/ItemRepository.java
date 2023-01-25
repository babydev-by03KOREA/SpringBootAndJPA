package com.start.mavenbook.Repository;

import com.start.mavenbook.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

// 제네릭 타입: <엔티티 클래스, 엔티티클래스의 기본키>
// Collection<T> find + (엔티티 이름) + By + 변수이름
// 이게되나 싶었지만 Java에서는 Interface만 다중상속이 가능하다!
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
    // WHERE 조건을 이용하여 조회하는 쿼리 메소드
    List<Item> findByItemName(String itemName);
    // OR 조건을 이용하여 조회하는 쿼리 메소드
    List<Item> findByItemNameOrItemDetail(String itemNum, String itemDetail);
    // 가격이 조건보다 작은 쿼리 메소드
    List<Item> findByPriceLessThan(Integer price);
    // DESC 조건을 이용하여 조회하는 쿼리 메소드
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    // @JPQL / from 뒤 엔티티명(소문자 에러)
    // like %[검색할 값]%
    // itemDetail 파라미터를 받아서 :itemDetail 파라미터 바인딩
    @Query("select i " +
            "from Item i " +
            "where i.itemDetail " +
            "like %:itemDetail% " +
            "order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}


