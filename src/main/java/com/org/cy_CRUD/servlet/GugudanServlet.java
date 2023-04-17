package com.org.cy_CRUD.servlet;
import com.org.cy_CRUD.Rq;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan") //주소창에 들어갈 주소 %필수%
public class GugudanServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 UTF-8 (한글)로 해석하겠다.
    resp.setCharacterEncoding("UTF-8"); // 완성되는 HTML의 인코딩을 UTF-8로 하겠다.
    resp.setContentType("text/html; charset-utf-8"); //우리가 만든 결과물이 UTF-8이라고 알리는 의미.

    Rq rq = new Rq(req, resp);

    int dan = rq.getIntParam("dan", 9);
    int limit = rq.getIntParam("limit", 9);

    //request 에 dan과 limit를 담음 % 중요 %
    req.setAttribute("dan", dan);
    req.setAttribute("limit", limit); //request 에 dna과 limit를 담음

    //gugudan2.jsp 에게 나머지 작업을 넘김 % 중요 %
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan2.jsp");
    requestDispatcher.forward(req, resp);

  }
}
