package server;

public class ServerMain {
	
	// launch this to open a server
	public static void main(String[] args) {
		Server server = new Server();
		server.bindServices();
	}

}
