package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.History;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HistoryDto {
    Long no;
    LocalDateTime loginDate;
    String ip;
    String userAgent;
    String userId;

    public static HistoryDto of(History history) {

        return HistoryDto.builder()
                .no(history.getNo())
                .loginDate(history.getLoginDate())
                .ip(history.getIp())
                .userAgent(history.getUserAgent())
                .userId(history.getUserId())
                .build();
    }
}
