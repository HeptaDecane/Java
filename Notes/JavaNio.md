# Java NIO
```java
import java.nio.file.*;		//JDK 7+
```

## Path
```java
// sets path to file(data.txt) in current working directory`
Path path = Paths.get("data.txt");
```
```java
// sets the path to file(data.txt) within directory(dir) in current working directory
Path path = Paths.get("dir","data.txt");
Path path = Paths.get("dir/data.txt");
```
```java
// sets path to file(data.txt) outside the current working directory using absolute path
Path path = Paths.get("home","user","data.txt");
path path = Paths.get("/home/user/data.txt");
```

## [java.nio.file.FileSystem](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileSystem.html)
>Provides an interface to a file system and is the factory for objects to access files and other objects in the file system.
>The default file system, obtained by invoking the  [FileSystems.getDefault](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileSystems.html#getDefault)  method, provides access to the file system that is accessible to the Java virtual machine. The  [FileSystems](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileSystems.html)  class defines methods to create file systems that provide access to other types of (custom) file systems.


## [java.nio.file.Files](https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html)
>This class consists exclusively of static methods that operate on files, directories, or other types of files. 
>In most cases, the methods defined here will delegate to the associated file system provider to perform the file operations.

## Files.copy( )
```java
Path source = Paths.get("to","source","file");
Path destination = Paths.get("to","destination","file");
// default copy (throws Exception if destination file exists)
try{
	Files.copy(source,destination);
}catch(IOException e){
	System.out.println(e)
}

// Copy and replace destination if existing
try{
	Files.copy(source,destination,StandardCopyOption.REPLACE_EXISTING);
}catch(IOException e){
	System.out.println(e)
}
```

## Files.move( )
```java
Path source = Paths.get("to","source","file");
Path destination = Paths.get("to","destination","file");
try{
	Files.move(source,destination);
}catch(IOException e){
	System.out.println(e)
}
```
#### rename
```java
Path source = Paths.get("path","originalName");
Path destination = Paths.get("path","newName");
try{
	Files.move(source,destination);
}catch(IOException e){
	System.out.println(e);
}
```

## Files.delete( )
```java
Path path = Path.get("path","to","file");
try{
	Files.delete(path);				// default delete
	Files.deleteIfExists(path);		// look before you leap
}catch(IOException e){
	System.out.println(e); 
}
```

## Reading Directory Contents

```java
Path path = Paths.get("to","target","directory");  
try(DirectoryStream<Path> contents = Files.newDirectoryStream(path)){  
    for(Path file:contents)  
        System.out.println(file.getFileName());  
}catch(IOException|DirectoryIteratorException e){  
    System.out.println(e);  
}
```
### Filters
- [Using Glob](https://javapapers.com/java/glob-with-java-nio/)
```java
Path path = Paths.get("to","target","directory");  
try(DirectoryStream<Path> contents = Files.newDirectoryStream(path,"glob_pattern")){  
    for(Path file:contents)  
        System.out.println(file.getFileName());  
}catch(IOException|DirectoryIteratorException e){  
    System.out.println(e);  
}
```
- Using DirectoryStream.Filter
```java
Path path = Paths.get("to","target","directory");  

DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {  
	@Override  
	public boolean accept(Path entry) throws IOException {  
		if("conditon on {entry}")
			return true;
		else
			return false;	 
	}  
};

try(DirectoryStream<Path> contents = Files.newDirectoryStream(path,filter)){  
    for(Path file:contents)  
        System.out.println(file.getFileName());  
}catch(IOException|DirectoryIteratorException e){  
    System.out.println(e);  
}
```

## File Tree
<figure align="center">
	<img align="center" src="http://www.mediafire.com/convkey/8b72/5a4sx6imy2ga8bgzg.jpg">
	<figcaption>Working Directory Structure</figcaption>
</figure>

### Walking File Tree
```java
Path path = Paths.get("Files","Dir1");  
try{  
	Files.walkFileTree(path,new GetFiles());  
}catch (IOException e){  
	System.out.println(e);  
}
```
```java
public class GetFiles extends SimpleFileVisitor<Path> {  
	// actions before visiting files in directory  
	@Override  
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {  
		System.out.println("dir  : "+ dir);  
		return FileVisitResult.CONTINUE;  
	}  
  
    // actions on visiting files in directory  
    @Override  
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {  
		System.out.println("file : "+file);  
		return FileVisitResult.CONTINUE;  
	}  
  
    // actions after visiting files in directory  
    @Override  
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {  
		System.out.println("/dir : "+ dir);  
		return FileVisitResult.CONTINUE;  
	}  
  
    // actions if visiting  the file failed  
    @Override  
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {  
		System.out.println(exc+" : "+file);  
		return FileVisitResult.CONTINUE;  
	}  
}
```

### Copying Entire File Tree
```java
Path source = Paths.get("Files","Dir1");  
Path destination = Paths.get("Files","Dir1(Copy)");  
try{  
    Files.walkFileTree(source,new CopyFiles(source,destination));  
}catch (IOException e){  
    System.out.println(e);  
}
```
```java
public class CopyFiles extends SimpleFileVisitor<Path> {  
    private final Path sourceRoot;  
	 private final Path destinationRoot;  
  
	public CopyFiles(Path sourceRoot, Path destinationRoot) {  
		 this.sourceRoot = sourceRoot;  
		 this.destinationRoot = destinationRoot;  
	}  
  
	// copy directory before visiting files  
    @Override  
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {  
		Path relativeSourcePath = sourceRoot.relativize(dir);  
		Path destinationPath = destinationRoot.resolve(relativeSourcePath);  
		try{  
			 System.out.println(dir+" ---> "+destinationPath);  
			 Files.copy(dir,destinationPath);  
		}catch (IOException e){  
			System.out.println(e);  
			return FileVisitResult.SKIP_SUBTREE;  
		 }  
        return FileVisitResult.CONTINUE;  
	}  
  
	// copy file on visit  
	@Override  
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {  
		Path relativeSourcePath = sourceRoot.relativize(file);  
		Path destinationPath = destinationRoot.resolve(relativeSourcePath);  
		try{  
			System.out.println(file+" ---> "+destinationPath);  
			Files.copy(file,destinationPath);  
		}catch (IOException e){  
			System.out.println(e);  
		}  
		return FileVisitResult.CONTINUE;  
	}  

	// report error  
	@Override  
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {  
		System.out.println(exc+" : "+file);  
		return FileVisitResult.CONTINUE;  
	}  
}
```