// package pnw.Slot;

// import java.io.IOException;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.Iterator;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import pnw.common.PnwDB;

// import javax.servlet.RequestDispatcher;

// /**
//  * Point: ex06の中にある，ShopProcessServletという名前で
//  * マッピングされるように，WebServlet内を埋めて下さい．かならず先頭は/から始めること．
//  */
// @WebServlet("/Slot/ShopListProcessServlet")
// public class ShopListProcessServlet extends HttpServlet {

//     /**
//      * @see HttpServlet#HttpServlet()
//      */
//     public ShopListProcessServlet() {
//         super();
//         // TODO Auto-generated constructor stub
//     }

//     /**
//      * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//      *      response)
//      */
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         // HTTP応答のエンコード設定
//         response.setContentType("text/html; charset=UTF-8");

//         ResultSet rs;
//         String forwardURL = "/Slot/shop.jsp";
//         // ボタンの値を取得する．
//         String btn_val = request.getParameter("btn");

//         try {
//  /**
//              * Point: PnwDBをインスタンス化して，かつtestdbに接続する ようにして下さい．また，必要に応じて上にあるimport文で
//              * PnwDBがimportされている状態にしてください．
//              */
//             PnwDB db = new PnwDB("testdb");
//             String sql = null;
//             // 入力値を取得しておく．
//             int in_id = 0;

//             if (!request.getParameter("id").equals("")) {
//                 in_id = Integer.valueOf(request.getParameter("id")).intValue();
//             }
//             //リクエストパラメータである，userid,passの値を格納する．
//             String userid = request.getParameter("userid");
//             String password = request.getParameter("pass");
//             PreparedStatement stmt = null;
//             /**
//              * Point: requestからセッションを取得させるようにしてください．
//              */
//             HttpSession session = request.getSession();
//             /**
//              * Point: sessionから，userlistというキーで，ArrayList<UserInfoBean>のリストをlistへ
//              * 格納させてください．ArrayList<UserInfoBean>でキャストさせないと動きません．
//              */
//             ArrayList<ShopInfoBean> list = (ArrayList<ShopInfoBean>)session.getAttribute("userlist");

//             switch (btn_val) {
//                 case "追加":
//                     sql = "INSERT INTO userinfo (userid,password) VALUES(?,?)";
//                     stmt = db.getStmt(sql);
//                     stmt.setString(1, userid);
//                     stmt.setString(2, password);
//                     int ret = stmt.executeUpdate();
//                     //AutoIncrementによって自動採番されたid値を取得する．
//                     //PnwDBクラスで，再度SQLを発行せずとも自動採番されたidを取得できる
//                     //設定にしている．
//                     ResultSet res = stmt.getGeneratedKeys();
//                     if(res.next()){
//                         int newID = res.getInt(1);
//                         //ここでsessionへ追加
//                         /**
//                          * Point: UserInfoBeanを，userid, passwordを渡してインスタンス化して，
//                          * さらにnewIDをbeanへセットさせてください．
//                          */
//                         ShopInfoBean bean = new ShopInfoBean(userid, password);
//                         bean.setID(newID);
//                         /**
//                          * Point: listに，beanを追加させてください．
//                          */
//                         list.add(bean);
                         
//                     }

//                     break;

//                 case "更新":
//                     sql = "UPDATE userinfo SET userid=?,password=? WHERE id=?";
//                     stmt = db.getStmt(sql);
//                     stmt.setString(1, userid);
//                     stmt.setString(2, password);
//                     /**
//                      * Point: インデックス3にin_idを設定するときの適切なメソッド名を設定してください．
//                      */
//                     stmt.setInt(3, in_id);
//                     int ret2 = stmt.executeUpdate();
//                     //正常に反映されたら，セッション側も更新させる．
//                     if(ret2 > 0){
//                         int len = list.size();
//                         for(int i=0;i<len;i++){
//                             ShopInfoBean info = list.get(i);
//                             //Point: info内のIDが，in_idと等しいならば，という条件を書いてください．
//                             if(info.getID() == in_id){
//                                 info.setUserID(userid);
//                                 info.setPassword(password);
//                             }
//                         }

//                     }
//                     break;

//                 case "削除":
//                     sql = "DELETE FROM userinfo WHERE id=?";
//                     stmt = db.getStmt(sql);
//                     /** 
//                      * Point: インデックス1にin_idを設定するときの適切なメソッド名を設定してください．
//                     **/
//                     stmt.setInt(1, in_id);
//                     int ret3 = stmt.executeUpdate();
//                     int len = list.size();
//                     if(ret3 >0){
//                         for(int i=0;i<len;i++){
//                             ShopInfoBean info = list.get(i);
//                             //Point: info内のIDが，in_idと等しいならば，という条件を書いてください．
//                             if(info.getID() == in_id){
//                                 list.remove(i);
//                             }
//                         }
//                     }


//                     break;

//             }
//         }catch(Exception e){
//             e.printStackTrace();
//         }
          
//         // 外部ファイルに転送する準備
//         RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
//         // 外部ファイルに表示処理を任せる
//         dispatcher.forward(request, response);
//     }

//     /**
//      * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//      *      response)
//      */
//     protected void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         // TODO Auto-generated method stub
//         doGet(request, response);
//     }

// }