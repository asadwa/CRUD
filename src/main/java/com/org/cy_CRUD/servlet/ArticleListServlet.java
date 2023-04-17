package com.org.cy_CRUD.servlet;

import com.org.cy_CRUD.Config;
import com.org.cy_CRUD.Rq;
import com.org.cy_CRUD.util.DBUtil;
import com.org.cy_CRUD.util.SecSql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/article/list") //주소창에 들어갈 주소 %필수% 아래 extends 포함
public class ArticleListServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req, resp);

    // DB 연결시작
    Connection conn = null;
    String diverName = Config.getDriverClassName();

    try {
      Class.forName(diverName);
    } catch (ClassNotFoundException e) {
      System.out.printf("[ClassNotFoundException 예외, %s]", e.getMessage());
      System.out.println("DB 드라이버 클래스 로딩 실패");
      return;
    }

    try {
      conn = DriverManager.getConnection(Config.getDBUrl(), Config.getDBId(), Config.getDBPw());
      DBUtil dbUtil = new DBUtil();

      int id = Integer.parseInt(req.getParameter("id"));

      //데이터를 받아오는 과정
      SecSql sql = new SecSql();
      sql.append("SELECT * FROM article");

      //데이터를 articleRows 에 넣음?
      List<Map<String, Object>> articleRows = dbUtil.selectRows(conn, sql);

      //데이터를 넣음
      req.setAttribute("articleRows", articleRows);
      req.getRequestDispatcher("../article/list.jsp").forward(req, resp);

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (conn != null && !conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  // DB 연결 끝
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);

  }
}
