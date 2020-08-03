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
Path path = Paths.get("home","near","data.txt");
path path = Paths.get("/home/near/data.txt");
```

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
