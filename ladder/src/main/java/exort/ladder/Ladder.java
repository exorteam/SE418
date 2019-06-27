package exort.se418.component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Ladder{
    private static Logger logger = LoggerFactory.getLogger(Ladder.class);

	private Ladder(){}

	public static ArrayList<String> run(String s1,String s2){
		if(s1.equals("") || s2.equals("")){
			logger.info("args must be non-empty.");
			return null;
		}
		if(s1.length() != s2.length()){
			logger.info("args must be in same length");
			return null;
		}
		if(s1.equals(s2)){
			logger.info("args must be different");
			return null;
		}

		ArrayList<String> res = null;
		logger.info("Generating ladder..");
		res = generateLadder(s1,s2);
		System.out.println(res);
		return res;
	}
	
	private static ArrayList<String> generateDict(String filename){
		ArrayList<String> res = new ArrayList<String>();
		InputStream is = Ladder.class.getClassLoader().getResourceAsStream(filename);

        try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
         
            String line;
            while ((line = br.readLine()) != null) {
				res.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

		return res;
	}
	
	private static ArrayList<String> generateLadder(String begin, String end){
		Queue<String> queue = new LinkedList<String>();
		ArrayList<String> words = generateDict("dictionary.txt");
		ArrayList<String> trace = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		Map<String,String> prev = new HashMap<String,String>();
		Map<String,Integer> dist = new HashMap<String,Integer>();
		   
		begin=begin.toLowerCase();
		end=end.toLowerCase();

		queue.offer(begin);
		trace.add(begin);
		dist.put(begin,0);
		String cur="";
		while(!queue.isEmpty()){
			cur=queue.poll();
			if(cur.equals(end))break;
			for(int i=0;i<cur.length();i++){
				for(char j='a';j<='z';j++){
					char[] arr=cur.toCharArray();
					arr[i]=j;
					String tstr=new String(arr);
					int curDist=dist.get(cur);
					int tDist;
					try{
						tDist=dist.get(tstr);
					}
					catch(NullPointerException e){
						tDist = Integer.MAX_VALUE;
					}
					if(words.contains(tstr)){
						if(trace.contains(tstr)){ 
							if(curDist+1 < tDist){
								dist.put(tstr,curDist+1);
								prev.put(tstr,cur);
							}
						}
						else{
							prev.put(tstr,cur);
							dist.put(tstr,curDist+1);
							queue.offer(tstr);
						}
						trace.add(tstr);
					}
				}
			}
		}
		
		if(!cur.equals(end)){
			System.out.println("Cannot generate a ladder.");
		}	
		else{
			res.add(cur);
			while(prev.get(cur)!=null){
				res.add(prev.get(cur));
				cur=prev.get(cur);
			}
		}
		return res;
	}

}
