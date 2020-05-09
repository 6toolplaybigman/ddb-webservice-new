package com.ddb.webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
* 주요 어노테이션을 클래스에 가깝게.
* 롬복은 코드를 단순화시켜 주지만 필수 어노테이션은 아님.
* 주요 어노테이션인 @Entity를 클래스에 가깝게 두고, 롬복 어노테이션을 그 위로 둠.
* Posts Class : 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고도 함.
* JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보단, 이 Entity 클래스의 수정을 통해 작업함.
* */

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
