package config.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import soundsystem.CompactDisc;
import soundsystem.HighSchoolRapper2Final;

@Configuration
@ComponentScan(basePackages={"soundsystem"})
public class CDPlayerConfig {
	
	// 명시적 자바 설정
	//	@Bean
	//	public CompactDisc compactDist() {
	//		return new HighSchoolRapper2Final();
	//	}
}
