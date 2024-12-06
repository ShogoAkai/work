import bluetooth as bl

#サーバー用のソケット作成
server_socket = bl.BluetoothSocket(bl.RFCOMM)

#ポート番号0を指定して動的にポートを選ばせる
server_socket.bind(("", 0)) #自動で空いているポートを選択

#使用されたポート番号を取得
port = server_socket.getsockname()[1]
print(f"サーバーがポート{port}で待機中...")

#接続待機
server_socket.listen(1)

#クライアントからの接続を待機
client_socket, client_address = server_socket.accept()
print(f"クライアント {client_address}が接続しました")

#受信したファイルの保存先を設定
file_path = "/Users/admin/OneDrive/デスクトップ/DTN/morattano.txt"
with open(file_path, "wb") as f:
    print(f"ファイルを受信中: {file_path}")
    while True:
        data = client_socket.recv(1024) #1KBごとにデータを受け取る
        if not data:
            break
        f.write(data)

print(f"ファイル受信完了:{file_path}")

#接続を閉じる
client_socket.close()
server_socket.close()
print("サーバーを終了しました。")