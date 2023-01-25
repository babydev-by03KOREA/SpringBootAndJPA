package com.start.mavenbook.Entity;

import com.start.mavenbook.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

// @Entity name default == class name
@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
    // 상품 코드, @Id: Primary Key
    @Id
    // 직접 @Column 정보도 작성이 가능함 / EX) @Column(columnDefinition = "varchar(100) default 'EMPTY'")
    // 여기서는 DB 컬럼명을 지정 / 기본값은 해당 객체명
    @Column(name = "item_id")
    // Primary Key 생성법 지정, GenerationType.AUTO / 방언에 따라 IDENTITY, SEQUENCE, TABLE 자동지정
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // 상품명
    // nullable (default = true)
    @Column(nullable = false, length = 50)
    private String itemName;
    // 가격
    @Column(name = "price", nullable = false)
    private int price;
    // 재고수량
    @Column(nullable = false)
    private int stockNumber;
    // 상품 상세 설명
    // DB에서 VARCHAR보다 큰 데이터를 담고싶을때 사용. BLOB, CLOB
    @Lob
    @Column(nullable = false)
    private String itemDetail;
    // 상품 판매 상태
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;
    // 등록 시간
    private LocalDateTime regTime;
    // 수정 시간
    private LocalDateTime updateTime;
}
