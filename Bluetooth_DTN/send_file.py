import bluetooth

#サーバーのBluetoothアドレス（サーバーのアドレスに合わせて設定）
server_address = "84:7B:57:E0:7F:6C" #サーバーのBluetoothアドレス
port = 4 #サーバーが使用しているポート番号

print(f"サーバー({server_address})に接続中...")

try:
    #Bluetoothソケットを作成
    client_socket = bluetooth.BluetoothSocket(bluetooth.RFCOMM)
    print("ソケット作成成功")
    
    #サーバーへの接続を試みる
    client_socket.connect((server_address, port)) #ポート番号1で接続
    print(f"サーバーに接続成功:{server_address}:{port}")
    
    #送信するファイルのパス
    file_path = "C:/Users/admin/OneDrive/デスクトップ/DTN/send.txt"
    
    with open(file_path, "rb") as f:
        print(f"ファイルを送信中: {file_path}")
        data = f.read(1024) #1KBごとに読み込む
        while data:
            client_socket.send(data)
            print("いぇあ")
            data = f.read(1024)
            #data -f.read(1024)
            print("ぴぇ")
            
    print("ファイル送信完了")
    
except Exception as e:
    print(f"エラーが発生しました: {e.__class__.__name__} - {e}")
    print(e)
    
finally:
    client_socket.close()
    print("クライアントを終了しました。")