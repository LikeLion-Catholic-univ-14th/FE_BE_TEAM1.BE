package org.example.fe_be_team1_be.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.*;

@Entity
@Table(name = "crud_post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String writer;

    private String quote;
}
