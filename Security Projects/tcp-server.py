import socket
import threading

bind_ip = "0.0.0.0"
bind_port = 9999

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind((bind_ip,bind_port))

server.listen(5)

print("[*] Listening on %s:%d" % (bind_ip,bind_port))


# This is our client-handling threading
def handleClient(client_socket):

    # Print out what the client sends
    request = client_socket.recv(1024)

    print("[*] Received: %s" % request)

    # Send back a packet
    client_socket.send(b"ACK!")
    print(client_socket.getpeername())
    client_socket.close()

while True:

    client,addr = server.accept()

    print("[*] Accepted connection from: %s:%d" % (addr[0], addr[1]))

    # Spin up our client thread to handle incoming data
    client_handler = threading.Thread(target=handleClient, args=(client,))
    client_handler.start()
