package pattern.controller;

import pattern.action.Action;
import pattern.action.LoginAction;

public class ActionFactory {
	private static ActionFactory af;
	
	//객체 생성을 하나만 하는 방식(singleton 패턴)
	public ActionFactory() {}
	public static ActionFactory getInstance() {
		if(af==null) {
			af=new ActionFactory();
		}
		return af;
	}
	Action action = null;
	//action 작업이 성공하면 움직일 페이지를 기록
	public Action action(String cmd) {
		if(cmd.equals("/login.do")) {
			action=new LoginAction("/index.jsp");
		}else if(cmd.equals("/update.do")) {
			
		}else if(cmd.equals("/index.do")) {
			
		}
		return action;
	}
}

// public : 외부에서 객체 생성시 무한정 만들어짐
// private : 외부에서 객체 생성 못함 => getInstance() 를 생성해줘야함
