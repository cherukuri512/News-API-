# News-API-
# Read Me 
* Pre-Requisites for running this project is 
    
    [Jdk17](https://download.java.net/openjdk/jdk17/ri/openjdk-17+35_windows-x64_bin.zip)
  
    [maven3](https://dlcdn.apache.org/maven/maven-3/3.9.3/binaries/apache-maven-3.9.3-bin.zip)
* Once above softwares are installed set the path 
```shell
java --version
openjdk 17.0.7 2023-04-18
OpenJDK Runtime Environment Homebrew (build 17.0.7+0)
OpenJDK 64-Bit Server VM Homebrew (build 17.0.7+0, mixed mode, sharing)

maven --version
Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: /opt/homebrew/Cellar/maven/3.8.1/libexec
Java version: 17, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk/16.0.1/libexec/openjdk.jdk/Contents/Home
Default locale: en_IN, platform encoding: UTF-8
OS name: "mac os x", version: "13.4", arch: "aarch64", family: "mac"
```

* If you can see above successfully follow the below instructions
```shell
1. git clone <url>

2. mvn clean package

3.java -jar target/news-feed-api-0.0.1-SNAPSHOT.jar
```
