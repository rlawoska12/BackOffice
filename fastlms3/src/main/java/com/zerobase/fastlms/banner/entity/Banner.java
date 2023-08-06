package com.zerobase.fastlms.banner.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bannerName;

    String fileName;

    String imagePath;

    String linkAddress;

    String openMethod;

    Integer sequence;

    boolean openYn;

    LocalDateTime regDt;

}
