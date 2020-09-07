package com.SobreMesa.Campus.Riddles.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SobreMesa.Campus.Riddles.Services.AmazonClient;

@RestController
@RequestMapping("api/storage/")
public class StorageController {
	
	@Autowired
	private AmazonClient amazonClient;
	
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }
}
