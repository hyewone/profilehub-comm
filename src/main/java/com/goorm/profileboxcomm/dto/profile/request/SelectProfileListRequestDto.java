package com.goorm.profileboxcomm.dto.profile.request;

import com.goorm.profileboxcomm.entity.Profile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@Data
@Schema(description = "프로필 리스트 조회 요청 DTO")
public class SelectProfileListRequestDto {

    @Schema(description = "필모 유형")
    private String filmoType;
    @Schema(description = "필모 이름")
    private String filmoName;
    @Schema(description = "프로필 제목")
    private String title;
    @Schema(description = "배우 이름")
    private String actorName;
    @Schema(description = "검색 페이지")
    private int offset;
    @Schema(description = "한 페이지당 검색 데이터")
    private int limit;
    @Schema(description = "정렬 필드")
    private String sortKey;
    @Schema(description = "정렬 방향")
    private String sortDirection;

    public SelectProfileListRequestDto() {
        this.offset = 0;
        this.limit = 10;
        this.sortKey = "profileId";
        this.sortDirection = Sort.Direction.DESC.toString();
        this.filmoType = "";
        this.filmoName = "";
        this.title = "";
        this.actorName = "";
    }

    public void setOffset(int offset) {
        if (offset < 1) {
            this.offset = 0;
        } else {
            this.offset = offset - 1;
        }
    }

    public void setLimit(int limit) {
        if (limit < 0) {
            this.limit = 10;
        } else {
            this.limit = limit;
        }
    }

    public void setSortKey(String sortKey){
        if (sortKey == null || sortKey.trim().isEmpty() || !isValidSortKey(sortKey)) {
            this.sortKey = "profileId";
        } else {
            this.sortKey = sortKey;
        }
    }

    private boolean isValidSortKey(String sortKey) {
        List<String> validSortKeys = Profile.getProfileFieldNames();
        return validSortKeys.contains(sortKey);
    }

    public void setSortDirection(String sortDirection) {
        if (sortDirection == null || sortDirection.trim().isEmpty() || !isValidSortDirection(sortDirection)) {
            this.sortDirection = Sort.Direction.DESC.toString();
        } else {
            this.sortDirection = sortDirection;
        }
    }

    private boolean isValidSortDirection(String sortDirection) {
        List<String> validSortDirections = Arrays.asList("DESC", "ASC");
        return validSortDirections.contains(sortDirection);
    }
}
