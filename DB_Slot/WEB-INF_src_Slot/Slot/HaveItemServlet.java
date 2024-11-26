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

import org.w3c.dom.Text;

import pnw.common.PnwDB;

import javax.servlet.RequestDispatcher;

@WebServlet("/Slot/HaveItemServlet")
public class HaveItemServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaveItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // HTTP応答のエンコード設定
        response.setContentType("text/html; charset=UTF-8");

        ResultSet rs;
        String forwardURL = "/Slot/have_item.jsp";
        HttpSession session = request.getSession();
        try {
            /**
             * Point: PnwDBをインスタンス化して，かつtestdbに接続する ようにして下さい．また，必要に応じて上にあるimport文で
             * PnwDBがimportされている状態にしてください．
             */
            PnwDB db = new PnwDB("2024e");

            String sql = "SELECT * FROM user_item_db WHERE user_id=?";
            PreparedStatement stmt = db.getStmt(sql);
            stmt.setInt(1, (int) session.getAttribute("User_ID"));
            // 実行結果取得
            rs = stmt.executeQuery();
            // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
            int cnt = 0;
            ArrayList<Integer> infoArray = new ArrayList<Integer>();
            while (rs.next()) {
                // カラムの値を取得する．
                infoArray.add(rs.getInt("have_normal"));
                infoArray.add(rs.getInt("have_rare"));
                infoArray.add(rs.getInt("have_super_rare"));
                cnt++;
            }
            request.setAttribute("itemlist", infoArray);

        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("name_overlap.jsp").forward(request, response);
        } finally {
            System.out.println();
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