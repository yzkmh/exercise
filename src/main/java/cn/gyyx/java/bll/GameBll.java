package cn.gyyx.java.bll;

import java.util.List;

import cn.gyyx.java.dao.GameDao;
import cn.gyyx.java.model.Game;




public class GameBll{
	private static GameDao gameDao;

	public GameBll()
	{
		GameBll.gameDao = new GameDao();
		
	}

	public Game GetGameById(int id){
		Game theGame;

		theGame=gameDao.selectByGameId(id);
		
		return theGame;
	}
	
	public Game GetGameByName(String name){
		Game theGame;

			theGame=gameDao.selectByUserName(name);


		return theGame;
	}
	
public List<Game> GetGameList(){
		return  gameDao.selectGameList();
	}

public Game AddNewGame(String userName,String password,String sex,String age,String mail){

	Game theGame = new Game();
	theGame.setUsername(userName);
	theGame.setPassword(password);
	theGame.setSex(sex);
	theGame.setAge(age);
	theGame.setMail(mail);
	int id = gameDao.insertGame(theGame);
	
	if(id>0)
	{
		theGame.setId(id);
		return theGame;
	}
	return null;
}

public Game updateGame(String userName,String password,String sex,String age,String mail,int id){

	Game theGame = new Game();
	theGame.setUsername(userName);
	theGame.setPassword(password);
	theGame.setSex(sex);
	theGame.setAge(age);
	theGame.setMail(mail);
	theGame.setId(id);
	int res = gameDao.updateGame(theGame);
	
	if(res>0)
	{
		return theGame;
	}
	return null;
}
	

}
