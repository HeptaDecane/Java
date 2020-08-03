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
