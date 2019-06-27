package exort.ladder;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exort.se418.component.Ladder;

@RestController
public class LadderController {

	@GetMapping("/ladder")
	public List<String> generateLadder(@RequestParam String start,@RequestParam String end){
		return Ladder.run(start,end);
	}
}
