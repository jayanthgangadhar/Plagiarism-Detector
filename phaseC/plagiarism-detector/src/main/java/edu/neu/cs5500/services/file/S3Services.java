package edu.neu.cs5500.services.file;

import java.io.File;
import java.io.InputStream;

public interface S3Services {
	public InputStream downloadFile(String keyName);
	public String uploadFile(String keyName, File fileToBeUpoaded);
}
