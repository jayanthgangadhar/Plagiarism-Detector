package edu.neu.cs5500.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    /**
     * Initalize the loca storage folder
     */
    public void init(String userID);

    /**
     * @param file
     * @return
     * Store the input multipart file into local file system temporarily
     */
    public  File store(MultipartFile file,String uniqueText);

    /**
     * @return
     * load all files present in local storage
     */
    public Stream<Path> loadAll();

    /**
     * @param filename
     * @return
     * 
     * Load a file based on the file name given
     */
    public Path load(String filename);

    /**
     * @param filename
     * @return
     * 
     * Load a resource based on the file name
     */
    public Resource loadAsResource(String filename);

    /**
     * 
     * Delete all files in the local storage folder
     */
    public  void deleteAll();
    /**
     * Delete the input file from the local storage
     */       
    public  void deleteFile(File f);
    
    
    /**
     * @param fileName
     * @param data
     * @return
     * 
     * Create a new file in the local storage system based on the input string data and file name
     */
    public File createFile(String fileName, String data);
    
    
    /**
     * @param fileStream
     * @param fileName
     * @return
     * Store the input stream as a file in the local storage system
     */
    public File store(InputStream fileStream, String fileName);
    

}
