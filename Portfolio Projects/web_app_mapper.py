"""Simple spider tool for open source web app installations that can be downloaded locally"""

import Queue
import threading
import os
import urllib.error
import urllib.parse
import urllib.request

threads = 10
target = "http://www.test.com"
directory = " /Users/justin/Downloads/joomla-3.1.1"  #directory where web app is saved
filters = [".jpg", ".gif", ".png", ".css"]       #List of file extensions your not interested in

#Change directory and store located files
os.chdir(directory)
web_paths = queue.Queue()

#Search through directory to see if files don't match filter and add to queue
for r, d, f in os.walk("."):
    for files in f:
        remote_path = "%s%s" % (r, files)
        if remote_path.startswith("."):
            remote_path = remote_path[1:]
        if os.path.splitext(files)[1] not in filters:
            web_paths.put(remote_path)


def test_remote():
    #Grab path from queue and add to the target's base path
    while not web_paths.empty():
        path = web_paths.get()
        url = "%s%s" % (target, path)
        request = urllib.request.Request(url)
    #If Successfully retrieved the files print HTTP status code and full file path
        try:
            response = urllib.request.urlopen(request)
            print("[%d] => %s" % (response.code, path))
            response.close()
    #If file isn't found or protected handle error to continue loop
        except urllib.error.HTTPError as error:
            print("Failed %s" % error.code)
            pass

#Loop until queue is empty
for i in range(threads):
    print("Spawning thread: %d" % i)
    t = threading.Thread(target=test_remote)
    t.start()
