package pnw.Slot;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pnw.common.PnwDB;
import javax.servlet.RequestDispatcher;

@WebServlet("/Slot/UpdatePointsServlet")
public class UpdatePointsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Fetch current points from session
        String pnt = request.getParameter("point");
        String[] gachas = {request.getParameter("normal"),request.getParameter("rare"),request.getParameter("srare")};
        List<Integer> items = new ArrayList<Integer>();
        for (String i : gachas) {
            if(i == null){
                items.add(0);
            }else{
                items.add(Integer.parseInt(i));
            }
        }
        int currentPoints = (int) session.getAttribute("Point");
        if(pnt != null){
            currentPoints = Integer.parseInt(pnt);
        }
        int user_id = (int)session.getAttribute("User_ID");

        try{
            PnwDB db = new PnwDB("2024e");
            String sql = "UPDATE user_management SET point=?,login_count=? WHERE user_id=?";
            PreparedStatement stmt = db.getStmt(sql);
            stmt.setInt(1, currentPoints);
            stmt.setInt(2,(int)session.getAttribute("logcnt"));
            stmt.setInt(3, user_id);
            int ret2 = stmt.executeUpdate();
            String itemsql = "UPDATE user_item_db SET have_normal=have_normal+?,have_rare=have_rare+?,have_super_rare=have_super_rare+? WHERE user_id=?";
            PreparedStatement itemstmt = db.getStmt(itemsql);
            for(int i=0;i<3;i++){
                itemstmt.setInt(i+1,items.get(i));
            }
            itemstmt.setInt(4,user_id);
            int ret3 = itemstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            System.out.println();
        }
        session.setAttribute("Point", currentPoints);
        request.getRequestDispatcher("/Slot/home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
