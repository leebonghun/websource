package pattern.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActionForward {
	//이동경로와 이동방식을 저장하는 클래스
	private String path;
	private boolean redirect; //true(sendRedirect), false(forward) 방식으로 간다는 의미.
}
