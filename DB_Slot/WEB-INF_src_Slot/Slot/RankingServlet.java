package pnw.Slot;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pnw.common.PnwDB;

import javax.servlet.RequestDispatcher;

@WebServlet("/Slot/RankingServlet")
public class RankingServlet extends HttpServlet {

    public RankingServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        ResultSet rs;
        String forwardURL = "/Slot/ranking.jsp";
        HttpSession session = request.getSession();
        //if (session.getAttribute("userlist") == null) {
            try {
                PnwDB db = new PnwDB("2024e");
                String sql = "SELECT * FROM user_management ORDER BY point DESC;";
                PreparedStatement stmt = db.getStmt(sql);
                rs = stmt.executeQuery();

                ArrayList<UserPointBean> infoArray = new ArrayList<UserPointBean>();
                while (rs.next()) {
                    String id = rs.getString("user_name");
                    int point = rs.getInt("point");
                    UserPointBean bean = new UserPointBean(id, point);
                    bean.setID(id);
                    infoArray.add(bean);
                }
                session.setAttribute("userlist", infoArray);

            } catch (Exception e) {
                e.printStackTrace();
            }
        //}

        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
