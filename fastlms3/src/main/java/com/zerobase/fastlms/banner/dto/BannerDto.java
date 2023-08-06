package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.entity.Course;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BannerDto {

    Long id;

    String bannerName;

    String imagePath;

    String fileName;

    String linkAddress;

    String openMethod;

    Integer sequence;

    boolean openYn;

    LocalDateTime regDt;


    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .imagePath(banner.getImagePath())
                .fileName(banner.getFileName())
                .linkAddress(banner.getLinkAddress())
                .openMethod(banner.getOpenMethod())
                .sequence(banner.getSequence())
                .openYn(banner.isOpenYn())
                .regDt(banner.getRegDt())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for(Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;
    }
}
