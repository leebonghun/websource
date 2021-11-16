package board.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

// 위아래 둘중에 하나!

/*@AllArgsConstructor
@Data
@NoArgsConstructor*/
public class boardDTO {
	private int bno; 
	private String title; 
	private String content; 
	private String password;   
	private String attach;            
	private int readcount;    
	private String name;      
	private Date regdate;     
	private int re_ref; 
	private int re_lev;  
	private int re_seq;
}
