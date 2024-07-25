package teamProject.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port;
	//포트 생성
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		try {
			//포트 번호를 9500으로 지정
			ServerSocket serverSocket = new ServerSocket(9500); // 포트번호를 9500번으로 지정
			while (true) {
				System.out.println("연결을 기다리는 중...");
				//접속 시도
				Socket socket = serverSocket.accept();
				//접속 완료
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("연결 수락됨" + isa.getHostName());
			}
		} catch (IOException e) {
		}

	}
}
