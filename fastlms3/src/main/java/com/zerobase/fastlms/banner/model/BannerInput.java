package com.zerobase.fastlms.banner.model;

import lombok.Data;

@Data
public class BannerInput {
    Long id;

    String bannerName;

    String imagePath;

    String fileName;

    String linkAddress;

    String openMethod;

    Integer sequence;

    boolean openYn;
}
