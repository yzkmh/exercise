package cn.gyyx.java;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.gyyx.java.bll.GameBll;
import cn.gyyx.java.model.Game;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate =  "222222";// dateFormat.format(date);
		
		GameBll gameBll = new GameBll();
		//Game theGmme = gameBll.GetGameById(1);
		
		List<Game> list = gameBll.GetGameList();
		model.addAttribute("list", list);
		
		//model.addAttribute("gameName", theGmme.getGameName() );
		//model.addAttribute("gameDes", theGmme.getGameDes() );
		return "home";
	}
	
	@RequestMapping(value="/postNewGame" , method = RequestMethod.POST)
	public String postNewGame(@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password,
			@RequestParam(value="sex") String sex,
			@RequestParam(value="age") String age,
			@RequestParam(value="mail") String mail,
			HttpServletResponse response,Model model){
		GameBll gameBll = new GameBll();
		Game gameRes = gameBll.AddNewGame(userName, password,sex,age,mail);
		
		List<Game> list = gameBll.GetGameList();
		model.addAttribute("list", list);
		
		if(gameRes != null){
			return "home";
		}
		return "home";
	}
	
	@RequestMapping(value="/ModifyGame" , method = RequestMethod.GET)
	public String ModifyGame( int id,
			HttpServletResponse response,Model model){
		
		GameBll gameBll = new GameBll();
		Game theGmme = gameBll.GetGameById(id);
		model.addAttribute("game", theGmme);
		
		if(theGmme != null){
			return "ModifyGame";
		}
		return "home";
	}
	
	@RequestMapping(value="/searchName" , method = RequestMethod.POST)
	public String searchName(String[] userName,
			HttpServletResponse response,Model model){
		
		GameBll gameBll = new GameBll();
		List<Game> list2 = gameBll.GetGameList();
		Game theGame;
		
		for (String name:userName){
			if(!name.isEmpty() && name != null){
				theGame = gameBll.GetGameByName(name);
				if(theGame != null)
				{
					System.out.println(theGame.getUsername());
					list2.add(theGame);
				}
			}
		}
		
		model.addAttribute("list2", list2);
		if(!list2.isEmpty()){
			return "home";
		}
		return "home";
	}
	
	@RequestMapping(value="/ModifyGame" , method = RequestMethod.POST)
	public String ModifyGame(@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password,
			@RequestParam(value="sex") String sex,
			@RequestParam(value="age") String age,
			@RequestParam(value="mail") String mail,
			@RequestParam(value="id") int id,
			HttpServletResponse response,Model model){
		GameBll gameBll = new GameBll();
		Game gameRes = gameBll.updateGame(userName, password,sex,age,mail,id);
		
		List<Game> list = gameBll.GetGameList();
		model.addAttribute("list", list);
		
		if(gameRes != null){
			return "home";
		}
		return "home";
	}
	
	
}
