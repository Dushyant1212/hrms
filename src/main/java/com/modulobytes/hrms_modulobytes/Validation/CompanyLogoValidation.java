package com.modulobytes.hrms_modulobytes.Validation;

import org.springframework.web.multipart.MultipartFile;

public class CompanyLogoValidation {
    // Max file size (e.g., 10 MB)
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB

    // Allowed file extensions
    private static final String[] ALLOWED_EXTENSIONS = {"png", "jpg", "jpeg", "gif"};

    public static void validate(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File must not be null or empty.");
        }

        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File size exceeds the maximum limit of 10 MB.");
        }

        String fileName = file.getOriginalFilename();
        if (!isValidExtension(fileName)) {
            throw new IllegalArgumentException("File type is not supported. Allowed types: PNG, JPG, JPEG, GIF.");
        }
    }
    private static boolean isValidExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return false;
        }

        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        for (String allowedExtension : ALLOWED_EXTENSIONS) {
            if (allowedExtension.equals(extension)) {
                return true;
            }
        }
        return false;
    }

}
