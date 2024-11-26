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

@WebServlet("/Slot/ShopListShowServlet")
public class ShopListShowServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopListShowServlet() {
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
        ResultSet item_rs;
        String forwardURL = "/Slot/shop_buy.jsp";
        String btn_val = request.getParameter("btn");
        if(btn_val == null){
            btn_val = "";
        }
        HttpSession session = request.getSession();
        session.setAttribute("shop_buy_text", "");
        try {
            /**
             * Point: PnwDBをインスタンス化して，かつtestdbに接続する ようにして下さい．また，必要に応じて上にあるimport文で
             * PnwDBがimportされている状態にしてください．
             */
            PnwDB db = new PnwDB("2024e");
            
            String sql = "SELECT * FROM shop_db";
            String item_sql = "SELECT item_name FROM item_db WHERE item_id = ?";
            PreparedStatement stmt = db.getStmt(sql);
            PreparedStatement item_stmt = db.getStmt(item_sql);
            int gID = 0;
            switch (btn_val) {
                case "購入":
                    gID = Integer.parseInt(request.getParameter("id"));
                    String check_sql = "SELECT * FROM shop_db WHERE goods_id = ?";
                    PreparedStatement check_stmt = db.getStmt(check_sql);
                    check_stmt.setInt(1,gID);
                    ResultSet check_rs = check_stmt.executeQuery();
                    while (check_rs.next()) {
                         int iPrice = check_rs.getInt("item_price");
                         Object aaa = session.getAttribute("Point");
                         int uPoint = Integer.parseInt(aaa.toString());
                         int howrare = check_rs.getInt("item_id");
                        if(iPrice <= uPoint){
                            String buy_sql = "DELETE FROM shop_db WHERE goods_id = ?";
                            PreparedStatement buy_stmt = db.getStmt(buy_sql);
                            buy_stmt.setInt(1,gID);
                            buy_stmt.executeUpdate();
                            session.setAttribute("Point", uPoint-iPrice);
                            session.setAttribute("shop_buy_text", "購入に成功しました");
                            String add_sql = "";
                            switch (howrare) {
                                case 0:
                                    add_sql = "UPDATE user_item_db SET have_normal = have_normal+1 WHERE user_id = ?";
                                    break;
                                case 1:
                                    add_sql = "UPDATE user_item_db SET have_rare = have_rare+1 WHERE user_id = ?";
                                    break;
                                case 2:
                                    add_sql = "UPDATE user_item_db SET have_super_rare = have_super_rare+1 WHERE user_id = ?";
                                    break;
                            }
                            PreparedStatement add_stmt = db.getStmt(add_sql);
                            add_stmt.setInt(1,(int)session.getAttribute("User_ID"));
                            int add1 = add_stmt.executeUpdate();
                        }else{
                             session.setAttribute("shop_buy_text","ポイントが不足しています");
                        }
                        break;
                    }
                    break;
                
            }

            // 実行結果取得
            rs = stmt.executeQuery();
            // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
            int cnt = 0;
            ArrayList<ShopInfoBean> infoArray = new ArrayList<ShopInfoBean>();
            while (rs.next()) {
                // カラムの値を取得する．
                int id = rs.getInt("user_id");
                int itemid = rs.getInt("item_id");
                int itemprice = rs.getInt("item_price");
                int goodsid = rs.getInt("goods_id");
                ShopInfoBean bean = new ShopInfoBean(id,itemid,itemprice,goodsid);
                infoArray.add(bean);
                cnt++;
            }

            for (ShopInfoBean info : infoArray) {
                item_stmt.setInt(1,info.getItemID());
                System.out.println(info.getItemID());
                item_rs = item_stmt.executeQuery();
                while (item_rs.next()) {
                    String item_name = item_rs.getString("item_name");
                    info.setItemName(item_name);
                }
                
            }
            /**
             * Point: sessionへ，userlistという名前でinfoArrayをセットしてください．
             */
            request.setAttribute("shoplist", infoArray);
        
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("name_overlap.jsp").forward(request, response);
        }finally{
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