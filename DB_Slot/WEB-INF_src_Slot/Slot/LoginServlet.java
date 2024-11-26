package pnw.Slot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pnw.common.PnwDB;

import javax.servlet.RequestDispatcher;

@WebServlet("/Slot/LoginServlet")
public class LoginServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String User_name = request.getParameter("Username");
        String password = request.getParameter("Password");
        String forwardURL = "/Slot/user_login.jsp";

        ResultSet rs;
        HttpSession session = request.getSession();

        try {
            PnwDB db = new PnwDB("2024e");
            String sql = "SELECT * FROM user_management WHERE user_name=?";
            PreparedStatement stmt = db.getStmt(sql);
            stmt.setString(1, User_name);
            // 実行結果取得
            rs = stmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (password.equals(dbPassword)) {
                    int uid = rs.getInt("user_id");
					session.setAttribute("UName", rs.getString("user_name"));
                    session.setAttribute("User_ID", uid);
                    session.setAttribute("Point", rs.getInt("point"));
                    int logcnt = rs.getInt("login_count");
                    if(logcnt == 0){
                        String logsql = "INSERT INTO user_item_db (user_id) VALUES (?)";
                        PreparedStatement logstmt = db.getStmt(logsql);
                        logstmt.setInt(1,uid);
                        int logrs = logstmt.executeUpdate();
                    }
                    logcnt ++;
                    session.setAttribute("logcnt",logcnt);
                    forwardURL = "UpdatePointsServlet"; // ログイン成功後のページ
                } else {
                    forwardURL = "user_entry_failure.jsp"; // パスワードが間違っている場合のページ
                }
            } else {
                forwardURL = "user_entry_failure.jsp"; // ユーザーが見つからない場合のページ
            }

        } catch (SQLException e) {
            e.printStackTrace();
            forwardURL = "user_entry_failure.jsp"; // データベースエラーの場合のページ
        } catch (Exception e) {
            e.printStackTrace();
            forwardURL = "user_entry_failure.jsp"; // その他のエラーの場合のページ
        }

        // 外部ファイルに転送する準備
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
        // 外部ファイルに表示処理を任せる
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
