package com.curso.ecommerce.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

    private String folder = "images" +File.separator;

    public String saveImage(MultipartFile file) throws IOException{
        if(!file.isEmpty()){
            //Crear carpeta sino existe
            File directorio = new File(folder);

            if(!directorio.exists()){
                directorio.mkdirs();
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder+file.getOriginalFilename());
            System.out.println("Ruta: " +path.toString());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        }
        return "default.jpg";
    }

    public void deleteImage(String nombre){
        File file = new File(folder + nombre);

        if(file.exists()){
            file.delete();  
        }
    }

}
