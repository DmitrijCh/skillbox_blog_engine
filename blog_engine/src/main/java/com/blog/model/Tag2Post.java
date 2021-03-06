package com.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "tag2post")
public class Tag2Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(name = "tag_id", nullable = false)
    private Integer tagId;
}
