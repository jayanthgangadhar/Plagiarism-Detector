package edu.neu.cs5500.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.GmailModule;

/**
 * @author Asim
 * 
 * Service related to creating local files for comparison purposes
 *
 */
@Service("storageService")
public class FileSystemStorageService implements StorageService {
	// Logger
	private static Logger logger = Logger.getLogger(FileSystemStorageService.class.getName());
	private Path rootLocation;
	private Path userLocation;

	public Path getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(Path userLocation) {
		this.userLocation = userLocation;
	}

	public Path getRootLocation() {
		return rootLocation;
	}

	public void setRootLocation(Path rootLocation) {
		this.rootLocation = rootLocation;
	}

	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public File store(MultipartFile file, String uniqueText) {
		String filename = uniqueText + "字" + StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + filename);
			}
			if (filename.contains("..")) {
				// This is a security check
				throw new StorageException(
						"Cannot store file with relative path outside current directory "
								+ filename);
			}
			if (filename.contains("/")) {
				
				filename = filename.replaceAll("/", "啊");
			}
			Files.copy(file.getInputStream(), this.userLocation.resolve(filename),
					StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e) {
			throw new StorageException("Failed to store file " + filename, e);
		}

		return new File(this.userLocation.resolve(filename).toString());
	}
	
	@Override
	public File store(InputStream fileStream, String fileName) {
		String filename = StringUtils.cleanPath(fileName);
		try {
			if (fileStream == null) {
				throw new StorageException("Failed to store empty file " + filename);
			}
			if (filename.contains("..")) {
				// This is a security check
				throw new StorageException(
						"Cannot store file with relative path outside current directory "
								+ filename);
			}
			if (filename.contains("/")) {
				
				filename = filename.replaceAll("/", "啊");
			}
			Files.copy(fileStream, this.userLocation.resolve(filename),
					StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e) {
			throw new StorageException("Failed to store file " + filename, e);
		}

		return new File(this.userLocation.resolve(filename).toString());
	}
	
	

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.userLocation, 1)
					.filter(path -> !path.equals(this.userLocation))
					.map(path -> this.userLocation.relativize(path));
		}
		catch (IOException e) {
			throw new StorageException("Failed to read stored files", e);
		}

	}

	@Override
	public Path load(String filename) {
		return userLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageFileNotFoundException(
						"Could not read file: " + filename);

			}
		}
		catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(userLocation.toFile());
	}

	@Override
	public void init(String userID) {
		try {

			userLocation = Paths.get(rootLocation.toString(), userID);
			Files.createDirectories(userLocation);
		}
		catch (IOException e) {
			throw new StorageException("Could not initialize storage", e);
		}
	}

	@Override
	public void deleteFile(File f) {

		FileSystemUtils.deleteRecursively(f);
	}

	@Override
	public File createFile(String fileName, String data) {
		
		
		File f  = new File(userLocation.toString()+ File.separator + fileName+".py");
		try (PrintWriter out = new PrintWriter(f)) {
		    out.println(data);
		    
		    return f;
		} catch (FileNotFoundException e) {
			
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		
		return null;
	}


}
