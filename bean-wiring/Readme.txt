1. soundsystem: Automatic configuration(Annotation scanning)
2. videosystem: Explicit configuration(Bean configuration)

[src/main/java]
    soundsystem
       |--- CDPlayer.java
       |--- CompactDisc.java
       |--- HighSchoolRapper2Final

    config.soundsystem
       |--- CDPlayerConfig.java
       
[src/main/resources]
    config.soundsystem
       |--- applicationContext.xml
       
[src/test/java]
    config.soundsystem
       |--- CDPlayerXmlConfigTest.java
       |--- CDPlayerJavaConfigTest.java
       
========================================
2. videosystem: Explicit configuration(Bean configuration)

[src/main/java]
    videosystem
       |--- DVDPlayer.java
       |--- DigitalVideoDisc.java
       |--- Avengers

    config.videosystem
       |--- DVDPlayerConfig.java

    config.videosystem.mixing
       |--- DVDConfig.java
       |--- DVDPlayerConfig.java
       |--- VideoSystemConfig.java

[src/main/resources]
    config.videosystem
       |--- applicationContext.xml

[src/test/java]
    config.videosystem
       |--- DVDPlayerJavaConfigTest.java
       |--- DVDPlayerXmlConfigTest.java

    config.videosystem.mixing
       |--- DVDPlayerMixingConfigTest01.java
       |--- DVDPlayerMixingConfigTest02.java