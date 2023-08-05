package com.trip.waytrip.global.imageStore;

import com.trip.waytrip.global.imageStore.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Component
public class ImageUploader {

    @Value("${path.images}")
    String STORE_PATH;

    @Value("${path.ipUrl}")
    String ipUrl;

    private static final String DELIMITER = "/";

    public Image upload(MultipartFile multipartFile, String dirName) throws Exception {
        String originalName = Objects.requireNonNull(multipartFile.getOriginalFilename());
        String storeName = makeRandomName(originalName);
        String storePath = STORE_PATH + DELIMITER + dirName + DELIMITER + storeName;
        Path path = Paths.get(storePath).toAbsolutePath();
        File file = path.toFile();

        file.getParentFile().mkdirs();
        multipartFile.transferTo(file);
        return new Image(storeName, originalName, ipUrl + storePath);
    }

    public void delete(Image image) throws IOException {
        File file = new File(image.getImagePath());
        Files.deleteIfExists(Path.of(file.getAbsolutePath()));
    }

    private String makeRandomName(String fileName) {
        int index = fileName.lastIndexOf(".");
        String extension = fileName.substring(index + 1);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + extension;
    }
}
