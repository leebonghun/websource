package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/add")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//cart.jsp에서 넘긴 값 가져오기
		String product=request.getParameter("product");
//		HttpSession session = request.getSession(); 하나만 받아올 때 
//		session.setAttribute("product", product);
		
		//세션에 담긴 장바구니 가져오기
		HttpSession session =request.getSession();
		ArrayList<String> cartList = (ArrayList<String>)session.getAttribute("cartList");
		
		if(cartList!=null) { //기존에 담아놓은 장바구니가 존재할떄
			cartList.add(product);
			
		}else { //새롭게 장바구니 생성
			cartList=new ArrayList<String>();
			cartList.add(product);
			session.setAttribute("cartList", cartList);
			
		}
		
//		response.sendRedirect("/cart/basket.jsp");
		//session에 값을 담기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html><head><meta charset=\"UTF-8\">");
		out.print("<title>사용자 정보</title>");
		out.print("<body>");
		out.print("<p><a href='/cart/cart.jsp'>상품 선택</a></p>");
		out.print("<p><a href='/cart/basket.jsp'>장바구니 보기</a></p>");
		out.print("</body>");
		out.print("</html>");
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
