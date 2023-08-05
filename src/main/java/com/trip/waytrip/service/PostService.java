package com.trip.waytrip.service;

import com.trip.waytrip.domain.Image;
import com.trip.waytrip.domain.Post;
import com.trip.waytrip.dto.response.post.PostCreateResponse;
import com.trip.waytrip.dto.response.post.PostFindAllResponse;
import com.trip.waytrip.dto.response.post.PostFindResponse;
import com.trip.waytrip.exception.NoAuthorizationException;
import com.trip.waytrip.exception.NoSuchElementException;
import com.trip.waytrip.oauth.SecurityUtil;
import com.trip.waytrip.repository.ImageRepository;
import com.trip.waytrip.repository.PostRepository;
import com.trip.waytrip.repository.ScheduleRepository;
import com.trip.waytrip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.trip.waytrip.domain.constant.Constants.*;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository posts;
    private final ScheduleRepository schedules;
    private final ImageRepository images;
    private final UserRepository users;

    @Transactional(readOnly = true)
    public PostFindResponse findPost(final Long postId) {
        //TODO: Redis에 유저명, 게시물아이디로 좋아요 이력 조회
        boolean liked = false;

        return PostFindResponse.of(posts.findById(postId)
                .orElseThrow(() -> new NoSuchElementException(POST)), liked);
    }

    @Transactional(readOnly = true)
    public PostFindAllResponse findPosts() {
        //TODO: Redis에 유저명, 게시물아이디로 좋아요 이력 조회
        return PostFindAllResponse.of(posts.findAllByCreatedBy(SecurityUtil.getCurrentUserEmail()).stream()
                .map(post -> PostFindResponse.of(post, true))
                .collect(Collectors.toList()));
    }

    public PostCreateResponse savePost(String title, String content, Long scheduleId, List<MultipartFile> multipartFiles) {
        Post savePost = posts.save(Post.builder()
                .title(title)
                .content(content)
                .schedule(schedules.findById(scheduleId)
                        .orElseThrow(() -> new NoSuchElementException(SCHEDULE)))
                .build());

        if(multipartFiles != null)
            multipartFiles.stream()
                    .map(this::upload)
                    .map(url -> Image.builder().post(savePost).url(url).build())
                    .forEach(images::save);

        return PostCreateResponse.from(savePost);
    }

    public void updatePost(final Long postId, List<MultipartFile> multipartFiles, String title, String content) {
        Post post = posts.findById(postId)
                .orElseThrow(() -> new NoSuchElementException(POST));

        if(!SecurityUtil.getCurrentUserEmail().equals(post.getCreatedBy()))
            throw new NoAuthorizationException(USER + UPDATE);

        post.setTitle(title);
        post.setContent(content);

        if(multipartFiles != null)
            multipartFiles.stream()
                    .map(this::upload)
                    .map(url -> Image.builder().post(post).url(url).build())
                    .forEach(images::save);
    }

    public void deletePost(final Long postId) {
        Post post = posts.findById(postId)
                .orElseThrow(() -> new NoSuchElementException(POST));

        if(!SecurityUtil.getCurrentUserEmail().equals(post.getCreatedBy()))
            throw new NoAuthorizationException(USER + DELETE);

        posts.delete(post);
    }

    public void likePost(final Long postId) {
        //TODO: Redis 연결 후 좋아요 기능 구현
        String userEmail = SecurityUtil.getCurrentUserEmail();
    }

    public void unlikePost(final Long postId) {
        //TODO: Redis 연결 후 좋아요 기능 구현
        String userEmail = SecurityUtil.getCurrentUserEmail();
    }

    public String upload(MultipartFile image) {
        //TODO: amazon S3 업로드 후 저장된 url 가져오기
        return "";
    }
}
