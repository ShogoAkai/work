// package pnw.Slot;

// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
// import pnw.common.PnwDB;
// import javax.servlet.RequestDispatcher;

// @WebServlet("/Slot/SlotServlet")
// public class SlotServlet extends HttpServlet {
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         int point = (int) request.getAttribute("point");
//     }
        
//     public SlotServlet() {
//         super();
//     }

//     private static final long serialVersionUID = 1L;
    
//     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         try{
//             PnwDB db = new PnwDB("2024e");
//             String sql = "UPDATE user_management SET point=?, WHERE user_id=?";
//             PreparedStatement stmt = db.getStmt(sql);
//             stmt.setInt(1, point);
//             stmt.setInt(2, user_id);
//             int ret2 = stmt.executeUpdate();
//         }
//     }
// }