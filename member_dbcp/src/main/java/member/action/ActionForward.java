package member.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
//이동방식과 이동경로를 저장하는 클래스 : actionforward
public class ActionForward {
	private String path;
	private boolean redirect;

}
