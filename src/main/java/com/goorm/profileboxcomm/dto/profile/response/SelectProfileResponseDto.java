package com.goorm.profileboxcomm.dto.profile.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.goorm.profileboxcomm.dto.filmo.response.SelectFilmoResponseDto;
import com.goorm.profileboxcomm.dto.image.response.SelectImageResponseDto;
import com.goorm.profileboxcomm.dto.link.response.SelectLinkResponseDto;
import com.goorm.profileboxcomm.dto.member.response.SelectMemberResponseDto;
import com.goorm.profileboxcomm.dto.video.response.SelectVideoResponseDto;
import com.goorm.profileboxcomm.entity.Profile;
import com.goorm.profileboxcomm.utils.Utils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
    public class SelectProfileResponseDto {

        @Schema(description = "프로필 ID")
        private Long profileId;

        @Schema(description = "배우 이름")
        private String actorName;

        @Schema(description = "제목")
        private String title;

        @Schema(description = "내용")
        private String content;

        @Schema(description = "기본 이미지 ID")
        private Long defaultImageId;

        @Schema(description = "프로필 공개 유형")
        private String ynType;

        @Schema(description = "생성일자")
        private String createDt;

        @Schema(description = "회원 정보")
        private SelectMemberResponseDto memberInfo;

        @Schema(description = "이미지 목록")
        private List<SelectImageResponseDto> images;

        @Schema(description = "비디오 목록")
        private List<SelectVideoResponseDto> videos;

        @Schema(description = "필모 목록")
        private List<SelectFilmoResponseDto> filmos;

        @Schema(description = "링크 목록")
        private List<SelectLinkResponseDto> links;

        @Schema(description = "좋아요 개수")
        private Long likeCount;

        public static SelectProfileResponseDto getDtoForDetail(Profile profile){
            SelectProfileResponseDto dto = new SelectProfileResponseDto();
            dto.setProfileId(profile.getProfileId());
            dto.setContent(profile.getContent());
            dto.setActorName(profile.getActorName());
            dto.setTitle(profile.getTitle());
            dto.setDefaultImageId(profile.getDefaultImageId());
            dto.setYnType(profile.getYnType().toString());
            dto.setCreateDt(Utils.localDateToString(profile.getCreateDt()));
            dto.setMemberInfo(new SelectMemberResponseDto(profile.getMember()));
            dto.setImages(profile.getImageEntities().stream()
                    .map(o -> new SelectImageResponseDto(o))
                    .collect(toList()));
            dto.setVideos(profile.getVideoEntities().stream()
                    .map(o -> new SelectVideoResponseDto(o))
                    .collect(toList()));
            dto.setFilmos(profile.getFilmoEntities().stream()
                    .map(o -> new SelectFilmoResponseDto(o))
                    .collect(toList()));
            dto.setLinks(profile.getLinkEntities().stream()
                    .map(o -> new SelectLinkResponseDto(o))
                    .collect(toList()));
            return dto;
        }

        public static SelectProfileResponseDto getDtoForList(Profile profile){
            SelectProfileResponseDto dto = new SelectProfileResponseDto();
            dto.setProfileId(profile.getProfileId());
            dto.setContent(profile.getContent());
            dto.setActorName(profile.getActorName());
            dto.setTitle(profile.getTitle());
            dto.setDefaultImageId(profile.getDefaultImageId());
            dto.setYnType(profile.getYnType().toString());
            dto.setCreateDt(Utils.localDateToString(profile.getCreateDt()));
            dto.setImages(profile.getImageEntities().stream()
                    .map(o -> new SelectImageResponseDto(o))
                    .collect(toList()));
            dto.setLikeCount(profile.getLikeCount());
            return dto;
        }

        public static SelectProfileResponseDto getDtoForUserInfo(Profile profile){
            SelectProfileResponseDto dto = new SelectProfileResponseDto();
            dto.setProfileId(profile.getProfileId());
            dto.setContent(profile.getContent());
            dto.setActorName(profile.getActorName());
            dto.setTitle(profile.getTitle());
            dto.setDefaultImageId(profile.getDefaultImageId());
            dto.setYnType(profile.getYnType().toString());
            dto.setCreateDt(Utils.localDateToString(profile.getCreateDt()));
            return dto;
        }
    }