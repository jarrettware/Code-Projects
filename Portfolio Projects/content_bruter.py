"""Simple Content brute forcer for directories and file locations"""


import queue
import threading
import urllib.error
import urllib.parse
import urllib.request

threads = 50
target_url = "http://testphp.vulnweb.com"
wordlist_file = r"C:\Users\jarre\Desktop\SVNDigger-master\SVNDigger-master\SVNDigger\all.txt"
resume = None
user_agent = "Mozilla/5.0 (X11; Linux x86_64; rv:19.0) " \
             "Gecko/20100101 " \
             "Firefox/19.0"


def build_wordlist(wordlist_file):
    # Read the word wordlist
    fd = open(wordlist_file, "r")
    raw_word = [line.rstrip('\n') for line in fd]
    fd.close()

    found_resume = False
    words = queue.Queue()

    for word in raw_word:
        if resume:
            if found_resume:
                words.put(word)
            else:
                if word == resume:
                    found_resume = True
                    print("Resuming wordlist from: %s" % resume)
        else:
            words.put(word)
    return words


def dir_bruter(extensions=None):
    while not word_queue.empty():
        attempt = word_queue.get()
        attempt_list = []

        # Check if there is a file extension if not it's a directory path we're bruting
        if "." not in attempt:
            attempt_list.append("/%s/" % attempt)
        else:
            attempt_list.append("/%s" % attempt)


        # if we want to bruteforce extensions
        if extensions:
            for extension in extensions:
                attempt_list.append("/%s%s" % (attempt, extension))

        # Iterate over our list of attempts
        for brute in attempt_list:
            url = "%s%s" % (target_url, urllib.parse.quote(brute))
            try:
                headers = {"User-Agent": user_agent}
                r = urllib.request.Request(url, headers=headers)
                response = urllib.request.urlopen(r)
                if len(response.read()):
                    print("[%d] => %s" % (response.code, url))
            except urllib.error.HTTPError as e:
                if e.code != 404:
                    print("!!! %d => %s" % (e.code, url))
                pass


word_queue = build_wordlist(wordlist_file)
file_extensions = [".php", ".bak", ".orig", ".inc"]

for i in range(threads):
    t = threading.Thread(target=dir_bruter, args=(file_extensions,))
    t.start()
