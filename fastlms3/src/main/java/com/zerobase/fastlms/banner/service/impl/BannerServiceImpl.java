package com.zerobase.fastlms.banner.service.impl;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import com.zerobase.fastlms.banner.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public boolean add(BannerInput parameter) {

        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .imagePath(parameter.getImagePath())
                .fileName(parameter.getFileName())
                .linkAddress(parameter.getLinkAddress())
                .openMethod(parameter.getOpenMethod())
                .sequence(parameter.getSequence())
                .openYn(parameter.isOpenYn())
                .regDt(LocalDateTime.now())
                .build();
        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }

    @Override
    public boolean set(BannerInput parameter) {

        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());

        if (!optionalBanner.isPresent()) {
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setBannerName(parameter.getBannerName());
        banner.setImagePath(parameter.getImagePath());
        banner.setFileName(parameter.getFileName());
        banner.setLinkAddress(parameter.getLinkAddress());
        banner.setOpenMethod(parameter.getOpenMethod());
        banner.setSequence(parameter.getSequence());
        banner.setOpenYn(parameter.isOpenYn());

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public List<BannerDto> list(BannerParam parameter) {

        List<BannerDto> list = BannerDto.of(bannerRepository.findAll());

        long totalCount = list.size();

        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public List<BannerDto> getOpenBannerList(boolean openYn) {

        List<BannerDto> openBannerList =
                BannerDto.of(bannerRepository.findAllByOpenYnIsTrueOrderBySequence());

        return openBannerList;
    }
}
