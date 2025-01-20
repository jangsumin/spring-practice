package config.videosystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import videosystem.DigitalVideoDisc;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:config/videosystem/application.xml"})
public class DVDPlayerXmlConfigTest {
	@Autowired
	DigitalVideoDisc dvd1;
	
	@Test
	public void testDVD1() {
		assertNotNull(dvd1);
	}
	
	
}
