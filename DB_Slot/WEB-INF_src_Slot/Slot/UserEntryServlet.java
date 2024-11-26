package pnw.Slot;
import pnw.common.PnwDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Slot/UserEntryServlet")
public class UserEntryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        //String dateBirth = request.getParameter("dateBirth");


        PreparedStatement pstmt = null;
        PreparedStatement check_stmt = null;

        try {
            PnwDB db = new PnwDB("2024e");
            String check_sql = "SELECT user_name FROM user_management where user_name=?";
            check_stmt = db.getStmt(check_sql);
            check_stmt.setString(1,userName);
            ResultSet check_rs = check_stmt.executeQuery();
            if(check_rs.next()){
                request.getRequestDispatcher("name_overlap.jsp").forward(request, response);
            }
            // SQL文の作成
            String sql = "INSERT INTO user_management (user_name, password) VALUES (?, ?)";
            pstmt = db.getStmt(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            //pstmt.setString(3, dateBirth);

            // SQLの実行
            int result = pstmt.executeUpdate();
            if (result > 0) {
                request.getRequestDispatcher("user_login.jsp").forward(request, response);
            } else {
                //response.sendRedirect("user_entry_failure.jsp"); // 登録失敗後のリダイレクト先
                request.getRequestDispatcher("user_entry_failure.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendRedirect("user_entry_failure.jsp"); // エラー時のリダイレクト先
            //response.sendRedirect("user_entry_failure.jsp"); // エラー時のリダイレクト先
            //request.getRequestDispatcher("user_entry_failure.jsp").forward(request, response);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                //if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //request.getRequestDispatcher("user_entry.jsp").forward(request, response);
    }
}
