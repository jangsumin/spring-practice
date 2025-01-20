package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	private final CompactDisc cd;
	
	// @Autowired 사용 대신 생성자 주입
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}
	
	public String play() {
		return cd.play();
	}
}
