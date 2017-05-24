package com.clearbases.codehouse.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by macair on 24/05/17.
 */
@Component
public class FileManager {

    @Autowired
    private HttpServletRequest request;

    public String create(String baseFolder, MultipartFile multipartFile) {

        String path = null;
        try {
            String realPath = request.getServletContext().getRealPath(File.separator + baseFolder);
            path = realPath + File.separator + multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baseFolder + File.separator + multipartFile.getOriginalFilename();

    }

}
